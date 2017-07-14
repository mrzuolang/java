import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestPrint {
	public static int len = 100 * 1024 * 1024;

	public static void main(String[] args) throws IOException {
		String path = args[0];
		String dir = args[1];
		System.out.println(path);
		System.out.println(dir);
		if (path != null && dir != null)
			read(path, dir);
	}

	public static void read(String path, String dir) {
		StringBuffer out = new StringBuffer(len);
		File files = new File(path);
		int index = 0;
		boolean isHashID=false;
		for (File file : files.listFiles()) {
			if (file.isFile() && file.getName().endsWith(".sql")) {
				BufferedReader buff = null;
				try {
					buff = new BufferedReader(new FileReader(file), 1024);
					String insertSQL = null;
					String sql = null;
					while ((sql = buff.readLine()) != null) {
						if (sql.startsWith("values")) {
							if(!isHashID)
							sql = sql.replace("values (", "values('" + Uuids.uuid() + "'");
							System.out.println(insertSQL + sql);
							if ((insertSQL + sql).length() + out.length() > len) {
								largeFileIO(out, dir + "\\" + index);
								index++;
								out.append(insertSQL + sql);
								out.append("\n\r");
							} else {
								out.append(insertSQL + sql);
								out.append("\n\r");
							}
						} else if (insertSQL == null && sql.startsWith("insert")) {
							if (sql.contains("datamart.")) {
								insertSQL = sql.replace("datamart.", "");
							}
							if (!insertSQL.contains("ID")) {
								insertSQL = insertSQL.replace("(", "( id,");
							}else{
								isHashID=true;
							}
						}
					}
					if(out.length()>0){
						largeFileIO(out, dir + "\\" + index);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (buff != null) {
						try {
							buff.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	static void largeFileIO(StringBuffer buff, String outputFile) {
		try {
			FileWriter fw = new FileWriter(outputFile + ".sql");
			fw.write(buff.toString());
			fw.flush();
			fw.close();
			buff.delete(0, buff.length());
			buff.setLength(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}