package at.ameisenbert.webshop.Entities.DB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data @NoArgsConstructor
public class CartDB {
    @Id
    @GeneratedValue
    private Integer cartID;

    @Column(nullable = false)
    private Integer userID;

    ArrayList<Integer> productIDs;

    public CartDB(Integer cartID, Integer userID, ArrayList<Integer> productIDs) {
        this.cartID = cartID;
        this.userID = userID;
        this.productIDs = productIDs;
    }

    /*
    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private UserDB user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartDB")
    private List<ProductDB> products = new ArrayList<>();*/
}
