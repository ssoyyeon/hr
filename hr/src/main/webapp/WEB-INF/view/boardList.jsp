<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div>
			<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
		</div>
		<h2>BoardList</h2>
		<a href="${pageContext.request.contextPath}/addboard">게시판 추가</a>
		<table border="1">
			<tr>
				<th>boardNo</th>
				<th>boardTitle</th>
				<th>boardContent</th>
				<th>boardfileNo</th>
				<th>filename</th>
				<th>fileType</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${boardList}" var="b">
				<tr>
					<td>${b.BOARDNO}</td>
					<td>${b.BOARDTITLE}</td>
					<td>${b.BOARDCONTENT}</td>
					<td>${b.BOARDFILENO}</td>
					<td>${b.FILENAME}</td>
					<td>${b.FILETYPE}</td>
					<td><a href= "${pageContext.request.contextPath}/modifyBoard?boardNo=${b.BOARDNO}">수정</a></td>
					<td><a href= "${pageContext.request.contextPath}/removeBoard?boardNo=${b.BOARDNO}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
		</div>
	</div>
</body>
</html>