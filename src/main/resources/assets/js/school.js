$(document).ready(function () {
    // alert("Document Ready");

    $("#addSchool").click(function (e) {
        AddShcool("Test");
    });
});

function AddShcool(name) {
    // alert(name);

    var data = {};
    data["schoolName"] = name;

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        url: '/admin/addSchool',
        type: 'POST',
        success: function (response) {
            alert("Success");
        },
        error: function (request, status, error) {
            alert("Fail");
        }
    })
}