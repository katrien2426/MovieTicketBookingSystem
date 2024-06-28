package MovieTicketBookingSystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private Long id;
    private Long userId;
    private Long showtimeId;
    private LocalDateTime bookingTime = LocalDateTime.now();
    private String seatNumber;
    private Double totalPrice;
    private String paymentStatus;
    private LocalDateTime createdAt = LocalDateTime.now();
}
