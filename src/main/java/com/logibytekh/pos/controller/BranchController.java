package com.logibytekh.pos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.payload.dto.BranchDTO;
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
    public ResponseEntity<BranchDTO> getAllBranchesByStoreId(
        @PathVariable Long id

    ) throws Exception{

        BranchDTO createBranch = branchService.geBranchDTO(id);

        return ResponseEntity.ok(createBranch);

    }




    
}
