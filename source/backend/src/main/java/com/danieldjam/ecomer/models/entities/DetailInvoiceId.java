package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DetailInvoiceId implements Serializable {
    private static final long serialVersionUID = -6944049164469910035L;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "invoice_ID", nullable = false)
    private Integer invoiceId;

    @Column(name = "user_ID", nullable = false, length = 50)
    private String userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DetailInvoiceId entity = (DetailInvoiceId) o;
        return Objects.equals(this.invoiceId, entity.invoiceId) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, quantity, userId);
    }

}