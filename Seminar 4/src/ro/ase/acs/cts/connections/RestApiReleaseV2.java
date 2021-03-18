package ro.ase.acs.cts.connections;

public class RestApiReleaseV2 extends RestServiceV2{
	
	public RestApiReleaseV2(String serviceURL) {
		super(serviceURL);
		System.out.println();
	}

	@Override
	public void connect() {
		System.out.println("Connected succesfully to "+ serverURL);
	}

}
