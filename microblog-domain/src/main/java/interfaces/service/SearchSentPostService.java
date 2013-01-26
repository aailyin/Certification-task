package interfaces.service;

import post.JAXBPostModel;
import post.Post;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * @author aa.ilyin
 */
@WebService(name = "searchSentPostService")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED)
public interface SearchSentPostService {

    @WebMethod
    public Post[] search10LastPostsUser(@WebParam(name = "username") String username);

    @WebMethod
    public Post[] search10LastPosts();

    @WebMethod
    public Post[] searchTextMatchPosts(@WebParam(name = "text") String text);

    @WebMethod
    @Oneway
    public void createSentPost(@WebParam(name = "jaxbPostModel")JAXBPostModel jaxbPostModel) throws JAXBException, FileNotFoundException;
}