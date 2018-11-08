$(document).ready(function () {
    // alert("Start");

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: "", // JSON.stringify(data),
        url: '/admin/getClassList',
        type: 'POST',
        success: function (response) {
            // alert(response);
            $.each(eval(response.Data.body), function (index, info) {
                var a = 1;
            });

            $.each(eval(response.Data.body), function (index, info) {
                $("#classInfoTableBody").append('<tr><td>' + info.no + '</td><td  onclick="modalTest(' + eval(info) + ');">' + info.title + '</td></tr>');
            });
            // location.reload(); // 새로고침
        },
        error: function (request, status, error) {
            alert("Fail");
            // location.reload(); // 새로고침
        }
    })
});

function modalTest(classInfo) {
    alert(classInfo.title);
    $("#modalTestText").text(classInfo.title);
    // $("#modalTestText").text("Test")
    $("#exampleModalLong").modal();
}