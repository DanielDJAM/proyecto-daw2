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
public class OrderId implements Serializable {
    private static final long serialVersionUID = 9125228575441886467L;
    @Column(name = "orders_ID", nullable = false)
    private Integer ordersId;

    @Column(name = "user_ID", nullable = false, length = 50)
    private String userId;

    @Column(name = "invoice_ID", nullable = false)
    private Integer invoiceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderId entity = (OrderId) o;
        return Objects.equals(this.ordersId, entity.ordersId) &&
                Objects.equals(this.invoiceId, entity.invoiceId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordersId, invoiceId, userId);
    }

}