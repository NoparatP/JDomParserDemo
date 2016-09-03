
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class DomParserDemo {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element moivesElement = document.getRootElement();
            List<Element> filmList = moivesElement.getChildren();
            System.out.println("Show detail in XML");
            System.out.println("----------------------------");

            for (int temp = 0; temp < filmList.size(); temp++) {
                Element film = filmList.get(temp);
                System.out.println("\nCurrent Element :"
                        + film.getName() + (temp + 1));
                System.out.println("Title : " + film.getChild("title").getText());
                System.out.println("Year : " + film.getChild("year").getText());
                System.out.print("Types : ");
                List<Element> typesList = film.getChildren("types");
                Element type = typesList.get(0);
                List<Element> typeList = type.getChildren();
                for (int count = 0; count < typeList.size(); count++) {
                    if (count != 0) {
                        System.out.print("\t");
                    }
                    System.out.println("" + type.getChild("type" + (count + 1)).getText());
                }
                System.out.println("Time : " + film.getChild("time").getText());
                System.out.println("Director : " + film.getChild("director").getText());
            }
            //---------- code show all XML
            String search = "in";
            System.out.println("\n\nsearch about : " + search);
            System.out.println("----------------------------");
            for (int temp = 0; temp < filmList.size(); temp++) {
                Element film = filmList.get(temp);
                if (film.getChild("title").getText().toLowerCase().contains(search.toLowerCase())) {
                    System.out.println("Title : " + film.getChild("title").getText());
                }
            }
            //---------- code search in
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
