package kg.project.courseworkjava.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class University {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    private String city;
    private String country;
    private String description;
    private String websiteUrl;
    private String contactEmail;
    private String phone;
}