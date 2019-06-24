<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/5/17
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
welcome ${user}
<p id="test"></p>
<button type="button" onclick="ok()">dianwo</button>
<script>
        function ok() {
            // $.ajax({
            //     url:"http://localhost:8080/Demo3_war/user/list",
            //     type:"get",
            //     dataType:"json",
            //     success:function (data) {
            //         $("#test").html("11111");
            //     },
            //     error:function () {
            //         $("#test").html("222222");
            //     }
            // })
            var username = sessionStorage.getItem("username");
            $("#test").html(username);
        }
</script>
<script  src="../../js/popper.js/popper.min.js"></script>
<script  src="../../js/jQuery/jquery-3.4.1.min.js"></script>
</body>
</html>
