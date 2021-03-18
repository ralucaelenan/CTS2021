package ro.ase.acs.cts.connections;

public abstract class RestServiceV2 {
	
	protected String serverURL;
	
	public RestServiceV2(String serverURL) {
		this.serverURL=serverURL;
	}
	
	public abstract void connect();
}
