package hu.samy.fundraiserdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferCreateCommand {

    @NotNull
    private Long target;

    @Min(value = 50, message = "Min amount is 50!")
    @Max(value = 1000, message = "Max amount is 1000!")
    private Integer amount;


}
