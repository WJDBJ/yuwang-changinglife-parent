$(function () {
    $(".alert").hide();

    $(".pr").click(function () {
        loginId = $(this).attr("data");
    })

    $.getJSON("/admin/getAdmin", function (result) {
        $.each(result.data,function (index,status) {
            const $select = $("<option value=''></option>");
            $select.val(status.statusId);
            $select.html(status.statusName);
            $(".status_name").append($select);
        })
    });

    $("#add").click(function () {
        const login_name = $("#login_name").val();
        const login_pwd = $("#login_pwd").val();
        const status_id = $("#myModal_insert select").val();
        $.getJSON("/admin/addAdmin",
            {"loginAccoun":login_name,"loginPassword":login_pwd,"statusId":status_id},
            function (result) {
                $(".alert").show();
                window.setTimeout("window.location='/admin/inAdmin'",3000);
                for (let i=3; i>0;i-- ){
                    $(".alert").text(result.msg+"     页面将在"+i+"秒后刷新······");
                }
            })
    });

    $("#privilege").click(function () {
        const status_id = $("#myModal_privilege select").val();
        $.getJSON("/admin/privilege",{"statusId":status_id,"loginId":loginId},function (result) {
            $(".alert").show();
            window.setTimeout("window.location='/admin/inAdmin'",3000);
            for (let i=3; i>0;i-- ){
                $(".alert").text(result.msg+"     页面将在"+i+"秒后刷新······");
            }
        });
    });

    $(".delete").click(function () {
        const login_id = $(this).attr("data");
        $.getJSON("/admin/deleteAdmin", {"loginId":login_id}, function (result) {
            $(".alert").show();
            window.setTimeout("window.location='/admin/inAdmin'",3000);
            for (let i=3; i>0;i-- ){
                $(".alert").text(result.msg+"     页面将在"+i+"秒后刷新······");
            }
        });
    });
});