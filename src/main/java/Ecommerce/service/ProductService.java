package Ecommerce.service;

import Ecommerce.dto.ProductDto;
import Ecommerce.model.Category;
import Ecommerce.model.Product;
import Ecommerce.repository.CategoryRepository;
import Ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void createProduct(ProductDto productDto) {
        Product product = new Product();
        Optional<Category> category = categoryRepository.findById(productDto.getCategoryId());
        category.ifPresent(product::setCategory);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        productRepository.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImageURL(product.getImageURL());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setStock(product.getStock());
        return productDto;
    }

    public List<ProductDto> getAllProducts() {
       return productRepository.findAll()
                .stream().map(this::getProductDto).toList();

    }
}
