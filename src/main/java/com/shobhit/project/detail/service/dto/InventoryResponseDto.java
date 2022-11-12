package com.shobhit.project.detail.service.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class InventoryResponseDto implements Serializable {
    private Integer id;
    private String productKey;
    private String productTitle;
    private String productColor;
    private String productDesign;
    private Double productScreenSize;
    private String barcode;
}