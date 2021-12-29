package com.hibernate_app;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopcart")
public class ShopCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "product_id")
    private Long product_id;

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    private List<Product> products;
    public List<Product> getProducts(){
        return products;
    }
    public void setProducts(List<Product> products){
        this.products = products;
    }


//    set get
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }



    @Override
    public String toString() {
        String allProducts = " ";
        for (Product product: products) {
            allProducts += product.getTitle() + " ";
        }
        return "Cart [" + id + " " + user_id + " " + allProducts + "]";
    }
}
