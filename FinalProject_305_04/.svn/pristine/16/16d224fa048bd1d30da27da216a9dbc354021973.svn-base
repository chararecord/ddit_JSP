$(function(){

    
    /** * 즐겨찾기 메뉴 ** */
    $(".star").click(function () {
        if ($(this).hasClass('on')) {
            $(this).removeClass('on');
        } else {
            $(this).addClass('on');

        }
    });
    
    

    /** SPINNER* */
    function spinner() {
        $(".spinner").spinner();
        // INPUT ONLY NUMBERS
        $('.spinner').keyup(function () {
            this.value = this.value.replace(/[^0-9]/g, '');
        });
    }
    // INPUT NUMBER MAX LENGHT
    function maxLengthCheck(object) {
        if (object.value.length > object.maxLength)
            object.value = object.value.slice(0, object.maxLength)
    }
    window.onload = spinner;
    
    
    
    /* 달력 */
    // datepicker
    $('.datepicker').datepicker({
        format: 'dd-mm-yyyy',
        startDate: '+1d'
    });
    $.datepicker.setDefaults({
        dateFormat: 'yymmdd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
    
    
    
    // scroll table
    $('.table-scrollable').each(function () {
    	const $this = $(this);
    	const $scrollEl = $('.table-responsive', $this);
    	
    	$scrollEl.on('scroll', () => {
    		$this.toggleClass('table-scrollable--scrolled-x', !!$scrollEl.scrollLeft());
    		$this.toggleClass('table-scrollable--scrolled-y', !!$scrollEl.scrollTop());
    	});
    });

    
});