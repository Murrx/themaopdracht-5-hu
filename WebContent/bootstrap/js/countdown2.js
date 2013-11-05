/**
 * 
 */

(function updateProgressBars() {
	$('.auction').each(function() {
		$this = $(this);
		now = new Date();
		startDate = new Date($this.data('start-year'),$this.data('start-month'),$this.data('start-day'),$this.data('start-hour'),$this.data('start-min'));
		endDate = new Date($this.data('end-year'),$this.data('end-month'),$this.data('end-day'),$this.data('end-hour'),$this.data('end-min'));
		
		if(endDate < startDate) {
			message = "This auction is corrupt.";
			$this.find('.progress')
			.removeClass('progress-striped active')
			.find('.progress-bar')
			.addClass('progress-bar-warning');
		} else if(startDate > now) {
			message = "This auction will start soon!";
			$this.find('.progress-bar')
			.addClass('progress-bar-success');
		} else if(endDate < now) {
			message = "This auction has ended.";
			percentage = 100;
			$this.find('.progress')
			.removeClass('progress-striped active')
			.find('.progress-bar')
			.addClass('progress-bar-danger');
		} else {
			message = "";
			amount = (endDate.getTime() - now.getTime()) / 1000;
			
			var days, hours, mins, secs = 0;

			days=Math.floor(amount/86400);//days
			amount=amount%86400;
			hours=Math.floor(amount/3600);//hours
			amount=amount%3600;
			mins=Math.floor(amount/60);//minutes
			amount=amount%60;
			secs=Math.floor(amount);//seconds

			if (days > 1) {
				message = days+" days";
			} else if (days != 0) {
				message = days+" day and "+hours+" hour";
				if(hours!=1) message+="s";
			} else if (hours >= 1) {
				message = hours+" hour"; if(hours!=1) message+="s";
				message += " and "+mins+" minute"; if(mins!=1) message+="s";
			} else if (mins >= 1) {
				message = mins+" minute"; if(mins!=1) message+="s";
				message += " and "+secs+" second"; if(secs!=1) message+="s";
			} else {
				message = secs+" second"; if(secs!=1) message+="s";
			}
			message += " left";			
			percentage = (100*(now.getTime()-startDate.getTime())/(endDate.getTime()-startDate.getTime())).toFixed(1);
			$this.find('.progress-bar')
			.removeClass('progress-bar-success')
			.css('width', percentage + "%");
		}

		$this.find('.progress-bar-label').html(message);
	});
	
		
	setTimeout(updateProgressBars, 100);
})()

