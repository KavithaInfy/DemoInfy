import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {

	public static void main(String[] args) {

		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/atest.zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			String file1Name = "c:/temp/file1.txt";
			String file2Name = "c:/temp/file2.txt";
			

			addToZipFile(file1Name, zos);
			addToZipFile(file2Name, zos);
			
			zos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");
		
		//File file = new File(fileName);
		System.out.println("file---"+fileName);
		InputStream fis =  ZipFiles.class.getResourceAsStream(fileName);
		System.out.println("file---"+fis.toString());
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

}