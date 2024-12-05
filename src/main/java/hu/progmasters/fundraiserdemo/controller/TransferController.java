package hu.progmasters.fundraiserdemo.controller;

import hu.progmasters.fundraiserdemo.dto.TransferInitData;
import hu.progmasters.fundraiserdemo.dto.TransferListItem;
import hu.progmasters.fundraiserdemo.service.TransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/transfers")
@Slf4j
public class TransferController {

    private TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public ResponseEntity<List<TransferListItem>> getAllTransfers() {
        log.info("http req GET /api/transfers :");
        List<TransferListItem> transferListItems = transferService.getAllTransfers();
        return new ResponseEntity<>(transferListItems, HttpStatus.OK);
    }

    @GetMapping("/newTransferData")
    public ResponseEntity<TransferInitData> newTransferData(HttpServletRequest request) {
        log.info("http req GET /api/transfers/newTransferData, with ip address: " + request.getRemoteAddr());
        TransferInitData transferInitData = transferService.getNewTransferData(request.getRemoteAddr());
        return new ResponseEntity<>(transferInitData, HttpStatus.OK);

    }
}
