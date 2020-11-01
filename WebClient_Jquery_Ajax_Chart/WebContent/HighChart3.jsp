<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <TITLE>Chart</TITLE>
   
    <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
   <script src="https://code.highcharts.com/highcharts.js"></script>
   <script src="https://code.highcharts.com/modules/exporting.js"></script>
 
 
<script type="text/javascript">
 
 
$(function () {
      var SUB_STA_NM=[];
      var RIDE_PASGR_NUM=[];
      var ALIGHT_PASGR_NUM=[];
      $.getJSON(
            "20160322bundang.json"
             ,function(data){
                $.each(data.DATA,function(index,obj){
                    SUB_STA_NM.push(obj.SUB_STA_NM);
                    RIDE_PASGR_NUM.push(parseInt(obj.RIDE_PASGR_NUM));
                    ALIGHT_PASGR_NUM.push(parseInt(obj.ALIGHT_PASGR_NUM));
                 });
      
       $('#highchart').highcharts({        //차트형식
           chart: {
               type: 'line'
           },
           title: {                    //차트주제
               text: '2016년 3월 22일 분당선 역별 승하차 인원수 '
           },
        
           xAxis: {            //x축 내용
               categories:  SUB_STA_NM,
               crosshair:{
                   color: 'lightgreen',
                   width:3
               }
           },
           yAxis: {            //y 축내용
               min: 0,
               title: {
                   text: '(명)'
               }
           },
           
           legend: {        //범례
               layout: 'vertical',
               align: 'right',
               verticalAlign: 'middle'
               
           },
           
           tooltip: {        //말풍선
               headerFormat: '<span style="font-size:15px">{point.key}</span>',
               pointFormat: '<table><tr><td style="color:{series.color}">{series.name}: </td>' +
                   '<td><b>{point.y:f} 명</b></td></tr></table>',
               shared: true,
               useHTML: true
           },
        
           series: [{
               name: '하차 인원',
               data:  ALIGHT_PASGR_NUM
 
           }, {
               name: '승차인원',
               data:  RIDE_PASGR_NUM
 
           }]
       });
   });
});
 
 
 </script>
</head>
<body>
   
<div id="highchart" style="min-width: 500px; height: 500px; margin: 0 auto"></div>
 
</body>
</html>