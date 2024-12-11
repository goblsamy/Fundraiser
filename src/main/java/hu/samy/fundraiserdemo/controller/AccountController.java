package hu.samy.fundraiserdemo.controller;

import hu.samy.fundraiserdemo.dto.AccountDetails;
import hu.samy.fundraiserdemo.dto.AccountRegistrationCommand;
import hu.samy.fundraiserdemo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController {
    private AccountService accountService;


    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody @Valid AccountRegistrationCommand command, HttpServletRequest request) {
        log.info("http req POST /api/accounts :" + command.toString());
        String ipAddress = request.getRemoteAddr();
        accountService.saveAccount(command, ipAddress);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/my-account")
    public ResponseEntity<AccountDetails> getMyAccount(HttpServletRequest request) {
        log.info("http req GET /api/accounts/my-account :");
        String ipAddress = request.getRemoteAddr();
        AccountDetails accountDetails = accountService.getMyAccount(ipAddress);
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<AccountDetails>> getAccounts() {
        log.info("http req GET /api/accounts :");
        List<AccountDetails> accountDetails = accountService.getAllAccounts();
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
    }
}
