package Ecommerce.controller;

import Ecommerce.common.ApiResponse;
import Ecommerce.model.Category;
import Ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/category")
@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true,"The category is created"),HttpStatus.CREATED);
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory( @PathVariable("categoryId") Integer categoryId, @RequestBody Category category) {
        categoryService.updateCategory(categoryId,category);
        return new ResponseEntity<>(new ApiResponse(true,"The category was updated."),HttpStatus.OK);
    }

}
