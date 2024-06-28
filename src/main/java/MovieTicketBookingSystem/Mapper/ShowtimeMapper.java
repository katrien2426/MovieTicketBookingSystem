package MovieTicketBookingSystem.Mapper;

import MovieTicketBookingSystem.entity.Showtime;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ShowtimeMapper {

    // 查询单个场次
    @Select("SELECT * FROM showtimes WHERE id = #{id}")
    Showtime findById(Long id);

    // 查询所有场次
    @Select("SELECT * FROM showtimes")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "movieId", column = "movie_id"),
            @Result(property = "theaterId", column = "theater_id"),
            @Result(property = "startTime", column = "start_time", javaType = LocalDateTime.class),
            @Result(property = "endTime", column = "end_time", javaType = LocalDateTime.class),
            @Result(property = "price", column = "price")
    })
    List<Showtime> findAll();

    // 插入新场次
    @Insert("INSERT INTO showtimes (movie_id, theater_id, start_time, end_time, price) VALUES (#{movieId}, #{theaterId}, #{startTime}, #{endTime}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Showtime showtime);

    // 更新场次信息
    @Update("UPDATE showtimes SET movie_id = #{movieId}, theater_id = #{theaterId}, start_time = #{startTime}, end_time = #{endTime}, price = #{price} WHERE id = #{id}")
    void update(Showtime showtime);

    // 删除场次
    @Delete("DELETE FROM showtimes WHERE id = #{id}")
    void deleteById(Long id);

    // 检查场次是否存在
    @Select("SELECT COUNT(*) > 0 FROM showtimes WHERE id = #{id}")
    boolean existsById(Long id);
}
