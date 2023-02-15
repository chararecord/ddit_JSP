<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="cont">

	<!-- cont-title -->
	<div class="cont-title">
		<h2>강의평가<button type="button" class="star on"><span class="sr-only">즐겨찾기</span></button></h2>
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
		<div class="tob-box">
			<strong class="tit">강의 평가 안내사항 </strong>
			<p>이 설문은 보다 좋은 강의를 학생분들께 제공하기 위해 실시되는 것입니다.</p>
			<p>익명으로 작성된 여러분의 응답은 성적평가 후 정리되어 교수님의 다음 학기 강의 준비를 위한</p>
			<p>참고자료 및 교육여건 개선을 위한 기초자료로 활용되오니 성실하게 답변하여 주시기 바랍니다.</p><br>
			<p>※각 문항별로 동의하는 정도에 따라 그렇다 ~ 그렇지않다 중 하나를 기재해 주시기 바랍니다.※</p>
		</div>
		
		<div class="cont-box-inner">
			<div class="title">
				<h3>강의 평가 항목</h3>
				<div class="box-btn">
					<button type="button" class="btn purple">등록</button>
				</div>
			</div>
			<!--tbl-->
			<div class="tbl-wrap">
				<table class="tbl center">
					<caption>description about table</caption>
					<colgroup>
						<col style="width: 5%">
						<col style="width: 40%">
						<col style="width: 5%">
						<col style="width: 5%">
						<col style="width: 5%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">순번</th>
							<th scope="col">평가문항</th>
							<th scope="col">그렇다</th>
							<th scope="col">보통</th>
							<th scope="col">그렇지않다</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>수업의 내용은 좋았나요?</td>
							<td>
								<div class="rc-wrap">
									<input type="radio" id="radio1" name="radio-group">
									<label for="radio1"><span class="sr-only">선택</span></label>
								</div>
							</td>
							<td>
								<div class="rc-wrap">
									<input type="radio" id="radio1" name="radio-group">
									<label for="radio1"><span class="sr-only">선택</span></label>
								</div>
							</td>
							<td>
								<div class="rc-wrap">
									<input type="radio" id="radio1" name="radio-group">
									<label for="radio1"><span class="sr-only">선택</span></label>
								</div>
							</td>
						</tr>
						<tr>
							<td>8</td>
							<td colspan="4">이 강의에서 대해 개선점이나 좋았던 점을 말해주세요.</td>
						</tr>
						<tr>
							<td colspan="5">
								<input type="text" class="w100">
							</td>
						</tr>
					</tbody>

				</table>
			</div>
			<!--end tbl-->
		</div>
	</div>
</div>
	
