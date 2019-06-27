$("#btn").click(function () {
   var username = $("#username").val();
   var password = $("#password").val();
   var admin = {};
     admin.account = username;
     admin.password = password;
    $.ajax({
        url:"http://localhost:8080/administrator/login",
        type:"post",
        data:JSON.stringify(admin),
        contentType:"application/json;charset=utf-8",
        dataType:"json",
        success:function (data) {
            //$("#test").innerText=data.username;
            if(data.msg === ""){
                alert("密码或用户名不正确");
            }
            else {
                sessionStorage.setItem("username",data.msg);
                window.location.href="http://localhost:8080/index.html";
            }
        },
        error:function () {
            alert("error");
        }
    })
});