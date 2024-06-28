package MovieTicketBookingSystem.service;

import MovieTicketBookingSystem.entity.Showtime;
import MovieTicketBookingSystem.Mapper.ShowtimeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {

    private final ShowtimeMapper showtimeMapper;

    // 构造器注入
    public ShowtimeService(ShowtimeMapper showtimeMapper) {
        this.showtimeMapper = showtimeMapper;
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeMapper.findAll();
    }

    public Showtime getShowtimeById(Long id) {
        return showtimeMapper.findById(id);
    }

    public Showtime saveShowtime(Showtime showtime) {
        showtimeMapper.save(showtime);
        return showtime;
    }

    public Showtime updateShowtime(Long id, Showtime showtimeDetails) {
        Showtime showtime = showtimeMapper.findById(id);
        if (showtime != null) {
            showtime.setMovieId(showtimeDetails.getMovieId());
            showtime.setTheaterId(showtimeDetails.getTheaterId());
            showtime.setStartTime(showtimeDetails.getStartTime());
            showtime.setEndTime(showtimeDetails.getEndTime());
            showtime.setPrice(showtimeDetails.getPrice());
            showtimeMapper.update(showtime);
            return showtime;
        } else {
            return null;
        }
    }

    public boolean deleteShowtime(Long id) {
        if (showtimeMapper.existsById(id)) {
            showtimeMapper.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
