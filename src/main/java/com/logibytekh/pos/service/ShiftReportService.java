package com.logibytekh.pos.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.logibytekh.pos.exceptions.UserException;
import com.logibytekh.pos.modal.ShiftReport;
import com.logibytekh.pos.payload.dto.ShiftReportDTO;

public interface ShiftReportService {

    ShiftReportDTO startShift() throws Exception;

    ShiftReportDTO endShift(Long shiftReportId, LocalDateTime shiftEnd) throws Exception;

    ShiftReportDTO getShiftReportById(Long id) ;

    List<ShiftReportDTO> getAllShiftReports() ;

    List<ShiftReportDTO> getShiftReportsByBranchId(Long branchId) ;

    List<ShiftReportDTO> getShiftReportsByCashierId(Long cashierId) ;

    ShiftReportDTO getCurrentShiftProgress(Long cashierId) throws Exception;


    ShiftReportDTO getShiftByCashierAndDate(Long cashierId, LocalDate date) throws Exception;


    
    



    
}
