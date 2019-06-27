
var lis;
var maxlength;
var curindex;

//展示客户
$(document).ready(function () {
    $("#tab").html("");
    curindex = 1;
    var user = {};
    user.start = "start";
    $.ajax({
        url:"http://localhost:8080/client/list",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            lis = data;
            var length = lis.length;
            maxlength = Math.ceil(length / 10);
            init(maxlength);
            for(var i = (curindex-1)*10;i<(curindex-1)*10+10;i++){
                var s = "<tr>"+
                    "<th>"+(i+1)+"</th>"+                              //////////////////////////////////////////
                    "<th>"+lis[i].clientName+"</th>"+
                    "<th>"+lis[i].clientContact+"</th>"+
                    "<th>"+lis[i].clientSex+"</th>"+
                    "<th>"+lis[i].clientPhone+"</th>"+
                    "<th>"+lis[i].clientEmail+"</th>"+
                    "<th>"+lis[i].clientAddress+"</th>"+
                    "</tr>";
                $("#tab").append(s);
            }
        },
        error:function () {
            alert("加载失败");
        }
    });
});


//增加客户
$("#btn_add").click(function () {
    var maimreg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    var phonereg = /^1(3|4|5|7|8)\d{9}$/;
    var cliname = $("#cliname").val();
    var name = $("#name").val();
    var sex = $("#sex").val();
    var phone = $("#phone").val();
    var email = $("#mail").val();
    var address = $("#address").val();
    if (cliname ===""||name === ""||sex === ""||phone === ""||email === ""||address === ""){
        $("#con_add").html("所有字段不能为空");
        $("#close_add").show();
        $("#sure_add").hide();
    }
    else {
        if(!maimreg.test(email)){
            $("#mail").val("");
            $("#con_add").html("邮箱格式不正确，请重新填写");
            $("#close_add").show();
            $("#sure_add").hide();
        }
        else if(!phonereg.test(phone)){
            $("#phone").val("");
            $("#con_add").html("手机号码格式不正确，请重新填写");
            $("#close_add").show();
            $("#sure_add").hide();
        }
        else {
            $("#con_add").html("确定新增此客户？");
            $("#close_add").hide();
            $("#sure_add").show();
        }
    }
});

$("#sure_add").click(function () {
    var cliname = $("#cliname").val();
    var name = $("#name").val();
    var sex = $("#sex").val();
    var phone = $("#phone").val();
    var email = $("#mail").val();
    var address = $("#address").val();
    var user = {};
    user.clientName = cliname;
    user.clientContact = name;
    user.clientSex = sex;
    user.clientPhone = phone;
    user.clientEmail = email;
    user.clientAddress = address;
    $.ajax({
        url: "http://localhost:8080/client/register",
        type:"post",
        dataType: "json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.msg === "fail"){
                alert("增加失败");
            }else {
                alert("增加成功！");
                $("#cliname").val("");
                $("#name").val("");
                $("#sex").val("");
                $("#phone").val("");
                $("#mail").val("");
                $("#address").val("");
            }

        },
        error:function () {
            alert("失败");
        }
    })
});


//删除客户
$("#btn_sub").click(function () {
    var n = $("#n").val();
    var user = {};
    user.clientName = n;
    if(n === ""){
        $("#con_sub").html("客户名称不能为空");
        $("#close_sub").show();
        $("#sure_sub").hide();
    }else {
        $.ajax({
            url:"http://localhost:8080/client/showbyname",
            type:"post",
            dataType:"json",
            data: JSON.stringify(user),
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                if(data.msg ==="fail"){
                    $("#con_sub").html("该客户不存在，请确认客户名称无误");
                    $("#close_sub").show();
                    $("#sure_sub").hide();
                }else {
                    $("#con_sub").html("确认删除该客户？");
                    $("#close_sub").hide();
                    $("#sure_sub").show()
                }
            },
            error:function () {
                $("#con_sub").html("出错啦？");
                $("#close_sub").show();
                $("#sure_sub").hide();
            }
        })
    }
});

$("#sure_sub").click(function () {
    var name = $("#n").val();
    var user = {};
    user.clientName = name;
    $.ajax({
        url:"http://localhost:8080/client/remove",
        type:"post",
        dataType:"json",
        data: JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.msg === "fail"){
                alert("删除失败");
            }else {
                alert("删除成功！")
                $("#n").val("");
            }

        },
        error:function () {
            alert("失败");
        }
    })
});





//分页功能
//初始化页数
function init(maxlength) {
    if (maxlength > 5) {
        $("#ellihead").hide();
        $("#pagec1").show();
        $("#pagec2").show();
        $("#pagec3").show();
        $("#ellifoot").show();
        $("#pagelast").show();
        $("#pagelast a").html(maxlength);
    } else if (maxlength > 4) {
        $("#ellihead").hide();
        $("#pagec1").show();
        $("#pagec2").show();
        $("#pagec3").show();
        $("#ellifoot").hide();
        $("#pagelast").show();
        $("#pagelast a").html(maxlength);
    } else if (maxlength > 3) {
        $("#ellihead").hide();
        $("#pagec1").show();
        $("#pagec2").show();
        $("#pagec3").show();
        $("#ellifoot").hide();
        $("#pagelast").hide();
        $("#pagelast a").html(maxlength);
    } else if (maxlength > 2) {
        $("#ellihead").hide();
        $("#pagec1").show();
        $("#pagec2").show();
        $("#pagec3").hide();
        $("#ellifoot").hide();
        $("#pagelast").hide();
        $("#pagelast a").html(maxlength);
    } else if (maxlength > 1) {
        $("#ellihead").hide();
        $("#pagec1").show();
        $("#pagec2").hide();
        $("#pagec3").hide();
        $("#ellifoot").hide();
        $("#pagelast").hide();
        $("#pagelast a").html(maxlength);
    } else {
        $("#ellihead").hide();
        $("#pagec1").hide();
        $("#pagec2").hide();
        $("#pagec3").hide();
        $("#ellifoot").hide();
        $("#pagelast").hide();
        $("#pagelast a").html(maxlength);
    }
}

//换页之后更新页面
function  reshow() {
    $("#tab").html("");
    for(var i = (curindex-1)*10;i<(curindex-1)*10+10;i++){
        var s = "<tr>"+
            "<th>"+(i+1)+"</th>"+                              //////////////////////////////////////////
            "<th>"+lis[i].clientName+"</th>"+
            "<th>"+lis[i].clientContact+"</th>"+
            "<th>"+lis[i].clientSex+"</th>"+
            "<th>"+lis[i].clientPhone+"</th>"+
            "<th>"+lis[i].clientEmail+"</th>"+
            "<th>"+lis[i].clientAddress+"</th>"+
            "</tr>";
        $("#tab").append(s);
    }
}



$("#Previous").click(function () {
    if (maxlength < 5 && curindex <= maxlength) {
        if (curindex === 1) {
        } else if (curindex === 2) {
            $("#pagec1").removeClass("active");
            $("#pagefirst").addClass("active");
            curindex=curindex - 1;
        } else if (curindex === 3) {
            $("#pagec2").removeClass("active");
            $("#pagec1").addClass("active");
            curindex=curindex - 1;
        } else if (curindex === 4) {
            $("#pagec3").removeClass("active");
            $("#pagec2").addClass("active");
            curindex=curindex - 1;
        } else if (curindex === 5) {
            $("#pagelast").removeClass("active");
            $("#pagec3").addClass("active");
            curindex=curindex - 1;
        }
    } else if (maxlength > 5 && curindex <= maxlength) {
        if (curindex <= 3) {
            $("#ellihead").hide();
            $("#ellifoot").show();
            if (curindex === 1) {
            } else if (curindex === 2) {
                $("#pagec1").removeClass("active");
                $("#pagefirst").addClass("active");
                curindex=curindex - 1;
            } else if (curindex === 3) {
                $("#pagec2").removeClass("active");
                $("#pagec1").addClass("active");
                curindex=curindex - 1;
            }
        } else if (curindex > maxlength - 2) {
            $("#ellifoot").hide();
            $("#ellihead").show();
            if (curindex === maxlength - 2) {
                $("#pagec2").removeClass("active");
                $("#pagec1").addClass("active");
                curindex=curindex - 1;
            } else if (curindex === maxlength - 1) {
                $("#pagec3").removeClass("active");
                $("#pagec2").addClass("active");
                curindex=curindex - 1;
            } else if (curindex === maxlength) {
                $("#pagelast").removeClass("active");
                $("#pagec3").addClass("active");
                curindex=curindex - 1;
            }
        } else if (curindex > 2 && curindex <= maxlength - 2) {
            $("#ellifoot").show();
            $("#ellihead").show();
            $("#pagec1 a").html(curindex - 2);
            $("#pagec2 a").html(curindex - 1);
            $("#pagec3 a").html(curindex);
            curindex = curindex - 1;
        }
    }
    reshow();
});
$("#Next").click(function () {
    if (maxlength <= 5 && curindex < maxlength) {
        if (curindex === 1) {
            $("#pagefirst").removeClass("active");
            $("#pagec1").addClass("active");
            curindex=curindex + 1;
        } else if (curindex === 2) {
            $("#pagec1").removeClass("active");
            $("#pagec2").addClass("active");
            curindex=curindex + 1;
        } else if (curindex === 3) {
            $("#pagec2").removeClass("active");
            $("#pagec3").addClass("active");
            curindex=curindex + 1;
        } else if (curindex === 4) {
            $("#pagec3").removeClass("active");
            $("#pagelast").addClass("active");
            curindex=curindex + 1;
        } else if (curindex === 5) {
        }
    } else if (maxlength > 5 && curindex < maxlength) {
        if (curindex < 3) {
            $("#ellihead").hide();
            $("#ellifoot").show();
            if (curindex === 1) {
                $("#pagefirst").removeClass("active");
                $("#pagec1").addClass("active");
                curindex=curindex + 1;
            } else if (curindex === 2) {
                $("#pagec1").removeClass("active");
                $("#pagec2").addClass("active");
                curindex=curindex + 1;
            } else if (curindex === 3) {
                $("#pagec2").removeClass("active");
                $("#pagec3").addClass("active");
                curindex=curindex + 1;
            }
        } else if (curindex >= maxlength - 2) {
            $("#ellifoot").hide();
            $("#ellihead").show();
            if (curindex === maxlength - 2) {
                $("#pagec2").removeClass("active");
                $("#pagec3").addClass("active");
                curindex=curindex + 1;
            } else if (curindex === maxlength - 1) {
                $("#pagec3").removeClass("active");
                $("#pagelast").addClass("active");
                curindex=curindex + 1;
            } else if (curindex === maxlength) {
            }
        } else if (curindex > 2 && curindex < maxlength - 2) {
            $("#ellifoot").show();
            $("#ellihead").show();
            $("#pagec1 a").html(curindex);
            $("#pagec2 a").html(curindex + 1);
            $("#pagec3 a").html(curindex + 2);
            curindex=curindex + 1;
        }
    }
    reshow();
});

$("#pagefirst").click(function () {
    if(maxlength > 5){
        $("#ellihead").hide();
        $("#ellifoot").show();
    }else {
        $("#ellihead").hide();
        $("#ellifoot").hide();
    }
    $("#pagefirst").addClass("active");
    $("#pagec1").removeClass("active");
    $("#pagec2").removeClass("active");
    $("#pagec3").removeClass("active");
    $("#pagelast").removeClass("active");
    $("#pagec1 a").html(2);
    $("#pagec2 a").html(3);
    $("#pagec3 a").html(4);
    curindex = 1;
    reshow();
});

$("#pagelast").click(function () {
    if(maxlength > 5){
        $("#ellihead").show();
        $("#ellifoot").hide();
    }else {
        $("#ellihead").hide();
        $("#ellifoot").hide();
    }
    $("#pagefirst").removeClass("active");
    $("#pagec1").removeClass("active");
    $("#pagec2").removeClass("active");
    $("#pagec3").removeClass("active");
    $("#pagelast").addClass("active");
    $("#pagec1 a").html(maxlength-3);
    $("#pagec2 a").html(maxlength-2);
    $("#pagec3 a").html(maxlength-1);
    curindex  = maxlength;
    reshow();
});

$("#pagec1").click(function () {
    var index = parseInt($("#pagec1 a").html());
    if(index < 3 && maxlength <5){
        $("#ellihead").hide();
        $("#ellifoot").hide();
        $("#pagefirst").removeClass("active");
        $("#pagec1").addClass("active");
        $("#pagec2").removeClass("active");
        $("#pagec3").removeClass("active");
        $("#pagelast").removeClass("active");
        curindex = index;
    }else if(index < 3 && maxlength >= 5){
        $("#ellihead").hide();
        $("#ellifoot").show();
        $("#pagefirst").removeClass("active");
        $("#pagec1").addClass("active");
        $("#pagec2").removeClass("active");
        $("#pagec3").removeClass("active");
        $("#pagelast").removeClass("active");
        curindex = index;
    }
    else {
        $("#ellihead").show();
        $("#ellifoot").show();
        $("#pagefirst").removeClass("active");
        $("#pagec1").removeClass("active");
        $("#pagec2").addClass("active");
        $("#pagec3").removeClass("active");
        $("#pagelast").removeClass("active");
        $("#pagec1 a").html(index-1);
        $("#pagec2 a").html(index);
        $("#pagec3 a").html(index+1);
        curindex = index;
    }
    reshow();
});

$("#pagec2").click(function () {
    var index = parseInt($("#pagec2 a").html());
    $("#pagefirst").removeClass("active");
    $("#pagec1").removeClass("active");
    $("#pagec2").addClass("active");
    $("#pagec3").removeClass("active");
    $("#pagelast").removeClass("active");
    $("#pagec1 a").html(index-1);
    $("#pagec2 a").html(index);
    $("#pagec3 a").html(index+1);
    curindex = index;
    reshow();
});

$("#pagec3").click(function () {
    var index = parseInt($("#pagec3 a").html());
    if(index > maxlength-2 && maxlength <= 5){
        $("#ellihead").hide();
        $("#ellifoot").hide();
        $("#pagefirst").removeClass("active");
        $("#pagec1").removeClass("active");
        $("#pagec2").removeClass("active");
        $("#pagec3").addClass("active");
        $("#pagelast").removeClass("active");
        curindex = index;
    }else if(index > maxlength-2 && maxlength > 5){
        $("#ellihead").show();
        $("#ellifoot").hide();
        $("#pagefirst").removeClass("active");
        $("#pagec1").removeClass("active");
        $("#pagec2").removeClass("active");
        $("#pagec3").addClass("active");
        $("#pagelast").removeClass("active");
        curindex = index;
    }
    else {
        $("#ellihead").show();
        $("#ellifoot").show();
        $("#pagefirst").removeClass("active");
        $("#pagec1").removeClass("active");
        $("#pagec2").addClass("active");
        $("#pagec3").removeClass("active");
        $("#pagelast").removeClass("active");
        $("#pagec1 a").html(index-1);
        $("#pagec2 a").html(index);
        $("#pagec3 a").html(index+1);
        curindex = index;
    }
    reshow();
});
