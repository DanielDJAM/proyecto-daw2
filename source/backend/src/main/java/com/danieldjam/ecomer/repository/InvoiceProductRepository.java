package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.entities.InvoiceProduct;
import com.danieldjam.ecomer.models.entities.InvoiceProductId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, InvoiceProductId> {
    List<InvoiceProduct> findByInvoiceIdInvoiceId(Integer invoiceId);
}
