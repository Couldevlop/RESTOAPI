package com.resatoAPI.com.validators;

import com.resatoAPI.com.dto.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class ValidateUpdateRequest {
    private void validateUpdateRequest(Long id, CategoryDTO dto) {
        if (id == null) {
            throw new IllegalArgumentException("The provided ID cannot be null.");
        }
        if (dto == null) {
            throw new IllegalArgumentException("The provided DTO cannot be null.");
        }
    }

}
