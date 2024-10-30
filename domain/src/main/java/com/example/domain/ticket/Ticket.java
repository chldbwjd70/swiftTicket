package com.example.domain.ticket;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document("ticket")
public class Ticket {

    @Id
    private ObjectId id;

    @Field("name")
    private String name;
    @Field("category")
    private String category;
    @Field("address")
    private String address;

    @Field("insertDt")
    private LocalDateTime insertDt;


    public Ticket(String name) {
        this.name = name;
        this.category = "SPORT";
        this.address = "SEOUL";
        this.insertDt = LocalDateTime.now();
    }
}
