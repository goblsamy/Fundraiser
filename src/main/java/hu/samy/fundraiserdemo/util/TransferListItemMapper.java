package hu.samy.fundraiserdemo.util;


import hu.samy.fundraiserdemo.domain.Transfer;
import hu.samy.fundraiserdemo.dto.TransferListItem;
public class TransferListItemMapper {

    public static TransferListItem transferListItemMap(Transfer transfer) {
        TransferListItem transferListItem = new TransferListItem();
        transferListItem.setId(transfer.getId());
        transferListItem.setAmount(transfer.getAmount());
        transferListItem.setTimestamp(transfer.getTimestamp().toString());
        transferListItem.setSourceName(transfer.getSource().getUsername());
        transferListItem.setTargetName(transfer.getTarget().getUsername());
        return transferListItem;
    }
}
