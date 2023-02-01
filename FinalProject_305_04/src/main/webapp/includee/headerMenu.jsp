<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

 <nav class="sb-topnav navbar navbar-expand">

 <!-- Navbar-->
   <!--          <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
 -->









	 <!-- Navbar Search-->
     <div class="header-left">
         <div class="search-wrap">
             <input class="form-control search-input" type="text" placeholder="메뉴를 입력해주세요" aria-label="Search for..." aria-describedby="btnNavbarSearch" />
             <button class="btn" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
         </div>
     </form>

     <!-- util  -->
     <div class="util">
    
    	<a href="${pageContext.request.contextPath}/login.do">로그인</a>
    
    
    	 <div class="login-session">
    	 	<span>53:33</span>
    	 	<a href="javascript:void(0);">로그인 연장</a>
    	 </div> 

         <!--알람 있을 경우 -->
         <button type="button" id="bell" class="item icon bell no_anime" title="알림"><span class="num"></span></button>
         <!-- //알람 있을 경우-->
         <!-- 알람 없을 경우 -->
         <!-- <button type="button" id="bell" class="item icon bell" title="알림"><span class="sr-only">알림</span></button> -->
         <!--  //알람 없을 경우 -->
         
         <div class="dropdown">
         	 <span class="profile"><img src="" alt=""></span>
             <a class="dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             	<strong class="person-name">이선민</strong>
             	<span class="person-info">컴퓨터공학과 | 1215190 </span> 
             </a>
             <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                 <li><a class="dropdown-item" href="#!">마이페이지 </a></li>
                 <li><a class="dropdown-item" href="#!">Logout</a></li>
             </ul>
         </div>
     </div>
     <!-- // util  -->
     
     
     
     
     
     
     
     
 
    
 </nav>
