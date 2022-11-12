package com.shobhit.project.detail.service.controller;

import com.shobhit.project.detail.service.dto.InventoryDto;
import com.shobhit.project.detail.service.dto.InventoryResponseDto;
import com.shobhit.project.detail.service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/")
    public ResponseEntity<InventoryResponseDto> saveInventory(@Valid @RequestBody InventoryDto inventoryDto){
        InventoryResponseDto inventoryResponseDto = inventoryService.saveInventory(inventoryDto);
        return new ResponseEntity<>(inventoryResponseDto, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> updateInventory(@PathVariable("id") Integer id,@Valid @RequestBody InventoryDto inventoryDto){
        InventoryResponseDto inventoryResponseDto = inventoryService.updateInventory(id, inventoryDto);
        return new ResponseEntity<>(inventoryResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> getInventory(@PathVariable("id") Integer id){
      InventoryResponseDto inventoryResponseDto =  inventoryService.getInventory(id);
        return new ResponseEntity<>(inventoryResponseDto, HttpStatus.OK);
    }
}
