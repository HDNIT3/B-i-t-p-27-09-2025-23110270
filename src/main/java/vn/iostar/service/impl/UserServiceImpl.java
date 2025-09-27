package vn.iostar.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.iostar.entity.User;
import vn.iostar.repository.UserRepository;
import vn.iostar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(u -> {
            u.setFullname(user.getFullname());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setPhone(user.getPhone());
            return userRepository.save(u);
        }).orElse(null);
    }

    @Override
    public boolean deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
