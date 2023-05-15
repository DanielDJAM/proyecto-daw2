package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.InvoiceDTO;
import com.danieldjam.ecomer.models.entities.Invoice;
import com.danieldjam.ecomer.models.entities.User;
import com.danieldjam.ecomer.repository.InvoiceRepository;
import com.danieldjam.ecomer.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class InvoiceServicesImpl implements InvoiceService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceRepository.save(convertInvoiceDTOToEntity(invoiceDTO));
        return convertInvoiceEntityToDTO(invoice);
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        List<Invoice> invoiceList = invoiceRepository.findAll();
        return invoiceList.stream().map(invoice -> convertInvoiceEntityToDTO(invoice)).collect(Collectors.toList());

    }

    public List<InvoiceDTO> getAllInvoicesByUserId(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found with " + email));
        List<Invoice> invoiceList = invoiceRepository.getInvoiceByUserId(user.getUserId());
        return invoiceList.stream().map(invoice -> convertInvoiceEntityToDTO(invoice)).collect(Collectors.toList());
    }

    @Override
    public InvoiceDTO getInvoiceById(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new NoSuchElementException("Invoice not found with invoiceId " + invoiceId));
        return convertInvoiceEntityToDTO(invoice);
    }

    @Override
    public InvoiceDTO updateInvoice(String invoiceId, InvoiceDTO invoiceDTO) {
        return null;
    }

    @Override
    public void deleteInvoiceById(String invoiceID) {
    }

    private Invoice convertInvoiceDTOToEntity(InvoiceDTO invoiceDTO) {return modelMapper.map(invoiceDTO, Invoice.class);}

    private InvoiceDTO convertInvoiceEntityToDTO(Invoice invoice){return modelMapper.map(invoice, InvoiceDTO.class);}
}
