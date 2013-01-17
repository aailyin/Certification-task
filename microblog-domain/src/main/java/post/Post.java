package post;

import com.gigaspaces.annotation.pojo.*;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.io.Serializable;
import java.util.Date;

/**
    @author aa.ilyin
 */
@SpaceClass
public class Post implements Serializable {

    private String idPost;
    private String post;
    private Date date;
    private String idUser;

    @SpaceId(autoGenerate = false)
    @SpaceRouting
    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String id) {
        this.idPost = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @SpaceIndex(type = SpaceIndexType.BASIC)
    @SpaceRouting
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
