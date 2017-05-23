package com.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zuolang zip文件压缩
 *
 */
public class FileZIP {

	/**
	 * 生成压缩文件 
	 * @param topic
	 * @return 是否生成成功
	 */
	public boolean zip(String topic) { // 方法重载
		System.out.println("日志文件：" + topic);
		String zipName = topic+ ".zip";
		System.out.println("zip文件名称：" + zipName);
		InputStream input = null;
		ZipOutputStream zipOut = null;
		try {

			File file = new File(topic);
			if(!file.exists()){
				System.out.println("文件不存在");
				return false;
			}
			File zipFile = new File(zipName);
			input = new FileInputStream(file);
			zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
			zipOut.putNextEntry(new ZipEntry(file.getName()));
			int temp = 0;
			while ((temp = input.read()) != -1) {
				zipOut.write(temp);
			}
			file.delete();
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
		return true;
	}
}
