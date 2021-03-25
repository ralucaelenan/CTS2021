package ro.ase.acs.cts.factoryMethod;

import ro.ase.acs.cts.simpleFactory.Document;
import ro.ase.acs.cts.simpleFactory.ExcelDocument;
import ro.ase.acs.cts.simpleFactory.NoSuchDocumentException;
import ro.ase.acs.cts.simpleFactory.WordDocument;

public class MicrosoftOfficeFactory implements AbstractDocumentFactory{

	@Override
	public Document getDocument(FileType type, String fileName) throws NoSuchDocumentException {
		if(type==FileType.DOCUMENT) {
			return new WordDocument(fileName);
		}else if(type==FileType.SPREADSHEET) {
			return new ExcelDocument(fileName);
		}throw new NoSuchDocumentException();
	}
	

}
