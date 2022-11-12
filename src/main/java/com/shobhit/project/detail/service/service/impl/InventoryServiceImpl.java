package com.shobhit.project.detail.service.service.impl;

import com.shobhit.project.detail.service.dto.InventoryDto;
import com.shobhit.project.detail.service.dto.InventoryResponseDto;
import com.shobhit.project.detail.service.exception.InventoryNotFoundException;
import com.shobhit.project.detail.service.exception.ProductDetailsNotFoundException;
import com.shobhit.project.detail.service.model.Inventory;
import com.shobhit.project.detail.service.model.ProductDetails;
import com.shobhit.project.detail.service.repository.InventoryRepository;
import com.shobhit.project.detail.service.repository.ProductDetailsRepository;
import com.shobhit.project.detail.service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public InventoryResponseDto saveInventory(InventoryDto inventoryDto) {
      ProductDetails productDetails =  productDetailsRepository.findByProductKey(inventoryDto.getProductKey()).orElseThrow(ProductDetailsNotFoundException::new);

        Inventory inventory = new Inventory();
        inventory.setBarcode(inventoryDto.getBarcode());
        inventory.setProductId(productDetails);
        inventory.setCreatedAt(Instant.now());
        inventory.setUpdateAt(Instant.now());

        inventoryRepository.save(inventory);

        return getInventoryResponse(inventory);
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public InventoryResponseDto updateInventory(Integer id, InventoryDto inventoryDto) {

        Inventory inventory = inventoryRepository.findById(id).orElseThrow(InventoryNotFoundException::new);

        ProductDetails productDetails =  productDetailsRepository.findByProductKey(inventoryDto.getProductKey()).orElseThrow(ProductDetailsNotFoundException::new);

        inventory.setBarcode(inventoryDto.getBarcode());
        inventory.setProductId(productDetails);
        inventory.setUpdateAt(Instant.now());

        inventoryRepository.save(inventory);
        return getInventoryResponse(inventory);
    }

    @Override
    public InventoryResponseDto getInventory(Integer id) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(InventoryNotFoundException::new);

        return getInventoryResponse(inventory);
    }

    private InventoryResponseDto getInventoryResponse(Inventory inventory) {
        InventoryResponseDto inventoryResponseDto = new InventoryResponseDto();
       ProductDetails productDetails = inventory.getProductId();
       inventoryResponseDto.setId(inventory.getId());
        inventoryResponseDto.setBarcode(inventory.getBarcode());
        inventoryResponseDto.setProductColor(productDetails.getColor());
        inventoryResponseDto.setProductKey(productDetails.getProductKey());
        inventoryResponseDto.setProductTitle(productDetails.getProductTitle());
        inventoryResponseDto.setProductDesign(productDetails.getDesign());
        inventoryResponseDto.setProductScreenSize(productDetails.getScreenSize());

        return inventoryResponseDto;
    }
}
