package ro.ase.acs.cts.factoryMethod;

import ro.ase.acs.cts.simpleFactory.Document;
import ro.ase.acs.cts.simpleFactory.NoSuchDocumentException;
import ro.ase.acs.cts.simpleFactory.OpenOfficeSpreadsheet;
import ro.ase.acs.cts.simpleFactory.OpenOfficeText;

public class OpenOfficeFactory implements AbstractDocumentFactory{

	@Override
	public Document getDocument(FileType type, String fileName) throws NoSuchDocumentException {
		if(type==FileType.DOCUMENT) {
			OpenOfficeText officeText = new OpenOfficeText();
			officeText.setName(fileName);
			return officeText;
		}else if(type==FileType.SPREADSHEET) {
			OpenOfficeSpreadsheet officeSpreadsheet = new OpenOfficeSpreadsheet();
			officeSpreadsheet.setName(fileName);
			return officeSpreadsheet;
		}
		return null;
	}

}
