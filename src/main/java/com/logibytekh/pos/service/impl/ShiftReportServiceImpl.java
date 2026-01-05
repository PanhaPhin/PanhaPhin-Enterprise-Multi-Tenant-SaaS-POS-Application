package com.logibytekh.pos.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.payload.dto.ShiftReportDTO;
import com.logibytekh.pos.service.ShiftReportService;
import com.logibytekh.pos.repository.ShiftReportRespository;
import com.logibytekh.pos.service.UserService;
import com.logibytekh.pos.modal.ShiftReport;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.repository.BranchRespository;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.mapper.ShiftReportMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShiftReportServiceImpl implements ShiftReportService {

    private final ShiftReportRespository shiftReportRespository;
    private final UserService userService;
    private final BranchRespository branchRespository;

    @Override
    public ShiftReportDTO startShift(Long cashierId, Long branchId, LocalDateTime shiftStart) throws Exception {

        User currentUser = userService.getCurrentUser();
        shiftStart = LocalDateTime.now();
        LocalDateTime startOfDay = shiftStart.withHour(0).withMinute(0).withSecond(0);

        LocalDateTime endOfDay = shiftStart.withHour(23).withMinute(59).withSecond(59);

        Optional<ShiftReport> existing = shiftReportRespository.findByCashierAndShiftStartBetween(
            currentUser, startOfDay, endOfDay
            
            );

            if(existing.isPresent()){
                throw new Exception("Shift already started for today.");
            }

            Branch branch = currentUser.getBranch();



            ShiftReport shiftReport = ShiftReport.builder()
                .cashier(currentUser)
                .shiftStart(shiftStart)
                .branch(branch)
                .build();

            ShiftReport savedReport = shiftReportRespository.save(shiftReport);

            

        return ShiftReportMapper.toDTO(savedReport);
    }
    @Override
    public ShiftReportDTO endShift(Long shiftReportId, 
                                   LocalDateTime shiftEnd) throws Exception {

        User currentUser = userService.getCurrentUser();

        // ShiftReport shiftReport = shiftReportRespository.findTopByCashierAndShiftEndIsNullOrderByShiftStartDesc(CurrentUser)
        //     .orElseThrow(() -> new Exception("Shift report not found."));

        return null;
    }

    @Override
    public ShiftReportDTO getShiftReportById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShiftReportById'");
    }

    @Override
    public List<ShiftReportDTO> getAllShiftReports() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllShiftReports'");
    }

    @Override
    public List<ShiftReportDTO> getShiftReportsByBranchId(Long branchId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShiftReportsByBranchId'");
    }

    @Override
    public List<ShiftReportDTO> getShiftReportsByCashierId(Long cashierId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShiftReportsByCashierId'");
    }

    @Override
    public ShiftReportDTO getCurrentShiftProgress(Long cashierId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentShiftProgress'");
    }

    @Override
    public ShiftReportDTO getShiftByCashierAndDate(Long cashierId, LocalDateTime date) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShiftByCashierAndDate'");
    }

}
