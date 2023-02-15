<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<!-- 		<div class="tob-box"> -->
<!-- 			<strong class="tit">게시판 안내 사항 </strong> -->
<!-- 			<p>게시판에 작성되는 본문 내용 및 첨부파일 내에 성명, 주민등록번호, 핸드폰 번호, 이메일 등 2개 이상의 개인정보 작성 시 -->
<!-- 			개인정보보호법 제2조제1호에 의거 개인정보에 해당되어 작성 및 등록을 제한하고 관리자에 의해 삭제 처리될 수 있습니다. 게시판 사용에 유의하시기 바랍니다.</p> -->
<!-- 			<br> -->
<!-- 			<p>※ 개인정보를 위조 또는 도용, 외부에 유출한 자는 관련법에 의거 법적 처벌을 받을 수 있으며, -->
<!-- 			게시글에 포함된 개인정보 또한 책임은 게시자에게 있으며 정보 노출을 원하지 않으실 경우에는 수정 및 삭제하시기 바랍니다.</p> -->
<!-- 			<strong class="red-txt">(개인정보보호법 제71조에 의거 개인정보를 유출한 자는 5년 이하의 징역 또는 5천만원 이하의 벌금이 부과될 수 있습니다.)</strong> -->
<!-- 		</div> -->

		<!-- cont-box-inner -->
		<div class="cont-box-inner">
			<div class="title">
				<p class="highlight-txt">총<em class="red-txt">${pagingVO.totalRecord }</em>건의 게시물이 있습니다</p>
				<div class="right-part">
					<div class="search-form">
						<form:form id="searchUI" modelAttribute="simpleCondition" onsubmit="return false;">
							<form:select path="searchType">
								<option value>전체</option>
								<form:option value="tit" label="제목" />
								<form:option value="cont" label="내용" />
							</form:select>
							<div class="input-group">
								<form:input path="searchWord"/>
								<input id="searchBtn" class="btn btn-search primary" type="button" value="검색" />
							</div>
							<div class="box-btn">
								<button type="button" class="insertBtn btn purple">등록</button>
							</div>
						</form:form>
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
							<th scope="col" class="w5">선택</th>			<!-- 얘는 emp만 보이게 할 예정이에요(삭제할때사용) -->
							<th scope="col" class="w5">글번호</th>
							<th scope="col" class="w50">제목</th>
							<th scope="col" class="w5">첨부파일</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col" class="w5">조회수</th>
						</tr>
					</thead>
					<tbody id="listBody" >
						<tr>
							<c:set var="noticeList" value="${pagingVO.dataList }" />
						</tr>
					</tbody>
				</table>
			</div>
			<!--tbl end-->

			<!-- 페이지 네비게이션 -->
			<div id="pagingArea">
				<ui:pagination pagingVO="${pagingVO }" type="bootstrap"/>
			</div>
			<!-- //페이지 네비게이션 -->
		</div>
		<!-- end cont-box-inner -->
	</div>
</div>
<form:form id="searchForm" method="get" modelAttribute="simpleCondition">
	<form:hidden path="searchType" name="searchType"/>
	<form:hidden path="searchWord"/>
	<input type="hidden" name="page" />
</form:form>
<script>
let listBody = $("#listBody");

let pagingArea = $("#pagingArea").on('click', "a.paging", function(event){
	event.preventDefault();
	let page = $(this).data("page");
	if(!page){return false;}
	searchForm.find("[name=page]").val(page);
	searchForm.submit();
	return false;
});

let makeTrTag = function(notice, index){
	
	/* 날짜 format */
	let wrDate = notice.wrDate;
	let day = wrDate.split(' ');
// 	let time = day[1];
// 	console.log(time);
// 	time = day[1].split('.');
// 	console.log(time[0]);
	
	let aTag = $("<a>")
				.attr("href", "${pageContext.request.contextPath}/campus/notice/" + notice.notiId)
				.html(notice.tit);
	
	let checkBoxInput = $("<input>")
						.attr({
							type:"checkbox"
							,id:"check_" +index
							,name:"notiCheck"
							,value:notice.notiId
						}); 
	let checkBoxLabel = $("<label>").append(
							$("<span>").addClass("sr-only")
						).attr('for', "check_" +index)
	let f_attach = function(){
		if(notice.attaCount >= 1){
			let attaTag = $("<span>").addClass('material-symbols-outlined')
						.css('font-size','15px')
						.html('attach_file')
			return attaTag;
		}
	}
	let f_emp = function(){
		let empId = notice.empId+""
		if(empId.startsWith('1')){
			return '관리자'
		}
	}

	

	return $("<tr>").append(
			$("<td>").append(
				checkBoxInput, 	checkBoxLabel	
			)
			,$("<td>").html(notice.rnum)
			,$("<td>").html(aTag).css('text-align', 'left')
			,$("<td>").html(f_attach())
			,$("<td>").html(f_emp())
			,$("<td>").html(day[0])
			,$("<td>").html(notice.hit)
	)
}


let searchForm = $('#searchForm').on('submit', function(event){
	event.preventDefault();
	
	let url = this.action;
	let method = this.method;
	let queryString = $(this).serialize();

	//아작스 보내는 방식이 다양한데, 확장성 좋은 요걸 외움(파일 전송빼고 모든 곳에 사용가능)
	$.ajax({
		url : url,
		method : method,
		data :  queryString,
		dataType:"json",
		success : function(resp) {
			listBody.empty();
			pagingArea.empty();
			searchForm[0].page.value="";
			
			let pagingVO = resp.pagingVO;
			let dataList = pagingVO.dataList;
			let trTags = [];
			
			if(dataList){
				$.each(dataList, function(index, notice){
					trTags.push(makeTrTag(notice, index));
				});
			} else {
				let tr = $("<tr>").html(
							$("<td>").attr("colspan", "5").html("조건에 맞는 게시글이 없습니다."));
				trTags.push(tr);
			}
			listBody.html(trTags);
			pagingArea.html(resp.pagingHTML)
		},
		error : function(jqXHR, status, error) {
			console.log(jqXHR);
			console.log(status);
			console.log(error);
		}
	});
	return false;
}).submit();

let searchUI = $("#searchUI").on('click', "#searchBtn", function(){
	// :input[name] : name 속성을 갖고 있는 모든 input/select 대상
	let inputs = searchUI.find(":input[name]");
	$.each(inputs, function(index, input){
		let name = this.name;
		let value = $(this).val();
		console.log(name, value);
		searchForm.find("[name="+name+"]").val(value);
	});
	searchForm.submit();
});

$(".insertBtn").on('click', function(event){
	event.preventDefault();
	let url = "${pageContext.request.contextPath}/campus/notice/form";
	location.href = url;
});
</script>

