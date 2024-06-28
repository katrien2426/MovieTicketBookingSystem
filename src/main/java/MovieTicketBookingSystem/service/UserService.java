package MovieTicketBookingSystem.service;

import MovieTicketBookingSystem.entity.User;
import MovieTicketBookingSystem.Mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    // 构造器注入
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public User getUserById(Long id) {
        return userMapper.findById(id);
    }

    public User saveUser(User user) {
        user.prePersist();
        userMapper.save(user);
        return user;
    }

    public User updateUser(Long id, User userDetails) {
        User user = userMapper.findById(id);
        if (user != null) {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            userMapper.update(user);
            return user;
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long id) {
        if (userMapper.existsById(id)) {
            userMapper.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
