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
	<!-- menu.jsp include (forward와 동일한 기술) -->
	<div>
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
	<form method="post" action="${pageContext.request.contextPath}/addRegion">
		<div>
			regionId: <input type="text" name="regionId">
		</div>
		<div>
			regionName: <input type="text" name="regionName">
		</div>
		<div>
			<button type="submit">addRegion</button>
		</div>
		<!-- footer -->
		<div>
			<c:import url="/WEB-INF/view/inc/footer.jsp">
			</c:import>
		</div>
	</form>
</body>
</html>