package com.example.application.service.shop;

import com.example.domain.shop.Shop;
import com.example.domain.shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public Long save(Shop shop) {
        shopRepository.save(shop);
        return shop.getId();
    }

    public Optional<Shop> getId(Long id){
        return shopRepository.findById(id);
    }
}
