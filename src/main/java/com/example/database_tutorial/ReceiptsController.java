package com.example.database_tutorial;

import com.example.database_tutorial.models.Receipts;
import com.example.database_tutorial.repositories.ReceiptsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receipts")
public class ReceiptsController {

    @Autowired
    private ReceiptsRepository repository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Receipts getReceiptById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }
}
