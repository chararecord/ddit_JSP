<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>





<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			시험
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
			
			
			<div class="tob-box">
				<strong class="tit">시험 응시자 안내 사항 </strong>
				<p>시험은 수업 담당교수님이 직접 출제합니다.</p>
				<p>수강생들은 시험 시작시간과 종료시간을 엄수하여주시길 바랍니다. </p>
				<br>
				<p>(1) 시험은 한 문제당 5점씩 채점되며, 제출을 완료하면 자동 채점됩니다. 총점은 백분율로 계산하여 보여집니다.</p>
				<p>(2) 한 시험당 문항은 최대 10개로 제한되어 있습니다.</p>
				<p>(3) 풀지 않은 문항이 있을 경우 시험 제출 할 수 없습니다. 응시자는 이를 확인하여 모든 답을 체크할 수 있도록 해야합니다.</p>
				<p>(4) 응시 한 후 제출한 퀴즈의 답을 확인할 수 있습니다.</p>
				<br>
				<strong class="red-txt">제출 마감시간이 되면 문제 풀이 유무와 상관없이 제출되며, 풀지 않은 문항은 자동으로 0점 처리됩니다. </strong>
			</div>



			
			
	
				<div class="title">
					<p class="highlight-txt">총<em class="red-txt">26</em>건의 게시물이 있습니다</p>
					<div class="right-part">
						<div class="search-form">
							<select>
								<option>전체</option>
								<option>전체</option>
								<option>전체</option>
							</select>
							<div class="input-group">
								<label for="searchTxt" class="sr-only">검색어를 입력하세요</label>
								<input type="text" class="form-control text input with dropdown button" id="searchTxt" name="searchTxt" value="" placeholder="검색어를 입력하세요.">
								<button class="btn btn-search primary" type="button">검색</button>
							</div>
						</div>
						<div class="box-btn">
								<button type="button" class="btn purple">등록</button>
						</div>
					</div>
				</div>
				
				

				<!--tbl-->
				<div class="tbl-wrap">
					<table class="tbl center">
						<caption>학생시험목록테이블</caption>
						<colgroup>
							<col style="width: 10%">
							<col style="width: 20%">
							<col style="width: 10%">
							<col style="width: 20%">
							<col style="width: 20%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">No</th>
								<th scope="col">강의명</th>
								<th scope="col">시험제목</th>
								<th scope="col">시험 시작</th>
								<th scope="col">시험 종료</th>
								<th scope="col">등록일</th>
								<th scope="col">완료여부</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							
								<c:set var="testList" value="${pagingVO.dataList }" />
								<c:choose>
									<c:when test="${not empty testList }">
										<c:forEach items="${testList }" var="test"> 
											<!-- <br><br><br><br><br> -->
											<%-- ${testList } --%>
											
											<!--
												<c:set var="noticeList" value="${pagingVO.dataList }" />
												1) value="${pagingVO.dataList}" => pagingVO속에 있는 dataList 가져와서 noticeList로 넣어놓기 
												2) value="${pagingVO}" => 컨트롤러단에 있는 model.addAttribute("pagingVO", pagingVO); 에서 "pagingVO"  들고온거임 
											-->
										   <form action="<c:url value='/student/test/testAllow'/>" id="testAllowForm" name="testAllowForm">
												<input type="hidden" name=testAllowId value="${test.testAllow.testAllowId }" />
												<input type="hidden" name="curlectId" value="${test.testAllow.curlectId }" />
												<input type="hidden" name="testId" value="${test.testId}" />
												<input type="hidden" name="examId" value="${test.examId }" />
												<input type="hidden" name="lectId" value="${test.lectId }" />
											</form> 
											
											
											<tr>
												<%--<td>${test["testAllow"][0]["curlectId"]}</td> --%>
												<%-- <td>${test.testAllow[0].curlectId}</td> --%>
												<td>${test.rnum }</td>
												<td>${test.lectNm}</td>
												<td>
												 	<%-- <c:url value="/student/test/testView" var="viewURL">
														<c:param name="testId" value="${test.testId}"></c:param>
														<c:param name="curlectId" value="${test.testAllow.curlectId}"></c:param>
														<c:param name="testAllowId" value="${test.testAllow.testAllowId}"></c:param>
													</c:url>  
													<a class="insertLink" href="${viewURL}">${test.testNm}</a> 
													 --%>
													<a class="insertLink" data-test-id="${test.testId}" href="javascript:void(0);">${test.testNm}</a> 
												</td>
												<td>${test.testStime }</td>
												<td>${test.testEtime }</td>
												<td>${test.testRdate }</td>
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
</div>





<script type="text/javascript">
$(".insertLink").on("click",function(event){
	
	//data-test-id="FG10002"
	let testIdData = $(this).data("testId");
	console.log("testIdData : " + testIdData);
	
	//<input type="text" name="testId"> name 값으로 찾기  
	$("input[name='testId']").val(testIdData);

	
	event.preventDefault();
	
	// 시험명 클릭시 
	// 시험명 클릭시 시험에 응시하시겠습니까? 팝업창 =>
	// testAllow 컨트롤러로 이동 =>  insert쿼리문 실행 (넘어간 데이터들은 자동으로 allow컨트롤러에 등록됨)
	// testAllow에서 testView컨트롤러로 redirect => testView로 데이터를 가지고 이동됨 
	// testView컨트롤러로 이동할때 testAllow가 가지고있는 파라미터 같이 옮겨주기  => RedirectAttributes redirect
	if(confirm("시험에 응시하시겠습니까?")){
		 $("#testAllowForm").submit();
	} 

  
	
});	
</script>






