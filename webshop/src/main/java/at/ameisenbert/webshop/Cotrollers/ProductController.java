package at.ameisenbert.webshop.Cotrollers;


import at.ameisenbert.webshop.Entities.*;
import at.ameisenbert.webshop.Entities.DTO.ProductDTO;
import at.ameisenbert.webshop.Entities.Resource.ProductResource;
import at.ameisenbert.webshop.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/ameisenbert.shop/products")
public class ProductController {
    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResource> getProducts() {
        return productService.getProductResources();
    }

    @GetMapping(value = "/{id}")
    public ProductResource getProduct(@PathVariable int id) {
        return productService.getProductResourceById(id);
    }

    @PostMapping
    public ProductResource addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping(value = "/{id}")
    public ProductResource updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ProductResource deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
