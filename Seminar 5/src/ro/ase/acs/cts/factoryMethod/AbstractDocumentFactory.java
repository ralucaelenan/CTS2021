package ro.ase.acs.cts.factoryMethod;

import ro.ase.acs.cts.simpleFactory.Document;
import ro.ase.acs.cts.simpleFactory.NoSuchDocumentException;

public interface AbstractDocumentFactory {
	public Document getDocument(FileType type, String fileName)throws NoSuchDocumentException;
}
