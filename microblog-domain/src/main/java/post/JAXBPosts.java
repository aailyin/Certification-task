package post;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author aa.ilyin
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "JAXBPosts")
@XmlType
public class JAXBPosts {

    @XmlElementWrapper(name = "posts")
    @XmlElement(name = "message")
    private List<JAXBPostModel> posts;

    private String sourceFile;

    public List<JAXBPostModel> getPosts() {
        return posts;
    }

    public void setPosts(List<JAXBPostModel> posts) {
        this.posts = posts;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public String toString(){
        String str = "";
        for(JAXBPostModel jaxbPostModel: posts){
            str += "Post: \""+jaxbPostModel.getPost()+"\", author: "+jaxbPostModel.getNamePoster()+"\n";
        }
        return str;
    }
}