
$(document).ready(function () {
    var list;
   // 收支对比
    var incomechart = $("#income_chart");
    console.log(123543532)
    if (incomechart.length > 0){
        $.ajax({
            url: "http://localhost:8080/balance/balancechart",
            type: "post",
            dataType: "json",
            data: JSON.stringify(user),
            contentType:"application/json;charset=utf-8",
            success: function (data) {
                   list = data;
                   console.log(list[0].balanceMoney)
                console.log(list[1].balanceMoney)
                new Chart(incomechart,{
                    type : "line" ,
                    data : {
                        labels:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
                        datasets:[{
                            labels:"users",
                            data:[list[0].balanceMoney, list[1].balanceMoney, list[2].balanceMoney, list[3].balanceMoney, list[4].balanceMoney, list[5].balanceMoney, list[6].balanceMoney, list[7].balanceMoney, list[8].balanceMoney, list[9].balanceMoney, list[10].balanceMoney, list[11].balanceMoney],
                            backgroundColor:'rgba(66, 165, 245, 0.5)',
                            borderColor: '#2196F3',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        legend: {
                            display: false
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        }
                    }

                })
            }
        });



    }



    // 入库总值


});





/**
 * Line Chart

 var lineChart = $('#line-chart');

 if (lineChart.length > 0) {
        new Chart(lineChart, {
            type: 'line',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: 'Users',
                    data: [120, 19, 3, 5, 2, 3, 20, 33, 23, -2, 33, 10],
                    backgroundColor: 'rgba(66, 165, 245, 0.5)',
                    borderColor: '#2196F3',
                    borderWidth: 1
                }]
            },
            options: {
                legend: {
                    display: false
                },
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
    }

 /**
 * Bar Chart

 var barChart = $('#bar-chart');

 if (barChart.length > 0) {
        new Chart(barChart, {
            type: 'bar',
            data: {
                labels: ["Red", "Blue", "Cyan", "Green", "Purple", "Orange"],
                datasets: [{
                    label: '# of Votes',
                    data: [12, 19, 3, 5, 2, 3],
                    backgroundColor: [
                        'rgba(244, 88, 70, 0.5)',
                        'rgba(33, 150, 243, 0.5)',
                        'rgba(0, 188, 212, 0.5)',
                        'rgba(42, 185, 127, 0.5)',
                        'rgba(156, 39, 176, 0.5)',
                        'rgba(253, 178, 68, 0.5)'
                    ],
                    borderColor: [
                        '#F45846',
                        '#2196F3',
                        '#00BCD4',
                        '#2ab97f',
                        '#9C27B0',
                        '#fdb244'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                legend: {
                    display: false
                },
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
    }

 /**
 * Radar Chart

 var radarChart = $('#radar-chart');

 if (radarChart.length > 0) {
        new Chart(radarChart, {
            type: 'radar',
            data: {
                labels: ["Red", "Blue", "Cyan", "Green", "Purple", "Orange"],
                datasets: [{
                    label: 'Users',
                    data: [100, 45, 87, 50, 77, 20],
                    backgroundColor: 'rgba(244, 88, 70, 0.5)',
                    borderColor: '#F45846',
                    borderWidth: 1
                }, {
                    label: 'Votes',
                    data: [23, 55, 75, 54, 95, 100],
                    backgroundColor: 'rgba(33, 150, 243, 0.5)',
                    borderColor: '#2196F3',
                    borderWidth: 1
                }]
            }
        });
    }

 /**
 * Pie Chart

 var pieChart = $('#pie-chart');

 if (pieChart.length > 0) {
        new Chart(pieChart, {
            type: 'pie',
            data: {
                labels: ["Red", "Blue", "Cyan", "Green", "Purple", "Orange"],
                datasets: [{
                    label: 'Users',
                    data: [100, 45, 87, 50, 77, 20],
                    backgroundColor: [
                        'rgba(244, 88, 70, 0.5)',
                        'rgba(33, 150, 243, 0.5)',
                        'rgba(0, 188, 212, 0.5)',
                        'rgba(42, 185, 127, 0.5)',
                        'rgba(156, 39, 176, 0.5)',
                        'rgba(253, 178, 68, 0.5)'
                    ],
                    borderColor: [
                        'rgba(244, 88, 70, 0.5)',
                        'rgba(33, 150, 243, 0.5)',
                        'rgba(0, 188, 212, 0.5)',
                        'rgba(42, 185, 127, 0.5)',
                        'rgba(156, 39, 176, 0.5)',
                        'rgba(253, 178, 68, 0.5)'
                    ],
                    borderWidth: 1
                }]
            }
        });
    }*/