<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>



<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>
			시험
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


	<!-- white-box -->
	<div class="white-box">
		<!-- 학번, 학생명, 강의코드, 강의명, 중간기말구분 -->
		<ul class="top-info">
			<li>
				<strong class="label-tit"> 과목명</strong>
				<input type="text" value="${test.testNm }" disabled />
			</li>
			<li>
			<strong class="label-tit"> 시험시작시간</strong>
			<input type="text" value="${test.testStime }" disabled />
			</li>
			<li>
			<strong class="label-tit"> 시험종료시간 </strong>
			<input type="text" value="${test.testEtime }" disabled />
			</li>
	
			<li>
			<strong class="label-tit"> 학번 </strong>
			<input type="text" value="${map.STD_ID}" disabled />
			</li>
			<li>
			<strong class="label-tit"> 학생명 </strong>
			<input type="text" value="${map.USER_NM}" disabled />
			</li>
			<li>
			<strong class="label-tit"> 강의코드 </strong>
			<input type="text" value="${map.LECT_ID}" disabled />
			</li>
			<li>
			<strong class="label-tit"> 강의명 </strong>
			<input type="text" value="${map.LECT_NM}" disabled />
			</li>
			<li>
			<strong class="label-tit"> 중간기말구분 </strong>
			<input type="text" value="${map.EXAM_TYPE}" disabled />
			</li>
		</ul>

		<!-- 
		test : TestVO
		test.queList : List<TestQueVO> queList
		testQue : TestQueVO
		testQue.pasgList : List<TestPasgVO> pasgList
		testPasg : TestPasgVO
		 -->
		<form:form modelAttribute="test" enctype="multipart/form-data">

		
		<ul class="listGroup-wrap">
		<!-- 시험문제   -->
		<c:choose>
           <c:when test="${not empty test.queList }">
           <!-- statL.index : 0부터 카운트
           		statL.count : 1부터 카운트
            -->

              <c:forEach  var="testQue" items="${test.queList }" varStatus="statL">
					 <%-- ${testQue } --%>
             		<li>
             			<!-- testQue.testNum : 시험문항아이디(testQueId) -->
                        <p>${testQue.testNum }.  ${testQue.testQue }</p>
                        
		              	<%-- <input type="text" name="ansList[statL.index].testQueId" value="${testQue.testNum}" /> --%>
						<!-- 1~10번  -->
                        <c:choose>
				           <c:when test="${not empty testQue.pasgList }">

				             <!-- testPasg : 지문번호아이디(testPasgId) -->
				              <c:forEach var="testPasg" items="${testQue.pasgList}" >
				              	 <%-- console.log(${ testPasg.testPasgId }); --%>
				              	 <!-- 주관식 객관식 구분   -->
				    			 <c:choose>
				              		<c:when test="${testPasg.queType == '객관식'}">
						               <div class="rc-wrap">
											<div class="rc-inner">
												<input type="radio" id="checkbox${testPasg.testPasgId}" name="${testPasg.testQueId}">
												<label for="checkbox${testPasg.testPasgId}">${testPasg.testPasg}</label>
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<label for="textarea${testPasg.testPasgId}" class="sr-only"></label>
										<textarea id="textarea${testPasg.testPasgId}" name="${testPasg.testQueId}"></textarea>
									</c:otherwise>
									</c:choose>
				              </c:forEach>
				           </c:when>
				           <c:otherwise>
				              	문제 없음
				           </c:otherwise>
			        	</c:choose> 
			        </li>
              </c:forEach>
           </c:when>
           <c:otherwise>
              		문제 없음
           </c:otherwise>
        </c:choose>
		</ul>
		
		<div class="btn-wrap right">
			<button type="button" class="btn default">목록</button>
			<button type="submit" class="btn purple">제출</button>
		</div>
		</form:form>
		
	</div>
	<!-- //  white-box -->

		
</div>

