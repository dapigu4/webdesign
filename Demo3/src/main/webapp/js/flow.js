$("input[name='day']").datepicker({
    format:'yyyy-mm-dd',
    language:'zh-CN',
    autoclose: true
});

//添加入库记录

$("#btn_in").click(function () {
    var date = $("#in_date").val();
    var name = $("#in_name").val();
    var count = $("#in_count").val();
    var productname = $("#in_product").val();
    var type = $("#in_type").val();
    var money = $("#in_money").val();
    var moneyi = $("#in_money_i").val();
    var totle = $("#in_totle").val();

    if(date === "" || name === "" || count === "" || productname === "" || type === "" || money ===""|| moneyi ==="" || totle === ""){
        $("#con_in").html("所有字段不能为空");
        $("#close_in").show();
        $("#sure_in").hide();
    }
    else {
        $("#con_in").html("确定增加该条入库记录？");
        $("#close_in").hide();
        $("#sure_in").show();
    }
});

$("#sure_in").click(function () {
    var date = $("#in_date").val();
    var name = $("#in_name").val();
    var count = $("#in_count").val();
    var productname = $("#in_product").val();
    var type = $("#in_type").val();
    var money = $("#in_money").val();
    var moneyi = $("#in_money_i").val();
    var total = $("#in_totle").val();

    var user = {};
    user.flowDate = date;
    user.supplyOrDemand = name;
    user.count = count;
    user.productName = productname;
    user.size = type;
    user.perCost = money;
    user.perSell = moneyi;
    user.total = total;
    $.ajax({
        url:"http://localhost:8080/flow/input",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.msg === "don't have this supplier"){
                alert("没有该供应商");
            } else if(data.msg === "success"){
                alert("入库成功！");
                $("#out_date").val("");
                $("#out_name").val("");
                $("#out_count").val("");
                $("#out_product").val("");
                $("#out_type").val("");
                $("#out_money").val("");
                $("#out_money_o").val("");
                $("#out_totle").val("");
            }
            else {
                alert("没有该供应商");
            }
        },
        error:function () {
            alert("添加记录失败!");

        }
    })
});


//添加出库记录

$("#btn_out").click(function () {
    var date = $("#out_date").val();
    var name = $("#out_name").val();
    var count = $("#out_count").val();
    var productname = $("#out_product").val();
    var type = $("#out_type").val();
    var money = $("#out_money").val();
    var moneyo = $("#out_money_o").val();
    var totle = $("#out_totle").val();

    if(date === "" || name === "" || count === "" || productname === "" || type === "" || money ===""|| moneyo ==="" || totle === ""){
        $("#con_out").html("所有字段不能为空");
        $("#close_out").show();
        $("#sure_out").hide();
    }
    else {
        $("#con_out").html("确定增加该条出库记录？");
        $("#close_out").hide();
        $("#sure_out").show();
    }
});

$("#sure_out").click(function () {
    var date = $("#out_date").val();
    var name = $("#out_name").val();
    var count = $("#out_count").val();
    var productname = $("#out_product").val();
    var type = $("#out_type").val();
    var money = $("#out_money").val();
    var moneyo = $("#out_money_o").val();
    var total = $("#out_totle").val();
    var user = {};
    user.flowDate = date;
    user.supplyOrDemand = name;
    user.count = count;
    user.productName = productname;
    user.size = type;
    user.perCost = money;
    user.perSell = moneyo;
    user.total = total;
    $.ajax({
        url:"http://localhost:8080/flow/output",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data.msg === "don't have this product"){
                alert("没有该产品");
            }else if(data.msg === "don't have enough stocks"){
                alert("产品数量不足");
            }else if(data.msg === "don't have this client"){
                alert("没有该客户");
            } else if(data.msg === "success"){
                alert("出库成功！");
                $("#out_date").val("");
                $("#out_name").val("");
                $("#out_count").val("");
                $("#out_product").val("");
                $("#out_type").val("");
                $("#out_money").val("");
                $("#out_money_o").val("");
                $("#out_totle").val("");
            }
            else {
                alert("没有该产品或数量不足");
            }
        },
        error:function () {
            alert("添加记录失败!");

        }
    })
});