package hu.progmasters.fundraiserdemo.dto;

import hu.progmasters.fundraiserdemo.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TargetAccountOption {

    private Long id;
    private String goal;


    public TargetAccountOption(Account account) {
        this.id = account.getId();
        this.goal = account.getGoal();
    }
}
