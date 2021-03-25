package ro.ase.acs.cts.factoryMethod;

import ro.ase.acs.cts.simpleFactory.Document;
import ro.ase.acs.cts.simpleFactory.NoSuchDocumentException;

public class NewMain {
	public static void main(String[] args) {
		AbstractDocumentFactory documentFactory = new OpenOfficeFactory();
		Document document;
		try {
			document = documentFactory.getDocument(FileType.SPREADSHEET, "Studenti");
		} catch (NoSuchDocumentException e) {
			e.printStackTrace();
		}
	}
}
