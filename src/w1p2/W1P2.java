/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package w1p2;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lizeshakya
 */
public class W1P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy series created by Douglas Adams.");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);

        //Get an entity manager and a transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("W1P2PU");
        EntityManager em = emf.createEntityManager();

        //Persists the book to the database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();

        em.close();
        emf.close();
        
	System.out.println("**********Persist the book into database**********");
        System.out.println(book);
	System.out.println("**************************************************");
        
        
        OrderLine orderLineOne = new OrderLine();
        orderLineOne.setItem("Samsung Mobile");
        orderLineOne.setQuantity(2);
        orderLineOne.setUnitPrice(200.0);
                
        OrderLine orderLineTwo = new OrderLine();
        orderLineTwo.setItem("One Plus Mobile");
        orderLineTwo.setQuantity(3);
        orderLineTwo.setUnitPrice(400.0);
        
        
        ArrayList<OrderLine> orderLines=new ArrayList();
        orderLines.add(orderLineOne);
        orderLines.add(orderLineTwo);
        
        AnOrder orderOne = new AnOrder();
        
        orderOne.setCreationDate(Calendar.getInstance().getTime());
        orderOne.setOrderLines(orderLines);
        
        emf = Persistence.createEntityManagerFactory("W1P2PU");
        em = emf.createEntityManager();
        
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        em.persist(orderLineOne);
        em.persist(orderLineTwo);
        em.persist(orderOne);

        tx2.commit();
        
        em.close();
        emf.close();
        
    }
    
}
