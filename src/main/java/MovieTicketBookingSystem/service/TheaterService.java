package MovieTicketBookingSystem.service;

import MovieTicketBookingSystem.entity.Theater;
import MovieTicketBookingSystem.Mapper.TheaterMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    private final TheaterMapper theaterMapper;

    // 构造器注入
    public TheaterService(TheaterMapper theaterMapper) {
        this.theaterMapper = theaterMapper;
    }

    public List<Theater> getAllTheaters() {
        return theaterMapper.findAll();
    }

    public Theater getTheaterById(Long id) {
        return theaterMapper.findById(id);
    }

    public Theater saveTheater(Theater theater) {
        theaterMapper.save(theater);
        return theater;
    }

    public Theater updateTheater(Long id, Theater theaterDetails) {
        Theater theater = theaterMapper.findById(id);
        if (theater != null) {
            theater.setName(theaterDetails.getName());
            theater.setSeats(theaterDetails.getSeats());
            theaterMapper.update(theater);
            return theater;
        } else {
            return null;
        }
    }

    public boolean deleteTheater(Long id) {
        if (theaterMapper.existsById(id)) {
            theaterMapper.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
