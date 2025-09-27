package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    boolean deleteUser(Long id);
}
