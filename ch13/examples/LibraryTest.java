package ch13.examples;

import java.io.*;
import org.apache.commons.csv.*;

public class LibraryTest {
	public static void main(String args[]) throws IOException {
		Reader in = new FileReader(args[0]);
		CSVFormat formatter = CSVFormat.DEFAULT.builder()
		  .setHeader()               // use first row as header
		  .setSkipHeaderRecord(true) // but don't include it
		  .get();
		Iterable<CSVRecord> records = formatter.parse(in);
		for (CSVRecord record : records) {
		    String port = record.get("Port");
		    String name = record.get("Service");
		    IO.println(name + "(" + port + ")");
		}
		in.close();
	}
}