$(document).ready(function () {
    var username = sessionStorage.getItem("username");
    var user = {};
    user.account = username;
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            $("#info_u").html("用户名：" + data.account);
            $("#info_m").html("邮箱：" + data.mail);
            $("#info_p").html("联系电话：" + data.phone);
            $("#info_d").html("注册日期：" + data.date);
        }
    });

    var val = sessionStorage.getItem("act");
    if(val === "two"){
        $("#pills-modify-tab").addClass("active");
        $("#pills-modify").addClass("show active");
    }
    else if (val === "three"){
        $("#pills-add-tab").addClass("active");
        $("#pills-add").addClass("show active");
    }
    else if (val === "four"){
        $("#pills-sub-tab").addClass("active");
        $("#pills-sub").addClass("show active");
    }
    else {
        $("#pills-user-tab").addClass("active");
        $("#pills-user").addClass("show active");
    }
    sessionStorage.removeItem("act");
});

//判断修改密码部分提交的数据是否符合规范
$("#btn_change").click(function () {
    var passwordreg = /^[a-z0-9_-]{6,16}$/;
    var maimreg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    var phonereg = /^1(3|4|5|7|8)\d{9}$/;
    var usern = $("#usern").val();
    var oldpassw = $("#oldpassw").val();
    var passw = $("#newpassw").val();
    var mail = $("#mail").val();
    var phone = $("#phone").val();
    if(usern ===""||oldpassw===""||passw===""||mail===""||phone===""){
        $("#text_change").html("所有字段不能为空");
        $("#close_change").show();
        $("#sure_change").hide();
    }
    else {
        if(!passwordreg.test(passw)){
            $("#newpassw").val("");
            $("#text_change").html("新密码格式不正确，请重新填写");
            $("#close_change").show();
            $("#sure_change").hide();
        }
        else if(!maimreg.test(mail)){
            $("#mail").val("");
            $("#text_change").html("邮箱格式不正确，请重新填写");
            $("#close_change").show();
            $("#sure_change").hide();
        }
        else if(!phonereg.test(phone)){
            $("#phone").val("");
            $("#text_change").html("手机号码格式不正确，请重新填写");
            $("#close_change").show();
            $("#sure_change").hide();
        }
        else {
            $("#text_change").html("确定将密码修改为新密码？");
            $("#close_change").hide();
            $("#sure_change").show();
        }
    }
});

//判断新增管理员部分提交的数据是否符合规范
$("#btn_add").click(function () {
    var passwordreg = /^[a-z0-9_-]{6,16}$/;
    var maimreg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    var phonereg = /^1(3|4|5|7|8)\d{9}$/;
    var userna = $("#userna").val();
    var passw = $("#newpasswo").val();
    var mail = $("#mail1").val();
    var phone = $("#phone1").val();
    if(userna ===""||passw===""||mail===""||phone===""){
        $("#text_add").html("所有字段不能为空");
        $("#close_add").show();
        $("#sure_add").hide();
    }
    else {
        if(!passwordreg.test(passw)){
            $("#newpasswo").val("");
            $("#text_add").html("新密码格式不正确，请重新填写");
            $("#close_add").show();
            $("#sure_add").hide();
        }
        else if(!maimreg.test(mail)){
            $("#mail1").val("");
            $("#text_add").html("邮箱格式不正确，请重新填写");
            $("#close_add").show();
            $("#sure_add").hide();
        }
        else if(!phonereg.test(phone)){
            $("#phone1").val("");
            $("#text_add").html("手机号码格式不正确，请重新填写");
            $("#close_add").show();
            $("#sure_add").hide();
        }
        else {
            $("#text_add").html("确定新增此管理员？");
            $("#close_add").hide();
            $("#sure_add").show();
        }
    }
});

$("#btn_sub").click(function () {
    var usern = $("#usernam").val();
    var passw = $("#oldpasswor").val();
    if(usern===""||passw===""){
        $("#text_sub").html("所有字段不能为空");
        $("#close_sub").show();
        $("#sure_sub").hide();
    }
    else {
        $("#text_sub").html("确认删除此管理员？");
        $("#close_sub").hide();
        $("#sure_sub").show();
    }
});

//提交修改密码的数据
$("#sure_change").click(function () {
    var usern = $("#usern").val();
    var passw = $("#newpassw").val();
    var mail = $("#mail").val();
    var phone = $("#phone").val();
    var user = {};
    var now = new Date();
    user.usern = usern;                                                       //==================*********************
    user.passw = passw;
    user.mail = mail;
    user.phone = phone;

    $.ajax({
        url: "",
        type: "post",
        dataType: "json",
        data: JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            alert("修改成功");
            $("#usern").val("");
            $("#oldpassw").val("");
            $("#newpassw").val("");
            $("#mail").val("");
            $("#phone").val("");
        },
        error:function () {
            alert("修改");
            $("#usern").val("");
            $("#oldpassw").val("");
            $("#newpassw").val("");
            $("#mail").val("");
            $("#phone").val("");
        }
    });
});

//提交新增管理员的数据
$("#sure_add").click(function () {
    var userna = $("#userna").val();
    var passwo = $("#newpasswo").val();
    var mail1 = $("#mail1").val();
    var phone1 = $("#phone1").val();
    var user = {};
    var now = new Date();
    user.register_date = now.toLocaleDateString();
    user.usern = userna;                                  //==================*********************
    user.passw = passwo;
    user.mail1 = mail1;
    user.phone1 = phone1;
    $.ajax({
        url: "",
        type: "post",
        dataType: "json",
        data: JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            alert("增加成功");
            $("#userna").val("");
            $("#newpasswo").val("");
            $("#mail1").val("");
            $("#phone1").val("");
        },
        error:function () {
            alert("增加");
            $("#userna").val("");
            $("#newpasswo").val("");
            $("#mail1").val("");
            $("#phone1").val("");
        }
    });
});

//提交删除管理员的数据
$("#sure_sub").click(function () {
    var usernam = $("#usernam").val();
    var oldpasswor = $("#oldpasswor").val();
    var user = {};
    user.usernam = usernam;                                                  //==================*********************
    user.oldpasswpr = oldpasswor;
    $.ajax({
        url: "",
        type: "post",
        dataType: "json",
        data: JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            alert("删除成功");
            $("#usernam").val("");
            $("#oldpasswor").val("");
        },
        error:function () {
            alert("删除");
            $("#usernam").val("");
            $("#oldpasswor").val("");
        }
    });
});