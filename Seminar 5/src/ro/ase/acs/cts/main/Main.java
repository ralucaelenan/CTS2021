package ro.ase.acs.cts.main;

import ro.ase.acs.cts.simpleFactory.Document;
import ro.ase.acs.cts.simpleFactory.DocumentFactory;
import ro.ase.acs.cts.simpleFactory.DocumentType;
import ro.ase.acs.cts.simpleFactory.NoSuchDocumentException;

public class Main {
	public static void main(String[] args) {
		DocumentFactory documentFactory = new DocumentFactory();
		try {
			Document document = documentFactory.getDocument(
								DocumentType.OPENOFFICE_SPREADSHEET, "Doc");
			document.open();
		} catch (NoSuchDocumentException e) {
			e.printStackTrace();
		}
	}
}
