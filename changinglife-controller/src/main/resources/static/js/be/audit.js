$(function () {
    $(".delete").click(function () {
        const videoId = $(this).attr("data");
        $.getJSON("/audit/auditFailure",{"videoId":videoId},function (result) {
            console.log(result.msg);
            window.setTimeout("window.location='/audit/inAudit'",3000);
        });
    });
});