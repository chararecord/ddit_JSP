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
						<i class="xi-sun"></i><span id="weatherSKY">맑음</span>, <!--<span id="weatherRN1"></span>mm / --><span id="weatherREH">0</span>%
						<div style="margin-top: 3px;font-size: 8px;">데이터출처 : 기상청</div>
					</div>
				</div>
				<div class="date-wrap">
					<span class="date"><span id="timeAMPM">PM</span> <span class="time" id="timeHM">09:45</span></span>
					<p class="detail-date" id="dateYMD">2023년 1월 29일 일요일</p>
				</div>
			</div>
		</div>
		<div class="right">
			<button class="p-login"><i><img src="images/m_login_icon.svg" alt=""></i>Login</button>
			<div class="login-wrap">
				<span class="tit">&nbsp;<span class="bold">Login</span></span>
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
						<a href="/html/main/findid.html" class="find-pass">아이디 or 패스워드 찾기</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<div class="main-cont-wrap">
		<div class="app-list">
			<div class="list">
				<a href="" target="_blank" class="app-box">
					<span class="app-icon icon13"><img src="${pageContext.request.contextPath}/resources/images/login/app_icon13.svg" alt="도서관"></span>
					도서관
				</a>
			</div>
		</div>

		
	</div>

	<footer class="footer">
		<div class="inner">
			<div class="bot-list">
				<a href="" target="_blank"><i><img src="${pageContext.request.contextPath}/resources/images/login/bot_icon01.svg" alt="개인정보처리방침 아이콘"></i>개인정보처리방침</a>
			</div>
			<div class="bot-list">
				<a href="" target="_blank"><i><img src="${pageContext.request.contextPath}/resources/images/login/bot_icon04.svg" alt=""></i>입학안내홈페이지</a>
			</div>
			<div class="bot-list">
				<a href="" target="_blank"><i><img src="${pageContext.request.contextPath}/resources/images/login/bot_icon04.svg" alt=""></i>동아리안내</a>
			</div>
			<div class="bot-list">
				<a href="" target="_blank"><i><img src="${pageContext.request.contextPath}/resources/images/login/bot_icon04.svg" alt=""></i>오시는길안내</a>
			</div>
		</div>
		<button class="btn-msg"><img src="${pageContext.request.contextPath}/resources/images/login/icon_msg.svg" alt=""></button>
	</footer>