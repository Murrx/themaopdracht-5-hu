

function GetCount(dateStart, dateEnd, iid){

	dateNow = new Date();	//grab current date
	amount = dateEnd.getTime() - dateNow.getTime();	//calc milliseconds between dates

	// if time is already past
	if (dateEnd.getTime() < dateStart.getTime()){
		document.getElementById(iid).innerHTML="This auction is corrupt.";
	} else if (dateStart.getTime() > dateNow.getTime()) {
		document.getElementById(iid).innerHTML="This auction has yet to start.";
	} else if (dateEnd.getTime() < dateNow.getTime()){
		document.getElementById(iid).innerHTML="This auction has ended.";
	}
	// else date is still good
	else{
		days=0;hours=0;mins=0;secs=0;out="time ";

		amount = Math.floor(amount/1000);//kill the "milliseconds" so just secs

		days=Math.floor(amount/86400);//days
		amount=amount%86400;

		hours=Math.floor(amount/3600);//hours
		amount=amount%3600;

		mins=Math.floor(amount/60);//minutes
		amount=amount%60;

		secs=Math.floor(amount);//seconds

		if (days > 1) {
			out = days+" days";
		} else if (days != 0) {
			out = days+" day and "+hours+" hours";
		} else if (hours != 0) {
			out = hours+" hours and "+mins+" minutes";
		} else {
			out = mins+" minutes and "+secs+" seconds";
		}
		out += " left";
		// old countdown
		/*out += (days<=9?'0':'')+days+":";
		out += (hours<=9?'0':'')+hours +":";
		out += (mins<=9?'0':'')+mins +":";
		out += (secs<=9?'0':'')+secs;
		*/
		document.getElementById(iid).innerHTML = out;
		
		setTimeout(function(){GetCount(dateStart, dateEnd, iid);}, 1000);
	}
}

/**
 * Method for updating the percentages shown in the auctions.
 * The update is real-time, every 1000 miliseconds.
 * Percentages are rounded to the nearest integer value.
 * 
 * @param dateStart The starting date of the auction
 * @param dateEnd The ending date of the auction
 * @param iid Id of the element that shows the percentage as a text
 * @param barid Id of the progress bar that shows the percentage as a progress-bar for this auction
 */
function GetPercentage(dateStart, dateEnd, iid, barid){

	dateNow = new Date();	//grab current date
	percentage = 0;
	
	$('barid').css('width', '100%');
	
	widthToSet = 100;

	// if time is already past
	if (dateEnd.getTime() < dateStart.getTime()){
		percentage = "ERROR";
		document.getElementById(barid).className += " progress-bar-warning";
	} else if (dateStart.getTime() > dateNow.getTime()) {
		percentage=0;
		document.getElementById(barid).className += " progress-bar-success";
	} else if (dateEnd.getTime() < dateNow.getTime()){
		percentage=100;
		document.getElementById(barid).className += " progress-bar-danger";
	}
	// else date is still good
	else{
		percentage = Math.round(100*((dateNow.getTime()-dateStart.getTime())/(dateEnd.getTime()-dateStart.getTime())));
		document.getElementById(barid).style.width=percentage+"%";
	}
	document.getElementById(iid).innerHTML = percentage;
	setTimeout(function(){GetPercentage(dateStart, dateEnd, iid, barid);}, 1000);
}