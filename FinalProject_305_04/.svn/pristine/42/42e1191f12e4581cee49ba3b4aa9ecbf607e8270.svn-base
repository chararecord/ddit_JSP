<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			학생정보관리
			<button type="button" class="star on">
			<span class="sr-only">즐겨찾기</span>
			</button>
		</h2>
		<!--cont-navi-->
		<div class="cont-navi">
			<span>home</span> <i class="bi bi-house-door-fill"></i><strong>학생관리</strong>
		</div>
		<!--end cont-navi-->
	</div>
	<!-- end cont-title -->

	<div class="white-box">
			
		<div class="cont-box-inner">
			<div class="title">
				<h3>Title</h3>
				<span class="total"><em>1</em>건</span>
				<div class="box-btn">
					<button type="button" class="btn default">수정</button>
					<button type="button" class="btn default">삭제</button>
					<button type="button" class="btn purple">등록</button>
				</div>
			</div>
			<!--tbl-->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>description about table</caption>
					<colgroup>
						<col style="width: 5%">
						<col style="width: 5%">
						<col style="width: 5%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 10%">
						<col style="width: 10%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">버튼</th>
							<th scope="col">글번호</th>
							<th scope="col">학년</th>
							<th scope="col">학번</th>
							<th scope="col">이름</th>
							<th scope="col">학적</th>
							<th scope="col">단과명</th>
							<th scope="col">학과명</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:set var="studentInfoList" value="${pagingVO.dataList }" />
							<c:choose>
								<c:when test="${not empty studentInfoList }">
									<c:forEach items="${studentInfoList }" var="studentInfo">
										<tr>
											<td>
												<!-- 체크박스 -->
												<div class="rc-wrap">
													<input type="checkbox" id="checkbox5" name="radio-group">
													<label for="checkbox5"><span class="sr-only">선택</span></label>
												</div>
											</td>
											<td>${studentInfo.rnum }</td>
											<td>${studentInfo.camYear }</td>
											<td>${studentInfo.stdId }</td>
											<td>${studentInfo.userNm }</td>
											<td>${studentInfo.recNm }</td>
											<td>${studentInfo.collNm }</td>
											<td>${studentInfo.majorId }</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<td colspan="5">조건에 맞는 게시글이 없습니다.</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</tbody>
				</table>
			</div>
			<!--end tbl-->
			
					
			<!-- 페이지 네비게이션 -->
			<div class="pagination_block">
				<ul class="pagination">
				    <li class="page-item">
				        <a class="page-link" href="javascript:void(0);" aria-label="처음">
				        <span aria-hidden="true">«</span><span class="sr-only">처음</span>
				        </a>
				    </li>
				    <li class="page-item">
				        <a class="page-link" href="javascript:void(0);" title="1 페이지로 이동">1</a>
				     </li>
				     <li class="page-item"><a class="page-link" href="javascript:void(0);" title="2 페이지로 이동">2</a></li>
				     <li class="page-item"><a class="page-link" href="javascript:void(0);" title="3 페이지로 이동">3</a></li>
				     <li class="page-item active"><a class="page-link" href="#" title="현재 페이지">4</a></li>
				     <li class="page-item"><a class="page-link" href="javascript:void(0);" title="5 페이지로 이동">5</a></li>
				      <li class="page-item"><a class="page-link" href="javascript:void(0);" aria-label="다음">
				            <span aria-hidden="true">&gt;</span><span class="sr-only">다음</span></a>
				      </li>
				     <li class="page-item">
				        <a class="page-link" href="javascript:void(0);" aria-label="마지막">
				         <span aria-hidden="true">»</span><span class="sr-only">마지막</span></a>
				     </li>
				</ul>	
			</div>
			<!-- //페이지 네비게이션 -->
						
						
							
							
			</div>
			
	</div>
</div>
	
