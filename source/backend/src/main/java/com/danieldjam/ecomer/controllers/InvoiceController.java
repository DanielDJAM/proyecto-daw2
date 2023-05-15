package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.models.dto.InvoiceDTO;
import com.danieldjam.ecomer.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<InvoiceDTO> getAllInvoices(){return invoiceService.getAllInvoices();}

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTO){
        return new ResponseEntity<>(invoiceService.createInvoice(invoiceDTO), HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public List<InvoiceDTO> getAllInvoicesByUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return invoiceService.getAllInvoicesByUserId(authentication.getName());
    }

}
