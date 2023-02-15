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
			강의게시판 등록
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
		<form:form id="lectBoardForm" modelAttribute="lectBoard" enctype="multipart/form-data" method="post">
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
								<form:input path="tit" type="text" cssClass="w100 display-tblCell" placeholder="제목을 입력해주세요." />
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
								<form:textarea id="cont" path="cont" type="text" cssClass="col display-tblCell" />
							</td>
						</tr>
						<tr>
							<th scope="row">첨부파일</th>
							<td>
								<input type="file" name="files" multiple="multiple" value="" />
							</td>
						</tr>
					</tbody>
				</table>
				<div class="title">
					<div class="box-btn">
						<form:button id="regBtn" type="submit" class="btn purple">등록</form:button>
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
</script>
