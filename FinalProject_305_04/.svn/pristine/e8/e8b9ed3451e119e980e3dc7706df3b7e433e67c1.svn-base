<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor/ckeditor.js"></script>
<form:form id="updateForm" modelAttribute="studentInfo" enctype="multipart/form-data" method="post">
<form:hidden path="stdId"/>
<form:hidden path="userId"/>
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
				<div class="box-btn">
					<form:button type="submit" class="btn btn-success purple">저장</form:button>
				</div>
			</div>


			<!--  "photo-wrap"-->
			<div class="photo-wrap">
				<div class="photo">
					<img src="/resources/images/star.png" alt="프로필사진" />
				</div>

				<div class="tbl-wrap">
					<table class="tbl">
						<caption></caption>
						<colgroup>
							<col style="width: 20%;">
							<col style="width: 20%;">
							<col style="width: 20%;">
							<col style="width: 20%;">
							<col style="width: 20%;">
							<col style="width: 20%;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">이름<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userNm" type="text" cssClass="form-control" />
									<form:errors path="userNm" element="span" cssClass="text-danger" />
								</td>
								<th scope="row">영문이름<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userNmEn" type="text" cssClass="form-control" />
									<form:errors path="userNmEn" element="span" cssClass="text-danger" />
								</td>
								<th scope="row">주민번호<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userRrn1" type="text" cssClass="form-control" />
									<form:input path="userRrn2" type="text" cssClass="form-control" />
									<form:errors path="userRrn1" element="span" cssClass="text-danger" />
									<form:errors path="userRrn2" element="span" cssClass="text-danger" />
								</td>

							</tr>
							<tr>

								<th scope="row">생년월일<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userBir" type="date" cssClass="form-control" />
									<form:errors path="userBir" element="span" cssClass="text-danger" />
								</td>
								<th scope="row">국적<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userNtl" type="text" cssClass="form-control" />
									<form:errors path="userNtl" element="span" cssClass="text-danger" />
								</td>
								<th scope="row">성별<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userGender" type="text" cssClass="form-control" />
									<form:errors path="userGender" element="span" cssClass="text-danger" />
								</td>

							</tr>
							<tr>
								<th scope="row">우편번호<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userPost" type="text" cssClass="form-control" />
									<form:errors path="userPost" element="span" cssClass="text-danger" />
								</td>
								<th scope="row">주소<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userAddr" type="text" cssClass="form-control" />
									<form:errors path="userAddr" element="span" cssClass="text-danger" />
								</td>
								<th scope="row">상세주소<em class="red-txt asterisk">*</em></th>
								<td>
									<form:input path="userDetailAddr" type="text" cssClass="form-control" />
									<form:errors path="userDetailAddr" element="span" cssClass="text-danger" />
								</td>
								
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
				<h3>학적 정보</h3>
<!-- 				<span class="total"><em>1</em>건</span> -->
			</div>
			<!--tbl-->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>description about table</caption>
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 20%" />
						<col style="width: 20%" />
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">학번<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.stdId }</td>			
							<th scope="row">비밀번호<em class="red-txt asterisk">*</em></th>
							<td>
								<form:input path="userPass" type="text" cssClass="form-control" />
								<form:errors path="userPass" element="span" cssClass="text-danger" />
							</td>			
							<th scope="row">학년<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.recordList[0].camYear }</td>		
						</tr>
						<tr>
							<th scope="row">단과대학</th>
							<c:set var="collList" value="${collVO }" />
							<td>
							<select id="selColl" name="collVO.collNm">
								<option value>단과대학</option>
							<c:choose>
								<c:when test="${not empty collList }">
									<c:forEach items="${collList }" var="callName">
									<option value="${callName.collId }" >${callName.collNm }</option>
									</c:forEach>
								</c:when>
							</c:choose>
							</select>
							</td>
							<th scope="row">학과</th>
							<td>
								<select id="selMajor" name="majorVO.majorId">
									<option value>학과</option>
								</select>
							</td>
							<th scope="row">학과교수</th>
							<td>
								<select id="selPro" name="profId">
									<option value="${studentInfo.professorVO.profId }" selected>${studentInfo.professorVO.profNm}</option>
								</select>
							</td>
						
						</tr>
						<tr>
							<th scope="row">입학일<em class="red-txt asterisk">*</em></th>
							<td>
								<form:input path="entDate" type="date" cssClass="form-control" />
								<form:errors path="entDate" element="span" cssClass="text-danger" />
							</td>			
							<th scope="row">학적상태<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.recordList[0].recNm }</td>				
							<th scope="row">최종변동일자<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.recordList[0].recUpdate }</td>							
									
						</tr>
						<tr>
							<th scope="row">은행<em class="red-txt asterisk">*</em></th>
							<td>
								<form:input path="userBank" type="text" cssClass="form-control" />
								<form:errors path="userBank" element="span" cssClass="text-danger" />
							</td>
							<th scope="row">예금주<em class="red-txt asterisk">*</em></th>
							<td>
								<form:input path="userAcctHd" type="text" cssClass="form-control" />
								<form:errors path="userAcctHd" element="span" cssClass="text-danger" />
							</td>
							<th scope="row">계좌번호<em class="red-txt asterisk">*</em></th>
							<td>
								<form:input path="userAcctNo" type="text" cssClass="form-control" />
								<form:errors path="userAcctNo" element="span" cssClass="text-danger" />
							</td>	
						</tr>	
						<tr>					
							<th scope="row">학사년도</th>
							<td>${studentInfo.semeYear }</td>	
							<th scope="row">연락처<em class="red-txt asterisk">*</em></th>
							<td>
								<form:input path="userPhone" type="text" cssClass="form-control" />
								<form:errors path="userPhone" element="span" cssClass="text-danger" />
							</td>			
							<th scope="row">이메일<em class="red-txt asterisk">*</em></th>
							<td>
								<form:input path="userEmail" type="text" cssClass="form-control" />
								<form:errors path="userEmail" element="span" cssClass="text-danger" />
							</td>	
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


<script>




	// 단과, 학과 셀렉트박스 변경
	$("#selColl").on("change", function(){
		let selColl = $(this).val(); //선택값을 selColl에 저장한다.
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
					let option = $("<option>").attr({value:majorVO.majorId}).html(majorVO.majorNm)
								.prop("selected","${studentInfo.majorId}"==majorVO.majorId);
					$("#selMajor").append(option);
				});
			}
		});
	}).val("${studentInfo.collVO.collId}").trigger("change");
	// 단과, 학과 셀렉트박스 변경 끝
	
	
	// 학과, 교수 셀렉트박스 변경
	$("#selMajor").on("change", function(){
		let selMajor = $(this).val(); //선택값을 selColl에 저장한다.
		let data = {"majorId":selMajor}; //json방식으로 하기 위해 이걸 적어줌.
		console.log(data);
		
		//*** 시큐리티 사용 시 token처리 필요
		$.ajax({
			url:"${pageContext.request.contextPath}/emp/selectProfList",
			contentType:"application/json;charset=UTF-8",
			data:JSON.stringify(data), //마샬링, 직렬화
			dataType:"json",
			type:"post",
			success:function(result){
				
				$("#selPro").html("");//초기화
				$("#selPro").append("<option value>" + "교수선택" + "</option>");
				$.each(result,function(index, professorVO){
					console.log(professorVO.userNm);
					let option = $("<option>").attr({value:professorVO.profId}).html(professorVO.userNm)
								.prop("selected","${studentInfo.profId}"==professorVO.profId);
					$("#selPro").append(option);
				});
			}
		});
	}).val("${studentInfo.profId}");
	// 학과, 교수 셀렉트박스 변경 끝
	
	

	//form:form의 아이디
	let updateForm = $("#updateForm");
	
</script>














