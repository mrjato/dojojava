package es.uvigo.esei.dojojava;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class FileUtils {

	public static byte[] loadFile(File f) throws IOException  {
		
		try (	FileInputStream fis = new FileInputStream(f);
				ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			
			/* byte[] buffer = new byte[1024];
			
			int readed = -1;
			
			while( (readed = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, readed);
			}
			*/
			copyStream(fis, baos);
			
			return baos.toByteArray();
		} 
	}
	
	public static void writeFile(File f, String s) throws IOException {
		try (PrintStream ps = new PrintStream(new FileOutputStream(f))) {
			ps.print(s);
		}
	}
	
	public static boolean fileContentsAreEquals(File f1, File f2) throws IOException {
		byte[] f1Bytes = loadFile(f1);
		byte[] f2Bytes = loadFile(f2);
		
		return Arrays.equals(f1Bytes, f2Bytes);
	}
	
	public static void copyFiles(File source, File destiny) throws IOException {
		
		try (FileInputStream fis = new FileInputStream(source);
			 FileOutputStream fos = new FileOutputStream(destiny)) {
			
			copyStream(fis, fos);
		}
	}
	
	public static void copyStream(InputStream input, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		
		int readed = -1;
		
		while ((readed = input.read(buffer))!= -1) {
			out.write(buffer, 0, readed);
		}
	}
}
