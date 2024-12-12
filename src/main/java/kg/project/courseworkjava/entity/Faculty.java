package kg.project.courseworkjava.entity;

import java.util.List;

public class Faculty {
    private String name;
    private String description;
    private List<UniversityLink> universities;

    public Faculty(String name, String description, List<UniversityLink> universities) {
        this.name = name;
        this.description = description;
        this.universities = universities;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<UniversityLink> getUniversities() {
        return universities;
    }
}
