package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    DB db;

    void getDataFromDb() {
        System.out.println(db.getData());
    }


}
