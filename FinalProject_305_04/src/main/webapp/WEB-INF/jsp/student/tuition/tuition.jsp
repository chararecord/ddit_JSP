<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			등록금 고지서 확인 및 내역 (학생)
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

			
	<div class="white-box">
		<button type="button" class="btn purple">등록금 고지서</button>
	</div>

	<!--tbl-->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>등록금 납부 내역</caption>
					<colgroup>
						<col style="width: 5%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 20%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">No</th>
							<th scope="col">연도</th>
							<th scope="col">학기</th>
							<th scope="col">등록금</th>
							<th scope="col">장학금</th>
							<th scope="col">실납부액</th>
							<th scope="col">납부여부</th>
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
<!-- 	여기 버튼 들어가는거 맞나,,?									 -->
											<td>
												<div class="white-box">
												<!-- 	조건문 써서 미납이면 "등록금고지서", 기납이면 "등록금 확인서" 띄워주기 현주야 제발 해 나중에 -->
													<button type="button" class="btn purple">미납이니까 돈내</button>
													<button type="button" class="btn purple">기납이니까 등록금 확인서 보여줘</button>
												</div>
											</td>
<!-- 	여기 버튼 들어가는거 맞을까.. 맞나..? 맞나..? 몰라 흑흑									 -->									
											
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
								
									<td colspan="7">조건에 맞는 게시글이 없습니다.</td>
								</c:otherwise>
							</c:choose>
<!-- !!!!	바꿨니..?  !!!! -->



						
						</tr>
					</tbody>

				</table>
			</div>
			<!--end tbl-->


			<!-- 페이지 네비게이션 -->
			<div class="pagination_block">
				<ul class="pagination">
					<li class="page-item"><a class="page-link"
						href="javascript:void(0);" aria-label="처음"> <span
							aria-hidden="true">«</span><span class="sr-only">처음</span>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="javascript:void(0);" title="1 페이지로 이동">1</a></li>
					<li class="page-item"><a class="page-link"
						href="javascript:void(0);" title="2 페이지로 이동">2</a></li>
					<li class="page-item"><a class="page-link"
						href="javascript:void(0);" title="3 페이지로 이동">3</a></li>
					<li class="page-item active"><a class="page-link" href="#"
						title="현재 페이지">4</a></li>
					<li class="page-item"><a class="page-link"
						href="javascript:void(0);" title="5 페이지로 이동">5</a></li>
					<li class="page-item"><a class="page-link"
						href="javascript:void(0);" aria-label="다음"> <span
							aria-hidden="true">&gt;</span><span class="sr-only">다음</span></a></li>
					<li class="page-item"><a class="page-link"
						href="javascript:void(0);" aria-label="마지막"> <span
							aria-hidden="true">»</span><span class="sr-only">마지막</span></a></li>
				</ul>
			</div>
			<!-- //페이지 네비게이션 -->

		</div>
	</div>