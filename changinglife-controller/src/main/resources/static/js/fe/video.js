$(function () {
    $("#Contribute").click(function () {
        alert("ssss")
        const loginId = $(this).attr("data");
        $.ajax({
           url:"/contribute/inContribute",
           type:"get",
           data:{"loginId":loginId},
           success:function (result) {
               if (result.code=="200") {
                   location.href = result.data+"?loginId="+loginId;
               }else {
                   location.href = result.data+"?userId="+loginId;
               }
           }
        });
    });

});