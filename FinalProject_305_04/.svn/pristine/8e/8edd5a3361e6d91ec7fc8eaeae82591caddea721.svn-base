<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>장학금 수여(교직원)<button type="button" class="star"><span class="sr-only">즐겨찾기</span></button></h2>
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

			<div class="tob-box">
				<strong class="tit">장학금 수혜 </strong>
			
				<p>
					수석 장학금 : 성적 기준(직전 학기) 학년별 석차 1등 <br> 장학금 2,000,000원 지급<br>
					우수 장학금 : 성적 기준(직전 학기) 학년별 석차 2등<br> 장학금 1,500,000원 지급<br>
					격려 장학금 : 성적 기준(직전 학기) 학년별 석차 3등<br> 장학금 1,000,000원 지급<br>
				</p>
			</div>
		
<!-- 		scroll bar	 -->
<div class="table-scrollable">
				<div class="table-responsive">
				
					<table class="tbl">
						<colgroup>
						<col style="width: 5%">
						<col style="width: 15%">
						<col style="width: 20%">
						<col style="width: 15%">
						<col style="width: 5%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 5%">
						<col style="width: 20%">
					</colgroup>
					
						<thead class="">
							<tr class="table-scrollable__fixed-y">
								<th>No</th>
								<th>단과대학</th>
								<th>학과</th>
								<th>학번</th>
								<th>학년</th>
								<th>이름</th>
								<th>학점</th>
								<th>석차</th>
								<th>장학금액(원)</th>
							</tr>
						</thead>
						
							<tbody>
						<tr>
						
						
<!-- !!!!	안에 컬럼명 바꾸셈 바꾸쎔 바꾸쎔 바꾸셈 일단 틀만 만든거임  !!!! -->
							<c:set var="scholarshipList" value="${pagingVO.dataList }" />
							<c:choose>
								<c:when test="${not empty scholarshipList }">
									<c:forEach items="${scholarshipList }" var="scholarship">
										<tr>
											<td>${scholarship.rnum }</td>
											<td>학사연도 불러오기</td>
											<td>학기 불러오기</td>
											<td><a href="#">${scholarship.schsNm }</a></td>
											<td>${scholarship.schsAmount }</td>
											<td>최종성적 불러오기</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<td colspan="9">조건에 맞는 게시글이 없습니다.</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</tbody>
				</table>
				</div>
			</div>
<!-- !!!!	바꿨니???????  !!!! -->


	<div class="white-box">
			<button type="button" class="btn purple">수여하기</button>
	
	
	
	
	
	
	</div>