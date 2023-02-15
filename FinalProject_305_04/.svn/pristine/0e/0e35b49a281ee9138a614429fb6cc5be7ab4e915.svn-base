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
			<strong class="tit">과제 안내 사항 </strong>
			<p>1. 과제에 대한 <span class="red-txt">제출마감 기간</span>을 잘 확인하여 불이익이 없도록 합니다. </p>
			<p>2. 담당교수 채줌 후 과제에 대한 점수를 확인할 수 있습니다.  </p>
		</div>
		
			

		<div class="right-part">
			<div class="title">
				<p class="highlight-txt">총<em class="red-txt">d</em>건의 게시물이 있습니다</p>
				<div class="right-part">
					<div class="search-form">
	
						<%-- 	<select>
								<option value>전체</option>
								<form:option value="tit" label="제목" />
								<form:option value="cont" label="내용" />
							</form>
							<div class="input-group">
								<form:input path="searchWord"/>
								<input id="searchBtn" class="btn btn-search primary" type="button" value="검색" />
							</div> --%>
							<div class="box-btn">
								<button type="button" class="insertBtn btn purple">등록</button>
							</div>
				
					</div>
				</div>
			</div>
		</div>
	
		
		
			<!--tbl start-->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>과제 페이지 목록 테이블</caption>
					<colgroup>
						<col style="width: 150px" />
						<col style="width: auto;" />
						<col style="width: 250px" />
						<col style="width: 250px" />
						<col style="width: 250px" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">No</th>		
							<th scope="col">과제제목</th>
							<th scope="col">과제 등록일</th>
							<th scope="col">과제 마감일</th>
							<th scope="col">제출여부</th>
						</tr>
					</thead>
					<tbody>

						<c:set var="assignList" value="${currLectVO.assignmentList }" />
							 <%-- ${assignList }  --%>
							<c:choose>
								<c:when test="${not empty assignList }">
									<c:forEach items="${assignList }" var="assignment">
										<tr>	
											<td>${assignment.rnum}</td> 
											<td><a href="${pageContext.request.contextPath}/student/assignment/assignmentView?asgnId=${assignment.asgnId}">${assignment.assignNm}</a></td> 
											<td>${assignment.assignRdate}</td> 
											<td>${assignment.assignDdate}</td> 
										</tr>
									</c:forEach>
								</c:when>
							</c:choose> 
						
					</tbody>
				</table>
			</div>
			<!--tbl end-->

		</div>
		<!-- end cont-box-inner -->

			
			
	</div>
</div>



