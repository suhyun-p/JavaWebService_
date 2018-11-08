$(document).ready(function () {
    // alert("Start");

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: "", // JSON.stringify(data),
        url: '/admin/getClassList',
        type: 'POST',
        success: function (response) {
            $.each(eval(response.Data.body), function (index, info) {
                $("#classInfoTableBody").append('<tr><td>' + info.no + '</td><td  onclick="modalTest(\'' + info.no + '\');">' + info.title + '</td></tr>');
            });
            // location.reload(); // 새로고침
        },
        error: function (request, status, error) {
            alert("Fail");
            // location.reload(); // 새로고침
        }
    })
});

function modalTest(classNo) {
    // alert(classNo);

    var data = {};
    data["classNo"] = classNo;

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        url: '/admin/getClass',
        type: 'POST',
        success: function (response) {
            // $("#modalTestText").text(response.Data.body.title);
            // location.reload(); // 새로고침
        },
        error: function (request, status, error) {
            alert("Fail");
            // location.reload(); // 새로고침
        }
    })

    $("#exampleModalLong").modal();
}