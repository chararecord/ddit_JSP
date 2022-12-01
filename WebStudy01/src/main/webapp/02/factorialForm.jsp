<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
<script>
	//*세개는 다 같은 행위를 하는 햄수 -> 바디가 닫히면 실행*
/* 	$(document).ready(function(){});
	$(document).on("ready", function(){}); */
	$(function(){
		let resultArea = $("#resultArea"); // 문서를 트래버싱하게 되는데 자주하면 부하걸리니까 *****
		$("form[name]").on("submit", function(event) {
			event.preventDefault();
			console.log($(this));
			console.log(this);
			console.log($(this)[0]);
			console.log($(this).get(0));
			let url = this.action;
			let method = this.method;
			let data = $(this).serialize();
			console.log(data);
			$.ajax({
				url : url,
				method : method,
				data : data,
				dataType : "html",
				success : function(resp) {
					resultArea.html(resp);
				},
				error : function(jqXHR, status, error) {
					console.log(jqXHR);
					console.log(status);
					console.log(error);
				}
			});
			return false; // 이벤트(고유의 액션=동기요청) 중단을 의미
		});
	});
</script>
</head>
<body>
<%/*
폼태그는 동기처리인데, 우리는 비동기로 바꾸려고 함. 여기서 keypoint는 lock!
아무나 먼저 가져다 쓰는 놈이 짱이여
동기요청은 화면 전체에 lock을 걸어요
이벤트핸들러를 사용한다 -> 콜백함수를 사용한다
인풋타입에서 결정되는 건 형태가 아니라 그 다음에 발생하는 이벤트
*/%>
<form name="facForm" action="<%=request.getContextPath() %>/02/factorial.do">
	<input type="number" name="number" />
	<input type="submit" value="전송" />
	<input type="reset" value="취소" />
	<input type="button" value="걍버튼" />
</form>
<div id="resultArea">

</div>
</body>
</html>