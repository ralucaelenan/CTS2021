package ro.ase.acs.cts.simpleFactory;

public class WordDocument implements Document{	
	private String name;
	
	public WordDocument() {
	}
	
	public WordDocument(String name) {
		this.name=name;
		}

	@Override
	public void open() {
		System.out.println(String.format("Opening file %s.docx...", name));
	}

}
