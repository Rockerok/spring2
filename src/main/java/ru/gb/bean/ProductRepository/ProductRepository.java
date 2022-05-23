package ru.gb.bean.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductRepository {

    public Product product;
    public void ProductRepository (){
        while (true){
            Scanner scanner = new Scanner();

        }
    }

//    public Product [] cart = new Product[10];
//    public Random price = new Random();
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().printf("<html><body>");
//        for(int i=1; i<=10; i++){
//            cart[i-1]=new Product(i, "apple" + i, price.nextInt(100));
//        }
//
//        for (Product p:cart) {
//            resp.getWriter().printf(String.valueOf(p)+"<br />");
//        }
//        resp.getWriter().printf("</body></html>");
}
