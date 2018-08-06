package springboot.with.vaadin.springbootvaadin.service;

import org.springframework.stereotype.Service;
import springboot.with.vaadin.springbootvaadin.product.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public ProductService(){

    }

    public List<Product> getAllProduct(){
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1, "Mobile", 5000));
        productList.add(new Product(4, "Cycle", 18000));
        productList.add(new Product(3, "TV", 50000));

        return productList;
    }
}
