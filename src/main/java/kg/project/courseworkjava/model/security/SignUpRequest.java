package kg.project.courseworkjava.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpRequest {
    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    @NotNull(message = "Роль не может быть пустой")
    private Long roleId;

}