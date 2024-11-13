package kg.project.courseworkjava.specification;

import kg.project.courseworkjava.entity.University;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class UniversitySpecification {

    public static Specification<University> withFiltersStudent(
            String name,
            String city) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if (city != null && !city.isEmpty()) {
                predicate = builder.and(predicate, builder.like(builder.lower(root.get("city")), "%" + city.toLowerCase() + "%"));
            }

            if (name != null && !name.isEmpty()) {
                predicate = builder.and(predicate, builder.like(builder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }

            return predicate;
        };
    }
}
