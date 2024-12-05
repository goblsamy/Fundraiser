package hu.progmasters.fundraiserdemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "ip_address")
    private String ipAddress;

    private String goal;

    private Integer balance;

    private Integer funds;

    @OneToMany(mappedBy = "source")
    private List<Transfer> outgoingTransfers;

    @OneToMany(mappedBy = "target")
    private List<Transfer> incomingTransfers;
}
