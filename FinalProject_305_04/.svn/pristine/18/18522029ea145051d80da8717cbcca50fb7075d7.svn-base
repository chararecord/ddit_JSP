<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.ddit.or.kr/class305" prefix="ui" %>

<style>
 .box-btn {
 	float: right;
 }
</style>

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
											<td>${studentInfo.recordList[0].camYear }</td>
											<td>
												<c:url value="/emp/studentInfoView" var="viewURL">
													<c:param name="what" value="${studentInfo.stdId }"/>
												</c:url>
												<a href="${viewURL }">${studentInfo.stdId }</a>
											</td>	
											<td>${studentInfo.userNm }</td>
											<td>${studentInfo.recordList[0].recNm }</td>
											<td>${studentInfo.collVO.collNm }</td>
											<td>${studentInfo.majorVO.majorNm }</td>
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
				<ui:pagination pagingVO="${pagingVO }" type="bootstrap"/>
			</div>
			<!-- //페이지 네비게이션 -->
			<div>
				<form:form id="searchUI" modelAttribute="simpleCondition" onclick="return false;">
					<form:select path="searchType">
						<option value>전체</option>
						<form:option value="camYear" label="학년" />
						<form:option value="userId" label="학번" />
						<form:option value="userNm" label="이름" />
					</form:select>
					<form:input path="searchWord"/>
					<input id="searchBtn" type="button" value="검색" />
				</form:form>
			</div>		
			<!-- //페이지 네비게이션 -->
						
		</div>
		<!-- end cont-box-inner -->
	</div>
</div>

<script>
let searchForm = $("#searchForm");
let searchUI = $("#searchUI").on('click', "#searchBtn", function(){
	// :input[name] : name 속성을 갖고 있는 모든 input/select 대상
	let inputs = searchUI.find(":input[name]");
	$.each(inputs, function(index, input){
		let name = this.name;
		let value = $(this).val();
		searchForm.find("[name="+name+"]").val(value);
	});
	searchForm.submit();
	
});


function f_insertBtn(){
}
</script>





























	
