package MovieTicketBookingSystem.Mapper;

import MovieTicketBookingSystem.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Long id);

    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("INSERT INTO users (username, password, role, email, phone, created_at) VALUES (#{username}, #{password}, #{role}, #{email}, #{phone}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);

    @Update("UPDATE users SET username = #{username}, password = #{password}, role = #{role}, email = #{email}, phone = #{phone} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteById(Long id);

    @Select("SELECT COUNT(*) > 0 FROM users WHERE id = #{id}")
    boolean existsById(Long id);
}
