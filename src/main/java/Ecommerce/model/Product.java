package Ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    //many-to-one relationship
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
