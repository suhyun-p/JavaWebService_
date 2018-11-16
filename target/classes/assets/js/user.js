$(document).ready(function () {
    // alert("Document Ready");

    $('#datatables-basic').DataTable({
        responsive: true,
        bPaginate: true,
        pageLength: 5,
        bLengthChange: true,
        lengthMenu : [ 5, 10, 15, 20],
        bAutoWidth: true,
        processing: true,
        ordering: true,
        serverSide: false,
        searching: true,
        ajax : {
            "url":"/api/users/getUserList",
            "type":"GET"
        },
        columns : [
            {data: "no"},
            {data: "nickname"},
            {data: "sex"},
            {data: "tutor"}
        ]
    });

    $("#addUser").click(function (e) {
        var userNickname = $("#userNicknameText").val()
        var userSex = $(':input[name=rdoUserSex]:radio:checked').val();
        var isInstructor = $("#chkInstructor").is(":checked");

        RegUser(userNickname, userSex, isInstructor);
    });
});

function RegUser(userNickname, userSex, isInstructor) {

    var data = {};
    data["nickname"] = userNickname;
    data["sex"] = userSex;
    data["instructor"] = isInstructor;

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        url: '/admin/regUser',
        type: 'POST',
        success: function (response) {
            alert("성공했습니다.");
            $('#datatables-basic').DataTable().ajax.reload(); // Table Reload
        },
        error: function (request, status, error) {
            alert("실패했습니다.");
        }
    })
}

function clearAddUserForm() {
    $("#userNicknameText").val("");
    $(':input[name=rdoUserSex]').prop('checked', false);
    $("#chkInstructor").prop('checked', false);

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

function showCareer(userNo) {

    var data = {};
    data["userNo"] = userNo;

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        url: '/admin/getCareer',
        type: 'POST',
        success: function (response) {
            setCareerInfo(response.Data.body);
        },
        error: function (request, status, error) {
            alert("Fail");
        }
    })

    $("#careerModal").modal();
}

/*
function setCareerInfo(info) {
    $("#exampleModalLongTitle").text(info.nickname + '\'s Career');

    $("#careerProfile").empty();
    $("#careerAwards").empty();
    $("#careerWorkshop").empty();
    $("#careerPerformance").empty();
    $("#careerClass").empty();

    if(info.tutor){
        if(info.profileList.length != 0) {
            $("#careerProfile").append('<h1>Profile</h1>');
            info.profileList.forEach(i => $("#careerProfile").append('<span>' + i + '</span><br/>'));
            $("#careerProfile").append('<br/>');
        }

        if(info.awardsList.length != 0) {
            $("#careerAwards").append('<h1>Awards</h1>');
            info.awardsList.forEach(i => $("#careerAwards").append('<span>' + i + '</span><br/>'));
            $("#careerAwards").append('<br/>');
        }

        if(info.workshopList.length != 0) {
            $("#careerWorkshop").append('<h1>Workshop</h1>');
            info.workshopList.forEach(i => $("#careerWorkshop").append('<span>' + i + '</span><br/>'));
            $("#careerWorkshop").append('<br/>');
        }

        if(info.performanceList.length != 0) {
            $("#careerPerformance").append('<h1>Performance</h1>');
            info.performanceList.forEach(i => $("#careerPerformance").append('<span>' + i + '</span><br/>'));
            $("#careerPerformance").append('<br/>');
        }
    }

    if(info.classList.length != 0) {
        $("#careerClass").append('<h1>Class</h1>');
        info.classList.forEach(i => $("#careerClass").append('<span>' + i + '</span><br/>'));
        $("#careerClass").append('<br/>');
    }
}*/
