package org.example;

import jakarta.persistence.*;
import java.util.List;
import java.util.Scanner;

public class LibraryBookJpaApp {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");

        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        // ---------- CREATE ----------
        em.getTransaction().begin();

//        Book b1 = new Book(1, "Clean Code", "Robert Martin", "Programming", 650.0, "Available", 2008);
//
//        Book b2 = new Book(2, "Effective Java", "Joshua Bloch", "Programming", 700.0, "Available", 2018);
//
//        Book b3 = new Book(3, "The Alchemist", "Paulo Coelho", "Fiction", 400.0, "Issued", 1988);
//
//        em.persist(b1);
//        em.persist(b2);
//        em.persist(b3);

        em.getTransaction().commit();
        System.out.println("Books Inserted Successfully");

        // ---------- READ BY ID ----------
        System.out.println("Enter the Book id to find name");
        int findBookId=sc.nextInt();
        Book book = em.find(Book.class, findBookId);
        System.out.println("Fetched by ID: " + book);

        // ---------- READ ALL ----------
        List<Book> books = em.createQuery("FROM Book", Book.class)
                .getResultList();

        System.out.println("All Books:");
        books.forEach(System.out::println);

        // ---------- UPDATE ----------
        em.getTransaction().begin();

        Book updateBook = em.find(Book.class, 2);
        updateBook.setPrice(750.0);
        updateBook.setAvailabilityStatus("Issued");

        em.getTransaction().commit();
        System.out.println("Book Updated Successfully");

        // ---------- DELETE ----------
        em.getTransaction().begin();

        Book deleteBook = em.find(Book.class, 3);
        em.remove(deleteBook);

        em.getTransaction().commit();
        System.out.println("Book Deleted Successfully");

        em.close();
        emf.close();
    }
}
