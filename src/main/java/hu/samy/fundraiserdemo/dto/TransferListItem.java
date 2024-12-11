package hu.samy.fundraiserdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferListItem {
    private Long id;
    private String sourceName;
    private String targetName;
    private Integer amount;
    private String timeStamp;
//
//    public TransferListItem(Transfer transfer) {
//        this.id = transfer.getId();
//        this.sourceName = transfer.getSource().getUsername();
//        this.targetName = transfer.getTarget().getUsername();
//        this.amount = transfer.getAmount();
//        this.timeStamp = transfer.getTimestamp().toString();
//    }
}
