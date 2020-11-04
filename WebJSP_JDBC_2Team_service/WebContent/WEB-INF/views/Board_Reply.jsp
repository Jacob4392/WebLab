<%@ page import="kr.or.bit.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	Board board = (Board) request.getAttribute("boarddata");
String Content = board.getBoard_content();
%>

<html>
<head>
<title>MVC 게시판</title>
<!-- 썸머노트 + Head : SummerNote.jsp -->
<jsp:include page="/common/SummerNote.jsp"></jsp:include>
<script language="javascript">
	function replyboard() {
		boardform.submit();
	}
	
	$(function(){
	    $('#summernote').summernote({
	        placeholder: 'Hello summernote',
	        tabsize: 2,
	        height: 120,
	        toolbar: [
					['style', ['style']
				],
				['font', 
					['bold', 'underline', 'clear']
				],
		        ['color', 
		        	['color']
		        ],
		        ['para', 
		        	['ul', 'ol', 'paragraph']
		        ],
		        ['table', 
		        	['table']
		        ],
		        ['insert', 
		        	['link', 'picture', 'video']
		        ],
		        ['view', 
		        	['fullscreen', 'codeview', 'help']
		        ]
	        ]
	      });
	});
</script>
</head>
<body>
	<!-- Top 부분 header와 nav를 묶은 Top.jsp -->
	<jsp:include page="/common/Top.jsp"></jsp:include>
	<section id="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<section class="panel">
						<div class="table-responsive">
							<!-- 게시판 답변 -->
							<form action="BoardReplyAction.do" method="post" name="boardform">
								<input type="hidden" name="BOARD_NUM"
									value="<%=board.getBoard_num()%>"> <input type="hidden"
									name="BOARD_RE_REF" value="<%=board.getBoard_re_ref()%>">
								<input type="hidden" name="BOARD_RE_LEV"
									value="<%=board.getBoard_re_lev()%>"> <input
									type="hidden" name="BOARD_RE_SEQ"
									value="<%=board.getBoard_re_seq()%>">

								<table class="table" cellpadding="0" cellspacing="0">
									<tr align="center" valign="middle">
										<td colspan="5">MVC 게시판</td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12" height="16">
											<div align="center">글쓴이</div>
										</td>
										<td><input name="BOARD_NAME" type="text" /></td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12" height="16">
											<div align="center">제 목</div>
										</td>
										<td><input name="BOARD_SUBJECT" type="text" size="50"
											maxlength="100" value="Re: <%=board.getBoard_subject()%>" /></td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12">
											<div align="center">내 용</div>
										</td>
										<td><textarea id="summernote" name="BOARD_CONTENT" cols="67" rows="15"></textarea>
										</td>
									</tr>
									<tr>
										<td style="font-family: 돋음; font-size: 12">
											<div align="center">비밀번호</div>
										</td>
										<td><input name="BOARD_PASS" type="password"></td>
									</tr>

									<tr bgcolor="cccccc">
										<td colspan="2" style="height: 1px;"></td>
									</tr>
									<tr>
										<td colspan="2">&nbsp;</td>
									</tr>

									<tr align="center" valign="middle">
										<td colspan="5"><a href="javascript:replyboard()">[등록]</a>&nbsp;&nbsp;
											<a href="javascript:history.go(-1)">[뒤로]</a></td>
									</tr>
								</table>
							</form>
							<!-- 게시판 답변 -->
							*원본글 내용* <br>
							<hr>
							<%= Content.replaceAll("\r\n", "<br>") %>
							<hr>
						</div>
					</section>
				</div>
			</div>
		</div>
	</section>

	<!-- End Hero -->
	<!-- Footer부분의 jsp -->
	<jsp:include page="/common/Bottom.jsp"></jsp:include>
	<!-- Template 자체 Animation 및 Vendor 파일을 묶은 Foot.jsp -->
	<jsp:include page="/common/Foot.jsp"></jsp:include>
	
</body>
</html>