$(function () {
    $(".delete").click(function () {
        const videoId = $(this).attr("data");
        const fileName = $(this).attr("datas");
        $.getJSON("/audit/auditFailure",{"videoId":videoId,"filename":fileName},function (result) {
            console.log(result.msg);
            window.setTimeout("window.location='/audit/inAudit'",3000);
        });
    });
});