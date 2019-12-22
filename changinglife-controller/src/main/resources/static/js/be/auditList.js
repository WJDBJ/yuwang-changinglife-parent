$(function () {
//视频
    jsModern.video("#video");
    //播放视频
    $(".VideoBtn").click(function () {
        var video = document.getElementById("videoShow");
        video.play();
        $('.VideoBtn').hide();
    })
    //监听视频的播放状态
    var video = document.getElementById("videoShow");
    video.oncanplay = function () {
        $(".VideoBtn").show();
        //$("#video").attr("poster","");
    }
    //视频播放事件
    video.onplay = function () {
        $("#videoShow").attr("poster", "");
        $(".VideoBtn").hide();
    };
    video.onplaying = function () {
        $(".VideoBtn").hide();
    };

    //视频暂停事件
    video.onpause = function () {
        $(".VideoBtn").show();
    };
    //点击视频周围暂停播放图片出现
    video.onclick = function () {
        if (video.paused) {
            $(".VideoBtn").hide();
            video.play();
        } else {
            $(".VideoBtn").show();
            video.pause();
        }
    };

    let myArray=[];
    $.getJSON("/videoType/getTypes", function (result) {
        $.each(result.data,function (index,type) {
            const $select = $("<option value=''></option>");
            $select.val(type.typeId);
            $select.html(type.typeName);
            $("#typePid").append($select);
        })
    });

    $("#add").click(function () {
        const typePid = $("#typePid").val();
        const videoId = $(".btns").attr("data");
        const obj = {videoId:videoId}
        if(myArray.length == 0) {
            obj.typeId = typePid;
        }else {
            obj.typeId = myArray;
        }
        console.log(obj)
        $.getJSON("/audit/goAudit",obj,function (result) {
             console.log(result.msg);
             window.setTimeout("window.location='/audit/inAudit'",3000);
        });
    });

    $(".btnx").click(function () {
        const typePid = $("#typePid").val();
        myArray.push(typePid)
        console.log(myArray)
    });
})