package post;

import javax.xml.bind.annotation.*;

/**
 * @author aa.ilyin
 */
@XmlRootElement(name = "message")
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(propOrder = {"post", "namePoster"})
public class JAXBPostModel {


    @XmlElement(name = "namePoster")
    private String namePoster;

    @XmlElement(name = "post")
    private String post;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }


    public String getNamePoster() {
        return namePoster;
    }

    public void setNamePoster(String namePoster) {
        this.namePoster = namePoster;
    }

    @Override
    public String toString(){
        return "Post: \""+this.getPost()+"\", author: "+this.getNamePoster()+"\n";
    }
}