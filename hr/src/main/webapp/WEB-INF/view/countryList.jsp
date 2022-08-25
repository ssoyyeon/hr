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
	<div>
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
	<div>
		<a href= "${pagaContext.request.contextPath}/addCountry">add Country</a>
	</div>
	<table border="1">
		<tr>
			<th>countryId</th>
			<th>countryName</th>
			<th>regionId</th>
			<th>regionName</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="c" items="${countryList}">
		<tr>
			<td>${c.COUNTRYID}</td>
			<td>${c.COUNTRYNAME}</td>
			<td>${c.REGIONID}</td>
			<td>${c.REGIONNAME}</td>
			<td><a href= "${pageContext.request.contextPath}/modifyCountry?countryId=${c.COUNTRYID}">수정</a></td>
			<td><a href= "${pageContext.request.contextPath}/removeCountry?countryId=${c.COUNTRYID}">삭제</a></td>
		</tr>	
		</c:forEach>
	</table>
</body>
</html>