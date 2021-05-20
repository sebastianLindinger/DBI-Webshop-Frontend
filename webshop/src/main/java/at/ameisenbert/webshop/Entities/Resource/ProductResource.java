package at.ameisenbert.webshop.Entities.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

@Data @AllArgsConstructor
public class ProductResource {
    private int productID;
    private String name;
    private double weight;
    private double price;
    private String image;
}
