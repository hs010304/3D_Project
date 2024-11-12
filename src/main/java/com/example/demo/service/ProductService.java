package com.example.demo.service;

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
public class ProductService {

    private final ProductRepository productRepository;
    private final String uploadDir = System.getProperty("user.dir") + "/uploads/";

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> findByCategory(Product.Category category) {
        return productRepository.findByCategory(category);
    }

    public void addProduct(ProductFormDTO productForm) {
        Product.Category category = Product.Category.valueOf(productForm.getCategory());
        String imageName = handleImageUpload(productForm.getImageFile());

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

    public void updateProductName(Long id, String name) {
        Product product = findById(id);
        product.setName(name);
        productRepository.save(product);
    }

    public void updateProductPrice(Long id, Integer price) {
        Product product = findById(id);
        product.setPrice(price);
        productRepository.save(product);
    }

    public void updateProductStock(Long id, Integer stock) {
        Product product = findById(id);
        product.setStock(stock);
        productRepository.save(product);
    }

    public void updateProductSize(Long id, String size) {
        Product product = findById(id);
        product.setSize(size);
        productRepository.save(product);
    }

    public void updateProductDescription(Long id, String description) {
        Product product = findById(id);
        product.setDescription(description);
        productRepository.save(product);
    }

    public void updateProductCategory(Long id, String category) {
        Product product = findById(id);
        product.setCategory(Product.Category.valueOf(category));
        productRepository.save(product);
    }

    public void updateProductImage(Long id, MultipartFile imageFile) throws IOException {
        Product product = findById(id);

        String imageName = handleImageUpload(imageFile);
        if (imageName != null) {
            product.setImageFile("/uploads/" + imageName);
            productRepository.save(product);
        }
    }

    public void deleteProduct(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. ID: " + id));
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public boolean verifyPayment(String impUid) {
        return true;
    }
}
