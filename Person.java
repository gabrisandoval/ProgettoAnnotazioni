import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



@Info(author = "Giofragab", version = 1.0)

public class Person  {
    
private String name;
private int age;


public Person (String name, int age){
    this.name=name;
    this.age=age;
}



@DeprecatedCustom(doNotUse = "do not use")
public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}



public String getInfo(){

String info="nome: "+ name + " età: " + age;

return info;
}

public void serializeXML() {
    try {
        // Creare una fabbrica di costruttori di documenti
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

        // Creare un costruttore di documenti
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        // Definire un nuovo documento
        Document document = documentBuilder.newDocument();

        // Creare l'elemento radice
        Element root = document.createElement("Persons");
        document.appendChild(root);

        // Creare un elemento figlio
        Element person = document.createElement("Person");

        root.appendChild(person);

        // Aggiungere un attributo all'elemento person
        person.setAttribute("id", "1");

        // Creare e aggiungere i sotto-elementi a person
        Element firstName = document.createElement("name");
        firstName.appendChild(document.createTextNode(name));
        person.appendChild(firstName);


        Element eta = document.createElement("età");
        eta.appendChild(document.createTextNode(String.valueOf(age)));
        person.appendChild(eta);

        // Creare l'istanza di TransformerFactory
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        // Creare il file XML
        StreamResult streamResult = new StreamResult(new File("Person.xml"));

        // Trasformare il DOM in un file XML
        transformer.transform(domSource, streamResult);

        System.out.println("File XML creato con successo!");

    } catch (ParserConfigurationException pce) {
        pce.printStackTrace();
    } catch (TransformerException tfe) {
        tfe.printStackTrace();
    }
    
}

    
}