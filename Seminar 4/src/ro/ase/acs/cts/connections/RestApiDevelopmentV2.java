package ro.ase.acs.cts.connections;

public class RestApiDevelopmentV2 extends RestServiceV2 {
	public RestApiDevelopmentV2 (String serviceURL) {
		super(serviceURL);
		System.out.println();
	}

	@Override
	public void connect() {
		System.out.println("Connected succesfully to "+ serverURL);
		
	}

}
