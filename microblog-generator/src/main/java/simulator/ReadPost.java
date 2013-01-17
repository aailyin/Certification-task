package simulator;

import org.springframework.stereotype.Component;
import post.JAXBPostModel;
import post.JAXBPosts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aa.ilyin
 */
@Component
public class ReadPost {

    public static JAXBPostModel[] readPostsXML(InputStream inputStream) throws JAXBException, FileNotFoundException {
        JAXBPosts jaxbPosts;

        JAXBContext jaxbContext = JAXBContext.newInstance(JAXBPosts.class);
        Unmarshaller um = jaxbContext.createUnmarshaller();
        jaxbPosts = (JAXBPosts) um.unmarshal(inputStream);

        List<JAXBPostModel> listPosts = new ArrayList<JAXBPostModel>(jaxbPosts.getPosts());

        return listPosts.toArray(new JAXBPostModel[listPosts.size()]);
    }

}