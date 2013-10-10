$(function () {
	$(".navbar-toggle").click(function() {
		$("#login-form").toggle();
	});
	$('#register_birthdate').datepicker({viewMode: 2});
	$('#auction_end_time').datepicker({viewMode: 2});  
});

