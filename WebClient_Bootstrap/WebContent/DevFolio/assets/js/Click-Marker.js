//클릭한 위치에 마커 표시하기
// var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
//     mapOption = { 
//         center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
//         level: 3 // 지도의 확대 레벨
//     };

// var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

var latClickInfo;
var lngClickInfo;

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 

    latClickInfo = latlng.getLat();
    lngClickInfo = latlng.getLng();
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var distance = (Math.sqrt(Math.pow(Math.abs(69.1*(latInfo-latClickInfo)),2) + Math.pow(Math.abs(53*(lngInfo-lngClickInfo)),2))*1.609344).toFixed(2);

    var message = '클릭한 위치의 위도는 ' + latlng.getLat().toFixed(3) + ' 이고, ';
    message += '경도는 ' + latlng.getLng().toFixed(3) + ' 이고, <br>';
    message += '내 위치와의 거리는 ' + distance + "km입니다.";
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});