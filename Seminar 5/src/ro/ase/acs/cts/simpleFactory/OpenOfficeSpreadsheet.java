package ro.ase.acs.cts.simpleFactory;

public class OpenOfficeSpreadsheet implements Document {
	private String name = "NewDocumentSpreadSheet";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void open() {
		System.out.println(String.format("Opening file %s.ods...", name));
		
	}

}
