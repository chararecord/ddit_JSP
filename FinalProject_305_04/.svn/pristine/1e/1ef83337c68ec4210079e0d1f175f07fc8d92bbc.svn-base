<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.ddit.or.kr/class305" prefix="ui" %>

<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			공지사항
			<button type="button" class="star">
				<span class="sr-only">즐겨찾기</span>
			</button>
		</h2>
		<!--cont-navi-->
		<div class="cont-navi">
			<span>home</span> <i class="bi bi-house-door-fill"></i> <strong>공지사항</strong>
		</div>
		<!--end cont-navi-->
	</div>
	<!-- end cont-title -->

	<div class="white-box">

		<!-- cont-box-inner -->
		
		
		
		<div class="cont-box-inner">
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
			<!--tbl start-->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>공지사항 페이지 목록 테이블</caption>
					<colgroup>
						<col style="width: 10%" />
<%-- 						<col style="width: 20%" /> --%>
<%-- 						<col style="width: 10%" /> --%>
<%-- 						<col style="width: 20%" /> --%>
					</colgroup>
					<thead>
						<tr>
							<th scope="col">선택</th>			<!-- 얘는 emp만 보이게 할 예정이에요(삭제할때사용) -->
							<th scope="col">글번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">등록일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:set var="noticeList" value="${pagingVO.dataList }" />
							<c:choose>
								<c:when test="${not empty noticeList }">
									<c:forEach items="${noticeList }" var="notice">
										<tr>
											<td>
												<!-- 체크박스 -->
												<div class="rc-wrap">
													<input type="checkbox" id="checkbox5" name="radio-group">
													<label for="checkbox5"><span class="sr-only">선택</span></label>
												</div>
											</td>
											<td>${notice.rnum }</td>
											<td>
											${notice.tit }</td>
											<td>${notice.empId }</td>
											<td>${notice.wrDate }</td>
											<td>${notice.hit }</td>
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
			<!--tbl end-->

			<!-- 페이지 네비게이션 -->
			<div class="pagination_block">
				<ui:pagination pagingVO="${pagingVO }" type="bootstrap"/>
			</div>
			<!-- //페이지 네비게이션 -->
			<div>
				<form:form id="searchUI" modelAttribute="simpleCondition" onclick="return false;">
					<form:select path="searchType">
						<option value>전체</option>
						<form:option value="writer" label="작성자" />
						<form:option value="content" label="내용" />
					</form:select>
					<form:input path="searchWord"/>
					<input id="searchBtn" type="button" value="검색" />
				</form:form>
			</div>

		</div>
		<!-- end cont-box-inner -->
	</div>
</div>
<form:form id="searchForm" method="get" modelAttribute="simpleCondition">
	<form:hidden path="searchType"/>
	<form:hidden path="searchWord"/>
	<input type="hidden" name="page" />
</form:form>
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

$("a.paging").on('click', function(event){
	event.preventDefault();
	let page = $(this).data("page");
	console.log(page);
	if(!page){return false;}
	searchForm.find("[name=page]").val(page);
	searchForm.submit();
	return false;
});
</script>

