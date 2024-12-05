package hu.progmasters.fundraiserdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {
    private Long id;
    private String username;
    private String goal;
    private Integer balance;
    private Integer fund;
    private List<TransferListItem> incomingTransfers = new ArrayList();
    private List<TransferListItem> outgoingTransfers = new ArrayList();


//    public AccountDetails(Account account) {
//        this.id = account.getId();
//        this.username = account.getUsername();
//        this.goal = account.getGoal();
//        this.balance = account.getBalance();
//        this.fund = account.getFunds();
//        this.incomingTransfers = account.getIncomingTransfers().stream()
//                .map(TransferListItem::new).collect(Collectors.toList());
//        this.outgoingTransfers = account.getOutgoingTransfers().stream()
//                .map(TransferListItem::new).collect(Collectors.toList());
//    }
}
