package ro.ase.acs.cts.connections;

public class SimpleFactoryV2 {
	private final static String DEVELOPMENT = "development";
	private final static String RELEASE = "release";
	
	public static RestServiceV2 createConnection(String type, String URL) {
		if(DEVELOPMENT.equals(type)) {
			return new RestApiDevelopmentV2(URL);
		}
		else if(RELEASE.equals(type)) {
			return new RestApiDevelopmentV2(URL);
		}else {
			return null;
		}
	}
}
