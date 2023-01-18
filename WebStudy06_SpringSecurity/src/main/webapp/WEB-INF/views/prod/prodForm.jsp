<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
<c:if test="${not empty message }">
	<script>
		alert("${message}");
	</script>
</c:if>
</head>
<body>
<h4>등록 폼</h4>
<form:form modelAttribute="prod" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>상품아이디</th>
			<td>
				<form:input path="prodId" cssClass="form-control" readonly="true" />
				<form:errors path="prodId" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td>
				<form:input path="prodName" cssClass="form-control" />
				<form:errors path="prodName" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>상품분류</th>
			<td>
				<form:select path="prodLgu">
					<option value>분류</option>
					<c:forEach items="${lprodList }" var="lprod">
						<!-- 알아서 selected 옵션 선택해줌 진짜 짱짱 -->
						<form:option value="${lprod.lprodGu }" label="${lprod.lprodNm }" />
					</c:forEach>
				</form:select>
				<form:errors path="prodLgu" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>거래처</th>
			<td>
<%-- 				<form:select path="prodBuyer" items="${buyerList }" itemValue="buyerId" itemLabel="buyerName"> --%>
				<form:select path="prodBuyer">
					<option value>거래처</option>
					<c:forEach items="${buyerList }" var="buyer">
						<form:option
							value="${buyer.buyerId }"
							label="${buyer.buyerName }" 
							cssClass="${buyer.buyerLgu }"
						/>
					</c:forEach>
				</form:select>
				<form:errors path="prodBuyer" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>구매가</th>
			<td>
				<form:input path="prodCost" cssClass="form-control" />
				<form:errors path="prodCost" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>판매가</th>
			<td>
				<form:input path="prodPrice" cssClass="form-control" />
				<form:errors path="prodPrice" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>세일가</th>
			<td>
				<form:input path="prodSale" cssClass="form-control" />
				<form:errors path="prodSale" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>상품요약</th>
			<td>
				<form:input path="prodOutline" cssClass="form-control" />
				<form:errors path="prodOutline" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>상품상세</th>
			<td>
				<form:input path="prodDetail" cssClass="form-control" />
				<form:errors path="prodDetail" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>상품이미지</th>
			<td>
				<form:input path="prodImage" cssClass="form-control" type="file" />
				<form:errors path="prodImage" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>재고</th>
			<td>
				<form:input path="prodTotalstock" cssClass="form-control" />
				<form:errors path="prodTotalstock" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>입고일</th>
			<td>
				<form:input path="prodInsdate" cssClass="form-control" type="date" />
				<form:errors path="prodInsdate" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td>
				<form:input path="prodProperstock" cssClass="form-control" />
				<form:errors path="prodProperstock" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>크기</th>
			<td>
				<form:input path="prodSize" cssClass="form-control" />
				<form:errors path="prodSize" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>색상</th>
			<td>
				<form:input path="prodColor" cssClass="form-control" />
				<form:errors path="prodColor" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>배송방법</th>
			<td>
				<form:input path="prodDelivery" cssClass="form-control" />
				<form:errors path="prodDelivery" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>단위</th>
			<td>
				<form:input path="prodUnit" cssClass="form-control" />
				<form:errors path="prodUnit" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>입고량</th>
			<td>
				<form:input path="prodQtyin" cssClass="form-control" />
				<form:errors path="prodQtyin" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>출고량</th>
			<td>
				<form:input path="prodQtysale" cssClass="form-control" />
				<form:errors path="prodQtysale" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>
				<form:input path="prodMileage" cssClass="form-control" />
				<form:errors path="prodMileage" cssClass="text-danger" element="span" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="저장">
			<input type="reset" value="취소">
		</tr>
	</table>
</form:form>
<script type="text/javascript">
let prodBuyerTag = $("[name=prodBuyer]");
$("[name=prodLgu]").on("change", function(){
	let prodLgu = $(this).val();
	if(prodLgu){
		prodBuyerTag.find("option:gt(0)").hide();
		prodBuyerTag.find("option." + prodLgu).show();		
	}
}).trigger("change");

</script>
<jsp:include page="/includee/postScript.jsp" />
</body>
</html>