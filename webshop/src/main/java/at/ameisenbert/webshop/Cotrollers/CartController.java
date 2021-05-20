package at.ameisenbert.webshop.Cotrollers;


import at.ameisenbert.webshop.Entities.DTO.CartDTO;
import at.ameisenbert.webshop.Entities.Resource.CartResource;
import at.ameisenbert.webshop.Services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/ameisenbert.shop/carts")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartResource> getCarts() {
        return cartService.getCartResources();
    }

    @GetMapping(value = "/{id}")
    public CartResource getCart(@PathVariable int id) {
        return cartService.getCartResourceById(id);
    }

    @PostMapping
    public CartResource addCart(@RequestBody CartDTO cartDTO) {
        return cartService.addCart(cartDTO);
    }

    @PutMapping(value = "/{id}")
    public CartResource updateCart(@PathVariable int id, @RequestBody CartDTO cartDTO) {
        return cartService.updateCart(id, cartDTO);
    }

    @DeleteMapping(value = "/{id}")
    public CartResource deleteCart(@PathVariable int id) {
        return cartService.deleteCart(id);
    }
}
