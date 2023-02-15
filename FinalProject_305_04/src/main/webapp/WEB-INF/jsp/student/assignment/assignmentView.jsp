<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.ddit.or.kr/class305" prefix="ui" %>


<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>과제<button type="button" class="star"><span class="sr-only">즐겨찾기</span></button></h2>
		<!--cont-navi-->
		<div class="cont-navi">
			<span>home</span> <i class="bi bi-house-door-fill"></i> 
			<strong>과제</strong>
		</div>
		<!--end cont-navi-->
	</div>
	<!-- end cont-title -->

	<div class="white-box">
	
		<div class="tob-box">
			과제 제출 시 <span class="red-txt">마감일 이내에</span> 수정이 가능합니다. <br>
			<span class="red-txt">마감일 이후에는 제출 또는 수정 할 수 없으므로</span> 기한을 잘 확인하여 불이익 없도록 주의하시길 바랍니다. 
		</div>

			<div class="tbl-wrap">
				<table class="tbl">
					<caption></caption>
					<colgroup>
						<col style="width: 150px;">
						<col style="width: auto;">
					</colgroup>
					<tbody>
						<tr>
							<td class="title pur-txt center" colspan="2"><h3>${assignmentVO.assignNm }</h3></td>
						</tr>
						<tr>
							<th scope="row">과제내용</th>
							<td>${assignmentVO.assignCont }</td>
						</tr>
						<tr>
							<th scope="row">등록일</th>
							<td>${assignmentVO.assignRdate }</td>
						</tr>
						<tr>
							<th scope="row">마감일</th>
							<td>${assignmentVO.assignDdate }</td>
						</tr>
						<tr>
							<td class="pt20 pl20 pr20 pb20" colspan="2">${assignmentVO.assignCont }</td>
						</tr>
						
					</tbody>
				</table>
				<div class="title">
					<div class="box-btn">
						<button type="button" class="btn default" onclick="f_movelist()">목록</button>
						<form:form id="delForm" action="#" method="post">
							<input type="hidden" name="_method" value="delete" />
							<button type="button" class="btn red">삭제</button>
						</form:form> 
						<button type="button" class="btn purple" onclick="f_moveedit()">수정</button>
					</div>
				</div>

			</div>
	
			
			
	</div>
</div>



