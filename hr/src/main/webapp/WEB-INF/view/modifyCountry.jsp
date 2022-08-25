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
      action="${pageContext.request.contextPath}/modifyCountry">
      <div>
         regionId : <input type="text" name="regionId" value="${countryList.regionId}" readonly="readonly">
      </div>
      <div>
         countryId : <input type="text" name="countryId" value="${countryList.countryId}" readonly="readonly">
      </div>
      <div>
         countryName : <input type="text" name="countryName" value="${countryList.countryName}">
      </div>
      <div>
         <button type="submit">Modify Country</button>
      </div>
   </form>
   <!-- footer include -->
   <hr>
   <div>
      <c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
   </div>
</body>
</html>
