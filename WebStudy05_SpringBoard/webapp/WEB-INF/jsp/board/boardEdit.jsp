<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor.js" ></script>
<form:form id="updateForm" modelAttribute="board" enctype="multipart/form-data" method="post">
<form:hidden path="boNo" />
<table>
	<tr>
		<th>게시글 제목</th>
		<td>
			<form:input path="boTitle" type="text" cssClass="form-control"  />
			<form:errors path="boTitle" element="span" cssClass="text-danger" />
		</td>
	</tr>
	<tr>
		<th>게시글 작성자</th>
		<td>
			<form:input path="boWriter" type="text" cssClass="form-control"  />
			<form:errors path="boWriter" element="span" cssClass="text-danger" />
		</td>
	</tr>
	<tr>
		<th>게시글 비밀번호</th>
		<td>
			<input type="password" name="boPass" class="form-control"/>
			<form:errors path="boPass" element="span" cssClass="text-danger" />
		</td>
	</tr>
	<tr>
		<th>게시글 IP</th>
		<td>
			<input name="boIp" type="text" readonly value="${pageContext.request.remoteAddr }"/>
			<form:errors path="boIp" element="span" cssClass="text-danger" />
		</td>
	</tr>
	<tr>
		<th>게시글 이메일</th>
		<td>
			<form:input path="boMail" type="email" cssClass="form-control" />
			<form:errors path="boMail" element="span" cssClass="text-danger" />
		</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
			<input type="file" name="boFiles" />
			<input type="file" name="boFiles" />
			<input type="file" name="boFiles" />
		</td>
	</tr>
	<c:if test="${not empty board.attatchList }">
		<tr>
			<th>기존 파일</th>
			<td>
				<c:forEach items="${board.attatchList }" var="attatch">
					<span>
						${attatch.attFilename }
						<input type="button" value="삭제" class="delBtn"
							data-att-no="${attatch.attNo }" />
					</span>
				</c:forEach>
			</td>
		</tr>
	</c:if>
	<tr>
		<th>게시글 내용</th>
		<td>
			<form:textarea path="boContent" type="text" cssClass="form-control" />
			<form:errors path="boContent" element="span" cssClass="text-danger" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<form:button type="submit" class="btn btn-success">저장</form:button>
			<a class="btn btn-secondary" href="<c:url value='/board/boardList.do'/>">목록으로</a>
		</td>
	</tr>
</table>
</form:form>
<script>
	CKEDITOR.replace('boContent', {
		filebrowserUploadUrl: '${pageContext.request.contextPath}/board/boardImage.do?command=QuickUpload&type=Files&responseType=json'
	});
	
	let updateForm = $("#updateForm");
	$(".delBtn").on("click", function(event){
		let attNo = $(this).data("attNo");
		let newInput = $("<input>").attr({
			type:"text"
			, name:"delAttNos"
		}).val(attNo);
		updateForm.append(newInput);
		let span = $(this).parents("span:first");
		span.hide();
	});
</script>