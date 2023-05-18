package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.InvoiceDTO;
import com.danieldjam.ecomer.models.entities.Invoice;
import com.danieldjam.ecomer.models.entities.Product;
import com.danieldjam.ecomer.repository.InvoiceRepository;
import com.danieldjam.ecomer.repository.OrderRepository;
import com.danieldjam.ecomer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = new Invoice();
        mapDtoToEntity(invoiceDTO, invoice);
        return mapEntityToDto(invoiceRepository.save(invoice));
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        List<InvoiceDTO> invoiceDTOList = new ArrayList<>();
        List<Invoice> invoiceList = invoiceRepository.findAll();
        invoiceList.stream().forEach(invoice -> {
            InvoiceDTO invoiceDTO = mapEntityToDto(invoice);
            invoiceDTOList.add(invoiceDTO);
        });
        return invoiceDTOList;
    }

    @Override
    public InvoiceDTO getInvoiceById(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(Integer.parseInt(invoiceId))
                .orElseThrow(() -> new NoSuchElementException("Invoice not found with invoiceId " + invoiceId));
        return mapEntityToDto(invoice);
    }

    @Transactional
    @Override
    public InvoiceDTO updateInvoice(String invoiceId, InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceRepository.getOne(Integer.parseInt(invoiceId));
        invoice.getProductList().clear();
        mapDtoToEntity(invoiceDTO, invoice);
        return mapEntityToDto(invoiceRepository.save(invoice));
    }

    @Transactional
    @Override
    public void deleteInvoiceById(String invoiceId) {
        Optional<Invoice> invoice = invoiceRepository.findById(Integer.parseInt(invoiceId));
        if (invoice.isPresent()){
            invoice.get().removeAllProducts();
            invoiceRepository.deleteById(Integer.parseInt(invoiceId));
        }
    }

    private void mapDtoToEntity(InvoiceDTO invoiceDTO, Invoice invoice){
        invoice.setQuantity(invoiceDTO.getQuantity());
        invoice.setUnitPrice(invoiceDTO.getUnitPrice());
        invoice.setTotalPrice(invoiceDTO.getTotalPrice());
        invoice.setFinalPrice(invoiceDTO.getFinalPrice());
        invoice.setOrderId(orderRepository.findById(invoiceDTO.getOrderId()).get());
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        if (null == invoice.getProductList()) {
            invoice.setProductList(new ArrayList<>());
        }
        invoiceDTO.getProductListDTO().stream().forEach(productId -> {
            Product product = productRepository.findByName(productId.toString());
            if (null == product){
                product = new Product();
                product.setInvoiceList(new ArrayList<>());
            }
            product.setProductId(productId);
            invoice.addProduct(product);
        });
    }


    private InvoiceDTO mapEntityToDto(Invoice invoice) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setQuantity(invoice.getQuantity());
        invoiceDTO.setUnitPrice(invoice.getUnitPrice());
        invoiceDTO.setTotalPrice(invoice.getTotalPrice());
        invoiceDTO.setFinalPrice(invoice.getFinalPrice());
        invoiceDTO.setOrderId(invoice.getOrderId().getOrderId());
        invoiceDTO.setInvoiceDate(invoice.getInvoiceDate());
        invoiceDTO.setInvoiceId(invoice.getInvoiceId());
        invoiceDTO.setProductListDTO(invoice.getProductList().stream().map(Product::getProductId).collect(Collectors.toList()));
        return invoiceDTO;
    }


}
