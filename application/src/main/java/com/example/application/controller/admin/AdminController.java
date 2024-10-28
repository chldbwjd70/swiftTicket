package com.example.application.controller.admin;

import com.example.application.service.admin.AdminService;
import com.example.domain.admin.AdminCollections;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @GetMapping("/test")
    public void test(){
        AdminCollections adminCollections = new AdminCollections("test1", "test1");
        adminService.testMongoCrud(adminCollections);
    }
}
