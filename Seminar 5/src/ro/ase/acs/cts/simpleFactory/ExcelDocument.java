package ro.ase.acs.cts.simpleFactory;

public class ExcelDocument implements Document{
	private String name;
	
	public ExcelDocument() {	
	}

	public ExcelDocument(String name) {
		this.name = name;
	}

	@Override
	public void open() {
	System.out.println(String.format("Opening file %s.xlsx...", name));	
	}
}
