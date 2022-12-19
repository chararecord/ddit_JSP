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

$.fn.sessionTimer = function(sec){
//	parameter로 초를 받는다. 그 초를 60으로 나누고 그 나눈 몫은 분 / 나머지는 초로 환산한다.
//	초가 0이 되는 순간 분을 -- 한다. 분도 0, 초도 0이 되면 session 만료.
//	but 1분이 되는 순간 session을 연장하겠냐는 알림을 띄워야 한다.
//	연장을 하면 다시 리셋, 연장하지 않으면 계속 시간이 간다.
	let area = this;
	setInterval(function(){
		sec--;
		console.log(sec)
		area.html(sec);
		if(sec==60){
			if(confirm("연장ㄱㄱ?")){
				location.reload();
			}
		}
		if(sec==0){
			clearInterval(sessionTimer);
		}
	}, 1000);
	return this;
}