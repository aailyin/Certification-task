/*
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import post.JAXBPostModel;
import simulator.ReadPost;

import java.io.InputStream;

*/
/**
 * @author aa.ilyin
 *//*


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/META-INF/webapp.spring/pu.xml")
public class ReadPostXMLTest extends TestCase {

    public ReadPostXMLTest(String testName){
        super(testName);
    }

    public void readPostXMLTest(){
        JAXBPostModel[] posts;
        try{
            InputStream inputStream = getClass().getResourceAsStream("/posts.xml");

            posts = ReadPost.readPostsXML(inputStream);
            for (JAXBPostModel jaxbPostModel: posts){
                System.out.println(jaxbPostModel);
            }
            assertNotNull(posts);
        }catch (Exception e){
            System.out.print(e);
        }

    }

    public static void main(String []args){
        TestRunner testRunner = new TestRunner();
        TestSuite testSuite = new TestSuite();
        testSuite.addTest(new ReadPostXMLTest("readPostXMLTest"));
        testRunner.doRun(testSuite);
    }
}
*/
