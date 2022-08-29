<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	// $(function(){
	$(document).ready(function() {
		$('#removeFile').click(function() {
			$('#fileSection').empty();
		});

		$('#addFile').click(function() {
			// 공백을 알아보기 위한 변수 
			let isFileEmpty = false;
	
			let html = '<div><input type="file" name="multiList" class="multiList"></div>';
			$('.multiList').each(function(index,item) {
				// $(this) --> item
				if ($(item)
						.val() == '') {
					isFileEmpty = true;
				}
			});
			
			if (isFileEmpty == false) {
				$('#fileSection').append(html);
			}
		});

		$('#addBtn').click(function() {
			// 공백을 알아보기 위한 변수 
			let isFileEmpty = false;
			// board 유효성 검사 후

			$('.multiList').each(function(index, item) {
				// $(this) --> item
				if ($(item).val() == '') {
					isFileEmpty = true;
				}
			});
			if ($('#boardTitle').val() == '') {
				alert('boradTitle를 입력하세요');
			} else if (isFileEmpty == true) {
				alert('boradTitle를 입력하세요');
			} else {
				$('#addFileForm').submit();
			}
		});
	});
</script>
</head>
<body>
	<form enctype="multipart/form-date" method="post"
		action="${pageContext.request.contextPath}/addBoard" id="addFileForm">
		<!-- Board 내용 -->
		<div>
			boardTitle <input type="text" name="board.boardTitle" id="boardTitle">
		</div>
		<!-- Board 내용 -->
		<!-- name="multiple" -> mutiple 여러개의 파일을 선택할 수 있다. -->
		<!-- button을 누르면 파일 입력창이 열려 파일을 선택할 수 있도록 -->
		<button type="button" id="addFile">파일추가</button>
		<!--  input type="file" -->
		<button type="button" id="removeFile">파일삭제</button>
		<div id="fileSection"></div>

		<button type="button" id="addBtn">addBoard</button>
	</form>
</body>
</html>