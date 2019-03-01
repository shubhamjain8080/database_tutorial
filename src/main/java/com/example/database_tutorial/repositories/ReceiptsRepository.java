package com.example.database_tutorial.repositories;

import com.example.database_tutorial.models.Receipts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptsRepository extends MongoRepository<Receipts, String> {

    Receipts findBy_id(ObjectId _id);
}
