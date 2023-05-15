package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService{

    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);

    public List<InvoiceDTO> getAllInvoices();

    public List<InvoiceDTO> getAllInvoicesByUserId(String email);
    public InvoiceDTO getInvoiceById(String invoiceId);
    public InvoiceDTO updateInvoice(String invoiceId, InvoiceDTO invoiceDTO);
    public void deleteInvoiceById(String invoiceID);

}
