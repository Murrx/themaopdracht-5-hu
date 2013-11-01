/**
 * 
 */

// return percentage
function getPercentage(bidID) {
	dateNow = new Date();	//grab current date
	dateStart = window["startDateAuction"+bidID];
	dateEnd = window["endDateAuction"+bidID];
	percentage = 0;
	
	// if auction is already over, yet to begin, or corrupt 
	if (dateEnd.getTime() < dateStart.getTime()){
		percentage = "ERROR";
	} else if (dateStart.getTime() > dateNow.getTime()) {
		percentage = 0;
	} else if (dateEnd.getTime() < dateNow.getTime()){
		percentage = 100;
	} // else the auction is currently active
	else{
		percentage = (100*((dateNow.getTime()-dateStart.getTime())/(dateEnd.getTime()-dateStart.getTime()))).toFixed(1);
	}
	return percentage;
}

// return message
function getMessage(bidID) {

	dateNow = new Date();	//grab current date
	dateStart = window["startDateAuction"+bidID];
	dateEnd = window["endDateAuction"+bidID];
	
	amount = dateEnd.getTime() - dateNow.getTime();	//calc milliseconds between dates
	message = "";

	// if time is already past
	if (dateEnd.getTime() < dateStart.getTime()){
		message = "This auction is corrupt.";
	} else if (dateStart.getTime() > dateNow.getTime()) {
		message = "This auction will start soon!";
	} else if (dateEnd.getTime() < dateNow.getTime()){
		message = "This auction has ended.";
	}
	// else date is still good
	else{
		days = 0;
		hours = 0;
		mins = 0;
		secs = 0;

		amount = Math.floor(amount/1000);//kill the "milliseconds" so just secs

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
	}
	return message;
}

// animate
function updateGUI(bidID) {
		
		dateNow = new Date();	//grab current date
		dateStart = window["startDateAuction"+bidID];
		dateEnd = window["endDateAuction"+bidID];
		// if time is already past
		if (dateEnd.getTime() < dateStart.getTime()){
			$('#pbar'+bidID).css('width', '100%');
			$('#pbar'+bidID).addClass('progress-bar-warning');
			$('#pbar'+bidID).parent().removeClass('progress-striped active');
		} else if (dateStart.getTime() > dateNow.getTime()) {
			$('#pbar'+bidID).css('width', '100%');
			$('#pbar'+bidID).addClass('progress-bar-success');
		} else if (dateEnd.getTime() < dateNow.getTime()){
			$('#pbar'+bidID).css('width', '100%');
			$('#pbar'+bidID).addClass('progress-bar-danger');
			$('#pbar'+bidID).parent().removeClass('progress-striped active');
		} else {
			$('#pbar'+bidID).removeClass('progress-bar-success');
			$('#pbar'+bidID).css('width', getPercentage(bidID)+'%');
		}

		$('#timer'+bidID).html(getMessage(bidID));
		$('#percent'+bidID).html(getPercentage(bidID));

}

