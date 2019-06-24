
$("#mon_detail").datepicker({
    format:'yyyy-mm',
    language:"zh-CN",
    startView:1,
    maxViewMode:2,
    minViewMode:1,
    autoclose:true
});
$("#mon_detail").datepicker("setDate",new Date());

$("#mon_totle").datepicker({
    format:'yyyy-mm',
    language:"zh-CN",
    startView:1,
    maxViewMode:2,
    minViewMode:1,
    autoclose:true
});

$("#mon_totle").datepicker("setDate",new Date());

var curindexw;
var curindexf;
var maxlengthw;
var maxlengthf;
var lisw;
var lisf;

$(document).ready(function () {
    $("#in").html("");
    curindexw = 1;
    var mon = $("#mon_totle").val();
    var user = {};
    user.date = mon;
    $.ajax({
        url:"http://localhost:8080/flow/warehouselist",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            lisw = data;
            var length = lisw.length;
            maxlengthw = Math.ceil(length / 10);
            initw(maxlengthw);
            for(var i = (curindexw-1)*10;i<(curindexw-1)*10+10;i++){
                var s = "<tr>"+
                    "<th>"+(i+1)+"</th>"+                              //////////////////////////////////////////
                    "<th>"+lisw[i].name+"</th>"+
                    "<th>"+lisw[i].size+"</th>"+
                    "<th>"+lisw[i].cost+"</th>"+
                    "<th>"+lisw[i].sell+"</th>"+
                    "<th>"+lisw[i].stocks+"</th>"+
                    "</tr>";
                $("#in").append(s);
            }
        },
        error:function () {
            alert("加载失败");
        }
    });
});



$("#mon_totle").change(function () {
    $("#in").html("");
    curindexw = 1;
    var mon = $("#mon_totle").val();
    var user = {};
    user.date = mon;
    $.ajax({
        url:"http://localhost:8080/flow/warehouselist",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            lisw = data;
            var length = lisw.length;
            maxlengthw = Math.ceil(length / 10);
            initw(maxlengthw);
            for(var i = (curindexw-1)*10;i<(curindexw-1)*10+10;i++){
                var s = "<tr>"+
                    "<th>"+(i+1)+"</th>"+                              //////////////////////////////////////////
                    "<th>"+lisw[i].name+"</th>"+
                    "<th>"+lisw[i].size+"</th>"+
                    "<th>"+lisw[i].cost+"</th>"+
                    "<th>"+lisw[i].sell+"</th>"+
                    "<th>"+lisw[i].stocks+"</th>"+
                    "</tr>";
                $("#in").append(s);
            }
        },
        error:function () {
            alert("加载失败");
        }
    });
});

$("#pills-out-tab").click(function () {
    $("#out").html("");
    curindexf = 1;
    var mon = $("#mon_detail").val();
    var user = {};
    user.date = mon;
    $.ajax({
        url:"http://localhost:8080/flow/flowlist",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            lisf = data;
            var length = lisf.length;
            maxlengthf = Math.ceil(length / 10);
            initf(maxlengthf);
            for(var i = (curindexf-1)*10;i<(curindexf-1)*10+10;i++){
                var s = "<tr>"+
                    "<th>"+(i+1)+"</th>"+                              //////////////////////////////////////////
                    "<th>"+lisf[i].date+"</th>"+
                    "<th>"+lisf[i].inOrOut+"</th>"+
                    "<th>"+lisf[i].supplyOrDemand+"</th>"+
                    "<th>"+lisf[i].productName+"</th>"+
                    "<th>"+lisf[i].size+"</th>"+
                    "<th>"+lisf[i].perCost+"</th>"+
                    "<th>"+lisf[i].perSell+"</th>"+
                    "<th>"+lisf[i].count+"</th>"+
                    "</tr>";
                $("#out").append(s);
            }
        },
        error:function () {
            alert("加载失败");
        }
    });
});

$("#mon_detail").change(function () {
    $("#out").html("");
    curindexf = 1;
    var mon = $("#mon_detail").val();
    var user = {};
    user.date = mon;
    $.ajax({
        url:"http://localhost:8080/flow/flowlist",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            lisf = data;
            var length = lisf.length;
            maxlengthf = Math.ceil(length / 10);
            initf(maxlengthf);
            for(var i = (curindexf-1)*10;i<(curindexf-1)*10+10;i++){
                var s = "<tr>"+
                    "<th>"+(i+1)+"</th>"+                              //////////////////////////////////////////
                    "<th>"+lisf[i].date+"</th>"+
                    "<th>"+lisf[i].inOrOut+"</th>"+
                    "<th>"+lisf[i].supplyOrDemand+"</th>"+
                    "<th>"+lisf[i].productName+"</th>"+
                    "<th>"+lisf[i].size+"</th>"+
                    "<th>"+lisf[i].perCost+"</th>"+
                    "<th>"+lisf[i].perSell+"</th>"+
                    "<th>"+lisf[i].count+"</th>"+
                    "</tr>";
                $("#out").append(s);
            }
        },
        error:function () {
            alert("加载失败");
        }
    });
});




//仓库分页功能
//初始化页数
function initw(maxlength) {
    if (maxlength > 5) {
        $("#ellihead_w").hide();
        $("#pagec1_w").show();
        $("#pagec2_w").show();
        $("#pagec3_w").show();
        $("#ellifoot_w").show();
        $("#pagelast_w").show();
        $("#pagelast_w a").html(maxlength);
    } else if (maxlength > 4) {
        $("#ellihead_w").hide();
        $("#pagec1_w").show();
        $("#pagec2_w").show();
        $("#pagec3_w").show();
        $("#ellifoot_w").hide();
        $("#pagelast_w").show();
        $("#pagelast_w a").html(maxlength);
    } else if (maxlength > 3) {
        $("#ellihead_w").hide();
        $("#pagec1_w").show();
        $("#pagec2_w").show();
        $("#pagec3_w").show();
        $("#ellifoot_w").hide();
        $("#pagelast_w").hide();
        $("#pagelast_w a").html(maxlength);
    } else if (maxlength > 2) {
        $("#ellihead_w").hide();
        $("#pagec1_w").show();
        $("#pagec2_w").show();
        $("#pagec3_w").hide();
        $("#ellifoot_w").hide();
        $("#pagelast_w").hide();
        $("#pagelast_w a").html(maxlength);
    } else if (maxlength > 1) {
        $("#ellihead_w").hide();
        $("#pagec1_w").show();
        $("#pagec2_w").hide();
        $("#pagec3_w").hide();
        $("#ellifoot_w").hide();
        $("#pagelast_w").hide();
        $("#pagelast_w a").html(maxlength);
    } else {
        $("#ellihead_w").hide();
        $("#pagec1_w").hide();
        $("#pagec2_w").hide();
        $("#pagec3_w").hide();
        $("#ellifoot_w").hide();
        $("#pagelast_w").hide();
        $("#pagelast_w a").html(maxlength);
    }
}

//换页之后更新页面
function  reshoww() {
    $("#in").html("");
    for(var i = (curindexw-1)*10;i<(curindexw-1)*10+10;i++){
        var s = "<tr>"+
            "<th>"+(i+1)+"</th>"+                                                ////////////////////////////////////////////
            "<th>"+lisw[i].name+"</th>"+
            "<th>"+lisw[i].size+"</th>"+
            "<th>"+lisw[i].cost+"</th>"+
            "<th>"+lisw[i].sell+"</th>"+
            "<th>"+lisw[i].stocks+"</th>"+
            "</tr>";
        $("#in").append(s);
    }
}



$("#Previous_w").click(function () {
    if (maxlengthw < 5 && curindexw <= maxlengthw) {
        if (curindexw === 1) {
        } else if (curindexw === 2) {
            $("#pagec1_w").removeClass("active");
            $("#pagefirst_w").addClass("active");
            curindexw = curindexw - 1;
        } else if (curindexw === 3) {
            $("#pagec2_w").removeClass("active");
            $("#pagec1_w").addClass("active");
            curindexw = curindexw - 1;
        } else if (curindexw === 4) {
            $("#pagec3_w").removeClass("active");
            $("#pagec2_w").addClass("active");
            curindexw = curindexw - 1;
        } else if (curindexw === 5) {
            $("#pagelast_w").removeClass("active");
            $("#pagec3_w").addClass("active");
            curindexw=curindexw - 1;
        }
    } else if (maxlengthw > 5 && curindexw <= maxlengthw) {
        if (curindexw <= 3) {
            $("#ellihead_w").hide();
            $("#ellifoot_w").show();
            if (curindexw === 1) {
            } else if (curindexw === 2) {
                $("#pagec1_w").removeClass("active");
                $("#pagefirst_w").addClass("active");
                curindexw = curindexw - 1;
            } else if (curindexw === 3) {
                $("#pagec2_w").removeClass("active");
                $("#pagec1_w").addClass("active");
                curindexw = curindexw - 1;
            }
        } else if (curindexw > maxlengthw - 2) {
            $("#ellifoot_w").hide();
            $("#ellihead_w").show();
            if (curindexw === maxlengthw - 2) {
                $("#pagec2_w").removeClass("active");
                $("#pagec1_w").addClass("active");
                curindexw =curindexw - 1;
            } else if (curindexw === maxlengthw - 1) {
                $("#pagec3_w").removeClass("active");
                $("#pagec2_w").addClass("active");
                curindexw = curindexw - 1;
            } else if (curindexw === maxlengthw) {
                $("#pagelast_w").removeClass("active");
                $("#pagec3_w").addClass("active");
                curindexw = curindexw - 1;
            }
        } else if (curindexw > 2 && curindexw <= maxlengthw - 2) {
            $("#ellifoot_w").show();
            $("#ellihead_w").show();
            $("#pagec1_w a").html(curindexw - 2);
            $("#pagec2_w a").html(curindexw - 1);
            $("#pagec3_w a").html(curindex);
            curindexw = curindexw - 1;
        }
    }
    reshoww();
});
$("#Next_w").click(function () {
    if (maxlengthw <= 5 && curindexw < maxlengthw) {
        if (curindexw === 1) {
            $("#pagefirst_w").removeClass("active");
            $("#pagec1_w").addClass("active");
            curindexw = curindexw + 1;
        } else if (curindexw === 2) {
            $("#pagec1_w").removeClass("active");
            $("#pagec2_w").addClass("active");
            curindexw = curindexw + 1;
        } else if (curindexw === 3) {
            $("#pagec2_w").removeClass("active");
            $("#pagec3_w").addClass("active");
            curindexw = curindexw + 1;
        } else if (curindexw === 4) {
            $("#pagec3_w").removeClass("active");
            $("#pagelast_w").addClass("active");
            curindexw = curindexw + 1;
        } else if (curindexw === 5) {
        }
    } else if (maxlengthw > 5 && curindexw < maxlengthw) {
        if (curindexw < 3) {
            $("#ellihead_w").hide();
            $("#ellifoot_w").show();
            if (curindexw === 1) {
                $("#pagefirst_w").removeClass("active");
                $("#pagec1_w").addClass("active");
                curindexw = curindexw + 1;
            } else if (curindexw === 2) {
                $("#pagec1_w").removeClass("active");
                $("#pagec2_w").addClass("active");
                curindexw = curindexw + 1;
            } else if (curindexw === 3) {
                $("#pagec2_w").removeClass("active");
                $("#pagec3_w").addClass("active");
                curindexw = curindexw + 1;
            }
        } else if (curindexw >= maxlengthw - 2) {
            $("#ellifoot_w").hide();
            $("#ellihead_w").show();
            if (curindexw === maxlengthw - 2) {
                $("#pagec2_w").removeClass("active");
                $("#pagec3_w").addClass("active");
                curindexw = curindexw + 1;
            } else if (curindexw === maxlengthw - 1) {
                $("#pagec3_w").removeClass("active");
                $("#pagelast_w").addClass("active");
                curindexw = curindexw + 1;
            } else if (curindexw === maxlengthw) {
            }
        } else if (curindexw > 2 && curindexw < maxlengthw - 2) {
            $("#ellifoot_w").show();
            $("#ellihead_w").show();
            $("#pagec1_w a").html(curindexw);
            $("#pagec2_w a").html(curindexw + 1);
            $("#pagec3_w a").html(curindexw + 2);
            curindexw = curindexw + 1;
        }
    }
    reshoww();
});

$("#pagefirst_w").click(function () {
    if(maxlengthw > 5){
        $("#ellihead_w").hide();
        $("#ellifoot_w").show();
    }else {
        $("#ellihead_w").hide();
        $("#ellifoot_w").hide();
    }
    $("#pagefirst_w").addClass("active");
    $("#pagec1_w").removeClass("active");
    $("#pagec2_w").removeClass("active");
    $("#pagec3_w").removeClass("active");
    $("#pagelast_w").removeClass("active");
    $("#pagec1_w a").html(2);
    $("#pagec2_w a").html(3);
    $("#pagec3_w a").html(4);
    curindexw = 1;
    reshow();
});

$("#pagelast_w").click(function () {
    if(maxlengthw > 5){
        $("#ellihead_w").show();
        $("#ellifoot_w").hide();
    }else {
        $("#ellihead_w").hide();
        $("#ellifoot_w").hide();
    }
    $("#pagefirst_w").removeClass("active");
    $("#pagec1_w").removeClass("active");
    $("#pagec2_w").removeClass("active");
    $("#pagec3_w").removeClass("active");
    $("#pagelast_w").addClass("active");
    $("#pagec1_w a").html(maxlengthw-3);
    $("#pagec2_w a").html(maxlengthw-2);
    $("#pagec3_w a").html(maxlengthw-1);
    curindexw  = maxlengthw;
    reshoww();
});

$("#pagec1_w").click(function () {
    var index = parseInt($("#pagec1_w a").html());
    if(index < 3 && maxlengthw <5){
        $("#ellihead_w").hide();
        $("#ellifoot_w").hide();
        $("#pagefirst_w").removeClass("active");
        $("#pagec1_w").addClass("active");
        $("#pagec2_w").removeClass("active");
        $("#pagec3_w").removeClass("active");
        $("#pagelast_w").removeClass("active");
        curindexw = index;
    }else if(index < 3 && maxlengthw >= 5){
        $("#ellihead_w").hide();
        $("#ellifoot_w").show();
        $("#pagefirst_w").removeClass("active");
        $("#pagec1_w").addClass("active");
        $("#pagec2_w").removeClass("active");
        $("#pagec3_w").removeClass("active");
        $("#pagelast_w").removeClass("active");
        curindexw = index;
    }
    else {
        $("#ellihead_w").show();
        $("#ellifoot_w").show();
        $("#pagefirst_w").removeClass("active");
        $("#pagec1_w").removeClass("active");
        $("#pagec2_w").addClass("active");
        $("#pagec3_w").removeClass("active");
        $("#pagelast_w").removeClass("active");
        $("#pagec1_w a").html(index-1);
        $("#pagec2_w a").html(index);
        $("#pagec3_w a").html(index+1);
        curindexw = index;
    }
    reshoww();
});

$("#pagec2_w").click(function () {
    var index = parseInt($("#pagec2_w a").html());
    $("#pagefirst_w").removeClass("active");
    $("#pagec1_w").removeClass("active");
    $("#pagec2_w").addClass("active");
    $("#pagec3_w").removeClass("active");
    $("#pagelast_w").removeClass("active");
    $("#pagec1_w a").html(index-1);
    $("#pagec2_w a").html(index);
    $("#pagec3_w a").html(index+1);
    curindexw = index;
    reshoww();
});

$("#pagec3_w").click(function () {
    var index = parseInt($("#pagec3_w a").html());
    if(index > maxlengthw-2 && maxlengthw <= 5){
        $("#ellihead_w").hide();
        $("#ellifoot_w").hide();
        $("#pagefirst_w").removeClass("active");
        $("#pagec1_w").removeClass("active");
        $("#pagec2_w").removeClass("active");
        $("#pagec3_w").addClass("active");
        $("#pagelast_w").removeClass("active");
        curindexw = index;
    }else if(index > maxlengthw-2 && maxlengthw > 5){
        $("#ellihead_w").show();
        $("#ellifoot_w").hide();
        $("#pagefirst_w").removeClass("active");
        $("#pagec1_w").removeClass("active");
        $("#pagec2_w").removeClass("active");
        $("#pagec3_w").addClass("active");
        $("#pagelast_w").removeClass("active");
        curindexw = index;
    }
    else {
        $("#ellihead_w").show();
        $("#ellifoot_w").show();
        $("#pagefirst_w").removeClass("active");
        $("#pagec1_w").removeClass("active");
        $("#pagec2_w").addClass("active");
        $("#pagec3_w").removeClass("active");
        $("#pagelast_w").removeClass("active");
        $("#pagec1_w a").html(index-1);
        $("#pagec2_w a").html(index);
        $("#pagec3_w a").html(index+1);
        curindexw = index;
    }
    reshoww();
});











//仓库分页功能
//初始化页数
function initf(maxlength) {
    if (maxlength > 5) {
        $("#ellihead_f").hide();
        $("#pagec1_f").show();
        $("#pagec2_f").show();
        $("#pagec3_f").show();
        $("#ellifoot_f").show();
        $("#pagelast_f").show();
        $("#pagelast_f a").html(maxlength);
    } else if (maxlength > 4) {
        $("#ellihead_f").hide();
        $("#pagec1_f").show();
        $("#pagec2_f").show();
        $("#pagec3_f").show();
        $("#ellifoot_f").hide();
        $("#pagelast_f").show();
        $("#pagelast_f a").html(maxlength);
    } else if (maxlength > 3) {
        $("#ellihead_f").hide();
        $("#pagec1_f").show();
        $("#pagec2_f").show();
        $("#pagec3_f").show();
        $("#ellifoot_f").hide();
        $("#pagelast_f").hide();
        $("#pagelast_f a").html(maxlength);
    } else if (maxlength > 2) {
        $("#ellihead_f").hide();
        $("#pagec1_f").show();
        $("#pagec2_f").show();
        $("#pagec3_f").hide();
        $("#ellifoot_f").hide();
        $("#pagelast_f").hide();
        $("#pagelast_f a").html(maxlength);
    } else if (maxlength > 1) {
        $("#ellihead_f").hide();
        $("#pagec1_f").show();
        $("#pagec2_f").hide();
        $("#pagec3_f").hide();
        $("#ellifoot_f").hide();
        $("#pagelast_f").hide();
        $("#pagelast_f a").html(maxlength);
    } else {
        $("#ellihead_f").hide();
        $("#pagec1_f").hide();
        $("#pagec2_f").hide();
        $("#pagec3_f").hide();
        $("#ellifoot_f").hide();
        $("#pagelast_f").hide();
        $("#pagelast_f a").html(maxlength);
    }
}

//换页之后更新页面
function  reshowf() {
    $("#out").html("");
    for(var i = (curindexf-1)*10;i<(curindexf-1)*10+10;i++){
        var s = "<tr>"+
            "<th>"+(i+1)+"</th>"+                                                ////////////////////////////////////////////
            "<th>"+lisf[i].date+"</th>"+
            "<th>"+lisf[i].inOrOut+"</th>"+
            "<th>"+lisf[i].supplyOrDemand+"</th>"+
            "<th>"+lisf[i].productName+"</th>"+
            "<th>"+lisf[i].size+"</th>"+
            "<th>"+lisf[i].perCost+"</th>"+
            "<th>"+lisf[i].perSell+"</th>"+
            "<th>"+lisf[i].count+"</th>"+
            "</tr>";
        $("#out").append(s);
    }
}



$("#Previous_f").click(function () {
    if (maxlengthf < 5 && curindexf <= maxlengthf) {
        if (curindexf === 1) {
        } else if (curindexf === 2) {
            $("#pagec1_f").removeClass("active");
            $("#pagefirst_f").addClass("active");
            curindex=curindex - 1;
        } else if (curindexf === 3) {
            $("#pagec2_f").removeClass("active");
            $("#pagec1_f").addClass("active");
            curindexf = curindexf - 1;
        } else if (curindexf === 4) {
            $("#pagec3_f").removeClass("active");
            $("#pagec2_f").addClass("active");
            curindexf = curindexf - 1;
        } else if (curindexf === 5) {
            $("#pagelast_f").removeClass("active");
            $("#pagec3_f").addClass("active");
            curindexf = curindexf - 1;
        }
    } else if (maxlengthf > 5 && curindexf <= maxlengthf) {
        if (curindexf <= 3) {
            $("#ellihead_f").hide();
            $("#ellifoot_f").show();
            if (curindexf === 1) {
            } else if (curindexf === 2) {
                $("#pagec1_f").removeClass("active");
                $("#pagefirst_f").addClass("active");
                curindexf = curindexf - 1;
            } else if (curindexf === 3) {
                $("#pagec2_f").removeClass("active");
                $("#pagec1_f").addClass("active");
                curindexf = curindexf - 1;
            }
        } else if (curindexf > maxlengthf - 2) {
            $("#ellifoot_f").hide();
            $("#ellihead_f").show();
            if (curindexf === maxlengthf - 2) {
                $("#pagec2_f").removeClass("active");
                $("#pagec1_f").addClass("active");
                curindexf =curindexf - 1;
            } else if (curindexf === maxlengthf - 1) {
                $("#pagec3_f").removeClass("active");
                $("#pagec2_f").addClass("active");
                curindexf = curindexf - 1;
            } else if (curindexf === maxlengthf) {
                $("#pagelast_f").removeClass("active");
                $("#pagec3_f").addClass("active");
                curindexf = curindexf - 1;
            }
        } else if (curindexf > 2 && curindexf <= maxlengthf - 2) {
            $("#ellifoot_f").show();
            $("#ellihead_f").show();
            $("#pagec1_f a").html(curindexw - 2);
            $("#pagec2_f a").html(curindexw - 1);
            $("#pagec3_f a").html(curindex);
            curindexf = curindexf - 1;
        }
    }
    reshowf();
});
$("#Next_f").click(function () {
    if (maxlengthf <= 5 && curindexf < maxlengthf) {
        if (curindexf === 1) {
            $("#pagefirst_f").removeClass("active");
            $("#pagec1_f").addClass("active");
            curindexf = curindexw + 1;
        } else if (curindexf === 2) {
            $("#pagec1_f").removeClass("active");
            $("#pagec2_f").addClass("active");
            curindexf = curindexf + 1;
        } else if (curindexf === 3) {
            $("#pagec2_f").removeClass("active");
            $("#pagec3_f").addClass("active");
            curindexf = curindexf + 1;
        } else if (curindexf === 4) {
            $("#pagec3_f").removeClass("active");
            $("#pagelast_f").addClass("active");
            curindexf = curindexf + 1;
        } else if (curindexf === 5) {
        }
    } else if (maxlengthf > 5 && curindexf < maxlengthf) {
        if (curindexf < 3) {
            $("#ellihead_f").hide();
            $("#ellifoot_f").show();
            if (curindexf === 1) {
                $("#pagefirst_f").removeClass("active");
                $("#pagec1_f").addClass("active");
                curindexf = curindexf + 1;
            } else if (curindexf === 2) {
                $("#pagec1_f").removeClass("active");
                $("#pagec2_f").addClass("active");
                curindexf = curindexf+ 1;
            } else if (curindexf === 3) {
                $("#pagec2_f").removeClass("active");
                $("#pagec3_f").addClass("active");
                curindexf = curindexf + 1;
            }
        } else if (curindexw >= maxlengthw - 2) {
            $("#ellifoot_f").hide();
            $("#ellihead_f").show();
            if (curindexf === maxlengthf - 2) {
                $("#pagec2_f").removeClass("active");
                $("#pagec3_f").addClass("active");
                curindexf = curindexf+ 1;
            } else if (curindexf === maxlengthf - 1) {
                $("#pagec3_f").removeClass("active");
                $("#pagelast_f").addClass("active");
                curindexf = curindexf+ 1;
            } else if (curindexf === maxlengthf) {
            }
        } else if (curindexf > 2 && curindexf< maxlengthf - 2) {
            $("#ellifoot_w").show();
            $("#ellihead_w").show();
            $("#pagec1_w a").html(curindexf);
            $("#pagec2_w a").html(curindexf + 1);
            $("#pagec3_w a").html(curindexf + 2);
            curindexf = curindexf + 1;
        }
    }
    reshowf();
});

$("#pagefirst_f").click(function () {
    if(maxlengthf > 5){
        $("#ellihead_f").hide();
        $("#ellifoot_f").show();
    }else {
        $("#ellihead_f").hide();
        $("#ellifoot_f").hide();
    }
    $("#pagefirst_f").addClass("active");
    $("#pagec1_f").removeClass("active");
    $("#pagec2_f").removeClass("active");
    $("#pagec3_f").removeClass("active");
    $("#pagelast_f").removeClass("active");
    $("#pagec1_f a").html(2);
    $("#pagec2_f a").html(3);
    $("#pagec3_f a").html(4);
    curindexf = 1;
    reshowf();
});

$("#pagelast_f").click(function () {
    if(maxlengthf > 5){
        $("#ellihead_f").show();
        $("#ellifoot_f").hide();
    }else {
        $("#ellihead_f").hide();
        $("#ellifoot_f").hide();
    }
    $("#pagefirst_f").removeClass("active");
    $("#pagec1_f").removeClass("active");
    $("#pagec2_f").removeClass("active");
    $("#pagec3_f").removeClass("active");
    $("#pagelast_f").addClass("active");
    $("#pagec1_f a").html(maxlengthf-3);
    $("#pagec2_f a").html(maxlengthf-2);
    $("#pagec3_f a").html(maxlengthf-1);
    curindexf  = maxlengthf;
    reshowf();
});

$("#pagec1_f").click(function () {
    var index = parseInt($("#pagec1_f a").html());
    if(index < 3 && maxlengthf <5){
        $("#ellihead_f").hide();
        $("#ellifoot_f").hide();
        $("#pagefirst_f").removeClass("active");
        $("#pagec1_f").addClass("active");
        $("#pagec2_f").removeClass("active");
        $("#pagec3_f").removeClass("active");
        $("#pagelast_f").removeClass("active");
        curindexf = index;
    }else if(index < 3 && maxlengthf >= 5){
        $("#ellihead_f").hide();
        $("#ellifoot_f").show();
        $("#pagefirst_f").removeClass("active");
        $("#pagec1_f").addClass("active");
        $("#pagec2_f").removeClass("active");
        $("#pagec3_f").removeClass("active");
        $("#pagelast_f").removeClass("active");
        curindexf = index;
    }
    else {
        $("#ellihead_f").show();
        $("#ellifoot_f").show();
        $("#pagefirst_f").removeClass("active");
        $("#pagec1_f").removeClass("active");
        $("#pagec2_f").addClass("active");
        $("#pagec3_f").removeClass("active");
        $("#pagelast_f").removeClass("active");
        $("#pagec1_f a").html(index-1);
        $("#pagec2_f a").html(index);
        $("#pagec3_f a").html(index+1);
        curindexf = index;
    }
    reshowf();
});

$("#pagec2_f").click(function () {
    var index = parseInt($("#pagec2_f a").html());
    $("#pagefirst_f").removeClass("active");
    $("#pagec1_f").removeClass("active");
    $("#pagec2_f").addClass("active");
    $("#pagec3_f").removeClass("active");
    $("#pagelast_f").removeClass("active");
    $("#pagec1_f a").html(index-1);
    $("#pagec2_f a").html(index);
    $("#pagec3_f a").html(index+1);
    curindexf = index;
    reshowf();
});

$("#pagec3_f").click(function () {
    var index = parseInt($("#pagec3_f a").html());
    if(index > maxlengthf-2 && maxlengthf <= 5){
        $("#ellihead_f").hide();
        $("#ellifoot_f").hide();
        $("#pagefirst_f").removeClass("active");
        $("#pagec1_f").removeClass("active");
        $("#pagec2_f").removeClass("active");
        $("#pagec3_f").addClass("active");
        $("#pagelast_f").removeClass("active");
        curindexf = index;
    }else if(index > maxlengthf-2 && maxlengthf > 5){
        $("#ellihead_f").show();
        $("#ellifoot_f").hide();
        $("#pagefirst_f").removeClass("active");
        $("#pagec1_f").removeClass("active");
        $("#pagec2_f").removeClass("active");
        $("#pagec3_f").addClass("active");
        $("#pagelast_f").removeClass("active");
        curindexf = index;
    }
    else {
        $("#ellihead_f").show();
        $("#ellifoot_f").show();
        $("#pagefirst_f").removeClass("active");
        $("#pagec1_f").removeClass("active");
        $("#pagec2_f").addClass("active");
        $("#pagec3_f").removeClass("active");
        $("#pagelast_f").removeClass("active");
        $("#pagec1_f a").html(index-1);
        $("#pagec2_f a").html(index);
        $("#pagec3_f a").html(index+1);
        curindexf = index;
    }
    reshowf();
});
