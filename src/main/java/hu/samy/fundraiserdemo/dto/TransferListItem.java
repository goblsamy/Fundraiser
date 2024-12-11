package hu.samy.fundraiserdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferListItem {
    private Long id;
    private String sourceName;
    private String targetName;
    private Integer amount;
    private String timestamp;

    public TransferListItem(Long id, String sourceName, String targetName, Integer amount, LocalDateTime timestamp) {
        this.id = id;
        this.sourceName = sourceName;
        this.targetName = targetName;
        this.amount = amount;
        this.timestamp = timestamp != null ? timestamp.toString() : null;
    }
//
//    public TransferListItem(Transfer transfer) {
//        this.id = transfer.getId();
//        this.sourceName = transfer.getSource().getUsername();
//        this.targetName = transfer.getTarget().getUsername();
//        this.amount = transfer.getAmount();
//        this.timeStamp = transfer.getTimestamp().toString();
//    }
}
