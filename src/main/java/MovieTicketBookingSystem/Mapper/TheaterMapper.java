package MovieTicketBookingSystem.Mapper;

import MovieTicketBookingSystem.entity.Theater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TheaterMapper {

    @Select("SELECT * FROM theaters WHERE id = #{id}")
    Theater findById(Long id);

    @Select("SELECT * FROM theaters")
    List<Theater> findAll();

    @Insert("INSERT INTO theaters (name, seats) VALUES (#{name}, #{seats})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Theater theater);

    @Update("UPDATE theaters SET name = #{name}, seats = #{seats} WHERE id = #{id}")
    void update(Theater theater);

    @Delete("DELETE FROM theaters WHERE id = #{id}")
    void deleteById(Long id);

    @Select("SELECT COUNT(*) > 0 FROM theaters WHERE id = #{id}")
    boolean existsById(Long id);
}
