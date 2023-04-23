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
public class RolHasUserId implements Serializable {
    private static final long serialVersionUID = 9117581143288600255L;
    @Column(name = "rol_ID", nullable = false, length = 45)
    private String rolId;

    @Column(name = "user_ID", nullable = false, length = 50)
    private String userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RolHasUserId entity = (RolHasUserId) o;
        return Objects.equals(this.rolId, entity.rolId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId, userId);
    }

}