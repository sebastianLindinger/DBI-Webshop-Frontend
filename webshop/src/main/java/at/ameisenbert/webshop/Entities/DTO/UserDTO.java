package at.ameisenbert.webshop.Entities.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String password;
    private String email;
}
