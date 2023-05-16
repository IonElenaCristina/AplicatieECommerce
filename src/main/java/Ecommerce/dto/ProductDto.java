package Ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String imageURL;
    @NonNull
    private Double price;
    @NonNull
    private String description;
    @NonNull
    private Integer stock;

    @NonNull
    private Integer categoryId;
}
