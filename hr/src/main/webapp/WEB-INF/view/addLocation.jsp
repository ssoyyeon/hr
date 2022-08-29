<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#regionId').change(function() {
		// alert('regionId change');
		// ajax호출 -> 값 -> countryId select append
		if($('#regionId').val() == '') {
			alert('region을 선택하세요');
		} else {
			$('#countryId').empty();
			$('#countryId').append('<option value="">::: country 선택 :::</option>')
			
			$.ajax({
				url : '/rest/getCountryList',
				type : 'get',
				data : {regionId : $('#regionId').val()},
				success : function(json) {
					//let arr = [];
					$(json).each(function(index, item){
						//arr.push(item);
						$('#countryId').append('<option value="'+item.countryId+'">'+item.countryName+'</option>')
					});
					//console.log(arr);
				}
			});
		}
	});
});
</script>
</head>
<body>
	<!-- menu.jsp include(forward동일한 기술) -->
	<div>
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
	<hr>
	
	<form method="post" action="${pageContext.request.contextPath}/addLocation">
		<div>
			regionId :
			<select id="regionId">
				<option value="">::: region 선택 :::</option>
				<c:forEach var="r" items="${regionList}">
					<option value="${r.regionId}">${r.regionName}</option>
				</c:forEach>
			</select>
			
			countryId :
			<select name="countryId" id="countryId">
			<option value="">::: country 선택 :::</option>
			</select>
		</div>
		
		<div>
			locationId : <input type="text" name="locationId">
		</div>
	</form>
		<div>
			<button type="button" id="addLocationBtn" >추가</button>
		</div>
	
	<!-- footer include -->
	<hr>
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
</body>
</html>