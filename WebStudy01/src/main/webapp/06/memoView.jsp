<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
</head>
<body>
<h4>Restful 기반의 메모 관리</h4> <!-- restful : 메소드가 제 역할을 하도록 하자^^! -->
<form action="${pageContext.request.contextPath}/memo" method="post">
	<input type="text" name="writer" placeholder="작성자" />
	<input type="date" name="date" placeholder="작성일" />
	<textarea name="content"></textarea>
	<input type="submit" value="등록" />
</form>
<table class="table-bordered">
	<thead>
		<tr>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody id="listBody">
	</tbody>
</table>
<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">메모</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      zzz
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-primary">저장</button>
	      </div>
	    </div>
	  </div>
	</div>
<script type="text/javascript">
// 	EDD(Event Driven Development), TDD(Test Driven Development)
	$("#exampleModal").on("show.bs.modal", function(event){
// 		this==event.target : modal 창
		let memo = $(event.relatedTarget).data("memo"); // modal을 오픈할 때 사용한 클릭 대상, tr
		console.log(memo)
		$(this).find(".modal-body").html(memo.content)
		$(this).find(".modal-title").html(memo.code)
	}).on("hidden.bs.modal", function(event){
		$(event.target).find(".modal-body").empty();
	});
	
	let listBody = $("#listBody");
	
	let makeListBody = function(memoList){
		listBody.empty();
		let trTags = [];
		if(makeListBody.length>0){
			$.each(memoList, function(index, memo){
				let tr = $("<tr>").append(
							$("<td>").html(memo.writer)		
							,$("<td>").html(this.date)
				).attr({
					"data-bs-toggle":"modal"
					,"data-bs-target":"#exampleModal"
				}).data("memo", memo);
				trTags.push(tr);
			});
			
		} else {
			let tr = $("<tr>").html(
					 $("<td>")
						.attr("colspan", "2")
						.html("작성된 메모가 없습니다.")
			);
			trTags.push(tr);
		}
		listBody.append(trTags);
	}
	let makeTrTag = function(name, value){
		let tr = $("<tr>").append(
				 $("<td>").html(name)		
				,$("<td>").html(value)		
		);
		return tr;
	}
	
	$.ajax({
		url : "${pageContext.request.contextPath}/memo",
		method : "get",
		dataType : "json",
		success : function(resp) {
			makeListBody(resp.memoList);
		},
		error : function(jqXHR, status, error) {
			console.log(jqXHR);
			console.log(status);
			console.log(error);
		}
	})
	
	// insert
	$("form").on("submit", function(event){
		event.preventDefault();
		console.log($(this));
		let method = this.method;
		let data = $(this).serialize();
		
		console.log("method",method,"///data",data);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/memo",
			method : "post",
			data : data,
			dataType : "json",
			success : function(resp) {
				makeListBody(resp.memoList);
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
	});
	
	
</script>
<jsp:include page="/includee/postScript.jsp" />
</body>
</html>