package arturmichalak.fantastic.http.DTO;

import com.google.gson.annotations.SerializedName;

public class FakeDTO {

    @SerializedName("userId")
    private int user;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("completed")
    private boolean completed;

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public FakeDTO(int user, int id, String title, boolean completed) {

        this.user = user;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
}
