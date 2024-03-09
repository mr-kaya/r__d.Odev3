package org.mustafakaya.odev5.Core.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "orders")
@Entity
public class OrderEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    private String orderNumber;

    @Column
    @CreationTimestamp
    private Date orderDate;
    private String orderDescription;
    private Double totalAmount;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private Set<OrderProductEntity> orderProductEntity = new HashSet<>();

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
