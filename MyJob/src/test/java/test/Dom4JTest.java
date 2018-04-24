package test;

import java.io.File;
import java.io.FileInputStream;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Dom4JTest {
	public static void main(String[] args) throws Exception {
		File f = new File("N:\\FTP\\EOI_20170524101010.001.XML");
		FileInputStream fis = new FileInputStream(f);
		byte []b = new byte[fis.available()];
		fis.read(b);
		System.out.println(new String(b));
		fis.close();
		
		
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(new File("N:\\FTP\\EmisOrg.xsd"));
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(f));
	}
}
