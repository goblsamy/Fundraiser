package hu.progmasters.fundraiserdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer")
@Data
@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "transfer_from", nullable = false)
    private Account source;

    @ManyToOne
    @JoinColumn(name = "transfer_to", nullable = false)
    private Account target;
}
