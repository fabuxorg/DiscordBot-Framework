package com.johanneslosch.discordbotframework.datahandler.database.mongodb;


/* EXAMPLE DOCUMENT
Document person = new Document()
                .append("name", "Jo")
                .append("address", new BasicDBObject("street", "123 Fake St")
                        .append("city", "Faketon")
                        .append("state", "MA")
                        .append("zip", 12345))
                .append("books", "BookName");
 */

import com.johanneslosch.discordbotframework.datahandler.filehandler.config.ConfigReader;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Objects;

public class MongoDBHandler {
    /**
     * creates Database and gets conection
     * @return      database connection
     */
    private static MongoDatabase mongoDatabase(){
        MongoClient mongoClient = new MongoClient(new MongoClientURI(ConfigReader.read("data", "config", "MONGODB_URL")));
        return mongoClient.getDatabase("DiscordDataLogger");
    }

    /**
     * writes Data in a document
     * @param collection        collection where document is
     * @param document          document to write
     */
    public static void writeData(String collection, Document document){
        getCollection(collection).insertOne(document);
    }

    /**
     * sets collection
     * @param collectionName    name from collection
     * @return                  collection
     */
    public static MongoCollection<Document> getCollection(String collectionName){
        return mongoDatabase().getCollection(collectionName);
    }

    /**
     * Creates a new collection
     * @param collectionName    name for collection
     */
    public static void createCollection(String collectionName){
        mongoDatabase().createCollection(collectionName);
    }

    /**
     * Gets Data from Document
     * @param collection        collection where data is
     * @param criteria          criteria to search
     * @param knownField        value at criteria to match
     * @param searchedField     wanted output
     * @return                  data from searchedField
     */
    public static String getData(String collection, String criteria, String knownField, String searchedField){
        Document query = new Document(criteria, knownField);
        FindIterable<Document> cursor = getCollection(collection).find(query);
        return (String) Objects.requireNonNull(cursor.first()).get(searchedField);
    }

    /**
     * updates Data from Document
     * @param collection        collection where data is
     * @param criteria          criteria to search
     * @param knownField        value at criteria to match
     * @param document          document with changes
     */
    public static void updateData(String collection, String criteria, String knownField, Document document){
        getCollection(collection).updateOne(new BasicDBObject(criteria, knownField), document);
    }

    /**
     * removes Data from collection
     * @param collection        collection where data is
     * @param criteria          criteria to search
     * @param knownField        value at criteria to match
     */
    public static void removeDataSet(String collection, String criteria, String knownField){
        getCollection(collection).dropIndex(new BasicDBObject(criteria, knownField));
    }
}
