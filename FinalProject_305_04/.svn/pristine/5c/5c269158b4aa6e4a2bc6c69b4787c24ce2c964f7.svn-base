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



		<!-- cont-box-inner -->
		<div class="cont-box-inner">
			<div class="title">
				<h3>개인 정보</h3>
				<div class="box-btn">
					<c:url value="/emp/studentInfoEdit.do" var="updateURL">
						<c:param name="what" value="${studentInfo.stdId }" />
					</c:url> 
					<a class="btn purple" href="${updateURL}">수정</a> 
					
					<button type="button" class="btn default">삭제</button>
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
							<col style="width: 15%;">
							<col style="width: 20%;">
							<col style="width: 15%;">
							<col style="width: 20%;">
							<col style="width: 15%;">
							<col style="width: 20%;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">이름<em class="red-txt asterisk">*</em></th>
								<td>${studentInfo.userNm }</td>
								<th scope="row">영문이름<em class="red-txt asterisk">*</em></th>
								<td>${studentInfo.userNmEn }</td>
								<th scope="row">주민번호<em class="red-txt asterisk"></em></th>
								<td>${studentInfo.userRrn1 }${studentInfo.userRrn2 }</td>
							</tr>
							<tr>
								<th scope="row">생년월일<em class="red-txt asterisk"></em></th>
								<td>${studentInfo.userBir }</td>
								<th scope="row">국적<em class="red-txt asterisk"></em></th>
								<td>${studentInfo.userNtl }</td>
								<th scope="row">성별<em class="red-txt asterisk">*</em></th>
								<td>${studentInfo.userGender }</td>
							</tr>
							<tr>
								<th scope="row">우편번호<em class="red-txt asterisk"></em></th>
								<td>${studentInfo.userPost }</td>
								<th scope="row">주소<em class="red-txt asterisk"></em></th>
								<td>${studentInfo.userAddr }</td>
								<th scope="row">상세주소<em class="red-txt asterisk"></em></th>
								<td>${studentInfo.userDetailAddr }</td>
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
						<col style="width: 15%" />
						<col style="width: 20%" />
						<col style="width: 15%" />
						<col style="width: 20%" />
						<col style="width: 15%" />
						<col style="width: 20%" />
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">학번<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.userId }</td>
							<th scope="row">비밀번호<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.userPass }</td>
							<th scope="row">학년<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.recordList[0].camYear }</td>
						</tr>
						<tr>
							<th scope="row">단과대학<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.collVO.collNm }</td>
							<th scope="row">학과<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.majorVO.majorNm }</td>
							<th scope="row">학과교수<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.professorVO.profNm }</td>
						</tr>
						<tr>
							<th scope="row">입학일<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.entDate }</td>
							<th scope="row">학적상태<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.recordList[0].recNm }</td>
							<th scope="row">최종변동일자<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.recordList[0].recUpdate }</td>
						</tr>
						<tr>
							<th scope="row">은행<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.userBank }</td>
							<th scope="row">예금주<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.userAcctHd }</td>
							<th scope="row">계좌번호<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.userAcctNo }</td>
						</tr>
						<tr>
							<th scope="row">학사년도<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.semeYear }</td>
							<th scope="row">연락처<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.userPhone }</td>
							<th scope="row">이메일<em class="red-txt asterisk">*</em></th>
							<td>${studentInfo.userEmail }</td>
						</tr>
					</tbody>

				</table>
			</div>
			<!--end tbl-->




		</div>
	</div>
<!--   // "전체-wrap"-->
</div>












