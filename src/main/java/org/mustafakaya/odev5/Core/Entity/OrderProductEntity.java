package org.mustafakaya.odev5.Core.Entity;

import jakarta.persistence.*;

@Table(name = "orderProducts")
@Entity
public class OrderProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    private String orderProductDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public String getOrderProductDesc() {
        return orderProductDesc;
    }

    public void setOrderProductDesc(String orderProductDesc) {
        this.orderProductDesc = orderProductDesc;
    }
}
