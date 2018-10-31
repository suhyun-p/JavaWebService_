$(document).ready(function () {
    // alert("Document Ready");

    $("#regStudent").click(function (e) {
        var studentlName = $("#studentName").val();
        var schoolNo = $("#school option:selected").val();

        AddStudent(studentlName, schoolNo);
    });
});

function AddStudent(studentName, schoolNo) {

    var data = {};
    data["studentName"] = studentName;
    data["schoolNo"] = schoolNo;

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        url: '/admin/addStudent',
        type: 'POST',
        success: function (response) {
            alert("Success");
            $(location).attr('href', "/admin/student");
        },
        error: function (request, status, error) {
            alert("fail");
            $(location).attr('href', "/admin/student");
        }
    })
}