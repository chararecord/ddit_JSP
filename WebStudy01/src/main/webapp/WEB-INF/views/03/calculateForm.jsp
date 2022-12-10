<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<!--
	사칙연산기를 만들어보자! 백그라운드 방식으로 동작하는 사칙연산기를 만들자!
	get방식이 됐던 post방식이 됐던 한가지 통일된 방식으로 받는다..
	연산은 서버사이드에서 실행, 그 결과를 클라이언트에게 보내줌. 굳이 불편하게 동기처리해야해? => 비동기처리 연산 수행
	최종적인 연산 수행 결과는  div 공간 안에 넣자.
	form action 값이 없지...? => location의 href값
	수업때는 바디가 없었는데 이번에는 바디가 있다는 차이점~!~! 해결해오면 여기에다가 몇가지 문법을 얹어볼건데 그 중 하나는 enum
	열거형에서 파생된 열거형 파일이라는 enum을 가지고 수업을 할 것입니다.. 초급자바 잘 찾아보면 enum 수업 내용 있으니까 한번만 살펴보고 오세요
-->
<input type="radio" name="dataType" value="json" />JSON
<input type="radio" name="dataType" value="xml" />XML
<form method="post">
	<input type="number" name="leftOp" placeholder="좌측피연산자" />
	<select name="operator" id="target">
		<option value="PLUS">+</option>
		<option value="MINUS">-</option>
		<option value="MULTIPLY">*</option>
		<option value="DIVIDE">/</option>
	</select>
	<input type="number" name="rightOp" placeholder="우측피연산자" />
	<button type="submit">=</button>
</form>
<div id="resultArea">
<p></p>
</div>
</body>
<script type="text/javascript">
	let resultArea = $("#resultArea"); // 			div 공간
	let dataTypes = $("input[name=dataType]"); // 	dataTypes
	let select = document.querySelector("#target");
	let html = "";
	
	
	let sucesses = {
		json:function(resp){
			console.log("resp : " + resp);
			resultArea.empty();
			resultArea.append(html.replace("%r",resp));
		},
		xml:function(domResp){
			console.log("domResp : " + domResp);
			let root = $(domResp).find("Integer");
			let name = "";
			let value = "";
			let set = [];
			root.children().each(function(idx, child){
				name = child.tagName;
				value = child.innerHTML;
				set.push(name, value);
			});
			console.log("name : "+ name)
			console.log("value : "+ value)
			console.log("set : "+ set)
			resultArea.empty();
			resultArea.append(html.replace("%r",set));
		}
	}
	$("form").on("submit", function(event){
		event.preventDefault();
		let method = this.method;
		let data = $(this).serialize();
		let dataType = dataTypes.filter(":checked").val();
		let x = $("input[name=leftOp]").val();
		let y = $("input[name=rightOp]").val();
		let oper = select.options[select.selectedIndex].text;
		html = "%x%o%y=%r".replace("%x", x).replace("%o", oper).replace("%y", y);
		
		console.log("x" + x)
		console.log("oper" + oper)
		console.log("y" + y)
		console.log("method : " + method)
		console.log("data : " + data)
		console.log("dataType : " + dataType);
		$.ajax({
			method : method,
			data : data,
			dataType : dataType,
			success : sucesses[dataType],
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
	});
</script>
</html>