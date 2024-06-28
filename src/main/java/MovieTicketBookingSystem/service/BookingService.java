package MovieTicketBookingSystem.service;

import MovieTicketBookingSystem.entity.Booking;
import MovieTicketBookingSystem.Mapper.BookingMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingMapper bookingMapper;

    // 构造器注入
    public BookingService(BookingMapper bookingMapper) {
        this.bookingMapper = bookingMapper;
    }

    // 获取所有预订
    public List<Booking> getAllBookings() {
        return bookingMapper.findAll();
    }

    // 根据ID获取预订
    public Booking getBookingById(Long id) {
        return bookingMapper.findById(id);
    }

    // 保存预订
    public Booking saveBooking(Booking booking) {
        bookingMapper.save(booking);
        return booking;
    }

    // 更新预订
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingMapper.findById(id);
        if (booking != null) {
            booking.setUserId(bookingDetails.getUserId());
            booking.setShowtimeId(bookingDetails.getShowtimeId());
            booking.setBookingTime(bookingDetails.getBookingTime());
            booking.setSeatNumber(bookingDetails.getSeatNumber());
            booking.setTotalPrice(bookingDetails.getTotalPrice());
            booking.setPaymentStatus(bookingDetails.getPaymentStatus());
            booking.setCreatedAt(bookingDetails.getCreatedAt());
            bookingMapper.save(booking);
            return booking;
        } else {
            return null;
        }
    }

    // 删除预订
    public boolean deleteBooking(Long id) {
        if (bookingMapper.existsById(id)) {
            bookingMapper.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // 根据用户ID获取预订
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingMapper.findByUserId(userId);
    }

    // 根据放映时间ID获取预订
    public List<Booking> getBookingsByShowtimeId(Long showtimeId) {
        return bookingMapper.findByShowtimeId(showtimeId);
    }

    // 根据座位号获取预订
    public List<Booking> getBookingsBySeatNumber(String seatNumber) {
        return bookingMapper.findBySeatNumber(seatNumber);
    }
}
