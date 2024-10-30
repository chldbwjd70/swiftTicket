package com.example.domain.admin;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "admin")
public class AdminCollections {

    @Id
    private ObjectId id;

//    @Field("userId")
    private String userId;

//    @Field("userPw")
    private String userPw;


    @Builder
    public AdminCollections(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }
}
