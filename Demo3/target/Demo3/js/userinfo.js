//获取用户名
$(document).ready(function () {
   var username = sessionStorage.getItem("username");
   if(username !== null){
      $("#user").html(username);
   }
   else {
      $("#user").html("用户名");
   }
});

//退出登录
$("#btn_quit").click(function () {
   sessionStorage.removeItem("username");
   var admin = {};
   $.ajax({
      url:"http://localhost:8080/administrator/logout",
      type:"post",
      data:JSON.stringify(admin),
      contentType:"application/json;charset=utf-8",
      dataType:"json",
      success:function (data) {
      },
      error:function () {
      }
   });
   window.location.href = "login.html";
});

//确定用户操作的选中项
$("#nav a").each(function () {
   $(this).click(function () {
      var val = $(this).attr("id");
      sessionStorage.setItem("act",val);
   });
});

//备份功能
$("#btn_backup").click(function () {
   var user = {};
   user.start = "start";
   $.ajax({
      url:"",
      type:"post",
      dataType:"json",
      data:JSON.stringify(user),
      contentType:"application/json;charset=utf-8",
      success:function (data) {
         if(data.msg === "success"){
            alert("备份成功");
         }else {
            alert("备份失败");
         }
      },
      error:function () {
         alert("oh gg")
      }
   })
});


//还原功能
$("#btn_reduction").click(function () {
   var user = {};
   user.start = "start";
   $.ajax({
      url:"",
      type:"post",
      dataType:"json",
      data:JSON.stringify(user),
      contentType:"application/json;charset=utf-8",
      success:function (data) {
         if(data.msg === "success"){
            alert("还原成功");
         }else {
            alert("还原失败");
         }
      },
      error:function () {
         alert("oh gg")
      }
   })
});







