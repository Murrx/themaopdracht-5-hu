package com.th5.domain.other;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import com.th5.domain.service.ServiceProvider;

public class RefreshAuctionsTimer{
	Timer timer;
	
	public RefreshAuctionsTimer(){
		timer = new Timer();
		timer.schedule(
				new RefreshAuctionsTask(),
				0,
				1000*60
				);
	}

	private class RefreshAuctionsTask extends TimerTask {
		public void run() {
			System.out.println("Refreshing auctions");
			ServiceProvider.getService().refreshAllAuctions();

		}
	}
}
