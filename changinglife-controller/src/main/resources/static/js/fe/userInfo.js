$(function() {
    $(document).ajaxError(function () {
        alert("一个错误的发生！");
    })

    $("#user_date").change(function(){
        $("#user_date").attr("value",$(this).val()); //赋值
    });

    $("#updateInfo").click(function () {
        const user_name = $("#user_name").val();
        const user_sex = $('input:radio:checked').val();
        const user_date = $("#user_date").val();
        const user_address = $("#province").val()+$("#city").val()+$("#district").val();
        const user_desc = $("#user_desc").val();
        let formDate = new FormData();
        formDate.append("infoName",user_name);
        formDate.append("infoGender",user_sex);
        formDate.append("infoBirthday",user_date);
        formDate.append("infoAddress",user_address);
        formDate.append("infoDesc",user_desc);
        alert(user_name+" , "+user_sex+" , "+user_date+" , "+user_address+" , "+user_desc);
        $.ajax({
            url: '/personalInformation/modify',
            type: 'POST',
            dataType: "json",
            data: formDate,
            success: result(),
            error:result()
        });
    });

    function result(data) {
        console.log(data.msg);
        $(".tailoring-container").toggle();
    }
});