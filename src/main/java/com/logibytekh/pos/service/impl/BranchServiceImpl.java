package com.logibytekh.pos.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.mapper.BranchMapper;
import com.logibytekh.pos.modal.Branch;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.BranchDTO;
import com.logibytekh.pos.repository.BranchRepository;
import com.logibytekh.pos.repository.StoreRepository;
import com.logibytekh.pos.service.BranchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final UserServiceImpl userRepository;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO) throws Exception {
        User currentUser = userRepository.getCurrentUser();
        List<Store> stores = storeRepository.findByStoreAdminId(currentUser.getId());

        if (stores.isEmpty()) {
            throw new RuntimeException("No store found for current admin");
        }

        // Pick the first store (or implement logic if multiple stores)
        Store store = stores.get(0);

        Branch branch = BranchMapper.toEntity(branchDTO, store);
        Branch saveBranch = branchRepository.save(branch);

        return BranchMapper.tDto(saveBranch);

    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO) throws Exception {
        Branch exiting = branchRepository.findById(id).orElseThrow(
                () -> new Exception("Branch not found"));
        exiting.setName(branchDTO.getName());
        exiting.setWorkingDays(branchDTO.getWorkingDays());
        exiting.setEmail(branchDTO.getEmail());
        exiting.setPhone(branchDTO.getPhone());
        exiting.setAddress(branchDTO.getAddress());
        exiting.setOpenTime(branchDTO.getOpenTime());
        exiting.setUpdatedAt(LocalDateTime.now());

        Branch updatedBranch = branchRepository.save(exiting);
        return BranchMapper.tDto(updatedBranch);
    }

    @Override
    public void deleteBranchDTO(Long id) throws Exception {
        Branch exiting = branchRepository.findById(id).orElseThrow(
                () -> new Exception("branch not exist .."));
        branchRepository.delete(exiting);
    }

    @Override
    public List<BranchDTO> getBranchesByStoreId(Long storeId) {
        List<Branch> branchs = branchRepository.findByStoreId(storeId);
        return branchs.stream().map(BranchMapper::tDto)
                .collect(Collectors.toList());

    }

    @Override
    public BranchDTO getBranchById(Long id) {
        Branch exiting = branchRepository.findById(id).orElseThrow(
                () -> new RuntimeException("branch not found"));
        return BranchMapper.tDto(exiting);
    }

}
