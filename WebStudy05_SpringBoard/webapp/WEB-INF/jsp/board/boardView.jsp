<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<table>
	<thead>
		<tr>
			<th>글번호</th>
			<td>${board.rnum }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.boTitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.boWriter }</td>
		</tr>
		<c:if test="${not empty board.attatchList }">
			<tr>
				<th>첨부파일</th>
				<td>
					<c:forEach items="${board.attatchList }" var="attatch" varStatus="vs">
						${attatch.attFilename } ${vs.last ? "" : "," }
					</c:forEach>
				</td>
			</tr>
		</c:if>
		<tr>
			<th>IP</th>
			<td>${board.boIp }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${board.boMail }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${board.boPass }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.boContent }</td>
		</tr>
	</thead>
</table>