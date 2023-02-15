<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
${studentInfo }
<hr>
${studentInfo.usrVO }
<hr>
${studentInfo.recordList }

<c:set var="stdInfo" value="${studentInfo }"/>
<c:set var="usrInfo" value="${studentInfo.usrVO }"/>
<c:set var="recordList" value="${studentInfo.recordList }" />


<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>학적 정보 조회<button type="button" class="star"><span class="sr-only">즐겨찾기</span></button></h2>
		<!--cont-navi -->
		<div class="cont-navi">
			<span>home</span> <i class="bi bi-house-door-fill"></i>
			<strong>path1</strong> 
			<strong>path2</strong> 
			<strong>path3</strong>
			<strong>path4</strong>
		</div>
		<!--end cont-navi -->
	</div>
	<!-- end cont-title -->

	<div class="white-box">
		

		
		<!-- cont-box-inner -->
		<div class="cont-box-inner">

			<div class="title">
				<h3>현재 학적 조회</h3>
			</div>

			

			<!--  "photo-wrap" -->
			<div class="photo-wrap">
				<div class="photo">
					<img src="/resources/images/star.png" alt="프로필사진" />
				</div>

				<div class="tbl-wrap">
					<table class="tbl">
						<caption></caption>
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 20%;">
							<col style="width: 10%;">
							<col style="width: 20%;">
							<col style="width: 10%;">
							<col style="width: 20%;">
						</colgroup>
						<tbody>
							<c:choose>
							<c:when test="${not empty stdInfo }">
							<tr>
								<th scope="row">학번</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell">${stdInfo.stdId }</div>
									</div>
								</td>
								<th scope="row">이름</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell">${usrInfo.userNm }</div>
									</div>
								</td>
								<th scope="row">이름(영문)</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell">${usrInfo.userNmEn }</div>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">입학구분</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell">신${recordList[0].recNm }</div>
									</div>
								</td>
								<th scope="row">학과전공</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell">${stdInfo.majorVO.majorNm }</div>
									</div>
								</td>
								<th scope="row">재적학년도</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell"></div>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">최종변동코드</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell">${recordList[0].recNm }</div>
									</div>
								</td>
								<th scope="row">최종변동일자</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell">${recordList[0].recUpdate }</div>
									</div>
								</td>
								<th scope="row">등록상태</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell"></div>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">재학여부</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell"></div>
									</div>
								</td>
								<th scope="row">졸업대상/예정구분</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell"></div>
									</div>
								</td>
								<th scope="row">일반휴학횟수</th>
								<td>
									<div class="display-tbl">
										<div class="display-tblCell"></div>
									</div>
								</td>
							</tr>
							</c:when>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
			<!--   // "photo-wrap" -->

		</div>
		<!--  // cont-box-inner -->
		
		
		
		<!-- cont-box-inner -->
		<div class="cont-box-inner">
			<div class="title">
				<h3>학적 변동 내역</h3>
				<span class="total"><em>${recordList[0].rnum }</em>건</span>
			</div>
			<!--tbl -->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>description about table</caption>
					<colgroup>
						<col style="width: 5%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 20%" />
						<col style="width: 15%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">학년도</th>
							<th scope="col">학기</th>
							<th scope="col">학적변동구분</th>
							<th scope="col">변동일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${recordList }" var="record">
							<tr>
								<td>${record.rnum }</td>
								<td>${record.semester.semeYear }</td>
								<td>${record.semester.seme }</td>
								<td>${record.recNm }</td>
								<td>${record.recUpdate }</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
			<!--end tbl -->


			<!-- 페이지 네비게이션 -->
<!-- 			<div class="pagination_block"> -->
<!-- 				<ul class='pagination'> -->
<!-- 					<li class='page-item'><a class='page-link' -->
<!-- 						href="javascript:void(0);" aria-label='처음'> <span -->
<!-- 							aria-hidden='true'>&laquo;</span><span class='sr-only'>처음</span> -->
<!-- 					</a></li> -->
<!-- 					<li class='page-item'><a class='page-link' -->
<!-- 						href="javascript:void(0);" title='1 페이지로 이동'>1</a></li> -->
<!-- 					<li class='page-item'><a class='page-link' -->
<!-- 						href="javascript:void(0);" title='2 페이지로 이동'>2</a></li> -->
<!-- 					<li class='page-item'><a class='page-link' -->
<!-- 						href="javascript:void(0);" title='3 페이지로 이동'>3</a></li> -->
<!-- 					<li class='page-item active'><a class='page-link' href='#' -->
<!-- 						title='현재 페이지'>4</a></li> -->
<!-- 					<li class='page-item'><a class='page-link' -->
<!-- 						href="javascript:void(0);" title='5 페이지로 이동'>5</a></li> -->
<!-- 					<li class='page-item'><a class='page-link' -->
<!-- 						href="javascript:void(0);" aria-label='다음'> <span -->
<!-- 							aria-hidden='true'>&gt;</span><span class='sr-only'>다음</span></a></li> -->
<!-- 					<li class='page-item'><a class='page-link' -->
<!-- 						href="javascript:void(0);" aria-label='마지막'> <span -->
<!-- 							aria-hidden='true'>&raquo;</span><span class='sr-only'>마지막</span></a> -->
<!-- 					</li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
			<!-- //페이지 네비게이션 -->




		</div>
		<!-- end cont-box-inner -->
	
		
		
		
		
	</div>

</div>

