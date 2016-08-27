package blog.forms;

import groovy.lang.Singleton;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePostForm {
    @NotNull
    @Size(min=1, max=100, message = "Post title must be between 1 and 100 characters long.")
    private String postTitle;

    @NotNull
    @Size(min=1, message = "Post body must not be empty.")
    private String postBody;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}
