package com.oscar2.ubicua2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(
        name = "order_items"
)
public class orderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String imgUrl;
    private BigDecimal price;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private product Product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private order Order;
}
