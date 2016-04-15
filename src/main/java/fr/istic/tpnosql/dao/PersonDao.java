package fr.istic.tpnosql.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import fr.istic.tpnosql.entity.Person;
import org.bson.types.ObjectId;

public class PersonDao extends BasicDAO<Person, ObjectId>{
    
    public PersonDao(Class<Person> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
    
}
