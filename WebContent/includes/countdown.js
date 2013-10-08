function GetCount(ddate,iid){

	dateNow = new Date();	//grab current date
	amount = ddate.getTime() - dateNow.getTime();	//calc milliseconds between dates
	delete dateNow;

	// if time is already past
	if(amount < 0){
		document.getElementById(iid).innerHTML="Now!";
	}
	// else date is still good
	else{
		days=0;hours=0;mins=0;secs=0;out="";

		amount = Math.floor(amount/1000);//kill the "milliseconds" so just secs

		days=Math.floor(amount/86400);//days
		amount=amount%86400;

		hours=Math.floor(amount/3600);//hours
		amount=amount%3600;

		mins=Math.floor(amount/60);//minutes
		amount=amount%60;

		secs=Math.floor(amount);//seconds

		out += (days<=9?'0':'')+days+":";
		out += (hours<=9?'0':'')+hours +":";
		out += (mins<=9?'0':'')+mins +":";
		out += (secs<=9?'0':'')+secs;
		document.getElementById(iid).innerHTML=out;

		setTimeout(function(){GetCount(ddate,iid);}, 1000);
	}
}