<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="cont">
	<!-- cont-title -->
	<div class="cont-title">
		<h2>	강의 계획서 관리<button type="button" class="star"><span class="sr-only">즐겨찾기</span></button></h2>
		<!--cont-navi-->
		<div class="cont-navi">
			<span>home</span> <i class="bi bi-house-door-fill"></i>
			<strong>path1</strong> 
			<strong>path2</strong> 
			<strong>path3</strong>
			<strong>path4</strong>
		</div>
		<!--end cont-navi-->
	</div>
	<!-- end cont-title -->

	<div class="white-box">
		<div class="cont-box-inner">
			<div class="title">
				<h3>강의 계획서 조회</h3>
				<div class="box-btn">
				<select id="select2">
					<option>전체</option>
					<option>2022/1학기</option>
					<option>2022/2학기</option>
				</select>
					<button type="button" class="btn purple">신규 강의계획서 등록</button>
				</div>
			</div>

			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>description about table</caption>
					<colgroup>
						<col style="width: 10%">
						<col style="width: 5%">
						<col style="width: 10%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 20%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">학사연도</th>
							<th scope="col">학기</th>
							<th scope="col">대상학년</th>
							<th scope="col">강의명</th>
							<th scope="col">희망수강인원</th>
							<th scope="col">이수구분</th>
							<th scope="col">학점</th>
							<th scope="col">강의시간</th>
							<th scope="col">건물</th>
							<th scope="col">강의실</th>
							<th scope="col">대면여부</th>
							<th scope="col">승인상태</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:set var="syllaList" value="${syllabusVO }" />
						<c:choose>
							<c:when test="${not empty syllaList }">
							<c:forEach items="${syllaList }" var="sylla">
								<td>${sylla.semeYear }</td>
								<td>${sylla.semester }</td>
								<td>${sylla.camYear }</td>
								<td>${sylla.lectNm }</td>
								<td>${sylla.hopeMax }</td>
								<td>${sylla.commDesc }</td>
								<td>${sylla.credit }</td>
								<td>${sylla.hopeTime }</td>
								<td>${sylla.buildNm }</td>
								<td>${sylla.roomNum }</td>
								<td>${sylla.syllaMeet }</td>
								<td>${sylla.aprvState }</td>
							</c:forEach>
							</c:when>
							<c:otherwise>
								<td colspan="12">등록된 계획서가 없습니다.</td>
							</c:otherwise>
						</c:choose>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
