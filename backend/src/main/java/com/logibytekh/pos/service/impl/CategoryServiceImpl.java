package com.logibytekh.pos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.logibytekh.pos.domain.UserRole;
import com.logibytekh.pos.mapper.CategoryMapper;
import com.logibytekh.pos.modal.Category;
import com.logibytekh.pos.modal.Store;
import com.logibytekh.pos.modal.User;
import com.logibytekh.pos.payload.dto.CategoryDTO;
import com.logibytekh.pos.repository.CategoryRespository;
import com.logibytekh.pos.repository.StoreRepository;
import com.logibytekh.pos.service.CategoryService;
import com.logibytekh.pos.service.UserService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRespository categoryRespository;
    private final StoreRepository storeRepository;
    private final UserService userService;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) throws Exception {
        User user = userService.getCurrentUser();

        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new Exception("Store not found"));

        checkAuthority(user, store);

        Category category = Category.builder()
                .name(dto.getName())
                .store(store)
                .build();

        return CategoryMapper.toDTO(
                categoryRespository.save(category)
        );
    }

    @Override
    public List<CategoryDTO> getCategoriesByStoreId(Long storeId) {
        return categoryRespository.findByStoreId(storeId)
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) throws Exception {
        Category category = categoryRespository.findById(id)
                .orElseThrow(() -> new Exception("Category not found"));

        User user = userService.getCurrentUser();
        checkAuthority(user, category.getStore());

        return CategoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) throws Exception {
        Category category = categoryRespository.findById(id)
                .orElseThrow(() -> new Exception("Category not found"));

        User user = userService.getCurrentUser();
        checkAuthority(user, category.getStore());

        category.setName(dto.getName());

        return CategoryMapper.toDTO(
                categoryRespository.save(category)
        );
    }

    @Override
    public void deleteCategory(Long id) throws Exception {
        Category category = categoryRespository.findById(id)
                .orElseThrow(() -> new Exception("Category not found"));

        User user = userService.getCurrentUser();
        checkAuthority(user, category.getStore());

        categoryRespository.delete(category);
    }

    // =========================
    // AUTHORIZATION CHECK
    // =========================
    private void checkAuthority(User user, Store store) throws Exception {
        boolean isAdmin = user.getRole() == UserRole.ROLE_STORE_ADMIN;
        boolean isManager = user.getRole() == UserRole.ROLE_STORE_MANAGER;
        boolean isSameStore = user.equals(store.getStoreAdmin());

        if ((!isAdmin && !isManager) || !isSameStore) {
            throw new Exception("You don't have permission to perform this action");
        }
    }
}
