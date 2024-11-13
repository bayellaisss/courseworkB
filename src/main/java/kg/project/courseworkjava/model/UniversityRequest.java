package kg.project.courseworkjava.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityRequest {

    private String name;

    private String city;

    private String country;

    private String description;

    private String websiteUrl;

    private String contactEmail;

    private String phone;
}

