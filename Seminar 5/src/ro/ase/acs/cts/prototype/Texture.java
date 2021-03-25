package ro.ase.acs.cts.prototype;

public class Texture implements Cloneable{
	private String name;

	public String getName() {
		return name;
	}

	public Texture (String name) {
		this.name=name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Texture copy = (Texture)super.clone();
		copy.name=name;
		return copy;
	}
	
	

}
