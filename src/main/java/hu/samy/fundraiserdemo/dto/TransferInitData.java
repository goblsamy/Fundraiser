package hu.samy.fundraiserdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferInitData {

    private String sourceAccountName;
    private List<TargetAccountOption> targetAccountOptions;
    private Integer balance;
}
