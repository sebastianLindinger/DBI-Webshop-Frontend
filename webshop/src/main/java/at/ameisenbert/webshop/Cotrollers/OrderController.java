package at.ameisenbert.webshop.Cotrollers;

import at.ameisenbert.webshop.Entities.*;
import at.ameisenbert.webshop.Entities.DTO.OrderDTO;
import at.ameisenbert.webshop.Entities.Resource.OrderResource;
import at.ameisenbert.webshop.Services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ameisenbert.shop/orders")
public class OrderController {
    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderResource> getOrders() {
        return service.getOrderResources();
    }

    @GetMapping(value = "/{id}")
    public OrderResource getOrder(@PathVariable int id) {
        return service.getOrderResourceById(id);
    }

    @PostMapping
    public OrderResource addOrder(@RequestBody OrderDTO order) {
        return service.addOrder(order);
    }

    @PutMapping(value = "/{id}")
    public OrderResource updateOrder(@PathVariable int id, @RequestBody OrderDTO orderDTO) {
        return service.updateOrder(id, orderDTO);
    }

    @DeleteMapping(value = "/{id}")
    public OrderResource deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }
}
