package ro.ase.acs.cts.main;

import ro.ase.acs.cts.adapter.FlightAbstractScheduler;
import ro.ase.acs.cts.adapter.FlightCovidScheduler;
import ro.ase.acs.cts.adapter.FlightCovidToNonCovidClassAdapter;
import ro.ase.acs.cts.adapter.FlightCovidToNonCovidObjectAdapter;
import ro.ase.acs.cts.adapter.FlightScheduler;

public class NewMain {
	public static void main(String[] args) {
		FlightAbstractScheduler scheduler = new FlightScheduler();
		scheduler = new FlightCovidToNonCovidObjectAdapter(new FlightCovidScheduler());
		scheduler = new FlightCovidToNonCovidClassAdapter();
		//existing code
		scheduler.bookPlace(1, 'B');
		scheduler.bookPlace(1, 'C');
		scheduler.displayPlaces();
	}

}
