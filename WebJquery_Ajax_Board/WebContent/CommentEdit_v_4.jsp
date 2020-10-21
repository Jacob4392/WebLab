<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.over {cursor:pointer;}
	</style>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//순서를 보장하는 형태의 꽁수 ....
			//promise 패턴 사용 (권장) 
			GetBoardList();
			RowUpdateBoard();
		});
	
		function RowUpdateBoard(){
			//https://www.w3schools.com/jquery/ajax_serialize.asp
			$('#updateForm').on("submit",function(){
				var param = $(this).serialize();
				//console.log(param);
				//alert("submit");
				$.ajax({
					url:"CommentEditUpdate.jsp",
					dataType:"JSON",
					type : "POST",
					data : param, //{"seq" :"1" ,"title" : "A" , "content":"A" , "regdate":"11" , "hit":"1"} ,
					success : function(returndata){
						    alert(returndata.result);
						 	if(returndata.result){
								alert("수정성공");
								GetBoardList(); //데이터 갱신하기
							}else{
								alert("수정실패");
							}  
						}
					
					});
				
			 	return false; //기본적인 submit 하지 말아라  (동기식 하지 말아라 ...)
			});
		}
		
		
		
		function GetBoardList(){
			alert("호출 : GetBoardList");
			//데이터 만드는 작업 (비동기)
			$.ajax({
				url : "CommentEditList.jsp" ,
				dataType : "JSON",
				type : "POST" ,
				success : function(data){
					//[{"content":"0 번째 내용","hit":0,"regdate":"2017-11-12","seq":0,"title":"0 번쨰 제목"},{"content":"1 번째 내용","hit":1,"regdate":"2017-11-12","seq":1,"title":"1 번쨰 제목"},{"content":"2 번째 내용","hit":2,"regdate":"2017-11-12","seq":2,"title":"2 번쨰 제목"},{"content":"3 번째 내용","hit":3,"regdate":"2017-11-12","seq":3,"title":"3 번쨰 제목"},{"content":"4 번째 내용","hit":4,"regdate":"2017-11-12","seq":4,"title":"4 번쨰 제목"}]
 				    //console.log(data);
					//https://www.w3schools.com/jquery/misc_data.asp
					$('#listView').empty();
					$('#listView').data("list",data); //key "data" value Array객체
					
					//data -> [{},{},{},{}]
					//data -> json 형태의 ArrayObject
					//테이블 구성하기
					//$.each(data,function(index , obj){
						//obj.seq
					//});
					
					for(var k=0 ; k < data.length ; k++){
						var tr="";
						tr += "<tr index='"+ (k) +"'>";
						tr += "<td>" + data[k].seq + "</td>";
						tr += "<td>" + data[k].title + "</td>";
						tr += "<td>" + data[k].content + "</td>";
						tr += "<td>" + data[k].regdate + "</td>";
						tr += "<td>" + data[k].hit + "</td>";
						tr += "</tr>";
						
						//<tr index=0><td>0</td><td>홍길동</td></tr>
						
						var trObj = $(tr); //trObj (json 객체로 만들기)
						console.log(trObj);
						
						trObj.addClass("over").on("click",function(){
							//tr > click 하면 상세  출력 
							//각각의 tr 을 클릭했을때  >  현재 선택한 tr 을 내용을 
							//수정가능한 아래 테이블에 내용 보여주기
							
								var index = $(this).attr("index");
								//console.log(index);
								var data = $("#listView").data("list");
								console.log("데이터 : " + data);
								var rowdata = data[index];  //[{},{},{}]
								//rowdata = {"content":"0 번째 내용","hit":0,"regdate":"2017-11-12","seq":0,"title":"0 번쨰 제목"}
								//console.log(data);
							    //rowdata {}객체 	
								
								//https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_prop_attr
								//각각의 input 태그에 value 값을 넣기
								$('#detailView').find(":input").each(function(){
									var name = $(this).prop("name"); //속성의 이름만 가져오기
									//console.log(name);
									var value =rowdata[name];
									//console.log(value);
									if(value != undefined){
										$(this).val(value);
									}
								});
							
						});
						
						$('#listView').append(trObj);
					}
				}
			});
		}
	</script>
</head>
<body>
	<a href="Comment_v_3.jsp">이전</a>
	<a href="">다음</a>
	<br>
	<p>CommentEdit_v_4.jsp</p><br><br>

	<div>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>글제목</th>
					<th>글내용</th>
					<th>등록일</th>
					<th>조회수</th>				
				</tr>
			</thead>
			<tbody id="listView">
			
			</tbody>
		</table>
	</div>
	<div id="detailView">
		<form id="updateForm">
			<table border="1">
				<tr>
					<td>번호</td>
					<td><input type="text" name="seq" value="" readonly></td>
				</tr>
				<tr>
					<td>글제목</td>
					<td><input type="text" name="title" value=""></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><input type="text" name="content" value=""></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="text" name="regdate" value=""></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td><input type="text" name="hit" value=""></td>
				</tr>
			</table>
			<input type="submit" id="btnUpdate" value="수정하기">
		</form>	
	</div>
</body>
</html>














