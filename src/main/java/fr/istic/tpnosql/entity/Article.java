
package fr.istic.tpnosql.entity;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class Article {
  private ObjectId id;
  private String name;
  private int stars;
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
}
