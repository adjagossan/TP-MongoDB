package fr.istic.tpnosql.datastore;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import java.net.UnknownHostException;

public class DataStoreHelper {
    private static Morphia morphia;
    private static Mongo mongo;
    private static Datastore dataStore;
    
    private DataStoreHelper(){}
    
    private DataStoreHelper(String packageName, String dbName) throws UnknownHostException{
        morphia = new Morphia();
        mongo = new Mongo();
        morphia.mapPackage(packageName);
        dataStore = morphia.createDatastore(mongo, dbName);
    }
    
    public static Datastore getInstance(String packageName, String dbName) throws UnknownHostException{
        if(dataStore == null)
            new DataStoreHelper(packageName, dbName);
        return dataStore;
    }
}
