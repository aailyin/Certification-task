package services.implementations;

import interfaces.engine.JAXBRemoteService;
import org.openspaces.core.GigaSpace;
import org.openspaces.remoting.RemotingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import post.JAXBPostModel;
import post.Post;
import poster.Poster;
import util.IdGenerator;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author aa.ilyin
 */
@RemotingService
public class JAXBRemoteServiceImpl implements JAXBRemoteService {
     @Resource
     @Qualifier(value = "gigaSpace")
     private GigaSpace gigaSpace;
     /*
     * LOGGER
     * */

    @Override
    public JAXBPostModel unmarshallPost(String postfilename) throws JAXBException, FileNotFoundException {
        JAXBPostModel jaxbPostModel= new JAXBPostModel();

        JAXBContext context = JAXBContext.newInstance(JAXBPostModel.class);
        Unmarshaller um = context.createUnmarshaller();
        jaxbPostModel = (JAXBPostModel) um.unmarshal(new FileReader(postfilename));

        return jaxbPostModel;
    }


    @Override
    @Transactional
    public void savePost(JAXBPostModel jaxbPostModel) throws JAXBException, FileNotFoundException {
        Calendar calendar = new GregorianCalendar();

        Post post = new Post();
        post.setIdPost(IdGenerator.getUUID());
        post.setPost(jaxbPostModel.getPost());
        post.setDate(calendar.getTime());

        Poster poster = new Poster();
        poster.setUsername(jaxbPostModel.getNamePoster());
        poster = gigaSpace.read(poster);
        if(poster == null){

            poster.setUsername(jaxbPostModel.getNamePoster());
            poster.incrementAmount();
            poster.setId(IdGenerator.getUUID());
            poster.addPostId(post.getIdPost());

            post.setIdUser(poster.getId());

            gigaSpace.write(poster);
            gigaSpace.write(post);

        } else {
            post.setIdUser(poster.getId());
            poster.incrementAmount();

            gigaSpace.write(post);
            gigaSpace.write(poster);
        }
        gigaSpace.write(post);
     }
}