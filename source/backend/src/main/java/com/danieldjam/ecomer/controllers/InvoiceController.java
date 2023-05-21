package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.models.dto.InvoiceDTO;
import com.danieldjam.ecomer.models.entities.Invoice;
import com.danieldjam.ecomer.repository.InvoiceRepository;
import com.danieldjam.ecomer.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<InvoiceDTO> getAllInvoices(){return invoiceService.getAllInvoices();}

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTO){
        return new ResponseEntity<>(invoiceService.createInvoice(invoiceDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable String invoiceId){
        return new ResponseEntity<>(invoiceService.getInvoiceById(invoiceId), HttpStatus.OK);
    }

    @PutMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDTO> updateInvoiceById(@PathVariable String invoiceId, @RequestBody InvoiceDTO invoiceDTO){
        return new ResponseEntity<>(invoiceService.updateInvoice(invoiceId, invoiceDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<Void> deleteInvoiceById(@PathVariable String invoiceId){
        invoiceService.deleteInvoiceById(invoiceId);
        return ResponseEntity.noContent().build();
    }
}
