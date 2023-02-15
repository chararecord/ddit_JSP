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
								
								<div class="cont-box-inner">
									<div class="title">
										<h3>강의 기본사항</h3>
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
													<td colspan="3">
														\${resp.syllabus.semesterVO.semeYear }년도 / \${resp.syllabus.semesterVO.seme } 학기 
													</td>
												</tr>
												<tr>
													<th scope="row">과목 목록</th>
													<td>
														과목
													</td>
													
													<th scope="row">이수구분</th>
													<td>
														이수구분
													</td>
												</tr>
												<tr>
													<th scope="row">대상학년</th>
													<td>
														\${resp.syllabus.camYear }학년
													</td>
													
													<th scope="row">학점</th>
													<td>
														학점
													</td>
												</tr>
												<tr>
													<th scope="row">강의명</th>
													<td>
														강의명
													</td>
													<th scope="row">대면여부</th>
													<td>
														\${resp.syllabus.syllaMeet }
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<!--end tbl-->
								    
								<div class="title"><h3>세부사항</h3></div>
								
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
													<td colspan="4">\${resp.syllabus.lectCom }</td>
												</tr>
												<tr>
													<th scope="row" colspan="2">교재</th>
													<td colspan="4">\${resp.syllabus.textbook }</td>
												</tr>
												<tr>
													<th scope="row" colspan="2">최대정원</th>
													<td colspan="4">\${resp.syllabus.hopeMax }명</td>
							
												</tr>
												<tr>
													<th scope="row" colspan="2">평가방법(%)</th>
													<td align="center">중간고사<br> %</td>
													<td align="center">기말고사<br> %</td>
													<td align="center">과제<br> %</td>
													<td align="center">출결<br> %</td>
												</tr>
												<tr>
													<th colspan="2">비고</th>
													<td colspan="4">\${resp.syllabus.note }</td>
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
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">2주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">3주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">4주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">5주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">6주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">7주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">8주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">9주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">10주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">11주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">12주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">13주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">14주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">15주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">16주차</th>
												<td>
													<div class="display-tbl">
														<div class="display-tblCell">
														</div>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								
								
								<div class="title"><h3>시간표</h3></div>
									<td>
										건물 / 강의실
									</td>
								
							</div>
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

