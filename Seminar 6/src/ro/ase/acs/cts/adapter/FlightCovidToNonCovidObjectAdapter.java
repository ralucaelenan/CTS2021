package ro.ase.acs.cts.adapter;

public class FlightCovidToNonCovidObjectAdapter extends FlightScheduler implements FlightCovidAbstractScheduler{
	private FlightCovidScheduler covidScheduler;
	
	public FlightCovidToNonCovidObjectAdapter(FlightCovidScheduler covidScheduler) {
		this.covidScheduler=covidScheduler;
	}
	
	@Override
	public void bookPlace(int column, char place) {
		covidScheduler.bookPlace(column);
	}
	
	@Override
	public void displayPlaces() {
		covidScheduler.printAvailablePlaces();
	}

	@Override
	public void bookPlace(int row) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printAvailablePlaces() {
		// TODO Auto-generated method stub
		
	}
}
