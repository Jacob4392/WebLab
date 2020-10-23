// 모달 만들기
var modal = document.getElementById('myModal');
var img = document.getElementsByName('myImg');
var captionText = document.getElementById("caption");

img[0].onclick = function(){    // Java img
    this.alt = "<h1>자바란?</h1>"
             + "<p style='font-style: italic;'>자바는 썬 마이크로시스템즈에서 개발한 대표적인 객체지향 프로그래밍 언어입니다.<br>"
             + "자바의 가장 중요한 특징은 운영체제에 독립적이라는 것입니다. 자바로 작성된 프로그램은 운영체제 종류에<br>"
             + "관계없이 실행이 가능하기 때문에, 운영체제에 따라 프로그램을 변경하지 않고도 실행이 가능합니다.</p><br>"
             + "<h2>자바언어의 특징</h2>"
             + "<ul>"   
             + "<li>자바는 'Java Virtual Machine' 위에서 실행되기에 운영체제에 관계없이 실행될 수 있으므로 독립적이며, 이식성이 높다고 할 수 있다.</li>"
             + "<li>하나 이상의 기능을 객체로 만들어서, 이러한 객체들을 결합하여 하나의 프로그램을 만드는 객체지향언어(OOP)이다.</li>"
             + "<li>Thread객체 상속 또는 Runnable인터페이스를 구현하여 동시에 여러가지 작업을 할 수 있거나, 대용량 작업을 효율적으로 처리할 수 있는 멀티스레드 환경을 지원한다.</li>"
             + "<li>자바는 Open Source 언어이다. 그렇기에 자바를 이용해 만들어진 라이브러리가 많고, 필요에 따른 라이브러리를 이용해 시간비용을 줄이면서 어플리케이션을 만들 수 있다.</li>"
             + "</ul>";
	showModal(this.alt);
}

img[1].onclick = function(){    // sql img
    this.alt = "<h1>SQL (Structured Query Language)</h1>"
             + "<p style='font-style: italic;'>SQL은 관계형 데이터베이스 관리 시스템(RDBMS)의 데이터를 관리하기 위한 목적을 가지는 프로그래밍 언어입니다.<br>"
             + "관계형 데이터 베이스 관리 시스템에서 자료의 검색과 관리, 데이터베이스 스키마 생성과 수정, 데이터 베이스 접근 조정 관리를<br>"
             + "위해 고안되었습니다. 많은 수의 데이터 베이스 관련 프로그램들이 SQL을 표준으로 채택하고 있습니다.</p><br>"
             + "<p>현재까지 저희는 SQLDeveloper를 이용하여 데이터베이스에 테이블을 생성하고, 데이터를 CRUD하는 등의 작업을 해보았습니다.<br>"
             + "앞으로 데이터베이스를 이용하여 직접적인 DB모델링, Java를 이용한 DB연동[JDBC]을 학습할 계획입니다.</p><br>"
             + "<h2>SQL의 특징</h2>"
             + "<ul>"
             + "<li>여타 프로그래밍 언어들처럼 절차적인 개별 단위로 처리되기보다, 데이터의 집합 단위로 처리됩니다.</li>"
             + "<li>선언적 언어 ; 실제 데이터들이 어떻게 처리되는지에 대한 세부적인 과정은 SQL문장을 작성하는 사람은 신경쓰지 않아도 된다는 장점이 있습니다.</li>"
             + "<li>공인된 기관의 표준 SQL 문법이 존재하기에, DBMS의 종류에 얽매이지 않고 사용할 수 있는 장점이 있습니다.</li>"
             + "</ul>";
	showModal(this.alt);
}
img[2].onclick = function(){    // html&css img
    this.alt = "<h1>HTML &#38; CSS</h1><br>"
             + "<h2>HTML</h2><p> : WWW상 개개인의 문서(페이지), 문서의 구조를 설계할 때 사용하는 언어이다.</p>"
             + "<h2>CSS</h2><p> : HTML로 만들어진 페이지의 '화장법'이다.</p>"
             + "<br>"
             + "<p>HTML과 CSS를 배우면서, 제가 넣고 싶은 Animation 효과등을 넣어보면서 즐거웠지만"
             + "보다 애니메이션 효과에 치중한 나머지 중요한 것들을 놓치지 않았나 생각이 됩니다.<br>"
             + "중간중간에 보면서 넘어간 Template를 사용한 페이지의 CSS나, Layout들을 보면서 방대한 div 구조와 다양한 CSS 속성 종류에 다시 한 번 놀랐습니다.</p>"
             + "<p><br></p>"
	showModal(this.alt);
}
img[3].onclick = function(){    // javascript img
    this.alt = "<h1>Java script</h1>"
            + "<h2>자바 스크립트란..</h2>"
            + "<p>자바스크립트를 한마디로 요약하자면 웹을 풍부하게 만들어주는 작고 가벼운 언어입니다.<br>"
            + "웹 브라우저에서 실행하는 스크립트 언어를 기술합니다. 작고도 빠르기 때문에<br>"
            + "웹문서를 동적으로 꾸밀 때 가장 널리 쓰입니다. 언어 규격은 자바의 부분 집합(subset)으로 되어 있습니다.<br>"
            + "하이퍼텍스트 생성 언어(HTML) 문서를 작성하는 수준의 사용자가 사용하는 것을 주안점으로 하여 자바의 언어 규격으로부터<br>"
            + "변수의 형(정수형이나 문자열형 등)을 생략하거나 새로운 클래스 정의를 할 수 없도록 하였습니다. 스크립트는 HTML 문서 속에 직접 기술하며,"
            + "script라는 꼬리표를 사용합니다. 프로그래밍 입문자들은 자바스크립트와 자바가 서로 비슷한 기술이라고 생각하곤 합니다.<br>"
            + "두 언어 모두 자바라는 언어를 기반으로 하고 있기 때문이죠. 하지만 자바스크립트는 자바와는 다른점이 상당히 많습니다. 기능과 사용법까지 완전히 다릅니다.<br><br>"
            + "<span style='font-size=10px;'>출처 : <a href='https://coding-factory.tistory.com/193'>https://coding-factory.tistory.com/193</a></span>";
	showModal(this.alt);
}
img[4].onclick = function(){    // jQuery img
    this.alt = "<h1>JQuery modal</h1>";
	showModal(this.alt);
}
img[5].onclick = function(){    // Servlet & jsp img
    this.alt = "<h1>Servlet & jsp modal</h1>";
	showModal(this.alt);
}
img[6].onclick = function(){    // Spring framework img
    this.alt = "<h1>Spring modal</h1>";
	showModal(this.alt);
}
img[7].onclick = function(){    // my life img
    this.alt = "<h2>과제를 진행하면서 Boot와 Template을 사용하지 않고 만들어보았습니다..</h2>"
             + "<h3>CSS도 만들어보니 굉장히 어려웠습니다.</h3>"
             + "<h3>W3, 검색 등을 이용해 넣고싶은 기능이나 효과들을 찾고, 적용하는데 시간이 걸렸던 것 같습니다.</h3>"
             + "<h3>넣지 못한 효과도 있고 반응형을 이 홈페이지 적용하지 않아 아쉬움이 있습니다.</h3>"
             + "<br>"
             + "<br><h2>고생한 우리 2조 다들 수고하셨습니다~~<h2><br>"
             + "<p><b>앞으로 같이 더더더 빡세게 수고합시다!</b></p>";
	showModal(this.alt);
}

function showModal(alt){
	modal.style.display = "block";
	captionText.innerHTML = alt;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none";
}