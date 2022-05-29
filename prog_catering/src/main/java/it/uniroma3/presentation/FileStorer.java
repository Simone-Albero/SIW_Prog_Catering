package it.uniroma3.presentation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileStorer {

	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/";
	
	
	
	public static String store(MultipartFile file, String owner) {
		new File(uploadDirectory+owner).mkdir();
		Path fileNameAndPath  = Paths.get(uploadDirectory+owner, file.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, file.getBytes());
			return fileNameAndPath.getFileName().toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
