package kg.project.courseworkjava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityResponse {

    private Long id;

    private String name;

    private String city;

    private String country;

    private String description;

    private String websiteUrl;

    private String contactEmail;

    private String phone;
}
