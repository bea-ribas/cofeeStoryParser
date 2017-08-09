package com.mastercard.javaTrainning.examples.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileManipulationExample {

	private final static String FILE_PATH = "src\\main\\resources\\";

	public static void createDirectoryTree(String direcoryTree) {
		Path path = Paths.get(direcoryTree);
		if (!Files.exists(path)) {
			new File(direcoryTree).mkdirs();
		}
	}

	public static void copyFDirectory(String from, String outputFilePath, StandardCopyOption option) {
		Path movefrom = FileSystems.getDefault().getPath(from);
		Path target = FileSystems.getDefault().getPath(outputFilePath);
		try {
			Files.copy(movefrom, target, option);
			File originalFile = new File(from);
			FileInputStream fis = new FileInputStream(originalFile);
			fis.close();
			if (originalFile.exists()) {
				originalFile.deleteOnExit();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private static String generateChecksum(String pathWithName, String cryptoType)
			throws NoSuchAlgorithmException, IOException {
		
		MessageDigest md = MessageDigest.getInstance(cryptoType);
		FileInputStream fis = new FileInputStream(pathWithName);
		byte[] dataBytes = new byte[1024];
		int nRead = 0;
		while ((nRead = fis.read(dataBytes)) != -1) {
			md.update(dataBytes, 0, nRead);
		}
		byte[] mdBytes = md.digest();

		// convert the byte to hex format
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < mdBytes.length; i++) {
			sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String fileName = "wiproExample.txt";
		String pathWithName = FILE_PATH + fileName;
		// wraps the file
		File file = new File(pathWithName);
		// write
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter writer = null;
		BufferedWriter bufferedWriter = null;
		// to read
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			/**
			 * Create new file
			 */

			if (!file.exists()) {
				String charset = "UTF-8";
				fileOutputStream = new FileOutputStream(fileName);
				writer = new OutputStreamWriter(fileOutputStream, charset);
				bufferedWriter = new BufferedWriter(writer);
				bufferedWriter.newLine();
				bufferedWriter.close();
			} else {
				System.out.println("File already exists in the folder.");
			}

			/**
			 * Set file permission
			 */
			file.setReadable(true);
			file.setWritable(true);
			file.setExecutable(false);

			/**
			 * Create file structure to read and write
			 */

			fileOutputStream = new FileOutputStream(file);

			// Write the file

			if (!file.exists()) {
				System.out.println("There was a problem while trying to create a file above!");
			}

			String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut leo magna, convallis eget cursus ornare, volutpat non lacus. Nullam non orci sit amet velit fermentum fermentum. Vivamus metus odio, facilisis at tincidunt imperdiet, vestibulum eu elit. Aliquam arcu enim, gravida ut nulla sed, posuere porta enim. Nullam ornare felis quam, id gravida ante tristique et. Praesent viverra commodo ex vel dictum. Praesent fringilla, ex ac consequat ornare, sapien purus laoreet nisi, non mattis quam quam vel libero. Cras urna metus, efficitur ac ante non, mattis euismod est. Quisque bibendum erat in dictum aliquam. Pellentesque scelerisque maximus ipsum, vel luctus elit. Cras nec placerat ante. Suspendisse blandit arcu quis tellus pulvinar elementum. Mauris sed mi vitae tellus ultricies ultricies quis eu est. Nunc nisl nibh, pretium euismod accumsan at, faucibus non orci. Quisque rutrum sapien vitae auctor tincidunt.";

			byte[] textInBytes = text.getBytes();

			fileOutputStream.write(textInBytes);

			// Read the file
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			System.out.println("======================================");
			System.out.println("What was read from the file created");
			System.out.println("======================================");
			String currentLine;
			while ((currentLine = bufferedReader.readLine()) != null) {
				System.out.println(currentLine);
			}

			/**
			 * Create a new directory
			 */
			createDirectoryTree(FILE_PATH + "subdirectory\\subdir1\\subdir3");

			/**
			 * Copy a file to a dir
			 */

			copyFDirectory(pathWithName, FILE_PATH + "copied.txt", StandardCopyOption.REPLACE_EXISTING);

			/**
			 * Generates a file checksum
			 */

			String fileHash = generateChecksum(pathWithName, "MD5");
			System.out.println(fileHash);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.out.println("Problem while closing output stream. " + e.getMessage() + e.getStackTrace());
			}
		}
	}
}
