package fr.istic.tpnosql.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import fr.istic.tpnosql.entity.Article;
import org.bson.types.ObjectId;

/**
 *
 * @author Gossan
 */
public class ArticleDao extends BasicDAO<Article, ObjectId> {
    
    public ArticleDao(Class<Article> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
    
}
