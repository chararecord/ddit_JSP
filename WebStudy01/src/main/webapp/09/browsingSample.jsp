<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09/browsingSample.jsp</title>
<jsp:include page="/includee/preScript.jsp" />
<script>
	$.fn.generateFileList=function(){
		let targetFolder = this.data("target");
		let ulTag = this;
		$.ajax({
			url : "<%=request.getContextPath()%>/browsing/getFileList",
			data : {
				target:targetFolder
			},
			dataType : "json", /* 마샬링해서 가져오기 */
			success : function(resp) {
				console.log(resp.files)
				let liTags = [];
				$.each(resp.files, function(idx, wrapper){
					let liTag = $("<li>")
								.addClass("list-group-item")
								.data("contentType",wrapper.contentType)
								.html(wrapper.name);
					liTags.push(liTag);
				});
				ulTag.html(liTags);
// 				resp.files - attribute의 Name
// 				데이터의 mime을 숨겨놓는 형태로 data 속성을 완성시켜보자
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
		return this;
	}
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<h4>src : /resources/images</h4>
			<ul class="list-group" id="srcUL" data-target="/resources/images">
<!-- 				<li data-content-type="image/jpeg"  class="list-group-item active">cat1.jpg</li> -->
<!-- 				<li data-content-type="image/jpeg"  class="list-group-item">cat1.jpg</li> -->
			</ul>
		</div>
		<div class="col">
			<input type="radio" name="command" value="COPY" checked />COPY
			<input type="radio" name="command" value="MOVE" />MOVE
			<button id="controlBtn" class="btn btn-primary">실행</button>
		</div>
		<div class="col">
			<h4>dest : /destImgs</h4>
			<ul class="list-group" id="destUL" data-target="/destImgs">
			</ul>
		</div>
	</div>
</div>

<script type="text/javascript">
	/* li 태그 완성시키는 ajax */
	/* function을 만들어서 파라미터를 받아 처리하는 구조 -> parameter는 target의 대상 값 */
	let srcUL = $("#srcUL").generateFileList().on("click","li",function(event){
		$(this).siblings("li").removeClass("active");
		$(this).addClass("active");
	});
// 	이런 형식은 동작하지 않아요 피하세요
// 	$("#srcUL>li").on("click",function(){
// 		alert("2번 방식");
// 	})
	let destUL = $("#destUL").generateFileList();
	let srcULL = $("#srcUL").generateFileList();
	let command = $('input[name="command"]').val();
	console.log(command)
	$(document).on("click", "#controlBtn", function(){
		let fileName = srcUL.find("li.active").text();
		if(!fileName) return false;
		
		let srcFile = srcUL.data("target") + "/" + fileName;
		let data = {
				srcFile: srcFile
				,destFolder: destUL.data("target")
				,command:command
			};
		$.post("<%=request.getContextPath()%>/browsing/fileManager", data, function(resp){
			if(resp.result){
				destUL.generateFileList()
				srcULL.generateFileList();
			}
			else {
				alert("파일 관리 실패");
			}
		}, "json");
	});
</script>
<jsp:include page="/includee/postScript.jsp" />
</body>
</html>


<!-- 1. li에서 선택 후 - resources 아래에 있는 이미지 대상 -->
<!-- 2. button을 누르면 복사가 되게끔 -->
<!-- 3. 위치는 destImgs -->
<!-- 4. 이 모든 걸 비동기처리로 완성해보자 -->

<!-- 1. 두개에 들어있는 li를 만들어내기 위한 비동기처리구조 -->
<!-- 2. 버튼을 클릭하더라도 page가 refresh되지 않으면서 복사가 되어야함 -> 마찬가지로 비동기 -->

