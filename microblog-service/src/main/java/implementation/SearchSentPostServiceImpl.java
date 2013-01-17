package implementation;

import interfaces.engine.JAXBRemoteService;
import interfaces.service.SearchSentPostService;
import org.openspaces.remoting.ExecutorProxy;
import post.JAXBPostModel;
import post.Post;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * @author aa.ilyin
 */
@WebService(endpointInterface = "interfaces.service.SearchSentPostService", serviceName = "postService")
public class SearchSentPostServiceImpl implements SearchSentPostService {

    @ExecutorProxy
    private JAXBRemoteService jaxbRemoteService;


    @Override
    public Post[] search10LastPostsUser(@WebParam(name = "username") String username) {
        return new Post[0];
    }

    @Override
    public Post[] search10LastPosts() {
        return new Post[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Post[] searchTextMatchPosts(@WebParam(name = "text") String text) {
        return new Post[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void createSentPost(@WebParam(name = "jaxbPostModel") JAXBPostModel jaxbPostModel) throws JAXBException, FileNotFoundException {
        jaxbRemoteService.savePost(jaxbPostModel);
    }

    public void setJaxbRemoteService(JAXBRemoteService jaxbRemoteService) {
        this.jaxbRemoteService = jaxbRemoteService;
    }

    public JAXBRemoteService getJaxbRemoteService() {
        return jaxbRemoteService;
    }
}