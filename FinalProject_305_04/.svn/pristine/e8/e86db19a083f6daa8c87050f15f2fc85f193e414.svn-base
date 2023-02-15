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
			공지사항 등록
			<button type="button" class="star">
				<span class="sr-only">즐겨찾기</span>
			</button>
		</h2>
		<!--cont-navi-->
		<div class="cont-navi">
			<span>home</span>
			<i class="bi bi-house-door-fill" ></i>
			<strong>공지사항</strong>
		</div>
		<!--end cont-navi-->
	</div>
	<!-- end cont-title -->

	<div class="white-box">


		<!-- cont-box-inner -->
		<form:form modelAttribute="notice" enctype="multipart/form-data" method="post">
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
								<form:input path="empId" type="text" cssClass="w100 display-tblCell" value="1010001" />
							</td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td>
								<form:textarea path="cont" type="text" cssClass="col display-tblCell" />
							</td>
						</tr>
						<tr>
							<th scope="row">첨부파일</th>
							<td>
								<input type="file" name=notiFiles multiple="multiple" />
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
let tit = $("input[name='tit']");
let empId = $("input[name='empId']");
let cont = $("input[name='cont']");
console.log("tit >>>>>>>>>>>> ", tit);
console.log("empId >>>>>>>>>>>> ", empId);
console.log("cont >>>>>>>>>>>> ", cont);
  $(function(){
    $('.datepicker').datepicker();
  })
  	CKEDITOR.replace('cont', {
		filebrowserUploadUrl: '${pageContext.request.contextPath}/board/boardImage.do?command=QuickUpload&type=Files&responseType=json'
	});
</script>
