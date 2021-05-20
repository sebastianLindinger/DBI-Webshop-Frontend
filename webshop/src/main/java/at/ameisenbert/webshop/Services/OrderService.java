package at.ameisenbert.webshop.Services;

import at.ameisenbert.webshop.Entities.DTO.OrderDTO;
import at.ameisenbert.webshop.Entities.DB.OrderDB;
import at.ameisenbert.webshop.Entities.Resource.OrderResource;
import at.ameisenbert.webshop.Exceptions.BadRequestException;
import at.ameisenbert.webshop.Exceptions.NotFoundException;
import at.ameisenbert.webshop.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //@PostConstruct
    public void initOrder() {
        OrderDB order1 = new OrderDB(1, "15/03/2021", 1, new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2})));
        orderRepository.save(order1);
    }


    public List<OrderResource> getOrderResources() {
        return orderRepository.findAll().stream()
                .map(this::orderToOrderResource)
                .collect(Collectors.toList());
    }

    public OrderResource getOrderResourceById(int id) {
        OrderDB order = getOrderById(id);
        return orderToOrderResource(order);
    }


    private OrderDB getOrderById(int id) {
        Optional<OrderDB> orderDB = orderRepository.findById(id);
        if(orderDB.isPresent()) return orderDB.get();
        else throw new NotFoundException("Order with the id " + id + " not found");
    }

    public OrderResource addOrder(OrderDTO orderDTO) {
        checkOrderDTO(orderDTO);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(OrderDB.dateFormat);
        OrderDB order = new OrderDB(null, LocalDate.now().format(dtf), orderDTO.getUserID(), orderDTO.getProductIDs());
        order = orderRepository.save(order);
        return orderToOrderResource(order);
    }

    private void checkOrderDTO(OrderDTO orderDTO) {
        if(orderDTO.getUserID() == 0) throw new BadRequestException("User ID must be set");
    }

    private OrderResource orderToOrderResource(OrderDB order) {
        return new OrderResource(order.getOrderID(), order.getOrderDate(), order.getUserID(), order.getProductIDs());
    }

    public OrderResource updateOrder(int id, OrderDTO orderDTO) {
        OrderDB order = getOrderById(id);

        if(orderDTO.getUserID() != 0)
            order.setUserID(orderDTO.getUserID());

        if(orderDTO.getProductIDs() != null)
            order.setProductIDs(orderDTO.getProductIDs());

        orderRepository.save(order);

        return orderToOrderResource(order);
    }

    public OrderResource deleteOrder(int id) {
        OrderDB order = getOrderById(id);

        orderRepository.delete(order);
        return orderToOrderResource(order);
    }
}
