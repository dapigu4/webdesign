/*jQuery(document).ready(function () {
    $("#btn1").html("获取验证码");
})*/

$("#mail").change(function () {
    var reg1 = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    var reg2 = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
    var mail = $("#mail").val();
    if(!reg1.test(mail)&&!reg2.test(mail))
    {
        $("#tip").hide();
        $("#alert1").html("邮箱格式不正确请重新输入");
        $("#alert1").show();
    }
    else {
        $("#tip").show();
        $("#alert1").html("");
        $("#alert1").hide();
        $("#btn1").show();
    }
});

$("#btn1").click(function (){
    $("#tip").hide();
    $("#alert2").html("");
    $("#alert2").hide();
    $("#part3").show();
    $("#btn1").hide();
    $("#btn3").show();
    var mail = $("#mail").val();
    var username = $("#username").val();
    $.ajax({
        url:"http://localhost:8080/administrator/forget",
        type:"post",
        dataType:"json",
        data:{ "username":username,"mail":mail},
        success:function (data) {
            $("#sb").html(data.msg);
            if (data.msg === "error"){
                $("#btn1").show();
                $("#btn3").hide();
                $("#part3").hide();
            }
            else {
                sessionStorage.setItem("temp_username",username);
                sessionStorage.setItem("ver",data.msg);
            }
        },
        error:function (data) {
            $("#sb").html("error function");
        }
    });
});

$("#btn3").click(function () {
    var verification = $("#verification").val();
    var ver = sessionStorage.getItem("ver");
    if(verification === ver )
    {
        $("#part1").hide();
        $("#part2").show()
    }
    else{
        $("#verification").val("");
        $("#alert2").show();
        $("#alert2").html("验证码错误，请重新获取");
        $("#part3").hide()
        $("#btn3").hide();
        $("#btn1").show();
    }
});

$("#password").change(function () {
    var reg3 = /^[a-z0-9_-]{6,16}$/;
    var password = $("#password").val();
    if(reg3.test(password))
    {
            $("#alert3").hide();
            $("#tip2").hide()
    }
    else{
            $("#alert3").html("密码格式不正确");
            $("#alert3").show();
            $("#btn2").hide()
    }
});

$("#password").focus(function () {
    $("#alert4").hide();
});

$("#password_r").focus(function () {
    var password = $("#password").val();
    var password_r = $("#password_r").val();
    if(password !== password_r){
        $("#btn2").hide();
    }
});

$("#password_r").change(function () {
    var password = $("#password").val();
    var password_r = $("#password_r").val();
    if(password === password_r)
    {
        $("#alert4").hide();
        $("#btn2").show();
    }
    else{
        $("#alert4").html("两次密码不一致,请重新输入");
        $("#alert4").show();
        $("#password").val("");
        $("#password_r").val("");
        $("#btn2").hide();
    }
});

$("#btn2").click(function () {
    var password = $("#password").val();
    var password_r = $("#password_r").val();
    var temp = sessionStorage.getItem("temp_username");
    if(password === password_r)
    {
        $("#alert4").hide();
        $("#btn2").show();
        $.ajax({
            url:"http://localhost:8080/administrator/modify",
            type:"post",
            dataType:"json",
            data:{"username":temp,"password":password},
            success:function () {
                window.location.href="http://localhost:8080/login.html";
            },
            error:function () {
                alert("error");
            }
        });
    }
    else{
        $("#alert4").html("两次密码不一致,请重新输入");
        $("#alert4").show();
        $("#password").val("");
        $("#password_r").val("");
        $("#btn2").hide();
    }
});

