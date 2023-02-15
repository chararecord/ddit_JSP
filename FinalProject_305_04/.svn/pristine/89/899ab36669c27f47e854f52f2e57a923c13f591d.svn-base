<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script type="text/javascript">
 $(function(){
 	alert("tt");
 	$("#userNm").val("박형준");
 	$("#userNmEn").val("Park Hyeongjun");
 	$("#userRrn1").val("123456");
 	$("#userRrn2").val("1234567");
 	$("#userBir").val("");
 	$("#userNtl").val("SOUTH KOREA");
 	$("#userGender").val("F");
 	$("#userPost").val("12345");
 	$("#userAddr").val("서울시");
 	$("#userDetailAddr").val("좋은곳");
 	$("#userId").val("20110186");
 	$("#userPass").val("1234");
 	$("#camYear").val("4");
 	$("#selCollselMajor").val("");
 	$("#selPro").val("");
 	$("#entDate").val("");
 	$("#recordList0.recNm").val("입학");
 	$("#recordList0.recUpdate").val("20220208");
 	$("#userBank").val("신한");
 	$("#userAcctHd").val("지은");
 	$("#userAcctNo").val("1234-84351-654");
 	$("#semeId").val("2023");
 	$("#userPhone").val("01062454545");
 	$("#userEmail").val("beomsu@naver.com");
 });
</script>

<!-- 카카오 주소 API -->
<!-- <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> -->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<!-- 카카오 주소 API -->

<form:form modelAttribute="studentInfo" enctype="multipart/form-data" method="post">

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



		<!-- cont-box-inner -->
		<div class="cont-box-inner">

			<div class="title">
				<h3>개인 정보</h3>
				<div class="title">
					<div class="box-btn">
						<form:button type="submit" class="btn purple">등록</form:button>
					</div>
				</div>				
			</div>				
				
<!-- 				<div class="box-btn"> -->
<%-- 					<c:url value="/emp/studentInfoEdit.do" var="updateURL"> --%>
<%-- 						<c:param name="what" value="${studentInfo.stdId }" /> --%>
<%-- 					</c:url>  --%>
<%-- 					<a class="btn purple" href="${updateURL}">완료</a>  --%>
<!-- 					<button type="button" class="btn default">취소</button> -->
<!-- 				</div> -->
<!-- 			</div> -->


			<!--  "photo-wrap"-->
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
							<tr>
								<th scope="row">이름<em class="red-txt asterisk">*</em></th>
								<td><form:input path="userNm" type="text" cssClass="form-control"  />
						        <form:errors path="userNm" element="span" cssClass="text-danger" /></td>
								<th scope="row">영문이름<em class="red-txt asterisk">*</em></th>
								<td><form:input path="userNmEn" type="text" cssClass="form-control"  />
						        <form:errors path="userNmEn" element="span" cssClass="text-danger" /></td>
								<th scope="row">주민번호<em class="red-txt asterisk">*</em></th>
								<td><form:input path="userRrn1" type="text" cssClass="form-control"  />
<!-- 								<div class="flex"> -->
<!-- 		                            <input type="text" class=""> -->
<!-- 		                            <span class="cal-dash"></span> -->
<!-- 		                            <input type="text" class=""> -->
<!-- 		                        </div> -->
								
								<div class="flex">
							        <form:errors path="userRrn1" element="span" class="w5" cssClass="text-danger" /><span class="cal-dash"></span>
							        <form:input path="userRrn2" type="text" class="w5" cssClass="form-control"  />
							     </div>   
						        <form:errors path="userRrn2" element="span" cssClass="text-danger" /></td>
								
							</tr>
							<tr>
						        
								<th scope="row">생년월일<em class="red-txt asterisk">*</em></th>
								<td><form:input path="userBir" type="date" cssClass="form-control"  />
						        <form:errors path="userBir" element="span" cssClass="text-danger" /></td>
								<th scope="row">국적<em class="red-txt asterisk">*</em></th>
								<td><form:input path="userNtl" type="text" cssClass="form-control"  />
						        <form:errors path="userNtl" element="span" cssClass="text-danger" /></td>
								<th scope="row">성별<em class="red-txt asterisk">*</em></th>
								<td><form:input path="userGender" type="text" cssClass="form-control"  />
						        <form:errors path="userGender" element="span" cssClass="text-danger" /></td>
								
							</tr>
							<tr>
								<th scope="row">우편번호<em class="red-txt asterisk">*</em></th>
								<td>
	                            <div class="search-wrap flex">
	                                <input id="sample6_postcode" name="userPost" type="text" value="" >
	                                <button type="button" class="btn btn-line x-small" onclick="openHomeSearch()"> <i class="bi bi-search"><span class="sr-only">검색</span></i></button>
							        <form:errors path="userPost" element="span" cssClass="text-danger" />
                                </div>
                                </td>
						        
								<th scope="row">주소<em class="red-txt asterisk">*</em></th>
								<td><form:input path="userAddr" type="text" id="sample6_address" cssClass="form-control" name="addr2" />
						        <form:errors path="userAddr" element="span" cssClass="text-danger" /></td>
						        
								<th scope="row">상세주소<em class="red-txt asterisk">*</em></th>
								<td><form:input path="userDetailAddr" type="text" id="sample6_detailAddress" cssClass="form-control" name="addr3" />
						        <form:errors path="userDetailAddr" element="span" cssClass="text-danger" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!--   // "photo-wrap"-->

		</div>
		<!--  // cont-box-inner -->





		<!-- cont-box-inner -->
		<div class="cont-box-inner">
			<div class="title">
				<h3>학적 상세정보</h3>
<!-- 				<span class="total"><em>1</em>건</span> -->
			</div>
			<!--tbl-->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>description about table</caption>
					<colgroup>
						<col style="width: 10%;">
						<col style="width: 20%;">
						<col style="width: 10%;">
						<col style="width: 20%;">
						<col style="width: 10%;">
						<col style="width: 20%;">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">학번<em class="red-txt asterisk">*</em></th>
							<td><form:input path="userId" type="text" cssClass="form-control"  />
					        <form:errors path="userId" element="span" cssClass="text-danger" /></td>
					        <th scope="row">비밀번호<em class="red-txt asterisk">*</em></th>
							<td><form:input path="userPass" type="text" cssClass="form-control"  />	
							<form:errors path="userPass" element="span" cssClass="text-danger" /></td>
					        <th scope="row">학년<em class="red-txt asterisk">*</em></th>
							<td><form:input path="recordList[0].camYear" type="text" cssClass="form-control"  />	
							<form:errors path="recordList[0].camYear" element="span" cssClass="text-danger" /></td>
						</tr>
						<tr>
							<th scope="row">단과대학</th>
							<c:set var="collList" value="${collVO }" />
							<td>
							<select id="selColl" class="w100">
								<option value>단과대학</option>
							<c:choose>
								<c:when test="${not empty collList }">
									<c:forEach items="${collList }" var="callName">
									<option value="${callName.collId }">${callName.collNm }</option>
									</c:forEach>
								</c:when>
							</c:choose>
							</select>
							</td>
							
							<th scope="row">학과</th>
							<td>
								<select id="selMajor" name="majorId" class="w100">
									<option value>학과</option>
								</select>
							</td>
							
							<th scope="row">학과교수</th>
							<td>
								<select id="selPro" name="profId" class="w100">
									<option value>담당교수</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">입학일<em class="red-txt asterisk">*</em></th>
							<td><form:input path="entDate" type="date" cssClass="form-control" />
					        <form:errors path="entDate" element="span" cssClass="text-danger" /></td>
					        
							<th scope="row">학적상태<em class="red-txt asterisk">*</em></th>
							<td><form:input path="recordList[0].recNm" type="text" cssClass="form-control"  />
					        <form:errors path="recordList[0].recNm" element="span" cssClass="text-danger" /></td>
					        
							<th scope="row">최종변동일자<em class="red-txt asterisk">*</em></th>
							<td><form:input path="recordList[0].recUpdate" type="date" cssClass="form-control"  />
					        <form:errors path="recordList[0].recUpdate" element="span" cssClass="text-danger" /></td>
						</tr>
						<tr>
							<th scope="row">은행<em class="red-txt asterisk">*</em></th>
							<td><form:input path="userBank" type="text" cssClass="form-control"  />
							<form:errors path="userBank" element="span" cssClass="text-danger" /></td>
							<th scope="row">예금주<em class="red-txt asterisk">*</em></th>
							<td><form:input path="userAcctHd" type="text" cssClass="form-control"  />
					        <form:errors path="userAcctHd" element="span" cssClass="text-danger" /></td>
							<th scope="row">계좌번호<em class="red-txt asterisk">*</em></th>
							<td><form:input path="userAcctNo" type="text" cssClass="form-control"  />
					        <form:errors path="userAcctNo" element="span" cssClass="text-danger" /></td>
						</tr>
						<tr>
							<th scope="row">학사년도</th>
							<c:set var="semeList" value="${semesterVO }" />
							<td>
							<select id=selSeme name="semeId" class="w100">
								<option value>학사년도</option>
							<c:choose>
								<c:when test="${not empty semeList }">
									<c:forEach items="${semeList }" var="semeName">
									<option value="${semeName.semeId }">${semeName.semeYear }</option>
									</c:forEach>
								</c:when>
							</c:choose>
							</select>
							</td>
							<th scope="row">연락처<em class="red-txt asterisk">*</em></th>
							<td><form:input path="userPhone" type="text" cssClass="form-control"  />
					        <form:errors path="userPhone" element="span" cssClass="text-danger" /></td>
							<th scope="row">이메일<em class="red-txt asterisk">*</em></th>
							<td><form:input path="userEmail" type="text" cssClass="form-control"/>
					        <form:errors path="userEmail" element="span" cssClass="text-danger"/></td>
						</tr>
						
					</tbody>

				</table>
			</div>
			<!--end tbl-->

		</div>
	</div>
<!--   // "전체-wrap"-->
</div>
</form:form>

<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
</div>



<script>


	// 단과, 학과 셀렉트박스 변경
	$("#selColl").on("change", function(){
		let selColl = $(this).val(); //선택값을 selColl에 저장한다.
		console.log(selColl);
		let data = {"collId":selColl}; //json방식으로 하기 위해 이걸 적어줌.
		
		//*** 시큐리티 사용 시 token처리 필요
		$.ajax({
			url:"${pageContext.request.contextPath}/emp/selectMajorList",
			contentType:"application/json;charset=UTF-8",
			data:JSON.stringify(data), //마샬링, 직렬화
			dataType:"json",
			type:"post",
			success:function(result){
				$("#selMajor").html("");//초기화
				$("#selMajor").append("<option value>" + "학과선택" + "</option>");
				$.each(result,function(index, majorVO){
// 					console.log("lectRoomId : " + lectRoomVO.lectRoomId + ", roomNum : " + lectRoomVO.roomNum);
					console.log("majorVO: " + majorVO);
					$("#selMajor").append("<option value='"+majorVO.majorId+"'>" + majorVO.majorNm + "</option>");
				});
			}
		});
	});
	// 단과, 학과 셀렉트박스 변경 끝

	
	
	// 학과, 교수 셀렉트박스 변경
	$("#selMajor").on("change", function(){
		let selMajor = $(this).val(); //선택값을 selColl에 저장한다.
		console.log(selMajor);
		let data = {"majorId":selMajor}; //json방식으로 하기 위해 이걸 적어줌.
		
		//*** 시큐리티 사용 시 token처리 필요
		$.ajax({
			url:"${pageContext.request.contextPath}/emp/selectProfList",
			contentType:"application/json;charset=UTF-8",
			data:JSON.stringify(data), //마샬링, 직렬화
			dataType:"json",
			type:"post",
			success:function(result){
				//result : [{"rnum":0,"profId":3120001,"laboId":"CB10001","majorId":"EE10023"
					//,"entDate":"20200105","levDate":null,"pos":"학과장","usrList":null,"recordList":null}]
				console.log("result : " + JSON.stringify(result));
				$("#selPro").html("");//초기화
				$.each(result,function(index, professorVO){
					$("#selPro").append("<option value='"+professorVO.profId+"'>" + professorVO.userNm + "</option>");
				});
			}
		});
	});
	// 학과, 교수 셀렉트박스 변경 끝
</script>
	
<script type="text/javascript">
//다음 우편번호 검색
function openHomeSearch() {
	new daum.Postcode({
		oncomplete: function(data) {
			$('[name=userPost]').val(data.zonecode); // 우편번호 (5자리)
			$('[name=userAddr]').val(data.address);
			$('[name=userDetailAddr]').val(data.buildingName);
		}
	}).open();
}
</script>
	











