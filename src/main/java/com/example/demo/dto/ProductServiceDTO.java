package com.example.demo.dto;

import com.example.demo.dto.ProductFormDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceDTO {

    private final ProductRepository productRepository;
    private final String uploadDir = System.getProperty("user.dir") + "/uploads/";

    public ProductServiceDTO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 상품 추가 로직
    public void addProduct(ProductFormDTO productForm) {
        Product.Category category;
        try {
            category = Product.Category.valueOf(productForm.getCategory());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 카테고리입니다.");
        }

        String imageName = handleImageUpload(productForm.getImageFile());
        if (imageName == null) {
            throw new IllegalArgumentException("이미지 업로드 오류가 발생했습니다.");
        }

        Product product = Product.builder()
                .name(productForm.getName())
                .price(productForm.getPrice())
                .stock(productForm.getStock())
                .description(productForm.getDescription())
                .size(productForm.getSize())
                .category(category)
                .imageFile("/uploads/" + imageName)
                .build();

        productRepository.save(product);
    }

    // 이미지 업로드 처리 로직
    public String handleImageUpload(MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String imageName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
                Path uploadPath = Paths.get(uploadDir + imageName);

                if (!Files.exists(uploadPath.getParent())) {
                    Files.createDirectories(uploadPath.getParent());
                }

                Files.copy(imageFile.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                return imageName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // 상품 이름 변경 로직
    public void updateProductName(Long id, String name) {
        Product product = findById(id);
        product.setName(name);
        productRepository.save(product);
    }

    // 상품 가격 변경 로직
    public void updateProductPrice(Long id, Integer price) {
        Product product = findById(id);
        product.setPrice(price);
        productRepository.save(product);
    }

    // 상품 재고 변경 로직
    public void updateProductStock(Long id, Integer stock) {
        Product product = findById(id);
        product.setStock(stock);
        productRepository.save(product);
    }

    // 상품 사이즈 변경 로직
    public void updateProductSize(Long id, String size) {
        Product product = findById(id);
        product.setSize(size);
        productRepository.save(product);
    }

    // 상품 설명 변경 로직
    public void updateProductDescription(Long id, String description) {
        Product product = findById(id);
        product.setDescription(description);
        productRepository.save(product);
    }

    // 상품 카테고리 변경 로직
    public void updateProductCategory(Long id, String category) {
        Product product = findById(id);
        try {
            product.setCategory(Product.Category.valueOf(category));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 카테고리입니다.");
        }
        productRepository.save(product);
    }

    // 상품 이미지 변경 로직
    public void updateProductImage(Long id, MultipartFile imageFile) throws IOException {
        Product product = findById(id);

        String imageName = handleImageUpload(imageFile);
        if (imageName != null) {
            product.setImageFile("/uploads/" + imageName);
            productRepository.save(product);
        }
    }

    // 상품 삭제 로직
    public void deleteProduct(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }

    // 모든 상품 조회 로직
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // 특정 상품 조회 로직
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. ID: " + id));
    }

    // 특정 상품을 Optional로 조회하는 메서드 (추가)
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }
    
    
    // 결제 검증 메서드 (예시)
    public boolean verifyPayment(String impUid) {
        // 결제 검증 로직을 여기에 추가합니다.
        return true;
    }
}
