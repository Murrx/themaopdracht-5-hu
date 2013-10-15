$(function () {
	$(".navbar-toggle").click(function() {
		$("#login-form").toggle();
	});
	$('#register_birthdate').datepicker({viewMode: 2});
	$('nav .active').click(function(event) {
		event.preventDefault();
	});
	$("#auction_end_time").datetimepicker({
		format: 'dd-mm-yyyy hh:ii',	//Date time format
		startDate: new Date(),		//Disable selectoin of date/time before 'now'.
	//	endDate: new Date("November 7, 2013 15:00"), //Disable selectoin of date/time after 'date'.
		weekStart: 1, 				//Start week on monday.
		autoclose: true,			//Close datetimepicker after date+time is selected
	});
});

