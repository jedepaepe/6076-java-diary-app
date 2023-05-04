package eu.epfc.tic.java.introduction;

public class Diary {
    private int id;
    private String title;
    private String description;
    private String begin;
    private boolean isPublic;

    public Diary(String title, String description, String begin, boolean isPublic) {
        this.title = title;
        this.description = description;
        this.begin = begin;
        this.isPublic = isPublic;
    }

    public Diary(int id, String title, String description, String begin, boolean isPublic) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.begin = begin;
        this.isPublic = isPublic;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
