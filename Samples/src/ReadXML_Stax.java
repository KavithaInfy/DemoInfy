import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class ReadXML_Stax {


	public static void main(String argv[]) throws Exception {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream in = new FileInputStream("D:\\Infosys\\SPS\\LCPTest1.xml");
        DateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date date = new Date();
		String currentTime = sdf.format(date);
        System.out.print("start time::::"+currentTime);
        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(in);
        streamReader.nextTag(); // Advance to "book" element
        streamReader.nextTag(); // Advance to "person" element

        int persons = 0;
        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {
                switch (streamReader.getLocalName()) {
                case "ImagingIdentifier": {
                    System.out.print("Loan Number : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "ExternalIdentifier": {
                    System.out.print("Doc src id : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "DocumentTypeIdentifier": {
                    System.out.print("Document Type : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "ContentType": {
                    System.out.print("ContentType : ");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                case "Url" : {
                	persons++;
                	System.out.print("Url : "+persons+"::::::");
                    System.out.println(streamReader.getElementText());
                    break;
                }
                }
            }
            streamReader.next();
        }
        date = new Date();
		currentTime = sdf.format(date);
        System.out.print("end time::::"+currentTime);
    }

}