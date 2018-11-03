$(document).ready(function () {
    // alert("Document Ready");

    $("#regUser").click(function (e) {
        var userNickname = $("#userNicknameText").val()
        var userSex = $(':input[name=sexRdo]:radio:checked').val();

        RegUser(userNickname, userSex);
    });
});

function RegUser(userNickname, userSex) {

    var data = {};
    data["nickname"] = userNickname;
    data["sex"] = userSex;

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        url: '/admin/regUser',
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