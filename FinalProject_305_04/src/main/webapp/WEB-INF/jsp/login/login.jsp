<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">		
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">   

<div id="wrap">
		<div class="gr-bg"></div>
		<div class="top-line">
			<div class="left">
				<div class="inner-top">
					<h1 class="logo">
					<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="대재대학교"></h1>
			</div>
			<div class="inner-bot">
				<div class="weather">
					<span class="b-temp" id="weatherT1H">0</span>
					<div class="detail-temp">
						<i class="bi bi-brightness-high"></i><span id="weatherSKY">맑음</span>, <!--<span id="weatherRN1"></span>mm / --><span id="weatherREH">0</span>%
						<div style="margin-top: 3px;font-size: 12px;">데이터출처 : 기상청</div>
					</div>
				</div>
				<div class="date-wrap">
					<span class="date"><span id="timeAMPM">PM</span> <span class="time" id="timeHM">09:45</span></span>
					<p class="detail-date" id="dateYMD">2023년 1월 29일 일요일</p>
				</div>
			</div>
		</div>
		

	
	</div>
	<div class="main-cont-wrap">
	
	
	  <div class="right">
			<button class="p-login"><i><img src="images/m_login_icon.svg" alt=""></i>Login</button>
			<div class="login-wrap">
				<span class="tit"><span class="bold">Login</span></span>
				
				
				<div class="login-type">
					<a href="javascript:void(0);">학생</a>
					<a href="javascript:void(0);">교수</a>
					<a href="javascript:void(0);">교직원</a>
				</div>
				
				
				<form action="javascript:void(0);">
					<fieldset>
						<legend>로그인</legend>
						<div class="input-wrap">
							<label><input type="text" name="id" id="id" class="inputtxt" placeholder="ID"></label>
							<label><input type="password" name="pass" id="pass" class="inputtxt" placeholder="password"></label>
							<button type="button" class="btn-login" id="loginBtn">
							<i class="bi bi-check2"></i>
							</button>
						</div>
						<a href="javascript:void(0);" class="find-pass">아이디 or 패스워드 찾기</a>
					</fieldset>
				</form>
			</div>
		</div>

	
	
		<div class="app-list">
			<div class="list">
				<a href="javascript:void(0);" target="_blank" class="app-box">
					<span class="app-icon icon13"><img src="${pageContext.request.contextPath}/resources/images/login/app_icon13.svg" alt="도서관"></span>
					도서관
				</a>
				<a href="http://hnu.kr/kor/about/about_07_2.html" target="_blank" class="app-box">
						<span class="app-icon icon11"><img src="${pageContext.request.contextPath}/resources/images/login/app_icon11.svg" alt="교내전화번호"></span>
						교내전화번호
				</a>
				<a href="http://job.hannam.ac.kr/main/" target="_blank" class="app-box">
						<span class="app-icon icon14"><img src="${pageContext.request.contextPath}/resources/images/login/app_icon14.svg" alt="취업"></span>
						취업
				</a>
				<a href="https://www.instagram.com/hannam_university/?hl=ko" target="_blank" class="app-box">
						<span class="app-icon icon06"><img src="${pageContext.request.contextPath}/resources/images/login/app_icon04.svg" alt="instagram"></span>
						instagram
				</a>
				<a href="http://hnu.kr/kor/guide/guide_06_1.html" target="_blank" class="app-box">
						<span class="app-icon icon03"><img src="${pageContext.request.contextPath}/resources/images/login/app_icon03.svg" alt="증명서발급"></span>
						증명서발급
				</a>
				<a href="http://www.hannam.ac.kr/data/building.html" target="_blank" class="app-box">
						<span class="app-icon icon07"><img src="${pageContext.request.contextPath}/resources/images/login/app_icon05.svg" alt="캠퍼스맵"></span>
						캠퍼스맵
				</a>
			</div>
		</div>

		
	</div>

	<footer class="footer">
		<div class="inner">
			<div class="bot-list">
				<a href="javascript:void(0);" target="_blank"><i><img src="${pageContext.request.contextPath}/resources/images/login/bot_icon01.svg" alt="개인정보처리방침 아이콘"></i>개인정보처리방침</a>
			</div>
			<div class="bot-list">
				<a href="javascript:void(0);" target="_blank"><i><img src="${pageContext.request.contextPath}/resources/images/login/bot_icon04.svg" alt=""></i>입학안내홈페이지</a>
			</div>
			<div class="bot-list">
				<a href="javascript:void(0);" target="_blank"><i><img src="${pageContext.request.contextPath}/resources/images/login/bot_icon04.svg" alt=""></i>동아리안내</a>
			</div>
			<div class="bot-list">
				<a href="javascript:void(0);" target="_blank"><i><img src="${pageContext.request.contextPath}/resources/images/login/bot_icon04.svg" alt=""></i>오시는길안내</a>
			</div>
		</div>
		<button class="btn-msg"><img src="${pageContext.request.contextPath}/resources/images/login/icon_msg.svg" alt=""></button>
	</footer>