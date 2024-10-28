package com.example.application.service.admin;

import com.example.domain.admin.AdminCollections;
import com.example.domain.admin.AdminCollectionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {


    private final AdminCollectionsRepository adminCollectionsRepository;

    @Transactional
    public void testMongoCrud(AdminCollections collections){

        List<AdminCollections> adminCollections = adminCollectionsRepository.findByUserId(collections.getUserId(), collections.getUserPw());
        adminCollections.forEach(System.out::println);


    }
}
