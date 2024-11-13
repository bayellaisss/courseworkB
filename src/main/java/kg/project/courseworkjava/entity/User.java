package kg.project.courseworkjava.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn
    Role role;


    public User(String username, String email, String encode,String name,String lastName) {
        this.username = username;
        this.email = email;
        this.password = encode;
        this.firstName = name;
        this.lastName = lastName;
    }

}
