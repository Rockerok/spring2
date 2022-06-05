package ru.gb.bean.productRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private Product tomatoes;
    private Product cucumbers;
    private Product carrot;
    private Product beet;
    private Product onion;

    private  List <Product>prodRepo;

    public List<Product> getProdRepo() {
        return prodRepo;
    }

    public void setProdRepo(List<Product> prodRepo) {
        this.prodRepo = prodRepo;
    }

    @Autowired
    public ProductRepository(List<Product> prodRep) {
        this.prodRepo = prodRepos(prodRep);
    }

    private List<Product> prodRepos(List<Product> prodRep) {
        tomatoes = new Product(1,"tomatoes", 25);
        cucumbers = new Product(2,"cucumbers", 35);
        carrot = new Product(3,"carrot", 20);
        beet = new Product(4,"beet", 40);
        onion = new Product(5,"onion", 15);
        Product [] productsArr = {tomatoes,cucumbers,carrot,beet,onion};
        prodRepo = new ArrayList<>(Arrays.asList(productsArr));
        return prodRepo;
    }

    public Product getProdRepoId(int id) {
        Product product=prodRepo.get(id);
        return product;
    }
}
