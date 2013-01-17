package simulator;

import org.springframework.stereotype.Component;
import post.JAXBPostModel;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * @author aa.ilyin
 */
@Component
public class Simulator {
    /*LOGGER with try/catch*/

    private String filename = "src/posts.xml";
    private long defaultDelay = 2000;
    private JAXBPostModel[] posts;

    @PostConstruct
    public void construct() throws InterruptedException, JAXBException, IOException {
 /*       ApplicationContext appContext = new ClassPathXmlApplicationContext();
        Resource resource = appContext.getResource("classpath*:posts.xml");
*/
        InputStream inputStream = getClass().getResourceAsStream("/posts.xml");
 /*       if(!resource.exists() || !resource.isReadable()){
            throw new Exception("File posts.xml not exist.");
        }*/

        posts = ReadPost.readPostsXML(inputStream);
        Random random = new Random();

        while(true){
            Thread.sleep(defaultDelay);
            CreateSentPost.createSentPost(posts[random.nextInt(posts.length)]);
        }
    }
}