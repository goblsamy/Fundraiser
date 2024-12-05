package hu.progmasters.fundraiserdemo.util;


import hu.progmasters.fundraiserdemo.domain.Transfer;
import hu.progmasters.fundraiserdemo.dto.TransferListItem;
public class TransferListItemMapper {

    public static TransferListItem transferListItemMap(Transfer transfer) {
        TransferListItem transferListItem = new TransferListItem();
        transferListItem.setId(transfer.getId());
        transferListItem.setAmount(transfer.getAmount());
        transferListItem.setTimeStamp(transfer.getTimestamp().toString());
        transferListItem.setSourceName(transfer.getSource().getUsername());
        transferListItem.setTargetName(transfer.getTarget().getUsername());
        return transferListItem;
    }
}
