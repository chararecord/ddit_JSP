<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			나의 출결 현황(학생)
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

			<!-- 		scroll bar	 -->
			<div class="title">
					
				<h3>${attendVO[0].semeYear }년도 ${attendVO[0].seme }학기 ${attendVO[0].lectNm }</h3>
				<div class="tob-box">
			<strong class="tit">출결 안내 사항 </strong>
			<br>
			<p>한 학기는 총 16주로 구성됩니다.</p>
			<br>
			<p>(1) 지각/조퇴 3회는 결석 1회로 산정합니다.</p>
			<p>(2) 공결로 인한 출석 인정 기간 : 모든 공결 사유를 합하여 출석 인정 기간은 수업일수의 1/3 이내만 가능합니다.</p>
			<p>(3) 지각 : 입실 시간으로부터 10분 경과 후 입실시 지각으로 처리합니다.</p>
			<p>(4) 결석: 입실 시간으로부터 30분 경과 후 입실시 결석으로 처리합니다.</p>
			<br> <strong class="red-txt">출결 사항에 이의가 있는 경우 해당 강의 교수님께 문의 바랍니다. </strong>
		</div>
				
				
				
			</div>
			<div class="table-scrollable">
				<div class="table-responsive">

					<table class="tbl">
						<colgroup>
							<col style="width: 10%">
							<col style="width: 15%">
							<col style="width: 15%">
							
						</colgroup>

						<thead class="">
							<tr class="table-scrollable__fixed-y">
								<th>주차</th>
								<th>날짜</th>
								<th>출결 상태</th>
							</tr>
						</thead>

						<tbody>
								<c:set var="studentAttendList" value="${attendVO }" />
									<c:choose>
										<c:when test="${not empty studentAttendList }">
											<c:forEach items="${studentAttendList }" var="stdAttend" varStatus="i">
												<tr>
													<th>${i.count }주차 </th>	
											     	<td>${stdAttend.attendDate }</td>
											     	<td>${stdAttend.attendStat }</td>
											    </tr>
									     	</c:forEach>
										</c:when>
										<c:otherwise>
											<td colspan="2">아직 강의 전 입니다.</td>
										</c:otherwise>
									</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		
		</div>
	</div>
</div>