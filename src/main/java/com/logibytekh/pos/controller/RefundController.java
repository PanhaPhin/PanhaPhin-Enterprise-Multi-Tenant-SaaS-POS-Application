package com.logibytekh.pos.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logibytekh.pos.payload.dto.RefundDTO;
import com.logibytekh.pos.service.RefundService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/refunds")
public class RefundController {

    private final RefundService refundService;

    @PostMapping
    public ResponseEntity<RefundDTO> createRefund(@RequestBody RefundDTO refundDTO) throws Exception {
        RefundDTO refund = refundService.createRefund(refundDTO);
        return ResponseEntity.ok(refund);
    }

    @GetMapping
    public ResponseEntity<List<RefundDTO>> getAllRefund() throws Exception {
        List<RefundDTO> refund = refundService.getAllRefunds();
        return ResponseEntity.ok(refund);
    }

    @GetMapping("/cashier/{cashierId}")
    public ResponseEntity<List<RefundDTO>> getRefundByCashier(
            @PathVariable Long cashierId) throws Exception {
        List<RefundDTO> refund = refundService.getRefundByCashier(cashierId);
        return ResponseEntity.ok(refund);
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<RefundDTO>> getRefundByBranch(
            @PathVariable Long branchId) throws Exception {
        List<RefundDTO> refund = refundService.getRefundByBranch(branchId);
        return ResponseEntity.ok(refund);
    }

    @GetMapping("/shift/{shiftId}")
    public ResponseEntity<List<RefundDTO>> getRefundByShift(
            @PathVariable Long shiftId) throws Exception {
        List<RefundDTO> refund = refundService.getRefundByCashier(shiftId);
        return ResponseEntity.ok(refund);
    }

    @GetMapping("/cashier/{cashierId}/range")
    public ResponseEntity<List<RefundDTO>> getRefundByCashierAndDateRange(
            @PathVariable Long cashierId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) throws Exception {

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);

        List<RefundDTO> refund = refundService.getRefundByCashierAndDateRange(
                cashierId,
                startDateTime,
                endDateTime);

        return ResponseEntity.ok(refund);
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<RefundDTO> getRefundById(
            @PathVariable Long id
        ) throws Exception {
        RefundDTO refund = refundService.getRefundById(id);
        return ResponseEntity.ok(refund);
    }

}
