<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body>
	<form action='${cPath}/imageStreaming.do' target='param'>
		<select name='image'>
		${options}
		</select>
		<input type='submit' value='전송' />
	</form>
	<div id='imgArea'></div>
	<iframe name='param' width="100%" height="100%" visible="hidden"></iframe>
<script type="text/javascript">
	$("[name=image]").on("change", function(event) {
 		event.target===this
		/* this.form.submit(); => submit 이벤트가 발생하지 않음 */
		// 그냥 this와 jquery의 this의 차이점? 콘솔에 출력해보렴
		$(this).parents("form").submit();
	});
</script>
</body>
</html>
