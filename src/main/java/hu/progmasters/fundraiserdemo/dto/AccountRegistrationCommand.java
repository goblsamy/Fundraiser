package hu.progmasters.fundraiserdemo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AccountRegistrationCommand {

    @Size(min = 4, max = 30, message = "Username must be between 4 and 30 chars!")
    @NotNull(message = "Username cannot be null!")
    private String username;

    @Size(min = 4, max = 30, message = "Goal must be between 4 and 30 chars!")
    @NotNull(message = "Goal cannot be null!")
    private String goal;
}
