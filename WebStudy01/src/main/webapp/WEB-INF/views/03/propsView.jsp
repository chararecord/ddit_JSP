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
<label>
	<input type="radio" name="dataType" value="json" checked />JSON
</label>
<label>
	<input type="radio" name="dataType" value="xml" />XML
</label>
<button type="button" class="loadData">LOAD DATA</button>
<button type="button" class="clearData">CLEAR DATA</button>
<table border="1">
	<thead>
		<tr>
			<th>key</th>
			<th>value</th>
		</tr>
	</thead>
	<tbody id="listBody">
	
	</tbody>
</table>
<script type="text/javascript">
	/* 셀렉팅은 미리 해두자 */
	let listBody = $("#listBody");
	let dataTypes = $("input[name=dataType]");
	let makeTrTag = function(name, value){
		let tr = $("<tr>").append(
				 $("<td>").html(name)		
				,$("<td>").html(value)		
		);
		return tr;
	}
	let sucesses = {
		json:function(resp){
			let trTags = [];
			$.each(resp.target, function(name, value) {
				console.log(name, value)
				trTags.push(makeTrTag(name,value));
			});
			listBody.empty(); // 자식들을 지우는 함수
			listBody.append(trTags);
		},
		xml:function(domResp){
			let root = $(domResp).find("target");
			console.log(root.children())
			let trTags = [];
			root.children().each(function(idx, child){
				let name = child.tagName;
				let value = child.innerHTML;
				let tr = makeTrTag(name,value);
				trTags.push(tr);
			});
			listBody.empty(); // 자식들을 지우는 함수
			listBody.append(trTags);
		}
	}
	let btn = $(".loadData").on("click",function(){
		let dataType = dataTypes.filter(":checked").val();
		$.ajax({
			/* url -> 이 요청이 servlet에게 넘어간다는 말씀! */
			/* 응답데이터와 관련된 설정들 */
			dataType : dataType,
			// [] 연상배열구조.. 이름이 아니라 값으로 바꿔주는!
			success : sucesses[dataType],
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
	});
	let clearBtn = $(".clearData").on("click",function(){
		listBody.empty();
	});
</script>
</body>
</html>