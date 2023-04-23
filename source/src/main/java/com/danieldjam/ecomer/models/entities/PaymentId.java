//package com.danieldjam.ecomer.models.entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.Hibernate;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Getter
//@Setter
//@Embeddable
//public class PaymentId implements Serializable {
//    private static final long serialVersionUID = -1478615351246570367L;
//    @Column(name = "payment_ID", nullable = false)
//    private Integer paymentId;
//
//    @Column(name = "user_ID", nullable = false, length = 50)
//    private String userId;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        PaymentId entity = (PaymentId) o;
//        return Objects.equals(this.paymentId, entity.paymentId) &&
//                Objects.equals(this.userId, entity.userId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(paymentId, userId);
//    }
//
//}