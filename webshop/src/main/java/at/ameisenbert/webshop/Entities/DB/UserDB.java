package at.ameisenbert.webshop.Entities.DB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @Entity @NoArgsConstructor
public class UserDB {
    @Id
    @GeneratedValue
    private Integer userID;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String dateOfRegistration;

    @Column(nullable = false)
    private String email;

    public static String dateFormat = "dd/MM/yyyy";

    public UserDB(Integer userID, String userName, String password, String dateOfRegistration, String email) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.email = email;
    }

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "userDB")
    private List<OrderDB> orders = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDB")
    private List<CartDB> carts = new ArrayList<>();*/
}
