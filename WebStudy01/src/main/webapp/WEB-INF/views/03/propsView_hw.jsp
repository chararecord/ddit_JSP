<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<!-- 마 절대경로를 써라! 상대경로 말고! -->
<!-- <img src="../../resources/images/cat1.jpg" /> -->
<h4> properties 파일 뷰어 </h4>
<table border="1">
	<thead>
		<tr>
			<th>key</th>
			<th>value</th>
		</tr>
	</thead>
	<tbody id="tb">
	
	</tbody>
</table>
<script type="text/javascript">
	$.ajax({
		/* url -> 이 요청이 servlet에게 넘어간다는 말씀! */
		/* 응답데이터와 관련된 설정들 */
		dataType : "json",
		success : function(resp) {
// 			resp.prop1 : 동적 변경 X
// 			resp['prop1'] : 동적 변경 O
			console.log(resp)
			let props = resp;
			let html = "";
			for(i=0; i<props.length; i++){
				console.log(props[i].key, props[i].value)
				html += `
					<tr>
						<td>\${props[i].key}</td>
						<td>\${props[i].value}</td>
					</tr>
				`
			}
			console.log(html);
			let obj = document.querySelector("#tb");
			obj.innerHTML = html;
		},
		error : function(jqXHR, status, error) {
			console.log(jqXHR);
			console.log(status);
			console.log(error);
		}
	});
</script>
</body>
</html>