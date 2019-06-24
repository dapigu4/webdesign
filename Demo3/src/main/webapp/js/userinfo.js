$(document).ready(function () {
   var username = sessionStorage.getItem("username");
   $("#user").html(username);
});