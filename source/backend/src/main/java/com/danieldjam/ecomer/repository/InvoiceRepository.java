package com.danieldjam.ecomer.repository;

import com.danieldjam.ecomer.models.dto.InvoiceDTO;
import com.danieldjam.ecomer.models.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    @Query("SELECT i FROM Invoice i WHERE i.userId=:userId")
    public List<Invoice> getInvoiceByUserId(@Param("userId") Integer userId);
}
