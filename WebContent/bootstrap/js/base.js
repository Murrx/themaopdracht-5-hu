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
	if($('#startDateRange').length != 0) {
		$('#startDateRange').daterangepicker({
			startDate: moment(),
			endDate: moment(),
			showDropdowns: true,
			showWeekNumbers: true,
			timePicker: false,
			timePickerIncrement: 1,
			timePicker12Hour: true,
			ranges: {
				'Today': [moment(), moment()],
				'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
				'Last 7 Days': [moment().subtract('days', 6), moment()],
				'Last 30 Days': [moment().subtract('days', 29), moment()],
				'This Month': [moment().startOf('month'), moment().endOf('month')],
				'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
			},
			opens: 'left', 
			buttonClasses: ['btn btn-default'],
			applyClass: 'btn-small btn-primary',
			cancelClass: 'btn-small',
			format: 'DD/MM/YYYY',
			separator: ' to ',
			locale: {
				applyLabel: 'Submit',
				fromLabel: 'From',
				toLabel: 'To',
				customRangeLabel: 'Custom Range',
				daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr','Sa'],
				monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
				firstDay: 1
			}
		},
			function(start, end) {
				console.log("Callback has been called!");
				$('#startDateRange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
			}
		);
	}
	if($('#endDateRange').length != 0) {
		$('#endDateRange').daterangepicker({
			startDate: moment(),
			endDate: moment(),
			showDropdowns: true,
			showWeekNumbers: true,
			timePicker: false,
			timePickerIncrement: 1,
			timePicker12Hour: true,
			ranges: {
				'Today': [moment(), moment()],
				'Tomorrow': [moment().add('days', 1), moment().add('days', 1)],
				'Next 7 Days': [moment().add('days', 6), moment()],
				'Last 30 Days': [moment().add('days', 29), moment()],
				'This Month': [moment().startOf('month'), moment().endOf('month')],
				'Next Month': [moment().add('month', 1).startOf('month'), moment().add('month', 1).endOf('month')]
			},
			opens: 'left', 
			buttonClasses: ['btn btn-default'],
			applyClass: 'btn-small btn-primary',
			cancelClass: 'btn-small',
			format: 'DD/MM/YYYY',
			separator: ' to ',
			locale: {
				applyLabel: 'Submit',
				fromLabel: 'From',
				toLabel: 'To',
				customRangeLabel: 'Custom Range',
				daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr','Sa'],
				monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
				firstDay: 1
			}
		},
			function(start, end) {
				console.log("Callback has been called!");
				$('#endDateRange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
			}
		);
	}
});

