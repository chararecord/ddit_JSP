<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

${studentInfo }
<hr>
${studentInfo.usrVO }
<hr>
${studentInfo.recordList }
<!-- <hr> -->
<%-- ${collegeList } --%>
<hr>
${semesterVO }
<hr>
${nextSemesterVO }

<c:set var="stdInfo" value="${studentInfo }"/>
<c:set var="usrInfo" value="${studentInfo.usrVO }"/>
<c:set var="recordList" value="${studentInfo.recordList }" />

<div class="cont">

	<!-- cont-title -->
	<div class="cont-title" id="reqHistory">
		<h2>학적 변동 신청<button type="button" class="star"><span class="sr-only">즐겨찾기</span></button></h2>
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
	
		
		<!-- cont-box-inner -->
		<div class="cont-box-inner">
			<div class="title">
				<h3>학적 변동 신청 내역</h3>
					<span class="total"><em></em>건</span>
				<div class="box-btn">
					<button type="button" class="btn default">수정</button>
					<button type="button" class="btn default">삭제</button>
				</div>
			</div>
			<!--tbl-->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>description about table</caption>
					<colgroup>
						<col style="width: 5%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 10%" />
						<col style="width: 15%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">연도</th>
							<th scope="col">학기</th>
							<th scope="col">신청구분</th>
							<th scope="col">변동일자</th>
							<th scope="col">신청일자</th>
<!-- 							<th scope="col">종료일자</th> -->
							<th scope="col">상태</th>
							<th scope="col">참고사항</th>
						</tr>
					</thead>
					<tbody id="dispList">
						
						<c:choose>
							<c:when test="${not empty recordList }">
								<c:forEach items="${recordList }" var="record">
									<c:choose>
										<c:when test="${not empty record.recDate }">
										<tr>
											<td>${record.rnum }</td>
											<td>${record.semester.semeYear }
											<td>${record.semester.seme }</td>
											<td>${record.recNm }</td>
	<!-- 											<button type="button" class="btn btn-s primary">삭제</button> -->
	<!-- 											<button type="button" class="btn btn-s purple">수정</button> -->
											<td>${record.recUpdate }</td>
											<td>${record.recDate }</td>
<!-- 											<td></td> -->
											<td>${record.recStatus }</td>
											<td>${record.recReason }</td>
										</tr>
										</c:when>
										<c:otherwise>
											<tr>
<!-- 												<td colspan="8">신청 내역이 없습니다.</td> -->
											</tr>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:when>	
							<c:otherwise>
<!-- 								<tr> -->
<!-- 									<td colspan="8">신청 내역이 없습니다.</td> -->
<!-- 								</tr> -->
							</c:otherwise>
						</c:choose>
					</tbody>

				</table>
			</div>
			<!--end tbl-->


			<!-- tob-box -->
			<div class="tob-box">
				<strong class="tit">유의사항</strong>
				<p>(1) <strong class="red-txt">휴학 승인 후 휴학취소는 어떠한 사유로도 절대 불가하며, 학부는 휴학 신청 즉시 접수처리되므로 심사숙고하여 신청해야 합니다.</strong></p>
				<p>(2) 전과와 자퇴는 학적 변동 신청 후, 상담을 신청해야 합니다.</p>
			</div>
			<!-- // tob-box -->

		<!-- cont-box-inner -->
			<div class="cont-box-inner" id="inputInfo">
				<div class="title">
					<h3>학적 변동 신청</h3>
					<p class="highlight red-txt">
						<em class="red-txt">*</em>는 필수입력사항입니다.
					</p>
					<div class="box-btn">
						<button type="button" class="btn purple" id="submitBtn">등록</button>
					</div>
				</div>
				
		
<!-- 			<pre>현재일:		휴학최대학기 : 6		총 휴학학기 : </pre> -->

				<div class="tbl-wrap">
					<table class="tbl" id="dataTbl">
						<caption></caption>
						<colgroup>
							<col style="width: 150px;">
							<col style="width: auto;">
							<col style="width: 150px;">
							<col style="width: auto;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">성명</th>
									<td>${usrInfo.userNm }</td>
								<th scope="row">학과</th>
									<td>${stdInfo.majorVO.majorNm }</td>
							</tr>
							<tr>
								<th scope="row">변동구분<em class="red-txt asterisk">*</em></th>
								<td>
									<!-- SELECT --> <select id="selRecNm">
										<option>휴학</option>
<!-- 										<option>입대휴학</option> -->
										<option>복학</option>
										<!-- <option>복수전공</option> -->
										<option>전과</option>
										<option>자퇴</option>
									</select> <!-- // SELECT -->
								</td>
								<th scope="row">신청사유<em class="red-txt asterisk">*</em></th>
									<td><input id="recReason" class="w100" type="text"></td>
							</tr>

							<tr id="recLeave" class="added">
								<th scope="row">휴학신청학기</th>
								<td id="leaveTd" data-leave="${semesterVO.semeId }">${semesterVO.semeYear }년도 ${semesterVO.seme }학기</td>
								<th scope="row">복학예정학기</th>
								<td>${nextSemesterVO.semeYear }년도 ${nextSemesterVO.seme }학기</td>
							</tr>

							<c:set var="collegeList" value="${collegeList }"/>
							<tr id="recTrans" class="added">
								<th scope="row">단과대학<em class="red-txt">*</em></th>
								<td>
									<!-- SELECT --> <select id="selColl">
										<c:choose>
											<c:when test="${not empty collegeList }">
												<c:forEach items="${collegeList }" var="college">
													<option value="${college.collId }">${college.collNm }</option>
												</c:forEach>		
											</c:when>
											<c:otherwise>
												<option value>단과대학 없음</option>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
								<th scope="row">학과<em class="red-txt">*</em></th>
								<td>
									<!-- SELECT --> <select id="selMajor">
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!--// cont-box-inner -->


		</div>
		<!-- end cont-box-inner -->
		
	</div>
</div>


<h4>Hidden Form</h4>
<form id="hiddenForm" method="post">
	<input type="text" name="stdId" value="${stdInfo.stdId }" />
	<input type="text" name="recNm" />
	<input type="text" name="recReason" />
	<input type="text" name="semeId" />
</form>
	
<script>
	$('#recTrans').hide();
	
	$("#submitBtn").on("click", function(){
		$("[name=recNm]").val($("#selRecNm").val());
		$("[name=recReason]").val($("#recReason").val());
		$("[name=semeId]").val($('#leaveTd').data('leave'));
		console.log($('#leaveTd').data('leave'));
		let stdId = $('[name=stdId]').val();
		let recNm = $('[name=recNm]').val();
		let recReason = $("[name=recReason]").val();
		let semeId = $('[name=semeId]').val();
		if(confirm(recNm + "을 신청하시겠습니까?") == false) return; 
// 		alert(stdId);
// 		alert(recNm);
// 		alert(recReason);
		// alert(semeId);
		
		let hiddenForm = $("#hiddenForm").on("submit", function(event){
			event.preventDefault();
			
			let url = this.action;
			let method = this.method;
			let data = {
				stdId : stdId,
				recNm : recNm,
				recReason : recReason,
				semeId : semeId
			};
			
			$.ajax({
				url : url,
				method : method,
				data : JSON.stringify(data),
				contentType: "application/json;charset=UTF-8",
				dataType : "json",
				success : function(resp) {
					// console.log(resp);
					let records = resp.savedInfo.recordList;
					// console.log(records);
					// if(records) {
						$.each(resp.savedInfo.recordList, function(idx, obj){
							console.log(obj.rnum);
							$('<td>').html(obj.rnum);
							// $('#dispList').html('');
							// $('#dispList').empty();
							// $('#dispList').html(tdList);
						});
					// }

					// alert("신청이 완료되었습니다.");

// 					window.location.reload();
				},
				error : function(jqXHR, status, error) {
					console.log(jqXHR);
					console.log(status);
					console.log(error);
				}
			});
// 			hiddenForm.submit();
			return false;
			
		}).submit();
	});

let tags = [];

$('#selRecNm').on('change', function(){
	let recNm = $(this).val();
	console.log(recNm);
	if(recNm == '휴학' || recNm == '복학') {
		$('#recTrans').hide();
		$('#recLeave').show();
	} else if(recNm == '전과') {
		$('#recLeave').hide();
		$('#recTrans').show();
	} else if(recNm == '자퇴') {
		$('#recTrans').hide();
		$('#recLeave').hide();
	}
});

// 단과대학 셀렉트박스
$('#selColl').on('change', function(){
	let selColl = $(this).val();
	console.log(selColl);
	let data = {
		"collId" : selColl
	};
	
	$.ajax({
		url : "${pageContext.request.contextPath}/student/selectMajorList",
		method : "post",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		success : function(resp) {
			console.log(resp);
			$('#selMajor').html('');
			$.each(resp, function(idx, major){
// 				console.log(major.majorId);
// 				console.log(major.majorNm);
				$('#selMajor').append('<option value="' + major.majorId + '">' + major.majorNm + '</option>');
			});
		},
		error : function(jqXHR, status, error) {
			console.log(jqXHR);
			console.log(status);
			console.log(error);
		}
	});
	
});
	
</script>