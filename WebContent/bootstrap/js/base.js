$(function () {
	if($(".user-box-mine, .user-box-edit").length != 0) {
		$(".user-box-mine, .user-box-edit").tooltip({placement: "bottom", container: "body"});
	}
	$(".navbar-toggle").click(function() {
		$("#login-form").toggle();
	});
	$('nav .active').click(function(event) {
		event.preventDefault();
	});
	if($('#register_birthdate').length != 0) {
		$('#register_birthdate').datetimepicker({
			format: 'dd-mm-yyyy',
			viewMode: 2
		});
	}
	if($('#edit_birthdate').length != 0) {
		$('#edit_birthdate').datetimepicker({
			format: 'dd-mm-yyyy',
			viewMode: 2
		});
	}
	if($('#auction_end_time').length != 0) {
		$("#auction_end_time").datetimepicker({
			format: 'dd-mm-yyyy hh:ii',	//Date time format
			startDate: new Date(),		//Disable selectoin of date/time before 'now'.
		//	endDate: new Date("November 7, 2013 15:00"), //Disable selectoin of date/time after 'date'.
			weekStart: 1, 				//Start week on monday.
			autoclose: true,			//Close datetimepicker after date+time is selected
		});
	}
	if($('.auction').length != 0) {
		$('.auction .panel-body').click(function(event) {
			id = $(this.parentNode).data('id');
			window.location.href = 'viewAction.action?id=' + id;
		});
	}
});

