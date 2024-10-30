package com.example.swiftTicket.controller.shop;

import com.example.application.service.shop.ShopService;
import com.example.domain.shop.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/shop")
@RestController
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/test")
    public void save(){
        Shop shop = new Shop("Shop2", "Address2");
        shopService.save(shop);
    }
}
