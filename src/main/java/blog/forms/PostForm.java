package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by lucky on 12/7/16.
 */
public class PostForm {

    @Size(min = 2, max = 30, message = "Title size should be in range [2..30]")
    private String title;

    @NotNull
    @Size(min = 2, message = "Content size should be in range [2..]")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
