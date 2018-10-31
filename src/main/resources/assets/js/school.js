$(document).ready(function () {
    // alert("Document Ready");

    $("#addSchool").click(function (e) {
        var schoolName = $("#schoolNameText").val()
        AddShcool(schoolName);
    });
});

function AddShcool(schoolName) {

    var data = {};
    data["schoolName"] = schoolName;

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        url: '/admin/addSchool',
        type: 'POST',
        success: function (response) {
            alert("Success");
            location.reload(); // 새로고침
        },
        error: function (request, status, error) {
            alert("Fail");
            location.reload(); // 새로고침
        }
    })
}