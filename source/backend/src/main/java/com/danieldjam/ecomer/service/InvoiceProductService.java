package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.InvoiceProductDTO;
import com.danieldjam.ecomer.models.entities.InvoiceProductId;

import java.util.List;

public interface InvoiceProductService {
    InvoiceProductDTO createInvoiceProduct(InvoiceProductDTO invoiceProductDTO);
    InvoiceProductDTO getInvoiceProductById(InvoiceProductId invoiceProductId);
    List<InvoiceProductDTO> getAllInvoiceProducts();
    void updateInvoiceProduct(InvoiceProductId invoiceProductId, InvoiceProductDTO updatedInvoiceProductDTO);
    void deleteInvoiceProduct(InvoiceProductId invoiceProductId);

    List<InvoiceProductDTO> getAllProductsByInvoice(Integer invoiceId);
}
