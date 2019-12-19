/**
 * 图片裁剪工具
 * @param $img 将剪切好的图片添加到该对象的src属性下
 */
const picture_clipping_tool = function ($img) {
    if ($('#picture-clipping-modal').length <= 0) {
        $("<link>").attr({href: "/static/css/cropper.min.css", rel: "stylesheet", type: "text/css"}).appendTo('head');
        $('body').append(`
            <div id="picture-clipping-modal" style="display: none" class="tailoring-container">
                <div class="black-cloth"></div>
                <div class="tailoring-content">
                    <div class="tailoring-content-one">
                        <label title="上传图片" for="chooseImg" class="l-btn choose-btn">
                            <input type="file" accept="image/jpg,image/jpeg,image/png" name="file" id="chooseImg" class="hidden">
        					选择图片
                        </label>
                        <div class="close-tailoring">×</div>
                    </div>
                    <div class="tailoring-content-two">
                        <div class="tailoring-box-parcel"><img id="tailoringImg"></div>
                        <div class="preview-box-parcel">
                            <p>图片预览：</p>
                            <div class="square previewImg"></div>
                            <div class="circular previewImg"></div>
                        </div>
                    </div>
                    <div class="tailoring-content-three">
                        <button class="l-btn cropper-reset-btn">复位</button>
                        <button class="l-btn cropper-rotate-btn">旋转</button>
                        <button class="l-btn cropper-scaleX-btn">换向</button>
                        <button class="l-btn sureCut" id="sureCut">确定</button>
                    </div>
                </div>
            </div>
         `);

        /* 引入图片裁剪所需cropper.min.js */
        $.ajax({
            url: "/static/js/cropper.min.js", dataType: "script", cache: true, success: function () {

                /* 弹出框水平垂直居中 */
                (window.onresize = function () {
                    const win_height = $(window).height();
                    const win_width = $(window).width();
                    if (win_width <= 768) {
                        $(".tailoring-content").css({
                            "top": (win_height - $(".tailoring-content").outerHeight()) / 2,
                            "left": 0
                        });
                    } else {
                        $(".tailoring-content").css({
                            "top": (win_height - $(".tailoring-content").outerHeight()) / 2,
                            "left": (win_width - $(".tailoring-content").outerWidth()) / 2
                        });
                    }
                })();
                /* 图像上传 */
                $('#chooseImg').on('change', function () {
                    const file = $(this)[0];
                    if (!file.files || !file.files[0]) {
                        return;
                    }
                    const reader = new FileReader();
                    reader.onload = function (evt) {
                        const replaceSrc = evt.target.result;
                        /* 更换cropper的图片、默认false，适应高度，不失真 */
                        $('#tailoringImg').cropper('replace', replaceSrc, false);
                    }
                    reader.readAsDataURL(file.files[0]);
                })
                /* cropper图片裁剪 */
                $('#tailoringImg').cropper({
                    aspectRatio: 1 / 1, /* 默认比例 */
                    preview: '.previewImg', /* 预览视图 */
                    guides: false, /* 裁剪框的虚线(九宫格) */
                    autoCropArea: 1, /* 0-1之间的数值，定义自动剪裁区域的大小，默认0.8 */
                    movable: false, /* 是否允许移动图片 */
                    dragCrop: true, /* 是否允许移除当前的剪裁框，并通过拖动来新建一个剪裁框区域 */
                    movable: true, /* 是否允许移动剪裁框 */
                    resizable: true, /* 是否允许改变裁剪框的大小 */
                    zoomable: false, /* 是否允许缩放图片大小 */
                    mouseWheelZoom: false, /* 是否允许通过鼠标滚轮来缩放图片 */
                    touchDragZoom: true, /* 是否允许通过触摸移动来缩放图片 */
                    rotatable: true, /* 是否允许旋转图片 */
                    crop: function (e) {
                        /* 输出结果数据裁剪图像。 */
                    }
                });
                /* 旋转 */
                $(".cropper-rotate-btn").on("click", function () {
                    $('#tailoringImg').cropper("rotate", 45);
                });
                /* 复位 */
                $(".cropper-reset-btn").on("click", function () {
                    $('#tailoringImg').cropper("reset");
                });
                /* 换向 */
                let flagX = true;
                $(".cropper-scaleX-btn").on("click", function () {
                    if (flagX) {
                        $('#tailoringImg').cropper("scaleX", -1);
                        flagX = false;
                    } else {
                        $('#tailoringImg').cropper("scaleX", 1);
                        flagX = true;
                    }
                });
                /* 关闭裁剪框 */
                $(".close-tailoring").on('click', function () {
                    $(".tailoring-container").toggle();
                });
                $("#sureCut").on("click", function () {
                    if ($("#tailoringImg").attr("src") == null) {
                        return false;
                    } else {
                        /* 获取被裁剪后的canvas */
                        const cas = $('#tailoringImg').cropper('getCroppedCanvas');
                        /* 转换为base64地址形式 */
                        const base64url = cas.toDataURL('image/png');
                        // 等比压缩，显示为图片的形式
                        photo_compression(base64url, 640, 640, function (base64Codes) {
                            $img.prop("src", base64Codes);
                        });
                        let formDate = new FormData();
                        formDate.append("userId",userId);
                        formDate.append("myFile", convert_base64_url_to_blob(base64url),"1.jpg");
                        $.ajax({
                            url: '/personalInformation/upload',
                            type: 'POST',
                            dataType: "json",
                            data: formDate,
                            contentType: false,
                            processData: false,
                            success: function (result) {
                                console.log(result.msg);
                                $(".tailoring-container").toggle();
                            },
                            error: function (data) {
                                console.log(data.msg);
                                $(".tailoring-container").toggle();
                            }
                        });
                    }
                });
            }
        })
    }
    /* 裁剪后的处理 */
}

/*
 * 图片长宽与质量压缩
 * @param base64data 需要压缩的Base64图片数据
 * @param width 压缩后的长度
 * @param height 压缩后的宽度
 * @param realize 压缩后对数据处理的实现
 */
const photo_compression = function (base64data, width, height, callback) {
    /* 缩放图片需要的canvas */
    const canvas = document.createElement('canvas');
    const context = canvas.getContext('2d');
    /* base64地址图片加载完毕后 */
    const image = new Image();
    image.src = base64data;
    image.onload = function () {
        /* 图片原始尺寸 */
        const originWidth = this.width, originHeight = this.height;
        /* 目标尺寸 */
        let targetWidth = originWidth, targetHeight = originHeight;
        /* 按照宽度限定尺寸 */
        if (originWidth > width || originHeight > height) {
            if (originWidth / originHeight > width / height) {
                targetWidth = width;
                targetHeight = Math.round(width * (originHeight / originWidth));
            } else {
                targetHeight = height;
                targetWidth = Math.round(height * (originWidth / originHeight));
            }
        }
        /* canvas对图片进行缩放 */
        canvas.width = targetWidth;
        canvas.height = targetHeight;
        /* 清除画布 */
        context.clearRect(0, 0, targetWidth, targetHeight);
        /* 图片压缩 */
        context.drawImage(image, 0, 0, targetWidth, targetHeight);
        /* canvas转码为base64 */
        const base = canvas.toDataURL("image/jpeg", 0.9);
        callback(base);
    };
}

/*
 * 将以Base64的图片Url数据转换为Blob
 * @param base64用url方式表示的base64图片数据
 */
const convert_base64_url_to_blob = function (base64) {
    let arr = base64.split(','),
        mime = arr[0].match(/:(.*?);/)[1],
        b = atob(arr[1]),
        n = b.length,
        u8arr = new Uint8Array(n);
    while (n--) {
        u8arr[n] = b.charCodeAt(n);
    }
    return new Blob([u8arr], {
        type: mime
    });
}



