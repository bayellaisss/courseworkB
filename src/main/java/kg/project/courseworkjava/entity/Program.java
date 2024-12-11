package kg.project.courseworkjava.entity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable=false)
    private University university;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="specialization_id", nullable=false)
    private Specialization specialization;

    private Integer duration;
    private BigDecimal cost;
    private String conditions;
    private LocalDate startDate;
    private LocalDate endDate;
    private String language;
}
