
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			학생 목록(교수)
			<button type="button" class="star">
				<span class="sr-only">즐겨찾기</span>
			</button>
		</h2>
		<!--cont-navi-->
		<div class="cont-navi">
			<span>home</span> <i class="bi bi-house-door-fill"></i> <strong>path1</strong>
			<strong>path2</strong> <strong>path3</strong> <strong>path4</strong>
		</div>
		<!--end cont-navi-->
	</div>
	<!-- end cont-title -->

	<div class="white-box">
		<div class="cont-box-inner">

			<!-- 		scroll bar	 -->
			<div class="title">
	<h3>${lectureVO.semeVO.semeYear }년도 ${lectureVO.semeVO.seme }학기 ${lectureVO.lectNm}</h3>
<%-- 	${lectureVO.myStudentList} --%>
			</div>
			<div class="table-scrollable">
				<div class="table-responsive">

					<table class="tbl">
						<colgroup>
<%-- 							<col style="width: 20%"> --%>
							<col style="width: 20%">
							<col style="width: 15%">
							<col style="width: 10%">
							<col style="width: 10%">
							<col style="width: auto">
						</colgroup>

						<thead class="">
							<tr class="table-scrollable__fixed-y">
								<th>단과대학</th>
								<th>학과</th>
								<th>학년</th>  
								<th>학번</th> 
								<th>이름</th>  
								<th>출결 관리</th><!--버튼으로 만들기  -->
							</tr>
						</thead>


						<tbody>
							<tr>
<%-- 							console.log(${ lectureVO}); --%>
								<c:set var="myStudentList" value="${lectureVO.myStudentList}" />
								<c:choose>
									<c:when test="${not empty myStudentList }">
										<c:forEach items="${myStudentList }" var="myStudentVO" >
											<tr>
												<td>${myStudentVO.collVO.collNm }</td>
												<td>${myStudentVO.majorVO.majorNm }</td>
												<td>${myStudentVO.camYear }</td>
												<td>${myStudentVO.stdId }</td>
												<td>${myStudentVO.userNm }</td>
												<td>
													<button type="button" class="btn btn-s purple" 
													onclick="location.href='${pageContext.request.contextPath}/prof/lectroom/profAttendManage?stdId=${myStudentVO.stdId}&lectId=${lectureVO.lectId}'">
													관리하기</button>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td colspan="5">강의가 없습니다.</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>