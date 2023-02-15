<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			수강중인 강의 목록(학생)
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
			
				<h3>${lectureVO.semeYear } ${lectureVO.seme } </h3>
				
				<div class="box-btn">
					<button type="button" class="btn purple">시간표 보기</button>
				</div>
			</div>
			<div class="table-scrollable">
				<div class="table-responsive">

					<table class="tbl">
						<colgroup>
							<col style="width: 10%">
							<col style="width: 15%">
							<col style="width: 20%">
							<col style="width: 10%">
							<col style="width: 5%">
							<col style="width: 10%">
							<col style="width: 15%">
							<col style="width: 10%">
							<col style="width: 10%">
						</colgroup>

						<thead class="">
							<tr class="table-scrollable__fixed-y">
								<th>이수구분</th>
								<th>개설학과</th>
								<th>강의명</th>
								<th>교수명</th>
								<th>학점</th>
								<th>출결현황</th>
								<th>강의계획서</th>
								<th>강의평가</th>
								<th>과제</th>
							</tr>
						</thead>

						<tbody>
						${ stdLectList}
							<tr>
								<c:set var="stdLectList" value="${stdLectList }" />
								<c:choose>
									<c:when test="${not empty stdLectList }">
										<c:forEach items="${stdLectList }" var="lecture" varStatus="i">
											<tr>
												<td>${lecture.mylectureList[i.index].estaSub  }</td>
												<td>${lecture.mylectureList[i.index].majorVO.majorNm }</td>
												<td>${lecture.mylectureList[i.index].lectNm }</td>
												<td>${lecture.mylectureList[i.index].userVO.userNm}</td>
												<td>${lecture.mylectureList[i.index].credit }</td>
												<td><button type="button" class="btn btn-s purple" onclick="f_attendStatus('${lecture.stdId}','${lecture.mylectureList[i.index].lectId }')">출결 현황</button></td>
												<td><button type="button" class="btn btn-s purple" onclick="f_lectSylla()">강의계획서</td>
												<td><button type="button" class="btn btn-s purple" onclick="f_lectEval()">강의평가</td>
												<td><button type="button" class="btn btn-s purple" onclick="f_lectEval()">과제</td>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td colspan="8">수강 중인 강의가 없습니다.</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

// '출결 현황' 버튼
function f_attendStatus(mystdId,mylectId){
	let url = "${pageContext.request.contextPath}/student/attend?stdId="+mystdId+"&lectId="+mylectId;
	location.href= url;
}

// 강의계획서 버튼


// 강의 평가 버튼

// 과제 버튼


</script>







