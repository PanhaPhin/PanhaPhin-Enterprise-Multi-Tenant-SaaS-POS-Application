package com.logibytekh.pos.controller;

import com.logibytekh.pos.domain.StoreStatus;
import com.logibytekh.pos.mapper.StoreMapper;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.StoreDTO;
import com.logibytekh.pos.payload.response.ApiResponse;
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

    @GetMapping("/emloyee")
    public ResponseEntity<StoreDTO> getAllStoreByEmployee(

            @RequestHeader("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(storeService.getStoreByEmployee());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> updateStore(@PathVariable long id,
            @RequestBody StoreDTO storeDTO) throws Exception {

        return ResponseEntity.ok(storeService.updateStore(id, storeDTO));

    }


    @PutMapping("/{id}/moderate")
    public ResponseEntity<StoreDTO> moderateStore(
        @PathVariable long id,
        @RequestParam StoreStatus status) throws Exception {

    return ResponseEntity.ok(storeService.moderateStore(id, status));
}


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStore(@PathVariable long id) throws Exception {

        storeService.deleteStore(id);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setMessage("store deleted successfully");

        return ResponseEntity.ok(apiResponse);

    }

}
