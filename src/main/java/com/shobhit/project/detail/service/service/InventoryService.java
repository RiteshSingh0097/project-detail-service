package com.shobhit.project.detail.service.service;

import com.shobhit.project.detail.service.dto.InventoryDto;
import com.shobhit.project.detail.service.dto.InventoryResponseDto;

public interface InventoryService {

    InventoryResponseDto saveInventory(InventoryDto inventoryDto);

    InventoryResponseDto updateInventory(Integer id, InventoryDto inventoryDto);

    InventoryResponseDto getInventory(Integer id);
}
