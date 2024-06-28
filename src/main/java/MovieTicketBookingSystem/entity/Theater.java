package MovieTicketBookingSystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theater {
    private Long id;
    private String name;
    private int seats;
}
