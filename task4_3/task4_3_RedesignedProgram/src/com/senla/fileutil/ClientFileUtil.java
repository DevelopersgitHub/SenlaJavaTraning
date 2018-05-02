package com.senla.fileutil;

import java.text.ParseException;
import com.senla.model.Client;
import com.senla.training.*;

public final class ClientFileUtil implements IClientFileUtil<Client> {
	

	private static final String TEST_FILE = "clients.txt";
	private final FileWorker fileWorker;
	
	public ClientFileUtil() {
		fileWorker = new TextFileWorker(TEST_FILE);
	}
	public Client[] readFromFile() throws NumberFormatException, ParseException {
		final String[] lines = fileWorker.readFromFile();
		
		if (lines == null || lines.length == 0) {
			throw new IllegalArgumentException();
		}
		
		final Client[] result = new Client[lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			result[i] = fromLine(lines[i]);
		}
		
		return result;
	}

	public void writeToFile(final Client[] values) {
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException();
		}
		final String[] lines = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			lines[i] = toLine(values[i]);
		}
		fileWorker.writeToFile(lines);
	}

	public String toLine(final Client client) {
		if (client == null) {
			throw new IllegalArgumentException();
		}

		final String[] array = new String[] { 
				String.valueOf(client.getClientID()), 
				String.valueOf(client.getClientName())
			};
		return String.join(";", array);
	}
	
	public Client fromLine(final String line) throws NumberFormatException, ParseException {
		if (line == null || line.isEmpty()) {
			throw new IllegalArgumentException();
		}
		final String[] parts = line.split(";");
		final Client result = new Client(
				Long.valueOf(parts[0]),
				parts[1]
			);
		return result;
	}
}
