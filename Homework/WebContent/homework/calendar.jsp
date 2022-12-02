<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
	@font-face {
	    font-family: 'Pretendard-Regular';
	    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
	    font-weight: 100;
	    font-style: normal;
	}
	body {
	    font-weight: Thin;
	}

	.cal-tbl {
		font-family: 'Pretendard-Regular';
		font-size: 15px;
		width: 300px;
		border: 1px solid #646464;
		border-collapse: collapse;
		background-color: #646464;
		color: white;
	}
	.tr-border {
		border-top: 1px solid #B6B6B6;
	}
	
	.cal-tbl td {
		padding-top: 10px;
		padding-bottom: 10px;
		padding-left: 15px;
		padding-right: 15px;
	}
	
	button {
		padding: 0;
	}
	#h1TimeArea {
		font-size: 40px;
		height: 10px;
	}
	#dateArea {
		color: pink;
	}
	.material-symbols-outlined {
		font-size:15px;
	}
</style>
</head>
<body>
	<div class='cal-wrapper'>
		<table class='cal-tbl'>
			<tr>
				<td colspan='7'><h1 id='h1TimeArea'><span id='timeArea' /></h1></td>
			</tr>
			<tr>
				<td colspan='7'><span id='dateArea' /></td>
			</tr>
			<tr class='tr-border'>
				<td colspan='5'>2022년 12월</td>
				<td><span class="material-symbols-outlined">keyboard_arrow_up</span></td>
				<td><span class="material-symbols-outlined">keyboard_arrow_down</span></td>
			</tr>
			<tr>
				<td>일</td>
				<td>월</td>
				<td>화</td>
				<td>수</td>
				<td>목</td>
				<td>금</td>
				<td>토</td>
			</tr>
			<tr class='tr-border'>
				<td colspan='6'>오늘</td>
				<td>+</td>
			</tr>
		</table>
	</div>
<script type="text/javascript">

	/* timeArea 시간 넣고 1초마다 움직이게 하기 */
	function f_clock() {
		let now = new Date().toLocaleTimeString();
		let time = document.getElementById('timeArea');
		timeArea.innerHTML=now;
		setTimeout('f_clock()', 1000);
	}
	f_clock();
	/* dateArea 날짜 출력 */
	function f_date() {
		let today = new Date();
		let option = {year:"numeric", month:"long", day:"numeric", weekday:"long"};
		let day = today.toLocaleDateString('ko-KR', option);
		dateArea.innerHTML=day;
	}
	f_date()
</script>
</body>
</html>