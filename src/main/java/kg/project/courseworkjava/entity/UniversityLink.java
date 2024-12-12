package kg.project.courseworkjava.entity;


public class UniversityLink {
    private String title;
    private String url;

    public UniversityLink(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}

