package thymeleafspringboot.respository;

import java.util.List;

import thymeleafspringboot.entity.User;

public interface UserRepository {
    public List<User> findAll();
    public User findById(long id);
    public void save(User user);
    public void update(User user);
    public void deleteById(long id);
}
