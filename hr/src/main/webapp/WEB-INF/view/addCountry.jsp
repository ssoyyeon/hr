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
	<!-- menu -->
	<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	<form method="post"
		action="${pageContext.request.contextPath}/addCountry">
		<table border="1">
			<caption>Country 추가하기</caption>
			<tr>
				<th>countryId</th>
				<td><input type="text" name="countryId"></td>
			</tr>
			<tr>
				<th>countryName</th>
				<td><input type="text" name="countryName"></td>
			</tr>
			<tr>
				<th>regionName</th>
				<td><select name="regionId">
						<c:forEach var="c" items="${regionList}">
							<option value="${c.regionId}">${c.regionName}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<div>
			<button type="submit">addCountry</button>
		</div>
	</form>

	<!-- footer -->
	<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
</body>
</html>