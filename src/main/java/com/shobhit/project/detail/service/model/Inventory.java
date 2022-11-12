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
@Table(name = "inventory")
public class Inventory {

    @Id
    Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    ProductDetails productId;

    String barcode;

    Instant createdAt;

    Instant updateAt;

    String createdBy;

    String updatedBy;

}
