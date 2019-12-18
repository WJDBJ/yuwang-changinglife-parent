$(function () {
    $(document).ajaxError(function () {
        alert("一个错误的发生！");
    })
    function buildTree(data, parentId) {
        const tree = [];
        for (let i = 0; i < data.length; i++) {
            const node = data[i];
            if (node.menuPid == parentId) {
                const newNode = {};
                newNode.menuId = node.menuId;
                newNode.menuName = node.menuName;
                newNode.menuUrl = node.menuUrl;
                newNode.children = buildTree(data, node.menuId);
                tree.push(newNode);
            }
        }
        return tree;
    };


    const generateMenu = function (data) {
        // $(".mainLis").show();
        for (let i = 0; i < data.length; i++) {
            const menuItemData = data[i];
            if(menuItemData.children.length==0){
                continue;
            }
            const $menuItem = $("#mainLi").clone(true);
            $menuItem.attr("class","mainLis")
            $menuItem.find(".header").text(menuItemData.menuName);
            $menuItem.find(".sub-menu").empty();
            for (let j = 0; j < menuItemData.children.length; j++) {
                const $menuChildItem = $(".sub-menu li:first").clone(true);
                $menuChildItem.find("a").attr("_href",menuItemData.children[j].menuUrl);
                $menuChildItem.find("cite").text(menuItemData.children[j].menuName);
                $menuItem.find(".sub-menu").append($menuChildItem);
            }
            $("#nav").append($menuItem);
        }
    };

    //返回的是id,name,uri,parent,pid对象数组
    $.getJSON("/privilege/query", {"id": id}, function (result) {
        $("#hideDiv").hide();
        generateMenu(buildTree(result,0));
        $("#hideDiv").empty();
    });

});// ready end