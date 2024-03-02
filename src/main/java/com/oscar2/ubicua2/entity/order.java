package com.oscar2.ubicua2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(
        name = "tbl_orders",
        schema = "ubicua",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_ordertrackingnumber",
                        columnNames = "order_tracking_number"
                )
        }
)
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp //graba por defecto la fecha actual
    private LocalDateTime dateCreated;
    @UpdateTimestamp // graba la fecha de la ultima actualizacion
    private LocalDateTime lastUpdated;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "Order")
    private address billingAddress;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "Order")
    //@JoinColumn(name = "order_id", referencedColumnName = "id")

    private Set<orderItem> OrderItems = new HashSet<>();

    public BigDecimal getTotalAmount(){
        BigDecimal amount = new BigDecimal("0.0");
        for (orderItem item: this.OrderItems){
            amount = amount.add(item.getPrice());
        }
        return amount;
    }
}
