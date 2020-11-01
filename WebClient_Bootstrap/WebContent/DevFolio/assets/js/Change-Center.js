
// 중심좌표 변경이벤트 등록하기
// var mapContainer = document.getElementById('map'), // 지도를 표시할 div
//     mapOption = { 
//         center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
//         level: 3 // 지도의 확대 레벨
//     };

// var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'center_changed', function() {

    // 지도의  레벨을 얻어옵니다
    var level = map.getLevel();

    // 지도의 중심좌표를 얻어옵니다 
    var latlng = map.getCenter(); 

    var message = '<p>지도 레벨은 ' + level + ' 이고</p>';
    message += '<p>지도의 중심 좌표는 위도 ' + latlng.getLat().toFixed(3) + ', 경도 ' + latlng.getLng().toFixed(3) + '입니다</p>';
    
    var resultDiv = document.getElementById('result');
    resultDiv.innerHTML = message;

});