//时间
$("#mon").datepicker({
    format:'yyyy-mm',
    language:'zh-CN',
    startView:1,
    maxViewMode:2,
    minViewMode:1,
    autoclose:true
});
//当前时间
$("#mon").datepicker("setDate", new Date());

//获取当前月份的数据
$(document).ready(function () {
    $("#tab").html("");
    var month = $("#mon").val();
    var user = {};
    user.month = month;
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        success:function (data) {
            arr = data.arr;
            if(length(arr) !== 0){
                for(var i = 0;i< length(arr);i++){
                    var s = "<tr>"+
                        "<th>"+i+"</th>"+
                        "<th>"+arr[i].number+"</th>"+                            ////////////////////////////////
                        "<th>"+arr[i].name+"</th>"+
                        "<th>"+arr[i].sex+"</th>"+
                        "<th>"+arr[i].phone+"</th>"+
                        "</tr>";
                    $("tbody").append(s);
                }
            }
        },
        error:function () {
            var s = "<tr>"+
                "<th>1</th>"+
                "<th>test1</th>"+
                "<th>test1</th>"+
                "<th>test1</th>"+
                "<th>test1</th>"+
                "</tr>";
            $("tbody").append(s);
        }
    });
});

//获取对应月份的数据
$("#mon").change(function () {
    $("#tab").html("");
    var month = $("#mon").val();
    var user = {};
    user.month = month;
    $.ajax({
        url:"",
        type:"post",
        dataType:"json",
        data:JSON.stringify(user),
        success:function (data) {
            arr = data.arr;
            if(length(arr) !== 0){
                for(var i = 0;i< length(arr);i++){
                    var s = "<tr>"+
                        "<th>"+i+"</th>"+
                        "<th>"+arr[i].number+"</th>"+                            ////////////////////////////////
                        "<th>"+arr[i].name+"</th>"+
                        "<th>"+arr[i].sex+"</th>"+
                        "<th>"+arr[i].phone+"</th>"+
                        "</tr>";
                    $("tbody").append(s);
                }
            }
        },
        error:function () {
            var s = "<tr>"+
                "<th>1</th>"+
                "<th>test1</th>"+
                "<th>test1</th>"+
                "<th>test1</th>"+
                "<th>test1</th>"+
                "</tr>";
            $("tbody").append(s);
        }
    });
});
