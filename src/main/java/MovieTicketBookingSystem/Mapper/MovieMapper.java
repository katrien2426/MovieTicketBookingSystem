package MovieTicketBookingSystem.Mapper;

import MovieTicketBookingSystem.entity.Movie;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MovieMapper {

    // 查询单个电影
    @Select("SELECT * FROM movies WHERE id = #{id}")
    Movie findById(Long id);

    // 查询所有电影
    @Select("SELECT * FROM movies")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "genre", column = "genre"),
            @Result(property = "language", column = "language"),
            @Result(property = "rating", column = "rating"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "releaseDate", column = "release_date", javaType = LocalDateTime.class),
            @Result(property = "description", column = "description")
    })
    List<Movie> findAll();

    // 插入新电影
    @Insert("INSERT INTO movies (title, genre, language, rating, duration, release_date, description) VALUES (#{title}, #{genre}, #{language}, #{rating}, #{duration}, #{releaseDate}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Movie movie);

    // 更新电影信息
    @Update("UPDATE movies SET title = #{title}, genre = #{genre}, language = #{language}, rating = #{rating}, duration = #{duration}, release_date = #{releaseDate}, description = #{description} WHERE id = #{id}")
    void update(Movie movie);

    // 删除电影
    @Delete("DELETE FROM movies WHERE id = #{id}")
    void deleteById(Long id);

    // 检查电影是否存在
    @Select("SELECT COUNT(*) > 0 FROM movies WHERE id = #{id}")
    boolean existsById(Long id);
}
