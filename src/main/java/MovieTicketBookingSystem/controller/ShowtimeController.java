package MovieTicketBookingSystem.controller;

import MovieTicketBookingSystem.entity.Showtime;
import MovieTicketBookingSystem.service.ShowtimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    // 构造器注入
    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping
    public ResponseEntity<List<Showtime>> getAllShowtimes() {
        List<Showtime> showtimes = showtimeService.getAllShowtimes();
        return ResponseEntity.ok(showtimes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable Long id) {
        Showtime showtime = showtimeService.getShowtimeById(id);
        if (showtime != null) {
            return ResponseEntity.ok(showtime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Showtime> createShowtime(@RequestBody Showtime showtime) {
        Showtime savedShowtime = showtimeService.saveShowtime(showtime);
        return ResponseEntity.ok(savedShowtime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Showtime> updateShowtime(
            @PathVariable Long id,
            @RequestBody Showtime showtimeDetails) {

        // 直接使用showtimeDetails中的数据更新放映时间
        Showtime updatedShowtime = showtimeService.updateShowtime(id, showtimeDetails);

        if (updatedShowtime != null) {
            return ResponseEntity.ok(updatedShowtime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable Long id) {
        boolean isDeleted = showtimeService.deleteShowtime(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
