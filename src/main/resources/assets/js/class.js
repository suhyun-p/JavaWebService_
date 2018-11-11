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
            setClassInfo(response.Data.body);
            // location.reload(); // 새로고침
        },
        error: function (request, status, error) {
            alert("Fail");
            // location.reload(); // 새로고침
        }
    })

    $("#exampleModalLong").modal();
}

function setClassInfo(info) {
    $("#classCurriculum").empty();
    $("#classDate").empty();
    $("#classPrice").empty();

    $("#classTitle").text(info.title);

    if(info.tutorNo2 != null) {
        var tutorText = info.tutorName1 + " & " + info.tutorName2;
        $("#classTutor").text(tutorText);
    }
    else
        $("#classTutor").text(info.tutorName1);

    if(info.curriculums.length != 0) {
        info.curriculums.forEach(i => $("#classCurriculum").append('<span>' + i + '</span><br/>'));
    }

    if(info.dateOptionList.length != 0) {
        info.dateOptionList.forEach(i => $("#classDate").append('<span>' + i + '</span><br/>'));
    }

    if(info.priceOptionList.length != 0) {
        info.priceOptionList.forEach(i => $("#classPrice").append('<span>' + i + '</span><br/>'));
    }

    $("#classRoom").text(info.room);
    $("#classPayment").text(info.payment);
    $("#classContact").text(info.contact);

}