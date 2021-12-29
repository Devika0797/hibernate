package com.hibernate_app;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

   public User getUser_id() {
       return user_id;
   }
   public void setUser_id(User user_id){
       this.user_id = user_id;
   }

   @ManyToMany
   @JoinTable(
           name = "products_users",//
           joinColumns = @JoinColumn(name = "product_id"),
           inverseJoinColumns = @JoinColumn(name = "user_id")
   )
   private List<User> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product() {
    }

    @Override
    public String toString(){
        return "Product [" + id + " " + title + " " + user_id.getName() + "]";
    }
}