package thymeleafspringboot.respository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thymeleafspringboot.entity.User;
import thymeleafspringboot.respository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("select * from user where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user(name,score) values(?,?)",user.getName(),user.getScore());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("update user set name = ?,score = ? where id = ?",user.getName(),user.getScore(),user.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from user where id = ?",id);
    }
}
