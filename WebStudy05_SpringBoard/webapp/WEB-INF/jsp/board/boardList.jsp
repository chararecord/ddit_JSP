<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<table>
	<thead>
		<tr>
			<th>일련번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>이메일</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="boardList" value="${pagingVO.dataList }" />
		<c:choose>
			<c:when test="${not empty boardList }">
				<c:forEach items="${boardList }" var="board">
					<tr>
						<td>${board.rnum }</td>
						<td>
							<c:url value="/board/boardView.do" var="viewURL">
								<c:param name="what" value="${board.boNo }" />
							</c:url>
							<a href="${viewURL }">${board.boTitle }[${board.attCount }]</a>
						</td>
						<td>${board.boWriter }</td>
						<td>${board.boMail }</td>
						<td>${board.boDate }</td>
						<td>${board.boHit }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6">조건에 맞는 게시글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<div id="pagingArea">${pagingVO.pagingHTML }</div>
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
			</td>
		</tr>
	</tfoot>
</table>
<form:form id="searchForm" method="get" modelAttribute="simpleCondition">
	<form:hidden path="searchType"/>
	<form:hidden path="searchWord"/>
	<input type="hidden" name="page" />
</form:form>
<script type="text/javascript">
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
		if(!page){return false;}
		searchForm.find("[name=page]").val(page);
		searchForm.submit();
		return false;
	});
</script>