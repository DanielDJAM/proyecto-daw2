package com.danieldjam.ecomer.service;

import com.danieldjam.ecomer.models.dto.InvoiceProductDTO;
import com.danieldjam.ecomer.models.entities.InvoiceProduct;
import com.danieldjam.ecomer.models.entities.InvoiceProductId;
import com.danieldjam.ecomer.repository.InvoiceProductRepository;
import com.danieldjam.ecomer.repository.InvoiceRepository;
import com.danieldjam.ecomer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceProductServiceImpl implements InvoiceProductService {

    @Autowired
    private InvoiceProductRepository invoiceProductRepository;

    @Override
    public InvoiceProductDTO createInvoiceProduct(InvoiceProductDTO invoiceProductDTO) {
        return convertToDTO(invoiceProductRepository.save(convertToEntity(invoiceProductDTO)));
    }

    @Override
    public InvoiceProductDTO getInvoiceProductById(InvoiceProductId invoiceProductId) {
        Optional<InvoiceProduct> invoiceProduct = invoiceProductRepository.findById(invoiceProductId);
        if (invoiceProduct.isPresent()) {
            return convertToDTO(invoiceProduct.get());
        }
        return null;
    }

    @Override
    public List<InvoiceProductDTO> getAllProductsByInvoice(Integer invoiceId) {
        List<InvoiceProduct> invoiceProducts = invoiceProductRepository.findByInvoiceIdInvoiceId(invoiceId);
        return invoiceProducts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceProductDTO> getAllInvoiceProducts() {
        List<InvoiceProduct> invoiceProducts = invoiceProductRepository.findAll();
        return invoiceProducts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void updateInvoiceProduct(InvoiceProductId invoiceProductId, InvoiceProductDTO updatedInvoiceProductDTO) {
        Optional<InvoiceProduct> invoiceProduct = invoiceProductRepository.findById(invoiceProductId);
        if (invoiceProduct.isPresent()) {
            InvoiceProduct existingInvoiceProduct = invoiceProduct.get();
            existingInvoiceProduct.setProviderId(updatedInvoiceProductDTO.getProviderId());
            existingInvoiceProduct.setProductName(updatedInvoiceProductDTO.getProductName());
            existingInvoiceProduct.setQuantity(updatedInvoiceProductDTO.getQuantity());
            existingInvoiceProduct.setUnitPrice(updatedInvoiceProductDTO.getUnitPrice());
            existingInvoiceProduct.setTotalPrice(updatedInvoiceProductDTO.getTotalPrice());
            existingInvoiceProduct.setInvoiceProductId(updatedInvoiceProductDTO.getInvoiceProductId());
            existingInvoiceProduct.setProductInvoiceId(updatedInvoiceProductDTO.getProductInvoiceId());
            invoiceProductRepository.save(existingInvoiceProduct);
        }
    }

    @Override
    public void deleteInvoiceProduct(InvoiceProductId invoiceProductId) {
        invoiceProductRepository.deleteById(invoiceProductId);
    }

    private InvoiceProductDTO convertToDTO(InvoiceProduct invoiceProduct) {
        InvoiceProductDTO invoiceProductDTO = new InvoiceProductDTO();
        invoiceProductDTO.setInvoiceId(invoiceProduct.getInvoiceProductId());
        invoiceProductDTO.setProductId(invoiceProduct.getProductInvoiceId());
        invoiceProductDTO.setProductName(invoiceProduct.getProductName());
        invoiceProductDTO.setQuantity(invoiceProduct.getQuantity());
        invoiceProductDTO.setProviderId(invoiceProduct.getProviderId());
        invoiceProductDTO.setUnitPrice(invoiceProduct.getUnitPrice());
        invoiceProductDTO.setTotalPrice(invoiceProduct.getTotalPrice());
        return invoiceProductDTO;
    }

    private InvoiceProduct convertToEntity(InvoiceProductDTO invoiceProductDTO) {
        InvoiceProduct invoiceProduct = new InvoiceProduct();
        invoiceProduct.setInvoiceProductId(invoiceProductDTO.getInvoiceId());
        invoiceProduct.setProductInvoiceId(invoiceProductDTO.getProductId());
        invoiceProduct.setProductName(invoiceProductDTO.getProductName());
        invoiceProduct.setQuantity(invoiceProductDTO.getQuantity());
        invoiceProduct.setUnitPrice(invoiceProductDTO.getUnitPrice());
        invoiceProduct.setTotalPrice(invoiceProductDTO.getTotalPrice());
        invoiceProduct.setProviderId(invoiceProductDTO.getProviderId());
        return invoiceProduct;
    }
}

