

//收据明细数据 询问是否提交
$("#btn_i").click(function () {
    var day = $("#time_i").val();
    var money = $("#money_i").val();
    var info = $("#info_i").val();
    if( day ==="" || money === "" || info ==="")
    {
        $("#con_i").html("值不能为空");
        $("#close_i").html("关闭");
        $("#sure_i").show();
        $("#sub_i").hide();
    }
    else {
        $("#con_i").html("确定提交该收入明细");
        $("#close_i").html("取消");
        $("#sure_i").hide();
        $("#sub_i").show();
    }
});
//提交数据
$("#sub_i").click(function () {
    /*var day = $("#time_i").val();
    var money = $("#money_i").val();
    var info = $("#info_i").val();
    var user = {};
    user.day = day;                                                    //==================*********************
    user.money = money;
    user.info = info;
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        success:function (data) {

        }
    });*/
    alert("提交成功");
});


//收集明细数据 询问是否提交
$("#btn_o").click(function () {
    var day = $("#time_o").val();
    var money = $("#money_o").val();
    var info = $("#info_o").val();
    if(day==="" || money === "" || info ==="")
    {
        $("#con_o").html("值不能为空");
        $("#close_o").html("关闭");
        $("#sure_o").show();
        $("#sub_o").hide();
    }
    else {
        $("#con_o").html("确定提交该收入明细");
        $("#close_o").html("取消");
        $("#sure_o").hide();
        $("#sub_o").show();
    }
});
//提交数据
$("#sub_o").click(function () {
    /*var day = $("#time_i").val();
    var money = $("#money_i").val();
    var info = $("#info_i").val();
    var user = {};
    user.day = day;                                                      //==================*********************
    user.money = money;
    user.info = info;
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        success:function (data) {

        }
    });*/
    alert("提交成功");
});

//获取时间
$("input[name='day']").datepicker({
   format:'yyyy-mm-dd',
    language:'zh-CN',
    autoclose: true
});