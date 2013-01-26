package simulator;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import post.JAXBPostModel;
import interfaces.service.SearchSentPostService;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * @author aa.ilyin
 */
public class CreateSentPost {

    public static void createSentPost(JAXBPostModel jaxbPostModel) throws JAXBException, FileNotFoundException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"/beans.xml"});

        SearchSentPostService client = (SearchSentPostService) context.getBean("clientSentPost");

        client.createSentPost(jaxbPostModel);
    }

}