$(document).ready(function () {
    $("#test").click(function () {
        alert("dianle");
    });
});
function getinfo1() {
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax({
        url:"",
        type:"post",
        data:{"username":username,"password":password},
        dataType:"json",
        success:function (data) {
            $("#test").innerText=data.username;
        }
    })
}

function getinfo2() {
    $.getJSON("", function (result) {
        $.each(result, function (i, field) {
            $("p").append(field + " ");
        });
    });
}

function getinfo3() {
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax({
        url:"",
        type:"post",
        data:{"username":username,"password":password},
        dataType:"json",
        success:function (data) {
            $("#test").innerText=data.username;
            sessionStorage.setItem("username",data.username);
        }
    })
}

