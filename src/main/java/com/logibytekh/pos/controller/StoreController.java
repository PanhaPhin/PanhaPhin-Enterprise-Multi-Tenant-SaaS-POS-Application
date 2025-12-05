package com.logibytekh.pos.controller;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.payload.dto.StoreDTO;
import com.logibytekh.pos.service.StoreService;
import com.logibytekh.pos.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody  StoreDTO storeDTO,
                                                @RequestHeader ("Authorization" )String jwt ) throws Exception{

       User user= userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(storeService.createStore(storeDTO, user));
     
    }

    @GetMapping
    public ResponseEntity<StoreDTO> getStoreById(
                                                @RequestHeader ("Authorization" )String jwt ) throws Exception{

       User user= userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(storeService.createStore(storeDTO, user));
     
    }




    
}
