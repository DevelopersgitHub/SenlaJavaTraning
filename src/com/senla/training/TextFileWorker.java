package com.senla.training;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public final class TextFileWorker implements FileWorker {

	private final static Charset FILE_ENCODING = StandardCharsets.UTF_8;
	private final static String FILE_PATH_IS_EMPTY = "com.senla.training.example";
	
	private final Path path;
	
	public TextFileWorker(final String filePath) {
		
		if (filePath == null || filePath.isEmpty()){
			throw new IllegalArgumentException(FILE_PATH_IS_EMPTY);
		}
			
		this.path = Paths.get(filePath);
		
		try {
			if (!Files.exists(this.path)){
				Files.createFile(this.path);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	public String[] readFromFile() {
		
		try {
			
			List<String> lines = Files.readAllLines(path, FILE_ENCODING);
			
			if (lines != null){
				return lines.toArray(new String[lines.size()]);
			}else{
				return new String [0];
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void writeToFile(final String[] values) {
		
		if (values != null && values.length > 0){
			List<String> lines = Arrays.asList(values);
			try {
				Files.write(path, lines, FILE_ENCODING, StandardOpenOption.TRUNCATE_EXISTING);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
}
