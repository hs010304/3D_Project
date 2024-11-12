package com.example.demo.controller;

import com.example.demo.dto.OrderDto.PaymentRequest;
import com.example.demo.dto.ProductFormDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 카카오페이 결제 요청 API
    @PostMapping("/products/requestPayment")
    @ResponseBody
    public ResponseEntity<?> requestPayment(@RequestParam Long productId, @RequestParam int quantity) {
        Optional<Product> productOpt = productService.findProductById(productId);

        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            int totalAmount = product.getPrice() * quantity; // 총 결제 금액 계산

            // 결제 요청 데이터 생성
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setProductName(product.getName());
            paymentRequest.setTotalAmount(totalAmount);

            // 결제 요청 데이터를 클라이언트에 전달
            return ResponseEntity.ok(paymentRequest);
        } else {
            return ResponseEntity.badRequest().body("상품을 찾을 수 없습니다.");
        }
    }

    // 결제 확인 API
    @PostMapping("/products/confirmPayment")
    @ResponseBody
    public ResponseEntity<String> confirmPayment(@RequestParam String impUid) {
        boolean isVerified = productService.verifyPayment(impUid);
        if (isVerified) {
            return ResponseEntity.ok("결제가 완료되었습니다.");
        } else {
            return ResponseEntity.status(400).body("결제 검증에 실패하였습니다.");
        }
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }
    // OUTER 카테고리 페이지
    @GetMapping("/outer")
    public String showOuterProducts(Model model) {
        List<Product> outerProducts = productService.findByCategory(Product.Category.OUTER);
        model.addAttribute("shop", outerProducts);
        return "outer"; // outer.html로 이동
    }

    // TOP 카테고리 페이지
    @GetMapping("/top")
    public String showTopProducts(Model model) {
        List<Product> topProducts = productService.findByCategory(Product.Category.TOP);
        model.addAttribute("shop", topProducts);
        return "top"; // top.html로 이동
    }

    // PANTS 카테고리 페이지
    @GetMapping("/pants")
    public String showPantsProducts(Model model) {
        List<Product> pantsProducts = productService.findByCategory(Product.Category.PANTS);
        model.addAttribute("shop", pantsProducts);
        return "pants"; // pants.html로 이동
    }


    // 상품 추가 폼 페이지로 이동
    @GetMapping("/products/add")
    public String showProductForm(Model model) {
        model.addAttribute("productForm", new ProductFormDTO());
        return "product_form"; // 상품 추가 폼으로 이동
    }

    // 상품 추가 처리 (이미지 업로드 포함)
    @PostMapping("/products/add")
    public String addProduct(@Valid ProductFormDTO productForm, 
                             BindingResult bindingResult, 
                             @RequestParam("imageFile") MultipartFile imageFile, 
                             Model model) {
        if (bindingResult.hasErrors()) {
            // 폼 검증 실패 시 오류 처리
            return "product_form"; // 폼으로 돌아가기
        }

        // 이미지 파일 업로드 처리
        String imageName = productService.handleImageUpload(imageFile);
        productForm.setImageFileName(imageName); // 업로드된 이미지 파일 이름 설정

        // 상품 추가 처리
        productService.addProduct(productForm);

        // 상품 목록 페이지로 리다이렉트
        return "redirect:/products";
    }

    // 상품 목록 페이지로 이동
    @GetMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "product_list"; // 상품 목록 페이지로 이동
    }

    // 쇼핑 페이지로 이동
    @GetMapping("/shoptest")
    public String showShoptest(Model model) {
        model.addAttribute("shoptest", productService.findAllProducts());
        return "shoptest";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("shop", productService.findAllProducts());
        return "shopnow";
    }

    // 상품 이름 변경
    @PostMapping("/products/updateName")
    public String updateProductName(@RequestParam Long id, @RequestParam String name) {
        productService.updateProductName(id, name);
        return "redirect:/products";
    }

    // 상품 가격 변경
    @PostMapping("/products/updatePrice")
    public String updateProductPrice(@RequestParam Long id, @RequestParam int price) {
        productService.updateProductPrice(id, price);
        return "redirect:/products";
    }

    // 상품 재고 변경
    @PostMapping("/products/updateStock")
    public String updateProductStock(@RequestParam Long id, @RequestParam int stock) {
        productService.updateProductStock(id, stock);
        return "redirect:/products";
    }

    // 상품 사이즈 변경
    @PostMapping("/products/updateSize")
    public String updateProductSize(@RequestParam Long id, @RequestParam String size) {
        productService.updateProductSize(id, size);
        return "redirect:/products";
    }

    // 상품 설명 변경
    @PostMapping("/products/updateDescription")
    public String updateProductDescription(@RequestParam Long id, @RequestParam String description) {
        productService.updateProductDescription(id, description);
        return "redirect:/products";
    }

    // 상품 카테고리 변경
    @PostMapping("/products/updateCategory")
    public String updateProductCategory(@RequestParam Long id, @RequestParam String category) {
        productService.updateProductCategory(id, category);
        return "redirect:/products";
    }

    // 상품 이미지 변경
    @PostMapping("/products/updateImage")
    public String updateImage(@RequestParam("id") Long id, 
                              @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            // 이미지 변경 로직 실행
            productService.updateProductImage(id, imageFile);
        } catch (IOException e) {
            // 파일 저장 중 오류가 발생한 경우 처리
            return "redirect:/products?error=true"; // 에러 발생 시 처리
        }

        // 성공 시 리다이렉트
        return "redirect:/products"; // 성공 후 상품 목록 페이지로 리다이렉트
    }

    // 상품 삭제 처리
    @PostMapping("/products/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    
    // 상품 상세 페이지 요청 처리
    @GetMapping("/products/{id}")
    public String showProductDetail(@PathVariable Long id, Model model) {
        Optional<Product> productOpt = productService.findProductById(id);
        if (productOpt.isPresent()) {
            model.addAttribute("product", productOpt.get());
            return "product_detail"; // 상품 상세 페이지로 이동
        } else {
            model.addAttribute("error", "상품을 찾을 수 없습니다.");
            return "error"; // 상품을 찾을 수 없는 경우 에러 페이지로 이동
        }
    }
}
