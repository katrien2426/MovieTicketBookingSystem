package MovieTicketBookingSystem.Mapper;

import MovieTicketBookingSystem.entity.Booking;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookingMapper {

    @Select("SELECT * FROM bookings WHERE user_id = #{userId}")
    List<Booking> findByUserId(Long userId);

    @Select("SELECT * FROM bookings WHERE showtime_id = #{showtimeId}")
    List<Booking> findByShowtimeId(Long showtimeId);

    @Select("SELECT * FROM bookings WHERE seat_number = #{seatNumber}")
    List<Booking> findBySeatNumber(String seatNumber);

    @Select("SELECT * FROM bookings")
    List<Booking> findAll();

    @Select("SELECT * FROM bookings WHERE id = #{id}")
    Booking findById(Long id);

    @Insert("INSERT INTO bookings (user_id, showtime_id, seat_number, booking_date) VALUES (#{userId}, #{showtimeId}, #{seatNumber}, #{bookingDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Booking booking);

    @Select("SELECT COUNT(*) > 0 FROM bookings WHERE id = #{id}")
    boolean existsById(Long id);

    @Delete("DELETE FROM bookings WHERE id = #{id}")
    void deleteById(Long id);
}
