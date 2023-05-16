package Ecommerce.controller;

import Ecommerce.common.ApiResponse;
import Ecommerce.dto.ProductDto;
import Ecommerce.service.CategoryService;
import Ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        if (!categoryService.isCategoryPresent(productDto))
            return new ResponseEntity<>(new ApiResponse(false, "The category doens't exist"), HttpStatus.NOT_FOUND);
        productService.createProduct(productDto);
        return new ResponseEntity<>(new ApiResponse(true, "The product is added"), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductDto productDto) {
        if (!categoryService.isCategoryPresent(productDto))
            return new ResponseEntity<>(new ApiResponse(false, "The category doens't exist"), HttpStatus.NOT_FOUND);
        productService.createProduct(productDto);
        return new ResponseEntity<>(new ApiResponse(true, "The product is added"), HttpStatus.CREATED);
    }
}
