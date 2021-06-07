package at.ameisenbert.webshop.Entities.DB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data @Entity @NoArgsConstructor
public class ProductDB {
    @Id
    @GeneratedValue
    private Integer productID;

    @Column(nullable = false)
    private String name;

    private Double weight;

    private Double price;

    private String image;

    public ProductDB(Integer productID, String name, Double weight, Double price, String image) {
        this.productID = productID;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.image = image;
    }

    /*@ManyToMany(cascade = CascadeType.ALL, mappedBy = "productDB")
    private List<OrderDB> orders = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "productDB")
    private List<CartDB> carts = new ArrayList<>();*/
}
