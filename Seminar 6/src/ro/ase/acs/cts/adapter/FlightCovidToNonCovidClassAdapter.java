package ro.ase.acs.cts.adapter;

public class FlightCovidToNonCovidClassAdapter extends FlightCovidScheduler implements FlightAbstractScheduler{

	@Override
	public void bookPlace(int column, char place) {
		super.bookPlace(column);
	}

	@Override
	public void displayPlaces() {
	super.printAvailablePlaces();
	}

}
