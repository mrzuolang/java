package com.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZIP {

	public void zip(String filepath, String zipFileName) { // 方法重载
		InputStream input = null;
		ZipOutputStream zipOut = null;
		try {

			File file = new File(filepath);
			File zipFile = new File(zipFileName);
			input = new FileInputStream(file);
			zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
			zipOut.putNextEntry(new ZipEntry(file.getName()));
			int temp = 0;
			while ((temp = input.read()) != -1) {
				zipOut.write(temp);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				zipOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
