package vn.iostar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.*;

import vn.iostar.dto.UserInput;
import vn.iostar.entity.User;
import vn.iostar.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // --- Query ---
    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUserById(@Argument Long id) {
        return userService.getUserById(id);
    }

    // --- Mutation ---
    @MutationMapping
    public User createUser(@Argument("user") UserInput input) {
        User user = new User();
        user.setFullname(input.getFullname());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user.setPhone(input.getPhone());
        return userService.createUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument("user") UserInput input) {
        User user = new User();
        user.setId(id);
        user.setFullname(input.getFullname());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user.setPhone(input.getPhone());
        return userService.updateUser(id, user);
    }

    @MutationMapping
    public boolean deleteUser(@Argument Long id) {
        return userService.deleteUser(id);
    }
}
