package fr.istic.tpnosql;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.QueryResults;
import fr.istic.tpnosql.dao.*;
import fr.istic.tpnosql.datastore.DataStoreHelper;
import fr.istic.tpnosql.entity.*;
import java.net.UnknownHostException;

public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
        String packageName = "fr.istic.tpnosql.entity";
        String dbName = "my_database";
        Datastore ds = DataStoreHelper.getInstance(packageName, dbName);
        
        ArticleDao articleDao = new ArticleDao(Article.class, ds);
        PersonDao personDao = new PersonDao(Person.class, ds);
        
        Article a = new Article();
        a.setName("panama papers");
        a.setStars(9);
        
        Address ad = new Address();
        ad.setCity("Rennes");
        ad.setCountry("France");
        ad.setPostCode("35700");
        ad.setStreet("Beaulieu");
        
        Address ad_ = new Address();
        ad_.setCity("Nantes");
        ad_.setCountry("France");
        ad_.setPostCode("92000");
        ad_.setStreet("Street");
        
        Person pers = new Person();
        pers.setName("Aurelia");
        
        pers.addAddress(ad);
        pers.addAddress(ad_);
        
        Person pers_ = new Person();
        pers_.setName("Arielle");
        
        Address ad__ = new Address();
        ad__.setCity("Abidjan");
        ad__.setCountry("Cote d'Ivoire");
        ad__.setPostCode("5000");
        ad__.setStreet("Babi");
        
        pers_.addAddress(ad__);
        
        a.addPerson(pers);
        a.addPerson(pers_);
        
        personDao.save(pers);
        personDao.save(pers_);
        articleDao.save(a);
        
        Article a_ = new Article();
        a_.setName("spacex");
        a_.setStars(5);
        
        Person p = new Person();
        p.setName("Ingrid");
        
        Address adr = new Address();
        adr.setCity("Yamoussoukro");
        adr.setCountry("Cote d'Ivoire");
        adr.setPostCode("300");
        adr.setStreet("Yakro");
        
        p.addAddress(adr);
        a_.addPerson(p);
        
        personDao.save(p);
        articleDao.save(a_);
        
        
        QueryResults<Article> articles = articleDao.find(ds.createQuery(Article.class));
        for(Article ar : articles){
            System.err.println(ar);
        }
    }
}
