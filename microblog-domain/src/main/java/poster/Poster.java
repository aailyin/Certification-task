package poster;

import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.util.ArrayList;
import java.util.List;

/**
    @author aa.ilyin
 */
public class Poster {

    private String UUID;
    private String username;
    private List<String> postsId = new ArrayList<String>();
    private Long amount;

    @SpaceId(autoGenerate = false)
    @SpaceRouting
    public String getId() {
        return UUID;
    }

    public void setId(String id) {
        this.UUID = id;
    }

    @SpaceIndex(type = SpaceIndexType.BASIC)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void incrementAmount(){
        amount++;
    }

    public void addPostId(String postId){
        postsId.add(postId);
    }

    public List<String> getPostsId() {
        return postsId;
    }

    public void setPostsId(List<String> postsId) {
        this.postsId = postsId;
    }
}
