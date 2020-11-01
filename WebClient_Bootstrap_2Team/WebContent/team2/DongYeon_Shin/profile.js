let inputtext = document.getElementById("inputtext");
function dragEnter1(ev) {
	ev.preventDefault();
}

function drag1(ev) {
	ev.dataTransfer.setData("text", ev.target.id);
}

function drop1(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");
	ev.target.appendChild(document.getElementById(data));
	 event.target.classList.add("dropped");
	 console.log(event.target.children[0].id);
	 if(event.target.children[0].id ==="drag1"){
		inputtext.innerHTML=("신동연");
	 }else if(event.target.children[0].id ==="drag2"){
		 inputtext.innerHTML=("만 29세");
	 }else if(event.target.children[0].id ==="drag3"){
		 inputtext.innerHTML=("1991년 6월 28일");
	 }else if(event.target.children[0].id ==="drag4"){
		 inputtext.innerHTML=("010-4707-4564");
	 }else if(event.target.children[0].id ==="drag5"){
		 inputtext.innerHTML=("인천 계양구 효성동 XX아파트");
	 }else if(event.target.children[0].id ==="drag6"){
		 inputtext.innerHTML=("ehddus299@naver.com");
	 }
}
function reset(){
    location.reload(); };