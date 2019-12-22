$(function () {
    $(".alert").hide();
    $(".delete").click(function () {
        if (confirm("确定要删除吗?")) {
            const typeId = $(this).attr("data");
            $.getJSON("/videoType/deleteType",{"typeId":typeId},function (result) {
                $(".alert").show();
                window.setTimeout("window.location='/videoType/inVideoType'",3000);
                for (let i=3; i>0;i-- ){
                    $(".alert").text(result.msg+"     页面将在"+i+"秒后刷新······");
                }
            });
        }
    });

    $.getJSON("/videoType/getType", function (result) {
        $.each(result.data,function (index,type) {
            const $select = $("<option value=''></option>");
            $select.val(type.typeId);
            $select.html(type.typeName);
            $("#typePid").append($select);
        })
    });

    $("#add").click(function () {
        const typeName = $("#typeName").val();
        const typePid = $("#typePid").val();
        $.getJSON("/videoType/insertType",{"typeName":typeName,"typePid":typePid},function (result) {
            $(".alert").show();
            window.setTimeout("window.location='/videoType/inVideoType'",3000);
            for (let i=3; i>0;i-- ){
                $(".alert").html(result.msg+"     页面将在"+i+"秒后刷新······");
            }
        });
    });
})