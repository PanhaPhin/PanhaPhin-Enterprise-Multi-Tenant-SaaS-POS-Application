package com.logibytekh.pos.service;

import com.logibytekh.pos.exceptions.UserException;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.BranchDTO;
import java.util.List;

public interface BranchService {
    

    BranchDTO createBranch (BranchDTO branchDTO) throws UserException, Exception;
    BranchDTO updateBranch (Long id, BranchDTO branchDTO, User user) throws Exception;
    void deleteBranchDTO (Long id) throws Exception;
    List<BranchDTO> getBranchesByStoreId (Long storeId);
    BranchDTO getBranchById(Long id);

    
    

    

}
