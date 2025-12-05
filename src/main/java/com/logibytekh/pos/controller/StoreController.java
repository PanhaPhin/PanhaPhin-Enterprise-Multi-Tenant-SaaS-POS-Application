package com.logibytekh.pos.controller;

import com.logibytekh.pos.mapper.StoreMapper;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.StoreDTO;
import com.logibytekh.pos.service.StoreService;
import com.logibytekh.pos.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.apache.catalina.StoreManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(
            @RequestBody StoreDTO storeDTO,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(storeService.createStore(storeDTO, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(
        @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {

        
        return ResponseEntity.ok(storeService.getStoreById(id));
    }


    @GetMapping()
    public ResponseEntity<List<StoreDTO>> getAllStore(
       
            @RequestHeader("Authorization") String jwt) throws Exception {

        
        return ResponseEntity.ok(storeService.getAllStores());
    }

     @GetMapping("/admin")
    public ResponseEntity<StoreDTO> getAllStoreByAdmin(
       
            @RequestHeader("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(StoreMapper.tDto(storeService.getStoreByAdmin()));
    }



   
}
