<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

  

  
     
<nav class="sb-sidenav accordion sb-sidenav-dark">

	<a class="navbar-brand" href="${pageContext.request.contextPath}/">
     	<span><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="" /></span>
     </a>
   
	<!-- tablist  -->
	<div class="tab-wrap"  id="nav-tab" role="tablist">
		<a class="active" href="javascript:void(0);" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">공통메뉴</a>
		<a  class="nav-link" href="javascript:void(0);" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">즐겨찾기</a>
	</div>
	<!--  // tablist  -->

	<!--  tabContent -->
	<div class="sb-sidenav-common tab-content" id="nav-tabContent">

		<!-- 공통메뉴 -->
		<div class="tab-pane active show" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
			 <a class="nav-link" href="${pageContext.request.contextPath}/style/cmpt.do">
	          	<div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
				공통스타일
	         </a>
			 <a class="nav-link" href="javascript:void(0);">
	          	<div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
				공지사항 
	         </a>
	         <a class="nav-link" href="javascript:void(0);">
	          	<div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
				학교뉴스
	         </a>
	         <a class="nav-link" href="javascript:void(0);">
	          	<div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
				시설대여
	         </a>
	         <a class="nav-link" href="javascript:void(0);">
	          	<div class="sb-nav-link sb-nav-link-icon"><i class="bi bi-building-fill-exclamation"></i></div>
				취업지원센터
	         </a>
         </div>
         
         <!-- 즐겨찾기  -->
         <div class="tab-pane" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
			<p class="center">즐겨찾기 메뉴가 없습니다.</p>
         </div>
	</div>
	<!-- // tabContent -->
	


	<!-- sidenav-menu -->
	<div class="sidenav-menu-wrap "  id="sidenavAccordion">
	    <div class="sb-sidenav-menu mScrollbar">
	      
	      
	      
	       <!--  학생일 경우 -->
	        <!-- <div class="nav">
				
	        	<a class="nav-link" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts1" aria-expanded="true" aria-controls="collapseLayouts1">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>
	               	 수강관리
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse show" id="collapseLayouts1" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">수강중인 강의</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">사전수강신청</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">수강신청</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">강의 공지사항</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">강의 자료실</a>
	                </nav>
	            </div>
	       
	            <a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>과제</a>
	            <a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>시험</a>
	          	
	          	<a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts2" aria-expanded="false" aria-controls="collapseLayouts2">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>
	               	학적관리
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts2" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">휴학 신청</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">복학신청</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">졸업 신청</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">자퇴 신청</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">학적 변동 사항 조회</a>
	                </nav>
	            </div>
	            
	            
	            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts3" aria-expanded="false" aria-controls="collapseLayouts3">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>
	               	상담 관리
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts3" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">상담 신청</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">상담 이력 조회</a>
	                </nav>
	            </div>
	            
	            
	            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts4" aria-expanded="false" aria-controls="collapseLayouts4">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>
	               	성적/평가
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts4" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">성적 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">성적 이의 신청</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">강의평가 등록</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">학점 취득 현황 관리</a>
	                </nav>
	            </div>
	
	
				
	            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts5" aria-expanded="false" aria-controls="collapseLayouts5">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="bi bi-mortarboard-fill"></i></div>
	               	등록/장학
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts5" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">등록금고지서 조회</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">납입 증명서 조회</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">장학금수혜내역조회</a>
	                </nav>
	            </div>
	        </div>  -->
	        
	        
	        <!--  교수일 경우 -->
	       <div class="nav">
	        
	       		<a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>나의 강의실</a>
	            <a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>과제</a>
	            <a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>시험</a>
	          	<a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>수강생 목록</a>
	
	          	<a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts11" aria-expanded="false" aria-controls="collapseLayouts11">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>
	               	학생 관리
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts11" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">학생 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">학적 변경 관리</a>
	                </nav>
	            </div>
	
	
	           <a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>상담 관리</a>
	           <a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>증명서 발급</a>
	        </div>  
	        <!--  // 교수일 경우 -->
	        
	        
	        
	        <!-- 교직원  -->
			<!--  <div class="nav">
			 
	        	<a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts111" aria-expanded="true" aria-controls="collapseLayouts111">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="bi bi-file-text-fill"></i></div>
	               	교무 업무
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts111" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">학사 일정 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">강의 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">강의실 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">졸업 요건 관리</a>
	                </nav>
	            </div>
	            

	       
	            <a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>증명서 발급 관리</a>
	          	
	          	<a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts222" aria-expanded="false" aria-controls="collapseLayouts222">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>
	               	학교 내 정보 관리
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts222" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">학생 정보 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">교수진 정보 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">교직원 정보 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">학과 정보 관리</a>
	                </nav>
	            </div>
	            
	            
	            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts333" aria-expanded="false" aria-controls="collapseLayouts333">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>
	               	게시판 관리
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts333" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">공지사항</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">학사상담(Q&A)</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">학교뉴스</a>
	                </nav>
	            </div>
	            
	            
	            <a class="nav-link collapsed" href="javascript:void(0);" ><div class="sb-nav-link sb-nav-link-icon"><i class="fas fa-columns"></i></div>교내 시설물 관리</a>
	          	
	            
	            <a class="nav-link collapsed" href="javascript:void(0);" data-bs-toggle="collapse" data-bs-target="#collapseLayouts444" aria-expanded="false" aria-controls="collapseLayouts444">
	                <div class="sb-nav-link sb-nav-link-icon"><i class="bi bi-mortarboard-fill"></i></div>
	               	등록금/장학금 관리
	                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
	            </a>
	            <div class="collapse" id="collapseLayouts444" data-bs-parent="#sidenavAccordion">
	                <nav class="sb-sidenav-menu-nested nav">
	                    <a class="nav-link collapsed" href="javascript:void(0);">등록금 관리</a>
	                    <a class="nav-link collapsed" href="javascript:void(0);">장학금 관리</a>
	                </nav>
	            </div>
	        </div> -->
	        <!--  //교직원  -->
	
		        
	
		</div>
    </div>
    <!-- // sidenav-menu -->
    
    

</nav>

