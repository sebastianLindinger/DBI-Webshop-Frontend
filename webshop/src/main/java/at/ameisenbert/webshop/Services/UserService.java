package at.ameisenbert.webshop.Services;

import at.ameisenbert.webshop.Entities.DTO.UserDTO;
import at.ameisenbert.webshop.Entities.Resource.UserResource;
import at.ameisenbert.webshop.Entities.DB.UserDB;
import at.ameisenbert.webshop.Exceptions.BadRequestException;
import at.ameisenbert.webshop.Exceptions.NotFoundException;
import at.ameisenbert.webshop.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@PostConstruct
    public void initProduct() {
        UserDB user = new UserDB(1, "sebastian", "geheimagent", "12/10/2021", "sebastian@gmail.com");
        userRepository.save(user);
    }

    public UserResource getUserResourceById(int id) {
        return userToUserResource(getUserById(id));
    }

    private UserDB getUserById(int id) {
        Optional<UserDB> userDB = userRepository.findById(id);
        if (userDB.isPresent()) return userDB.get();
        else throw new NotFoundException("User with the id " + id + " was not found");
    }

    private UserResource userToUserResource(UserDB user) {
        return new UserResource(user.getUserID(), user.getUserName(), user.getEmail());
    }

    public List<UserResource> getStudentsResource() {
        return userRepository.findAll().stream()
                .map(user -> new UserResource(user.getUserID(), user.getUserName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserResource addUser(UserDTO userDTO) {
        checkUserDTO(userDTO);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(UserDB.dateFormat);
        UserDB user = new UserDB(null, userDTO.getUserName(), userDTO.getPassword(), LocalDate.now().format(dtf), userDTO.getEmail());

        userRepository.save(user);
        return userToUserResource(user);
    }

    private void checkUserDTO(UserDTO userDTO) {
        if (userDTO.getUserName() == null || userDTO.getUserName().trim().equals(""))
            throw new BadRequestException("Username must be set");
        if (userDTO.getPassword() == null || userDTO.getPassword().trim().equals(""))
            throw new BadRequestException("Password must be set");
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().equals(""))
            throw new BadRequestException("Email must be set");
    }

    public UserResource updateUser(int id, UserDTO userDTO) {
        UserDB user = getUserById(id);

        if (userDTO.getEmail() != null && !userDTO.getEmail().trim().equals(""))
            user.setEmail(userDTO.getEmail());

        if (userDTO.getPassword() != null && !userDTO.getPassword().trim().equals(""))
            user.setPassword(userDTO.getPassword());

        if (userDTO.getUserName() != null && !userDTO.getUserName().trim().equals(""))
            user.setUserName(userDTO.getUserName());

        user = userRepository.save(user);
        return userToUserResource(user);
    }

    public UserResource deleteUser(int id) {
        UserDB user = getUserById(id);

        userRepository.delete(user);
        return userToUserResource(user);
    }

    public int login(UserDTO user) {
        List<UserDB> users = userRepository.findAll();
        for (UserDB userDB : users) {
            if (userDB.getUserName().equals(user.getUserName()) && userDB.getPassword().equals(user.getPassword()))
                return userDB.getUserID();
        }
        return -1;
    }
}

