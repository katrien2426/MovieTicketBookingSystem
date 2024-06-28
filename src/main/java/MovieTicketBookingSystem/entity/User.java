package MovieTicketBookingSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String role;
    private String email;
    private String phone;
    private LocalDateTime createdAt = LocalDateTime.now();

    // 自动设置创建时间
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
