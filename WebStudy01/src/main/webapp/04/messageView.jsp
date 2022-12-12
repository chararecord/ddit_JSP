<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/messageView.jsp</title>
<!-- contextPath, 절대경로, clientSide방식 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<!--
1.
옵션 값이 달라짐에 따라 data-key1 값이 변경되도록하기
option도 message bundle 파일에 있는 key만 싹 긁어와서 돌아가게만 만들어봐~~
-->
<select id="selName">

</select>
<h4 id="greetingArea" data-key1="prop1" data-key2="sample" data-other-key="TEST"></h4>
<input type="radio" name="dataType" data-data-type="json" checked />JSON
<input type="radio" name="dataType" data-data-type="xml" />XML
<input type="radio" name="dataType" data-data-type="text" />PLAIN

<!-- 선택되지 않는 변수도 존재 -->
<input type="radio" name="language" data-locale="ko" />한국어
<input type="radio" name="language" data-locale="en" />영어
<script>
	let greetingArea = $("#greetingArea");
// 	console.log(greetingArea.data("key1"));					// 키 꺼내오기
// 	console.log(greetingArea.data("otherKey"));				// 키 꺼내오기
// 	console.log(greetingArea.data("key2", "otherValue"));	// 키 변경하기
// 	console.log(greetingArea.data("key2"));					// 키 꺼내오기
	let radioBtns = $('[type="radio"]');
	let dataTypes = radioBtns.filter("[name=dataType]");
	let locales = radioBtns.filter("[name=language]");
	let select = $('#selName');
	

	/* sucesses 함수 */
	let successes = {
// 		ex) json -> resp.message; (json 원형 객체 안에 message라는 property가 있어야함)
		json:function(resp){
			greetingArea.text(resp.message);
			let options = [];
			$.each(resp.keyList, function(index, value){
				let option = $("<option>")
							.addClass(value)
							.html(value);
				options.push(option);
			})
			$("#selName").empty();
			$("#selName").append(options);
		},
		xml:function(domResp){
// 			console.log("xml resp : " + domResp);
			let message = $(domResp).find("message").text();
			greetingArea.html(message);
		},
		text:function(plain){
// 			console.log("text resp : " + plain);
			greetingArea.html(plain);
		}
	}
	
	/* ajax */
	let settings = {
		/* 절대경로, clientSide방식, contextPath */
		url : "<%=request.getContextPath()%>/04/getGreetingMessage",
		error : function(jqXHR, status, error) {
			console.log(jqXHR);
			console.log(status);
			console.log(error);
		}
	};
	
	radioBtns.on("change",function(){
// 		greetingArea.empty();
		greetingArea.html("");
		let dataType = dataTypes.filter(":checked").data("dataType");
		settings.dataType=dataType;
		settings.success=successes[dataType];
		settings.data = {
// 			name:greetingArea.data("key1")
			name:greetingArea.attr("data-key1") /* 속성에 바로 접근 */
		}
		let locale = locales.filter(":checked").data("locale");
		if(locale){
			settings.data.locale=locale;
			}
		console.log("========================");
		console.log(settings);
		console.log("========================");
		$.ajax(settings);		
	}).trigger("change");
	
	select.on("change", function(){
		let opTxt = $(this).find("option:selected").text();
		greetingArea.attr("data-key1", opTxt);
	}).trigger("change");
</script>
</body>
</html>