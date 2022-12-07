<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

	#calendar {
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
	
	#calendar td {
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
<script type="text/javascript">
var today = new Date();
function buildCalendar(){
  var row = null
  var cnt = 0;
  var calendarTable = document.getElementById("calendar");
  var calendarTableTitle = document.getElementById("calendarTitle");
  calendarTableTitle.innerHTML = today.getFullYear()+"년"+(today.getMonth()+1)+"월";
  
  var firstDate = new Date(today.getFullYear(), today.getMonth(), 1);
  var lastDate = new Date(today.getFullYear(), today.getMonth()+1, 0);
  while(calendarTable.rows.length > 4){
  	calendarTable.deleteRow(calendarTable.rows.length -1);
  }

  row = calendarTable.insertRow();
  for(i = 0; i < firstDate.getDay(); i++){
  	cell = row.insertCell();
  	cnt += 1;
  }
  	
  for(i = 1; i <= lastDate.getDate(); i++){
  	cell = row.insertCell();
  	cnt += 1;

    cell.setAttribute('id', i);
  	cell.innerHTML = i;
  	cell.align = "center";

    cell.onclick = function(){
    	clickedYear = today.getFullYear();
    	clickedMonth = ( 1 + today.getMonth() );
    	clickedDate = this.getAttribute('id');

    	clickedDate = clickedDate >= 10 ? clickedDate : '0' + clickedDate;
    	clickedMonth = clickedMonth >= 10 ? clickedMonth : '0' + clickedMonth;
    	clickedYMD = clickedYear + "-" + clickedMonth + "-" + clickedDate;

    	opener.document.getElementById("date").value = clickedYMD;
    	self.close();
    }

    if (cnt % 7 == 1) {
    	cell.innerHTML = "<font color=#F79DC2>" + i + "</font>";
    }

    if (cnt % 7 == 0){
    	cell.innerHTML = "<font color=skyblue>" + i + "</font>";
    	row = calendar.insertRow();
    }
  }

  if(cnt % 7 != 0){
  	for(i = 0; i < 7 - (cnt % 7); i++){
  		cell = row.insertCell();
  	}
  }
}

function prevCalendar(){
	today = new Date(today.getFullYear(), today.getMonth()-1, today.getDate());
	buildCalendar();
}

function nextCalendar(){
	today = new Date(today.getFullYear(), today.getMonth()+1, today.getDate());
	buildCalendar();
}
</script>
</head>
<body>
	<div class='cal-wrapper'>
		<table id='calendar'>
			<tr>
				<td colspan='7'><h1 id='h1TimeArea'><span id='timeArea' /></h1></td>
			</tr>
			<tr>
				<td colspan='7'><span id='dateArea' /></td>
			</tr>
			<tr class='tr-border'>
				<td colspan='5' id='calendarTitle'>yyyy년  m월</td>
				<td><label onclick="prevCalendar()" />∧</td>
				<td><label onclick="nextCalendar()" />∨</td>
			</tr>
			<tr>
				<td align="center"><font color ="#F79DC2">일</td>
				<td align="center">월</td>
				<td align="center">화</td>
				<td align="center">수</td>
				<td align="center">목</td>
				<td align="center">금</td>
				<td align="center"><font color ="skyblue">토</td>
			</tr>
			<script type="text/javascript">buildCalendar();</script>
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
	let option = {year:"numeric", month:"long", day:"numeric", weekday:"long"};
	let day = today.toLocaleDateString('ko-KR', option);
	dateArea.innerHTML=day;
}
f_date();
</script>
</body>
</html>