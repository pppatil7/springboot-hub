package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {


    private final DB db;

    public DBService(DB db) {
        this.db = db;
    }

    void getDataFromDb() {
        System.out.println(db.getData());
    }


}
