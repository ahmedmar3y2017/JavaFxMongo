package sample;

import com.mongodb.*;

import java.util.*;

/**
 * Created by ahmed on 7/25/2017.
 */


// mongo crud operation
public class Start {
    // To connect to mongodb server
    MongoClient mongoClient = new MongoClient("localhost", 27017);


//    public static void main(String[] args) {
//
//        try {
//
//            new Start().delete(2);
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        }
//
//
//    }


    // get All Collections
    public Set<String> getAllCollections() {
        // get all collections <tables>
        // Now connect to your databases
        DB db = mongoClient.getDB("mydb");
        DBCollection coll = db.getCollection("student");
        Set<String> tables = db.getCollectionNames();
        for (String col : tables) {
            System.out.println(col);
        }
        return tables;
    }


    // get specific Collection
    public Map find(String id) {
        // Now connect to your databases
        DB db = mongoClient.getDB("mydb");
        DBCollection coll = db.getCollection("student");
        DBObject cursor = coll.findOne(id);
        return cursor.toMap();


    }

    // insert Document
    public void insert(String id, String username, String password, String email, String Address, String phone) {
        // Now connect to your databases
        DB db = mongoClient.getDB("mydb");
        DBCollection coll = db.getCollection("student");
        BasicDBObject document = new BasicDBObject();
        document.put("_id", id);
        document.put("username", username);
        document.put("password", password);
        document.put("email", email);
        document.put("Address", Address);
        document.put("phone", phone);
        document.put("createdDate", new Date());
        coll.insert(document);

    }

    // update Document
    public void update(String id, String username, String password, String email, String Address, String phone) {
        // Now connect to your databases
        DB db = mongoClient.getDB("mydb");
        DBCollection coll = db.getCollection("student");
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("username", username);
        newDocument.put("password", password);
        newDocument.put("email", email);
        newDocument.put("Address", Address);
        newDocument.put("phone", phone);
        newDocument.put("createdDate", new Date());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        coll.update(query, updateObj);

    }

    // delete document
    public void delete(String id) {
        // Now connect to your databases
        DB db = mongoClient.getDB("mydb");
        DBCollection coll = db.getCollection("student");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("_id", id);

        coll.remove(searchQuery);


    }


}
