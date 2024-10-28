package com.example.domain.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "shop")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopName;

    private String address;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;


    public Shop(String shopName, String address) {
        this.shopName = shopName;
        this.address = address;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

}
