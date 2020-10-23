const title = document.querySelector("#title");
// title.innerHTML="Hi! ";
// title.style.color="red"
// function handleClick(){
//
// if(title.style.color==="red"){
//   title.style.color="orange";
// }else if(title.style.color==="orange"){
//   title.style.color="yellow";
// }else if(title.style.color==="yellow"){
//   title.style.color="green";
// }else if(title.style.color==="green"){
//   title.style.color="blue";
// }else if(title.style.color==="blue"){
//   title.style.color="navy";
// }else{
//   title.style.color="red";
// }
// }
// //window.addEventListener("resize", handleResize); //윈도우 사이즈 변경시 함수 실행 //handleResize()로 할경우에는 함수를 바로실행한다.
//  title.addEventListener("click", handleClick);
//
//  const name = prompt("what you are name?"); // prompt는 내장함수로서 팝업창에 질문과 답을 받을 수 있는 텍스트창이 나온다 입력값은 age의 값이 된다
//  //console.log(age); // 팝업창에 적은 답변이 출력된다.
// title.innerHTML+=name;
//
 const CLICKED_CLASS="clicked";
 function handleClick(){
   // const hasClass  = title.classList.contains(CLICKED_CLASS); //classlist 에 원하는 클래스명이 있는지 확인한다.
   //
   // if(!hasClass){
   //   title.classList.add(CLICKED_CLASS);
   // }else{
   //   title.classList.remove(CLICKED_CLASS);
   // }
title.classList.toggle(CLICKED_CLASS); //toggle()은 classlist에서 ()안의 class와 같은 이름을 찾고 있으면 지우고 없으면 추가해준다. 위의 주석내용을 요약한것이다.
 }
function init(){
    title.addEventListener("click", handleClick);
}
init()
