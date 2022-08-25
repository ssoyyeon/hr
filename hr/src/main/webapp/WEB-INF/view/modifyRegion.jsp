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
   <form method="post"
      action="${pageContext.request.contextPath}/modifyRegion">
      <div>
         regionId : <input type="text" name="regionId" value="${region.regionId}" readonly="readonly">
      </div>
      <div>
         regionName : <input type="text" name="regionName" value="${region.regionName}">
      </div>
      <div>
         <button type="submit">modifyRegion</button>
      </div>
   </form>
   <!-- footer include -->
   <hr>
   <div>
      <c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
   </div>
</body>
</html>
