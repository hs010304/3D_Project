package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductFormDTO {

    private Long id;  // 상품 ID (수정 시 사용할 수 있음)

    @NotBlank(message = "상품 이름은 필수 입력 항목입니다.")
    private String name;  // 상품 이름

    @NotNull(message = "가격은 필수 입력 항목입니다.")
    private Integer price;  // 가격

    @NotNull(message = "재고는 필수 입력 항목입니다.")
    private Integer stock;  // 재고

    @NotBlank(message = "설명은 필수 입력 항목입니다.")
    private String description;  // 상품 설명

    @NotNull(message = "이미지는 필수 입력 항목입니다.")
    private MultipartFile imageFile;  // 이미지 파일

    private String imageFileName;  // 업로드된 이미지 파일 이름 저장

    @NotBlank(message = "사이즈는 필수 입력 항목입니다.")
    @Size(max = 10, message = "사이즈는 최대 10자까지 입력할 수 있습니다.")
    private String size;  // 사이즈

    @NotBlank(message = "카테고리는 필수 입력 항목입니다.")
    private String category;  // 카테고리 (OUTER, TOP, PANTS)
    
    private String status;  // 상품 상태 (ACTIVE, INACTIVE 등)
    
    private LocalDateTime createdAt;  // 상품 등록일
    
    private LocalDateTime updatedAt;  // 상품 수정일
}
