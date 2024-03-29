<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>Basic Table<button type="button" class="star on"><span class="sr-only">즐겨찾기</span></button></h2>
		<!--cont-navi-->
		<div class="cont-navi">
			<span>home</span> <i class="bi bi-house-door-fill"></i>
			<strong>path1</strong> 
			<strong>path2</strong> 
			<strong>path3</strong>
			<strong>path4</strong>
		</div>
		<!--end cont-navi-->
	</div>
	<!-- end cont-title -->



	<div class="white-box">

		<!-- styletab  -->
		<div class="tab-wrap">
		    <!-- tablist  -->
			<ul class="tab tab-1dep" role="tablist">
				<li class="on"><a class="active tab1" href="${pageContext.request.contextPath}/style/cmpt.do" id="">테이블</a></li>
				<li><a  class="nav-link" href="${pageContext.request.contextPath}/style/tab.do">탭</a></li>
			</ul>
			<!--  // tablist  -->	
		</div>
		<!--  // styletab  -->


		<!-- cont-box-inner-->
		<div class="cont-box-inner">
		
			<div class="title">
				<h3>가로테이블</h3>
				<p class="highlight red-txt"><em class="red-txt">*</em>는 필수입력사항입니다.</p>
				<div class="box-btn">
					<button type="button" class="btn default">삭제</button>
					<button type="button" class="btn default">수정</button>
					<button type="button" class="btn purple">등록</button>
				</div>
			</div>
			
			<div class="tbl-wrap">
				<table class="tbl">
					<caption>description about table</caption>
					<colgroup>
						<col style="width: 7%;">
						<col style="width: 20%;">
						<col style="width: 7%;">
						<col style="width: 20%;">
						<col style="width: 7%;">
						<col style="width: 20%;">
						<col style="width: 7%;">
						<col style="width: 20%;">
					</colgroup>
					<tbody>
						<tr>
							<th>라디오버튼<em class="red-txt">*</em></th>
							<td>
								<!-- 라디오버튼 -->
								<div class="rc-wrap">
		                            <div class="rc-inner"><input type="radio" id="radio1" name="radio-group" checked=""><label for="radio1">전체</label></div>
		                            <div class="rc-inner"><input type="radio" id="radio2" name="radio-group" checked=""><label for="radio2">세금계산서</label></div>
		                            <div class="rc-inner"><input type="radio" id="radio3" name="radio-group" checked=""><label for="radio3">계산서</label></div>
		                        </div>	
		                        <!-- // 라디오버튼 -->
							</td>
							<th>SELECT박스<em class="red-txt">*</em></th>
							<td>
								<!-- SELECT -->
								<select id="select2">
		                            <option>sss</option>
		                            <option>sss</option>
		                        </select>
		                        <!-- // SELECT -->
							</td>
							<th>INPUT<em class="red-txt">*</em></th>
							<td>
								<input type="text">
							</td>
							<th>체크박스<em class="red-txt">*</em></th>
							<td>
								<!-- 체크박스  -->
								<div class="rc-wrap">
									<div class="rc-inner">
										<input type="checkbox" id="checkbox44444" name="radio-group">
										<label for="checkbox44444">선택1</label>
									</div>
									<div class="rc-inner">
										<input type="checkbox" id="checkbox4" name="radio-group">
										<label for="checkbox4">선택2</label>
									</div>
								</div>

                            	<!-- // 체크박스   -->
                            
							
							</td>
						</tr>
						<tr>
							<th>spinner<em class="red-txt">*</em></th>
							<td>
								 <!--spinner-->
                                  <div class="tbl-basic-td spinner-inner">
                                      <label class="sr-only">year</label>
                                      <input type="number" pattern="[0-9]*" class="spinner" name="value" value="2020" min="1" max="" step="1" oninput="maxLengthCheck(this)" maxlength="4">
                                  </div>
                                  <!--end spinner-->
							</td>
							<th>달력<em class="red-txt">*</em></th>
							<td>
							
								<!--달력-->
                                <div class="flex">
                                    <div class=" calendar-wrap">
                                        <label class="calendar" for="dateFrom" title="from"><i class="icon material-icons">calendar_today</i><span class="sr-only">날짜선택(시작)</span></label>
                                        <input type="text" id="dateFrom" class="datepicker" value="" autocomplete="off">
                                    </div>
                                    <span class="cal-dash"></span>
                                    <div class=" calendar-wrap">
                                        <label class="calendar" for="dateTo" title="to"><i class="icon material-icons">calendar_today</i><span class="sr-only">날짜선택(끝)</span></label>
                                        <input type="text" id="dateTo" class="datepicker" value="" autocomplete="off">
                                    </div>
                                </div>
                                <!-- //달력-->
							
							</td>
							<th>tit<em class="red-txt">*</em></th>
							<td colspan="3">우편번호 정보 업데이트</td>
						</tr>
						<tr>
							<th>tit<em class="red-txt">*</em></th>
							<td>우편번호 정보 업데이트</td>
							<th>tit<em class="red-txt">*</em></th>
							<td colspan="5">우편번호 정보 업데이트</td>
						</tr>
						<tr>
							<th>tit<em class="red-txt">*</em></th>
							<td colspan="7">우편번호 정보 업데이트</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- end cont-box-inner-->

			
			
			<!-- cont-box-inner -->
			<div class="cont-box-inner">
			
				<div class="title">
					<h3>가로테이블</h3>
					<p class="highlight red-txt"><em class="red-txt">*</em>는 필수입력사항입니다.</p>
					<div class="box-btn">
						<button type="button" class="btn default">삭제</button>
						<button type="button" class="btn default">수정</button>
						<button type="button" class="btn purple">등록</button>
					</div>
				</div>
				
				<div class="tbl-wrap">
	               <table class="tbl">
	                   <caption></caption>
	                   <colgroup>
	                       <col style="width: 150px;">
	                       <col style="width: 150px;">
	                       <col style="width: auto;">
	                       <col>
	                   </colgroup>
	                   <tbody>
	                       <tr>
	                           <th scope="row">기준일자<em class="red-txt asterisk">*</em></th>
	                           <td colspan="3">
	                               <div class="display-tbl">
	                                   <div class="display-tblCell">
	
	                                   </div>
	                               </div>
	                           </td>
	                       </tr>
	                       <tr>
	                           <th scope="row" rowspan="2">제목1<em class="red-txt asterisk">*</em></th>
	                           <th scope="row">제목2-1<em class="red-txt asterisk">*</em></th>
	                           <td colspan="2">
	                               <div class="display-tbl">
	                                   <div class="display-tblCell">
	                                       내용
	                                   </div>
	                               </div>
	                           </td>
	                       </tr>
	                       <tr>
	                           <th scope="row">제목2-1<em class="red-txt asterisk">*</em></th>
	                           <td colspan="2">
	                               <div class="display-tbl">
	                                   <div class="display-tblCell">
	                                       내용
	                                   </div>
	                               </div>
	                           </td>
	
	                       </tr>
	                   </tbody>
	               </table>
	           </div>
           </div>
			

			


			<!-- cont-box-inner -->
			<div class="cont-box-inner">
				<div class="title">
					<h3>Title</h3>
					<span class="total"><em>1</em>건</span>
					<div class="box-btn">
						<button type="button" class="btn default">수정</button>
						<button type="button" class="btn default">삭제</button>
						<button type="button" class="btn purple">등록</button>
					</div>
				</div>
				<!--tbl-->
				<div class="tbl-wrap">
					<table class="tbl center">
						<caption>description about table</caption>
						<colgroup>
							<col style="width: 10%" />
							<col style="width: 20%" />
							<col style="width: 10%" />
							<col style="width: 20%" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">기안자 소속</th>
								<th scope="col">기안자</th>
								<th scope="col">신청일자</th>
								<th scope="col">강의실 배정 완료 여부</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<!-- 체크박스 -->
									<div class="rc-wrap">
										<input type="checkbox" id="checkbox5" name="radio-group">
										<label for="checkbox5"><span class="sr-only">선택</span></label>
									</div>
									<!-- // 체크박스 -->
								</td>
								<td>컴퓨터 융합학과</td>
								<td>이규철</td>
								<td>
									<button type="button" class="btn btn-s primary">삭제</button>
									<button type="button" class="btn btn-s purple">수정</button>
								</td>
								
							</tr>
							<tr>
								<td>
									<!-- 체크박스 -->
									<div class="rc-wrap">
										<input type="checkbox" id="checkbox6" name="radio-group">
										<label for="checkbox6"><span class="sr-only">선택</span></label>
									</div>
									<!-- // 체크박스 -->
								</td>
								<td class="left">우편번호 정보 업데이트</td>
								<td>정회성</td>
								<td>2014-10-30</td>
							
							</tr>
							<tr>
								<td>
									<!-- 체크박스 -->
									<div class="rc-wrap">
										<input type="checkbox" id="checkbox7" name="radio-group">
										<label for="checkbox7"><span class="sr-only">선택</span></label>
									</div>
									<!-- // 체크박스 -->
								</td>
								<td class="left">우편번호 정보 업데이트</td>
								<td>정회성</td>
								<td>2014-10-30</td>
							</tr>
							<tr>
								<td>
									<!-- 체크박스 -->
									<div class="rc-wrap">
										<input type="checkbox" id="checkbox8" name="radio-group">
										<label for="checkbox8"><span class="sr-only">선택</span></label>
									</div>
									<!-- // 체크박스 -->
								</td>
								<td class="left">우편번호 정보 업데이트</td>
								<td>정회성</td>
								<td>2014-10-30</td>
							</tr>
						</tbody>

					</table>
				</div>
				<!--end tbl-->
				
						
				<!-- 페이지 네비게이션 -->
				<div class="pagination_block">
					<ul class='pagination'>
					    <li class='page-item'>
					        <a class='page-link' href="javascript:void(0);" aria-label='처음'>
					        <span aria-hidden='true'>&laquo;</span><span class='sr-only'>처음</span>
					        </a>
					    </li>
					    <li class='page-item'>
					        <a class='page-link' href="javascript:void(0);" title='1 페이지로 이동'>1</a>
					     </li>
					     <li class='page-item'><a class='page-link' href="javascript:void(0);" title='2 페이지로 이동'>2</a></li>
					     <li class='page-item'><a class='page-link' href="javascript:void(0);" title='3 페이지로 이동'>3</a></li>
					     <li class='page-item active'><a class='page-link' href='#' title='현재 페이지'>4</a></li>
					     <li class='page-item'><a class='page-link' href="javascript:void(0);" title='5 페이지로 이동'>5</a></li>
					      <li class='page-item'><a class='page-link' href="javascript:void(0);" aria-label='다음'>
					            <span aria-hidden='true'>&gt;</span><span class='sr-only'>다음</span></a>
					      </li>
					     <li class='page-item'>
					        <a class='page-link' href="javascript:void(0);" aria-label='마지막'>
					         <span aria-hidden='true'>&raquo;</span><span class='sr-only'>마지막</span></a>
					     </li>
					</ul>	
				</div>
				<!-- //페이지 네비게이션 -->
				
				
				
				
			</div>
			<!-- end cont-box-inner -->
			
			
			
			
			<!-- cont-box-inner  -->
			<div class="cont-box-inner">
                <div class="title ">
                    <h3>Button</h3>
                </div>
                <div>
                    <button type="button" class="btn default">default</button>
                    <button type="button" class="btn primary">primary</button>
                    <button type="button" class="btn purple">purple</button>
                    <button type="button" class="btn success">success</button>
                    <button type="button" class="btn info">info</button>
                    <button type="button" class="btn orange">orange</button>
                    <button type="button" class="btn red">red</button>
                    <button type="button" class="btn disable">disable</button>
                    <button type="button" class="btn disable">disable</button>
                    <button type="button" class="btn default btn-pd"><i class="excel-icon"></i>excel</button>
                    <button type="button" class="btn default btn-pd"><i class="pdf-icon"></i>PDF</button>
                </div>
                <div style="margin-top: 5px;">
                    <button type="button" class="btn btn-s default">default</button>
                    <button type="button" class="btn btn-s primary">primary</button>
                    <button type="button" class="btn btn-s purple">purple</button>
                    <button type="button" class="btn btn-s success">success</button>
                    <button type="button" class="btn btn-s info">info</button>
                    <button type="button" class="btn btn-s orange">orange</button>
                    <button type="button" class="btn btn-s red">red</button>
                    <button type="button" class="btn btn-s disable">disable</button>
                    <button type="button" class="btn default btn-s btn-pd"><i class="excel-icon"></i>excel</button>
                    <button type="button" class="btn default btn-s btn-pd"><i class="pdf-icon"></i>PDF</button>
                </div>
            </div>
            <!--  // cont-box-inner  -->
			
			
			
			
			
			
			
			
			
		</div>


	</div>
	
</div>
	
