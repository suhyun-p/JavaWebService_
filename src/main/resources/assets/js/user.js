$(document).ready(function () {
    // alert("Document Ready");

    $("#regUser").click(function (e) {
        var userNickname = $("#userNicknameText").val()
        var userSex = $(':input[name=sexRdo]:radio:checked').val();

        RegUser(userNickname, userSex);
    });

    $("#nicknameSearch").click(function (e) {
       var nicknameSearch  = $("#nicknameSearchText").val();
        SearchNickname(nicknameSearch);
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

function enrollTutor(userNickname, userNo) {

    if(confirm(userNickname + " 님을 Tutor로 등록하시겠습니까?")){
        var data = {};
        data["userNo"] = userNo;
        data["userType"] = "Tutor";

        $.ajax({
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(data),
            url: '/admin/enrollTutor',
            type: 'POST',
            success: function (response) {
                alert("Success");

                $("#userType_" + userNo + "").text("Tutor");
                $("#userType_" + userNo + "").removeAttr('style')
                $("#userType_" + userNo + "").attr('onclick', '').unbind('click');
            },
            error: function (request, status, error) {
                alert("Fail");
                location.reload(); // 새로고침
            }
        })
    }
}

function SearchNickname(nickname) {

    if(nickname != "") {

        // 검색어 입력
        var data = {};
        data["nickname"] = nickname;

        $.ajax({
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(data),
            url: '/admin/searchUser',
            type: 'POST',
            success: function (response) {
                $("#userInfoTableBody").empty();
                $.each(eval(response.Data.body), function (index, info) {
                    if(info.type == "Normal")
                        $("#userInfoTableBody").append('<tr><td>' + info.no + '</td><td>' + info.nickname + '</td><td>' + info.sex + '</td><td id="userType_' + info.no + '" style="text-decoration:underline" onclick="enrollTutor(\'' + info.nickname + '\' , \'' + info.no + '\');">' + info.type + '</td></tr>');
                    else
                        $("#userInfoTableBody").append('<tr><td>' + info.no + '</td><td>' + info.nickname + '</td><td>' + info.sex + '</td><td>' + info.type + '</td></tr>');
                });
            },
            error: function (request, status, error) {
                alert("Fail");
                // location.reload(); // 새로고침
            }
        })
    }
    else{
        // 검색어 없음 >> Page Reload
        location.reload(); // 새로고침
    }
}