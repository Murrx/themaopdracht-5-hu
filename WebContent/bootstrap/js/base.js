$(function () {
	$(".navbar-toggle").click(function() {
		$("#login-form").toggle();
	});
	$('#register_birthdate').datepicker({viewMode: 2});
	$('nav .active').click(function(event) {
		event.preventDefault();
	});
	$('#auction_end_time').datepicker({viewMode: 2});  
});

