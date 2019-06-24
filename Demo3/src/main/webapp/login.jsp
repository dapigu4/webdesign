<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/5/17
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color: red">${msg}</span>
<img src="images/image1.PNG">

<form action="administrator/forget" method="post">

用户名：<input type="text" id="username" name="username">
    密码：<input type="text" id="password" name="password">
    eamil:<input type="text" id="mail" name="mail">
    <input type="submit" value="登录">

</form>

<p id="test"></p>

<script>
    function getinfo1() {
        var username = $("#username").val();
        $.ajax({
            url:"http://localhost:8080/Demo3_war/user/list",
            type:"post",
            data:{"username":username},
            dataType:"json",
            success:function (data) {
                $("#test").html(data.username);
                $("#test").html(data.password);
                alert(data.username);
                sessionStorage.setItem("username",data.username);
                window.location.href="jsp/welcome.jsp";
            },
            error:function () {
                $("#test").html("222222");

            }
        })

    }
</script>
<script  src="../../js/popper.js/popper.min.js"></script>
<script  src="../../js/jQuery/jquery-3.4.1.min.js"></script>
</body>
</html>
