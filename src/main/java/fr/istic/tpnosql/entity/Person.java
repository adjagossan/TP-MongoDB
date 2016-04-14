package fr.istic.tpnosql.entity;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class Person {
   private ObjectId id;
   private String name;
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
