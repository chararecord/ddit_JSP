<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jpeg=red, png=green, gif=blue  -->
<!-- 옵션을 선택, 선택된 옵션이 가지고 있는 클래스를 확인하면 마임.. -->
<!-- 마임이 뭐냐에 따라 셀렉트 태그의 백그라운드가 바뀐다... -->
<!-- 1. 셀렉트 태그 이벤트 처리 -->
<!-- 2. 어떤 옵션이 선택되었는지 확인할 수 있어야하고 -->
<!-- 3. 그 옵션의 클래스를 확인하고 -->
<!-- 4. 클래스에 따라 스타일을 변경할 수 있어야함 -->

<!-- 처리할 이벤트의 종류 : 기존의 change 이벤트 그대로 가고 -->
<!-- 동적으로 바꿀 수 있는 코드만 만들면 됨 -->
<!-- img 태그를 동적으로 만들어..... 처음에는 문자열로 만들었었찌... 그걸.. 복습.. -->
<style type="text/css">
	.red {
		background-color: pink;
	}
	.green {
		background-color: silver;
	}
	.blue {
		background-color: fuchsia;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<form name="imgForm" action="<%=request.getContextPath()%>/imageStreaming.do">
	<select name='image'>
	</select>
	<input type='submit' value='전송' />
	</form>
	<div id="imgArea">
	</div>
<script>
	// [] attributeSelector
	const DIVTAG = $("#imgArea");
	const SELECTTAG = $("[name=image]").on("change", function(event) {
		let option = $(this).find("option:selected");
		let mime = option.attr("class");
		let clzName = matchedClass(mime);
		$(this).removeClass(colors);
		$(this).addClass(clzName);
		
		let srcURL = document.imgForm.action;
		let queryString = $(document.imgForm).serialize();
		let src = "%U?%P".replace("%U", srcURL).replace("%P", queryString);
		
		let img = $("<img>").attr("src", src);
		DIVTAG.html(img);
<%-- 		$('#iaid').attr('src', "<%=request.getContextPath()%>/imageStreaming.do?image=" + option.val()) --%>
	}); 
	const changeCondition = {
			jpeg:"red"
			, png:"green"
			, gif:"blue"
	}
	const colors = [];
	$.each(changeCondition, function(prop, propValue) {
		console.log(prop+",    "+propValue);
		colors.push(propValue);
	});
	
	
	// 자바스크립트에서는 함수도 객체다
	let matchedClass = function(mime) {
		let clzName = "";
		for (let prop in changeCondition) {
			let idx = mime.indexOf(prop);
			if(idx >= 0) {
				clzName = changeCondition[prop];
				break;
			}
		}
		return clzName;
	}
	
	$.ajax({
		dataType : "json",
		success : function(resp) {
			let options = []; // 비어있는 배열, 배열로 온 거니까 배열로 받자
			$.each(resp, function(index, file) {
				let option = $("<option>")
							.addClass(file.mime)
							.html(file.name);
				options.push(option);
			});
			SELECTTAG.append(options);
		},
		error : function(jqXHR, status, error) {
			console.log(jqXHR);
			console.log(status);
			console.log(error);
		}
	});
	
	/* $('select').on('change', function() {
	if ($('select option:selected').attr('class') == "image/jpeg") {
		$(this).attr("class", "image/jpeg pink");			
	} else if ($('select option:selected').attr('class') == "image/png") {
		$(this).attr("class", "image/jpeg teal");			
	} else if ($('select option:selected').attr('class') == "image/png") {
		$(this).attr("class", "image/jpeg silver");			
	}
}); */
	
</script>
</body>
</html>