<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.ddit.or.kr/class305" prefix="ui" %>
<script src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor.js" ></script>

<div class="cont">
	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			강의게시판 수정
			<button type="button" class="star">
				<span class="sr-only">즐겨찾기</span>
			</button>
		</h2>
		<!--cont-navi-->
		<div class="cont-navi">
			<span>home</span>
			<i class="bi bi-house-door-fill" ></i>
			<strong><a>나의강의목록</a></strong>
			<strong>강의게시판</strong>
		</div>
		<!--end cont-navi-->
	</div>
	<!-- end cont-title -->
	<div class="white-box">
		<div class="tob-box">
			<strong class="tit">강의게시판 안내 사항 </strong>
			<p>게시판에 작성되는 본문 내용 및 첨부파일 내에 성명, 주민등록번호, 핸드폰 번호, 이메일 등 2개 이상의 개인정보 작성 시
			개인정보보호법 제2조제1호에 의거 개인정보에 해당되어 작성 및 등록을 제한하고 관리자에 의해 삭제 처리될 수 있습니다. 게시판 사용에 유의하시기 바랍니다.</p>
			<br>
			<p>※ 개인정보를 위조 또는 도용, 외부에 유출한 자는 관련법에 의거 법적 처벌을 받을 수 있으며,
			게시글에 포함된 개인정보 또한 책임은 게시자에게 있으며 정보 노출을 원하지 않으실 경우에는 수정 및 삭제하시기 바랍니다.</p>
			<strong class="red-txt">(개인정보보호법 제71조에 의거 개인정보를 유출한 자는 5년 이하의 징역 또는 5천만원 이하의 벌금이 부과될 수 있습니다.)</strong>
		</div>

		<!-- cont-box-inner -->
		<form:form id="updateForm" modelAttribute="lectBoard" enctype="multipart/form-data" method="post">
		<form:hidden path="lectBoardId" />
		<div class="cont-box-inner">
			<div class="tbl-wrap">
				<table class="tbl">
					<caption></caption>
					<colgroup>
						<col style="width: 150px;">
						<col style="width: auto;">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">제목</th>
							<td>
								<form:input path="tit" type="text" cssClass="w100 display-tblCell" value="${notice.tit }" />
							</td>
						</tr>
						<tr>
							<th scope="row">작성자</th>
							<td>
								<form:input path="lectId" type="text" cssClass="w100 display-tblCell" value="DI10001" readonly="true" />
							</td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td>
								<form:textarea path="cont" type="text" cssClass="col display-tblCell" />
							</td>
						</tr>
						<c:if test="${not empty lectBoard.attaFileList }">
						<tr id="trOldFile">
							<th>기존 파일</th>
							<td>
								<c:forEach items="${lectBoard.attaFileList }" var="attaFile">
									<span>
										${attaFile.attaFilenm }
										<input type="button" value="X" class="btn default btn-s btn-pd delBtn" data-atta-id="${attaFile.attaId}" data-atta-sn="${attaFile.attaSn }" />
									</span>
								</c:forEach>
							</td>		
						</tr>					
						</c:if>
						<tr id="trNewFile">
							<th scope="row">첨부파일</th>
							<td>
								<input type="file" name=files multiple="multiple" />
							</td>
						</tr>
					</tbody>
				</table>
				<div class="title">
					<div class="box-btn">
						<form:button type="submit" class="btn purple">등록</form:button>
					</div>
				</div>
			</div>
		</div>
		</form:form>
	<!-- end cont-box-inner -->
	</div>
</div>
<script>
CKEDITOR.replace('cont', {
	filebrowserUploadUrl: '${pageContext.request.contextPath}/imageUpload?command=QuickUpload&type=Files&responseType=json'
});

let updateForm = $("#updateForm");
// var $item = $('.delBtn').on('click', function(e){
// });
	
	
var selectedFile = $(".delBtn").on("click", function(event){
	let attaId = $(this).data("attaId");
	let attaSn = $(this).data("attaSn");
	
	console.log("attaId : " + attaId);
	console.log("attaSn : " + attaSn);
	
	let data = {
			"attaId":attaId
			, "attaSn":attaSn
	};
	
	var target = $(this).closest('span');
	if(confirm('첨부파일을 삭제하시겠습니까?')){
		var seq = selectedFile.index(this);
		var dataTransfer = new DataTransfer();
		console.log(seq + "||" + dataTransfer);
		var files = $('input[name=files]')[0].files;
		var fileArray = Array.from(files);
		console.log(files + "||" + fileArray);
		
		fileArray.splice(seq, 1);
		fileArray.forEach(file => { dataTransfer.items.add(file); });
		$('input[name=files]')[0].files = dataTransfer.files;
		target.remove();
	}
	
	//아작났어유..피씨다타써
	$.ajax({
		url:"${pageContext.request.contextPath}/prof/lectBoard/${lectBoard.lectId}/${lectBoard.lectBoardId}/DeleteFile",
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(data),
		dataType:"json",
		type:"post",
		success:function(result){
			console.log("result : " + JSON.stringify(result));
		}
	});
});
</script>
