package com.logibytekh.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.logibytekh.pos.payload.dto.InventoryDTO;
import com.logibytekh.pos.payload.response.ApiResponse;
import com.logibytekh.pos.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping()
    public ResponseEntity<InventoryDTO>create(
        @RequestBody InventoryDTO inventoryDTO
    ) throws Exception {
        return ResponseEntity.ok(inventoryService.createInventory(inventoryDTO));
    }

    @PostMapping("/{id}")
    public ResponseEntity<InventoryDTO> update(
        @RequestBody InventoryDTO inventoryDTO,
        @PathVariable Long id
    ) throws Exception {
        return ResponseEntity.ok(inventoryService.updateInventory(id, inventoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(
        @PathVariable Long id
    ) throws Exception {
        inventoryService.deleteInventory(id);
        
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Inventory deleted successfully");

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<InventoryDTO>> getInventoryByBranch(
        @PathVariable Long branchId
    ) throws Exception {
        return ResponseEntity.ok(inventoryService.getAllInventoryByBranchId(branchId));
    }
    
}
