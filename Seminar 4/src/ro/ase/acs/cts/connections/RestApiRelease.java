package ro.ase.acs.cts.connections;

public class RestApiRelease implements RestService{
	
	public RestApiRelease() {
		System.out.println("Release sever");
	}
	
	public void connect() {
		System.out.println("Connected succesfully!");
	}
}
