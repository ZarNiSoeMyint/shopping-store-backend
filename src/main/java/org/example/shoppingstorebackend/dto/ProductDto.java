package org.example.shoppingstorebackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private String id;
    private String name;
    private double price;
    private String description;
    private String thumbUrl;
    private String imageUrl;
}
