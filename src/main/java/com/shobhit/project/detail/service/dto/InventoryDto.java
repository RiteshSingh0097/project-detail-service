package com.shobhit.project.detail.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class InventoryDto {

    @NotBlank(message = "Product key can't be blank")
    private String productKey;
    @NotBlank(message = "barcode can't be blank")
    private String barcode;
}