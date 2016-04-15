
package fr.istic.tpnosql.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

@Entity
public class Article {
  @Id
  private ObjectId id;
  private String name;
  private int stars;
  @Reference
  private List<Person> buyers;
  
  public Article(){
      
  }
  
  public Article(String name, int stars){
      this.name = name;
      this.stars = stars;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
    
    public void addPerson(Person pers){
        if(this.buyers == null)
            this.buyers = new ArrayList<Person>();
        this.buyers.add(pers);
    }
    
    public List<Person> getBuyers(){
        return buyers;
    }
    
    public String toString(){
       StringBuilder str = new StringBuilder();
       for(Person pers : buyers)
           str.append(pers.toString()+" ");
       return "article: {name: "+this.name+" ,stars: "+this.stars+" ,"+str+"}";
    } 
}
