package hu.blog.app.model;

public class PostEditForm {

    public PostEditForm() {
    }

    public PostEditForm(Integer id, String title, String text, Boolean visible) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.visible = visible;
    }

    public PostEditForm(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.text = post.getText();
        this.visible = post.getVisible();
    }

    private Integer id;
    private String title;
    private String text;
    private Boolean visible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
