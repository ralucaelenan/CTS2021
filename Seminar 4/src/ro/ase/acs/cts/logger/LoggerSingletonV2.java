package ro.ase.acs.cts.logger;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

public class LoggerSingletonV2 {
	public static LoggerSingletonV2 instance = null;

	static {
	instance = new LoggerSingletonV2();
	}
	
	public LoggerSingletonV2() {
		
	}
	
	public void log(String message)
	{
		try {
			FileOutputStream file = new FileOutputStream("Log.txt");
			OutputStreamWriter writer = new OutputStreamWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write(String.valueOf(new Date()+ " "));
			bufferedWriter.write(message);
			bufferedWriter.write(System.lineSeparator());
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
