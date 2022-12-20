/**
 * $ = jQuery 객체
 * $.fn. : element를 selecting 한 경우 사용할 수 있는 함수
 * this : 현재 함수의 대상이 되는 element
 * tagName이라는 속성을 가져올 때는 prop 만 가능 (attr x)
 * this : jquery 객체 -> this[0] : dom 객체
 */
$.fn.serializeObject = function(){
	if(this.prop('tagName') != 'FORM'){
		throw Error('form 태그 외에는 사용 불가');
	}
	
	let fd = new FormData(this[0]);
	let nameSet = new Set();
	for(let key of fd.keys()){
		nameSet.add(key); // 중복되는 이름을 가지고 있으면 set이 걸러줌
	}
	let data = {}; // 비어있는 객체
	for(let name of nameSet){ // 3번 돈다
		// get과 getAll의 차이 -> 반환타입이 배열이냐 아니냐
		// getParameter -> String, getParameterValues -> String[]
		let values = fd.getAll(name); // values의 타입은 배열[]
		if(values.length>1){ 		// 값이 1개 이상
			data[name] = values;			
		} else { 					// 값이 1개
			data[name] = values[0];
		}
	}
	return data;
}

/*
 * 폼태그의 모든 입력 데이터의 이름과 값을 콘솔에 로그로 출력할 수 있는 함수
 * ex) $('form').log().serializeObject();
 */

$.fn.log = function(){
	let data = this.serializeObject();
	// of 연산자 + 컬렉션,반복가능 | in 연산자 -> 속성 하나하나 접근가능
	for(let prop in data ){
		console.log(prop + " : " + data[prop]);
	}
	return this; // return this -> 체인구조로 사용 가능
}

$.fn.sessionTimer = function(timeout, msgObj){
	if(!timeout)
		throw Error("세션 타임아웃 값이 없습니다.");
		
	const SPEED = 100;
	const TIMEOUT = timeout;
	const timerArea = this;
	let msgArea = null;
	if(msgObj){
		msgArea = $(msgObj.msgAreaSelectoer).on("click",msgObj.btnSelector,function(event){
			/* 여기서 this는 .controlBtn */
			//		console.log( this.id + ", " + $(this).prop("id") );
			if(this.id=="YES"){
				jobClear();
				timerInit();
				$.ajax({
					method : "head" // 요청이 넘어가는데 필요한 구성요소는 다 포함되어있음
				});
			}
			msgArea.hide();
		}).hide();
	}
	
	let jobClear = function(){
		let timerJob = timerArea.data("timerJob");
		if(timerJob)
			clearInterval(timerJob); // setInterval -> clearInterval
		let msgJob = msgArea.data('msgJob');
		if(msgJob)
			clearTimeout(msgJob); // setTimeout -> clearTimeout
	}
	
	let timerInit = function(){
		if(msgObj){
			let msgJob = setTimeout(() => {
				msgArea.show();
			}, (TIMEOUT-60)*SPEED);
			msgArea.data('msgJob', msgJob); // 데이터 속성은 문자열밖에 못 넣지만 데이터 함수는 원래 타입을 유지함
		}
		
		let timer = TIMEOUT;
		let timerJob = setInterval(() => {
			if(timer==1){
				clearInterval(timerJob);
				location.reload();
			}
			else 
				timerArea.html( timeFormat(--timer) );
		},SPEED);
		timerArea.data("timerJob", timerJob);
	}
	
	timerInit();
	
	let timeFormat = function(time){
		let min = Math.trunc( time / 60 ); // 소수점 이하 자리는 버리고 정수만 취함
		let sec = time % 60;
		return min + " : " + sec
	}
	return this;
}

//$.fn.sessionTimer = function(sec){
////	parameter로 초를 받는다. 그 초를 60으로 나누고 그 나눈 몫은 분 / 나머지는 초로 환산한다.
////	초가 0이 되는 순간 분을 -- 한다. 분도 0, 초도 0이 되면 session 만료.
////	but 1분이 되는 순간 session을 연장하겠냐는 알림을 띄워야 한다.
////	연장을 하면 다시 리셋, 연장하지 않으면 계속 시간이 간다.
//	let area = this;
//	setInterval(function(){
//		sec--;
//		console.log(sec)
//		area.html(sec);
//		if(sec==60){
//			if(confirm("연장ㄱㄱ?")){
//				location.reload();
//			}
//		}
//		if(sec==0){
//			clearInterval(sessionTimer);
//		}
//	}, 1000);
//	return this;
//}