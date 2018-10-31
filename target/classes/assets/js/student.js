$(document).ready(function () {
    // alert("Document Ready");

    $("#addStudent").click(function (e) {
        AddStudent("Test");
    });
});

function AddStudent(name) {
    alert(name);
}