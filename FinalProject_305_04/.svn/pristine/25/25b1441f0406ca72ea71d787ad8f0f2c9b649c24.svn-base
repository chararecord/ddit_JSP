<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>

$(function(){
	
	// 신규 강의계획서 등록버튼
	$('#newSyllaBtn').on('click', function(){
		$.ajax({
			method : "get",
			success : function(resp) {
				location.href="${pageContext.request.contextPath}/prof/lectSylla?profId=3120001";
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
	})
	// 신규 강의계획서 등록버튼 끝
	
	
	// 상세조회 버튼 클릭시 상세조회 모달
	$('.btn').on('click', function(event){
		event.preventDefault();
		let btnId = $(this).attr('id');
// 		console.log("클릭한 버튼 아이디: " + btnId);
		
		let data = {"syllaId":btnId}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/prof/detailSylla",
			method : "post",
			contentType:"application/json;charset=UTF-8",
			data : JSON.stringify(data),
			dataType : "json",
			success : function(resp) {
// 				alert("값 넘어옴 : " + JSON.stringify(resp));
				console.log("resp 나오나" + JSON.stringify(resp));
				$('.modal-body').html(
					`
						<div class="cont">
							<div class="white-box">
								<div class="tab-wrap">
								    <!-- tablist  -->
									<ul class="tabs tab-1dep" role="tablist">
										<li class="tabMenu on" data-tab="lectSyllaBasic"><a class="tabs" href="#" id="">기본사항 작성</a></li>
										<li class="tabMenu" data-tab="lectSyllaDetail"><a class="tabs" href="#" id="">세부사항 작성</a></li>
										<li class="tabMenu" data-tab="lectTime"><a class="tabs" href="#" id="">시간표 선택</a></li>
									</ul>
									<!--  // tablist  -->	
								</div>
								
								<form id="syllaForm">
								<div class="cont-box-inner">
									<div class="title">
										<h3>강의 기본사항</h3>
										<div class="box-btn">
											<input type="submit" class="btn purple" value="제출" />
										</div>
									</div>
							
								<!--tbl-->
								<div class="tbl-wrap">
									<div class="tbl-wrap">
										<table class="tbl">
											<caption></caption>
											<colgroup>
												<col style="width: 150px;">
												<col style="width: auto;">
												<col style="width: 150px;">
												<col style="width: auto;">
											</colgroup>
											<tbody>
												<tr>
													<th scope="row">학사년도/학기</th>
													<c:set var="semeList" value="${semesterVO }" />
													<td colspan="3">
														<select id="selSemeYear" name="semeId">
															<option>==학사년도/학기==</option>
															<c:choose>
															<c:when test="${not empty semeList }">
															<c:forEach items="${semeList }" var="semYear">
																<option value="${semYear.semeId }">${semYear.semeYear }년도 / ${semYear.seme }학기</option>
															</c:forEach>
															</c:when>
															</c:choose>
														</select>
													</td>
												</tr>
												<tr>
													<th scope="row">과목 목록</th>
													<td>
														<select id="selSubMajor" name="subMajorId">
															<option>==과목==</option>
															<c:set var="subMajorList" value="${subMajorVO }" />
															<c:choose>
															<c:when test="${not empty subMajorList }">
															<c:forEach items="${subMajorList }" var="subMajor">
																<option value="${subMajor.majorId }">${subMajor.subjectNm }</option>
															</c:forEach>
															</c:when>
															</c:choose>
														</select>
													</td>
													
													<th scope="row">이수구분</th>
													<td>
														<input type="text" name="commDesc" value="" readonly="readonly" />
													</td>
												</tr>
												<tr>
													<th scope="row">대상학년</th>
													<td>
														<select id="selCamYear" name="camYear">
															<option value="1">1학년</option>
															<option value="2">2학년</option>
															<option value="3">3학년</option>
															<option value="4">4학년</option>
														</select>
													</td>
													
													<th scope="row">학점</th>
													<td>
														<input type="text" name="lectHour" value="" readonly="readonly" />
													</td>
												</tr>
												<tr>
													<th scope="row">강의명</th>
													<td><input type="text" id="lectNm" name="lectNm" class="w50"></td>
													<th scope="row">대면여부</th>
													<td>
														<select id="selCredit" name="syllaMeet">
															<option value="ONLINE">대면</option>
															<option value="OFFLINE">비대면</option>
														</select>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<!--end tbl-->
								    
								<div class="title"><h3>세부사항 작성</h3></div>
								
								<!--tbl-->
								<div class="tbl-wrap">
									<div class="tbl-wrap">
										<table class="tbl">
											<caption></caption>
											<colgroup>
												<col style="width: 150px;">
												<col style="width: auto;">
												<col style="width: 150px;">
												<col style="width: auto;">
											</colgroup>
											<tbody>
												<tr>
													<th scope="row" colspan="2">수업개요</th>
													<td colspan="4"><input type="text" id="lectCom" name="lectCom" class="w100"></td>
												</tr>
												<tr>
													<th scope="row" colspan="2">교재</th>
													<td colspan="4"><input type="text" id="textbook" name="textbook" class="w100"></td>
												</tr>
												<tr>
													<th scope="row" colspan="2">최대정원</th>
													<td colspan="4"><input type="text" id="hopeMax" name="hopeMax" class="w50">명</td>
							
												</tr>
												<tr>
													<th scope="row" colspan="2">평가방법(%)</th>
													<td align="center">중간고사<br> <input type="text" id="midTest" name="midTest" class="w50">%</td>
													<td align="center">기말고사<br> <input type="text" id="finTest" name="finTest" class="w50">%</td>
													<td align="center">과제<br> <input type="text" id="assign" name="assign" class="w50">%</td>
													<td align="center">출결<br> <input type="text" id="attend" name="attend" class="w50">%</td>
												</tr>
												<tr>
													<th colspan="2">비고</th>
													<td colspan="4"><input type="text" id="note" name="note" class="w100"></td>
												</tr>
											</tbody>
										</table>
										<div class="scorePer"></div>
									</div>
								</div>
								<!--end tbl-->
								
								<div class="title"><h3>강의 계획</h3></div>
								<div class="tbl-wrap">
									<table class="tbl tbl-rowGrid">
										<caption></caption>
										<colgroup>
											<col style="width: 280px">
											<col>
										</colgroup>
										<tbody>
											<tr>
												<th scope="row">1주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week1" name="week1" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">2주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week2" name="week2" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">3주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week3" name="week3" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">4주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week4" name="week4" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">5주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week5" name="week5" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">6주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week6" name="week6" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">7주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week7" name="week7" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">8주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week8" name="week8" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">9주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week9" name="week9" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">10주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week10" name="week10" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">11주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week11" name="week11" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">12주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week12" name="week12" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">13주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week13" name="week13" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">14주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week14" name="week14" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">15주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week15" name="week15" class="w100">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">16주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
															<input type="text" id="week16" name="week16" class="w100">
														</div>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								
								
								<div class="title"><h3>시간표</h3></div>
								<c:set var="buildList" value="${buildingVO }" />
									<td>
									<select id="selBuild" name="selBuild">
										<option>==건물==</option>
									<c:choose>
										<c:when test="${not empty buildList }">
										<c:forEach items="${buildList }" var="build">
											<option value="${build.buildId }">${build.buildNm }</option>
										</c:forEach>
										</c:when>
										<c:otherwise>
											<option value>과목없음</option>
										</c:otherwise>
									</c:choose>
									</select>
									</td>
								
								<select id="selLectRoom" name="lectRoomId">
									<option>==강의실==</option>
								</select>
							</div>
								<input name="hopeTime" value="10:00~10:50" />
							</form>
							</div>
						</div>
				`		
				);
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
	});
	// 상세조회 버튼 클릭시 상세조회 모달 끝
	
	
});
</script>
<div class="cont">
	<!-- cont-title -->
	<div class="cont-title">
		<h2>	강의 계획서 결재<button type="button" class="star"><span class="sr-only">즐겨찾기</span></button></h2>
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
				<h3>강의 계획서 결재목록</h3>
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
							<th scope="col">상세조회</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="syllaList" value="${syllabusVO }" />
						<c:choose>
							<c:when test="${not empty syllaList }">
							<c:forEach items="${syllaList }" var="sylla" varStatus="status">
							<tr>
								<td>${sylla.semesterVO.semeYear }</td>
								<td>${sylla.semesterVO.seme }</td>
								<td>${sylla.camYear }</td>
								<td>${sylla.lectNm }</td>
								<td>${sylla.hopeMax }</td>
								<td>${sylla.commDesc }</td>
								<td>${sylla.subMajorVO.credit }</td>
								<td>${sylla.hopeTime }</td>
								<td>${sylla.buildingVO.buildNm }</td>
								<td>${sylla.lectRoomVO.roomNum }</td>
								<td>${sylla.syllaMeet }</td>
								<td>${sylla.syllaApprVO.aprvState }</td>
								<td><button type="button" class="btn btn-s purple" id="${sylla.syllaId}" data-bs-toggle="modal" data-bs-target="#exampleModal">상세조회</button></td>
							</tr>
							</c:forEach>
							</c:when>
							<c:otherwise>
								<td colspan="12">등록된 계획서가 없습니다.</td>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- 모달화면 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-xl">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		      
		      
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- 모달화면 끝  -->
		
	</div>
</div>

