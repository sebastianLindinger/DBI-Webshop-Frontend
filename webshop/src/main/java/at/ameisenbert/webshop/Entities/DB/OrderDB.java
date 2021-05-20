package at.ameisenbert.webshop.Entities.DB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data  @Entity @NoArgsConstructor
public class OrderDB {
    @Id
    @GeneratedValue
    private Integer orderID;

    @Column(nullable = false)
    private String orderDate;

    @Column(nullable = false)
    private Integer userID;

    private ArrayList<Integer> productIDs;

    public static String dateFormat = "dd/MM/yyyy";

    public OrderDB(Integer orderID, String orderDate, Integer userID, ArrayList<Integer> productIDs) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.userID = userID;
        this.productIDs = productIDs;
    }

    /*@ManyToOne
    @JoinColumn(name = "userID")
    private UserDB user;*/

    /*@ManyToMany(cascade = CascadeType.ALL, mappedBy = "orderDB")
    private List<ProductDB> products = new ArrayList<>();*/
}
