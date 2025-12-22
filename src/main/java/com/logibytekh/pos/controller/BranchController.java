package com.logibytekh.pos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.payload.dto.BranchDTO;
import com.logibytekh.pos.payload.response.ApiResponse;
import com.logibytekh.pos.service.BranchService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branches")
public class BranchController {
    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branchDTO) throws Exception{

        BranchDTO createBranch = branchService.createBranch(branchDTO);

        return ResponseEntity.ok(createBranch);

    }


    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getBranchById(
        @PathVariable Long id

    ) throws Exception{

        BranchDTO createBranch = branchService.getBranchById(id);
        return ResponseEntity.ok(createBranch);

    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<BranchDTO>> getAllBranchesByStoreId(
        @PathVariable Long storeId

    ) throws Exception{

        List <BranchDTO> createBranch = branchService.getBranchesByStoreId(storeId);
        return ResponseEntity.ok(createBranch);

    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchDTO> updateBranch(
        @PathVariable Long id,
        @RequestBody BranchDTO branchDTO
        

    ) throws Exception{

        BranchDTO createBranch = branchService.updateBranch(id,branchDTO);
        return ResponseEntity.ok(createBranch);

    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBranchById(

        @PathVariable Long id

    ) throws Exception{

        branchService.deleteBranchDTO(id);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("branch deleted successfully");
        return ResponseEntity.ok(apiResponse);

    }
    
}
