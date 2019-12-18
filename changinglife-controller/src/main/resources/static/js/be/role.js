$(function () {
    $(".alert").hide();
    $("#add").click(function () {
        const status_name = $("#status_name").val();
        const status_dosc = $("#status_desc").val();
        $.getJSON(
            "/role/roleAdd",
            {"statusName":status_name,"statusDescription":status_dosc},
            function (result) {
                location.href="/role/inRole";
                $(".alert").text(result.msg);
                $(".alert").show();
            }
        );
    });

    $("#deleteA").click(function () {
        const status_id = $("#deleteA").attr("data");
        $.getJSON(
            "/role/roleDelete",
            {"statusId":status_id},
            function (result) {
                location.href="/role/inRole";
                $(".alert").text(result.msg);
                $(".alert").show();
            }
        );
    });

    $(".privilegeA").click(function () {
        statusId = $(this).attr("data");
        $.getJSON("/privilege/list", {"statusId": statusId}, function (result) {
            $.fn.zTree.init($("#tree"), setting, result);
        })
    });

    const setting = {
        check: {
            //使用复选框
            enable: true
        },
        data: {
            //使用外部数据
            simpleData: {
                enable: true
            }
        }
    };

    function getIdsFromCheckNodes(event, treeId, treeNode) {       //第二步
        const treeObj = $.fn.zTree.getZTreeObj("tree"),
            nodes = treeObj.getCheckedNodes(true),
            id = [];
        for (let i = 0; i < nodes.length; i++) {
            id[i] = nodes[i].id; //第三部
        }
        return id;
    }

    $("#privilege").click(function () {
        $.ajax({
            url: "/privilege/inPrivilege",
            type: "post",
            traditional: true,
            data: {"ids":getIdsFromCheckNodes(),"statusId":statusId},
            success: function (result) {
                $(".alert").text(result.msg);
                $(".alert").show();
            }
        });
    });
});