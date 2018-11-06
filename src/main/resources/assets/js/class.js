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
                $("#classInfoTableBody").append('<tr><td>' + info.no + '</td><td>' + info.title + '</td></tr>');
            });
            // location.reload(); // 새로고침
        },
        error: function (request, status, error) {
            alert("Fail");
            // location.reload(); // 새로고침
        }
    })


});