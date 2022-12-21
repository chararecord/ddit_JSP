<%@page import="kr.or.ddit.vo.MemoVO"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/elDesc.jsp</title>
</head>
<body>
<h4>EL(Expression Language)</h4>
<pre>
	: 표현(속성 데이터 출력)을 목적으로 하는 스크립트 형태의 언어
	<%
		String data = "데이터";
		pageContext.setAttribute("attr-Data", data);
	%>
	1. 속성(EL변수) 접근 방법
		<%=data %>, ${data } , ${attr-Data } <!-- 일반적인 변수는 el에서 쓸 수 없다 -->
		pageScope, requestScope, sessionScope, applicationScope
		<!-- 맵에서 key 접근할 때 . 사용, javascript와 같다? 연상배열도 사용 가능 -->
		${pageScope.attr-Data } , 💜${pageScope['attr-Data']}💜  <!-- 안정적인 구조 --> 
	2. 연산자 종류
		<!-- 산술, 논리, 비교 - 2항연산자 -->
		<!--  -->
		산술연산자 : +-*/%
			${3+4 }, ${"3"+4 }, ${"3"+"4" }, ${attr+4 }, \${"a"+4 }
			${4/3 }, ${attr*data }
		논리연산자 : &&(and, short-curit), ||(or, short-curit), !(not)
			${true and true }, ${"true" and true }, ${true or "false" }, ${false or attr }, ${not attr }
		비교연산자 : &gt;(gt), &lt;(lt), &gt;=(ge), &lt;=(le), ==(eq), !=(ne)
			${3 lt 4 }, ${4 ge 3 }, ${4 eq 3 }, ${4 ne 3 }
		단항연산자 : empty , exists -> null -> length, size check
		<%
			pageContext.setAttribute("attr", "  ");
			pageContext.setAttribute("listAttr", Arrays.asList("a","b")); /* 가변파라미터 : 타입만 동일하면 안넣거나, 여러개 넣을 수 있음 */
		%>
		<!-- 할당연산자가 지원되어야 증감연산자를 사용할 수 있는데 지원을 안하므로 다루지 않겠음 -->
			${empty attr }
			list attr : ${not empty listAttr }
		삼항연산자 : 조건식 ? 참표현 : 거짓표현
			${not empty attr ? "attr비었어" : attr }
			${listAttr }, ${not empty listAttr ? listAttr : "기본값"}
	3. (속성)객체에 대한 접근법
		<%
			MemoVO memo = new MemoVO();
			pageContext.setAttribute("memoAttr", memo);
			memo.setWriter("작작성자");
		%>
		${memoAttr }, ${memoAttr.writer}, ${memoAttr['writer']}
	4. (속성)집합 객체에 대한 접근법 : <a href="elCollection.jsp">elCollection</a>
	5. EL 기본객체 :  <a href="elObject.jsp">elObject</a>
</pre>
</body>
</html>