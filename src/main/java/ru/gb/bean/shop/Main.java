package ru.gb.bean.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import ru.gb.bean.cart.Cart;
import ru.gb.bean.cart.CartFactory;
import ru.gb.bean.config.ApplicationConfiguration;
import ru.gb.bean.productRepository.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext  context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//        ProductRepository pR = context.getBean(ProductRepository.class);
        System.out.println(context);
        System.out.println("\n Welcome in Shop. Insert your command. To help insert /help ");
        Scanner scanner = new Scanner(System.in);
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
            if (command.equals("/new")) context.getBean(Cart.class);
            if (command.equals("/add")) {
                System.out.println("Enter id Product");
                int id  = scanner.nextInt();
                context.getBean(Cart.class).setProductCart(context.getBean(ProductRepository.class).getProdRepoId(id));
                System.out.println("Complete");
            }
            if (command.equals("/del")){
                System.out.println("Enter id Product");
                int id  = scanner.nextInt();
                context.getBean(Cart.class).setRemoveProd(id);
                System.out.println("Complete");
            }
            if (command.equals("/cart")){
                System.out.println(context.getBean(Cart.class).getCart());
            }
            if (command.equals("/get_all")){
                System.out.println(context.getBean(ProductRepository.class).getProdRepo());
            }
            if (command.equals("/get_id")){
                System.out.println("Enter id");
                int id  = scanner.nextInt();
                System.out.println(context.getBean(ProductRepository.class).getProdRepoId(id));
            }
            if (command.equals("/exit")){
                break;
            }
        }
        System.out.println("Thank you for visiting, we are waiting for you again");
    }
}
