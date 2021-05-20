package at.ameisenbert.webshop.Cotrollers;

import at.ameisenbert.webshop.Entities.DTO.UserDTO;
import at.ameisenbert.webshop.Entities.Resource.UserResource;
import at.ameisenbert.webshop.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ameisenbert.shop/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResource> getUsers() {
        return userService.getStudentsResource();
    }

    @PostMapping(value = "/login")
    public int login(@RequestBody UserDTO user) { return userService.login(user);}

    @GetMapping(value = "/{id}")
    public UserResource getUser(@PathVariable int id) {
        return userService.getUserResourceById(id);
    }

    @PostMapping
    public UserResource addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PutMapping(value = "/{id}")
    public UserResource updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public UserResource deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
