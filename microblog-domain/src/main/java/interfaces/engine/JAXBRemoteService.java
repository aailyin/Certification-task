package interfaces.engine;

import post.JAXBPostModel;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * @author aa.ilyin
 */
public interface JAXBRemoteService {

    public JAXBPostModel unmarshallPost(String postfilename) throws JAXBException, FileNotFoundException;

    public void savePost(JAXBPostModel jaxbPostModel) throws JAXBException, FileNotFoundException;
}