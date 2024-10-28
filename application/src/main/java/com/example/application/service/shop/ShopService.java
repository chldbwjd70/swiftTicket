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

    public void save(Shop shop) {
        shopRepository.save(shop);

        Optional<Shop> byId = shopRepository.findById(shop.getId());
        if (byId.isPresent()) {
            System.out.println(byId.get().getShopName());
            System.out.println(byId.get().getAddress());
        }

    }
}
