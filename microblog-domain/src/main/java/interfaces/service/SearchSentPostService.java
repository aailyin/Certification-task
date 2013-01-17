package interfaces.service;

import post.JAXBPostModel;
import post.Post;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * @author aa.ilyin
 */
@WebService
public interface SearchSentPostService {

    @WebMethod
    public Post[] search10LastPostsUser(@WebParam(name = "username") String username);

    @WebMethod
    public Post[] search10LastPosts();

    @WebMethod
    public Post[] searchTextMatchPosts(@WebParam(name = "text") String text);

    @WebMethod
    public void createSentPost(@WebParam(name = "jaxbPostModel")JAXBPostModel jaxbPostModel) throws JAXBException, FileNotFoundException;
}