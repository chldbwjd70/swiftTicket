package com.example.domain.admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface AdminCollectionsRepository extends MongoRepository<AdminCollections, String> {
    List<AdminCollections> findByUserId(String userId, String userPw);
}
