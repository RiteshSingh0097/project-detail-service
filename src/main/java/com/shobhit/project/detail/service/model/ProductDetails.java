package com.shobhit.project.detail.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@ToString
@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productId;

    @Column(name = "product_key", unique = true)
    String productKey;

    String productTitle;

    String color;

    String design;

    Double screenSize;

    Instant createdAt;

    Instant updateAt;

    String createdBy;

    String updatedBy;
}
