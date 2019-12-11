$(function(){
    $(document).ajaxError(function(){
        alert("一个错误的发生！");
    })
    function getName() {
        const obj = {"name":id};
        $.getJSON("/getName",obj,function(data){
            if(data.code == "200") {
                alert(data.msg);
                $("#name").val(data.data.infoName);
                $("#img").attr("src",data.data.infoImg)
            }else if(data.code == "500") {
                console.log(data.msg);
            }
        });
    }
    getName();
});