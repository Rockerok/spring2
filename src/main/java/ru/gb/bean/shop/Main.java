package ru.gb.bean.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import ru.gb.bean.cart.Cart;
import ru.gb.bean.cart.CartFactory;
import ru.gb.bean.config.ApplicationConfiguration;
import ru.gb.bean.productRepository.Product;
import ru.gb.bean.productRepository.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext  context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//        ProductRepository pR = context.getBean(ProductRepository.class);
        System.out.println(context);
        System.out.println("\n Welcome in Shop. Insert your command. To help insert /help ");
        Scanner scanner = new Scanner(System.in);
        Cart cart = context.getBean(Cart.class);
        ProductRepository prodRep = context.getBean(ProductRepository.class);
        while (true) {
            String command = scanner.next();
            if (command.equals("/help"))
                System.out.println(" /new - add new Cart \n" +
                        "/cart - return Cart\n"+
                        "/add  - added Product_id in Cart by id \n " +
                        "/del - delete Product_id from Cart by id \n " +
                        "/get_all - return all Product from ProductRepository \n " +
                        "/get_id - return Product_id from ProductRepository by id \n " +
                        "/exit - to EXIT from App \n ");
            if (command.equals("/new")) {
                context.getBean(Cart.class);
                System.out.println("Add new Cart. Product in old Cart is Los");
            }
            if (command.equals("/add")) {
                System.out.println("Enter id Product 1-5");
                int id  = scanner.nextInt();
                cart.setProductCart((Product) prodRep.getProdRepoId(id-1));
                System.out.println("Complete");
            }
            if (command.equals("/del")){
                System.out.println("Enter id Product 1-5");
                int id  = scanner.nextInt();
                cart.setRemoveProd(id-1);
                System.out.println("Complete");
            }
            if (command.equals("/cart")){
                System.out.println(cart.getCart());
            }
            if (command.equals("/get_all")){
                System.out.println(prodRep.getProdRepo());
            }
            if (command.equals("/get_id")){
                System.out.println("Enter id 1-5");
                int id  = scanner.nextInt();
                System.out.println(prodRep.getProdRepoId(id-1));
            }
            if (command.equals("/exit")){
                break;
            }
        }
        System.out.println("\nThank you for visiting, we are waiting for you again");
    }
}
