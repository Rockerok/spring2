package ru.gb.bean.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.bean.productRepository.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    private CartFactory cartFactory;
    private List<Product> productCart;

    public int getCart() {
        for (Product pr: productCart) {
            System.out.println(pr);
        }
        return productCart.size();
    }
    public void setProductCart(Product product) {
        productCart.add(product);
        System.out.println(productCart);
    }

    @Autowired
    public Cart(CartFactory cartFactory, List<Product> productCart) {
        productCart = new ArrayList<>();
        this.cartFactory = cartFactory;
        this.productCart = productCart;
    }

    public void setRemoveProd(int id) {
       try {
           productCart.remove(id);
       } catch (IndexOutOfBoundsException iobe){
           System.out.println("Product not delete from Cart");
       }
    }
}
