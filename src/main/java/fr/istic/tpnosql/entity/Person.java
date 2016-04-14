package fr.istic.tpnosql.entity;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

@Entity
public class Person {
   @Id
   private ObjectId id;
   private String name;
   @Embedded
   private List<Address> addresses;
   
   public Person(){
       this.addresses = new ArrayList<Address>(); 
   }
   
   public Person(String name){
       this.name = name;
       this.addresses = new ArrayList<Address>(); 
   }
   
   public void addAddress(Address address){
       this.addresses.add(address);
   }
   
   public List<Address> getAddresses(){
       return addresses;
   }
   
   public String getName() {
        return name;
   }

    public void setName(String name) {
        this.name = name;
   }
}
