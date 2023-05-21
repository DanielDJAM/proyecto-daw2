package com.danieldjam.ecomer.controllers;

import com.danieldjam.ecomer.models.dto.InvoiceProductDTO;
import com.danieldjam.ecomer.models.entities.InvoiceProductId;
import com.danieldjam.ecomer.service.InvoiceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-products")
public class InvoiceProductController {

    @Autowired
    private InvoiceProductService invoiceProductService;

    @PostMapping
    public ResponseEntity<InvoiceProductDTO> createInvoiceProduct(@RequestBody InvoiceProductDTO invoiceProductDTO) {
        InvoiceProductDTO createdInvoiceProduct = invoiceProductService.createInvoiceProduct(invoiceProductDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoiceProduct);
    }

    @GetMapping("/{invoiceId}/{productInvoiceId}")
    public ResponseEntity<InvoiceProductDTO> getInvoiceProductById(
            @PathVariable("invoiceId") Integer invoiceId,
            @PathVariable("productInvoiceId") Integer productInvoiceId) {
        InvoiceProductId invoiceProductId = new InvoiceProductId(invoiceId, productInvoiceId);
        InvoiceProductDTO invoiceProduct = invoiceProductService.getInvoiceProductById(invoiceProductId);
        return ResponseEntity.ok(invoiceProduct);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<List<InvoiceProductDTO>> getAllProductsByInvoice(@PathVariable("invoiceId") Integer invoiceId) {
        List<InvoiceProductDTO> invoiceProducts = invoiceProductService.getAllProductsByInvoice(invoiceId);
        return ResponseEntity.ok(invoiceProducts);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceProductDTO>> getAllInvoiceProducts() {
        List<InvoiceProductDTO> invoiceProducts = invoiceProductService.getAllInvoiceProducts();
        return ResponseEntity.ok(invoiceProducts);
    }

    @PutMapping("/{invoiceId}/{productInvoiceId}")
    public ResponseEntity<Void> updateInvoiceProduct(
            @PathVariable("invoiceId") Integer invoiceId,
            @PathVariable("productInvoiceId") Integer productInvoiceId,
            @RequestBody InvoiceProductDTO updatedInvoiceProductDTO) {
        InvoiceProductId invoiceProductId = new InvoiceProductId(invoiceId, productInvoiceId);
        invoiceProductService.updateInvoiceProduct(invoiceProductId, updatedInvoiceProductDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{invoiceId}/{productInvoiceId}")
    public ResponseEntity<Void> deleteInvoiceProduct(
            @PathVariable("invoiceId") Integer invoiceId,
            @PathVariable("productInvoiceId") Integer productInvoiceId) {
        InvoiceProductId invoiceProductId = new InvoiceProductId(invoiceId, productInvoiceId);
        invoiceProductService.deleteInvoiceProduct(invoiceProductId);
        return ResponseEntity.ok().build();
    }
}

