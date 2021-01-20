/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.rentalsystemtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author edwin
 */
public class CustomerTest {
    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;

    public CustomerTest() {
    }

    @BeforeEach
	void setUp() throws Exception {
		theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        mulan = new Movie("Mulan", Movie.CHILDRENS);
        slumdogMillionaire = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
	}

    @Test
    public void testAddMovieRental() {
        System.out.println("addMovieRental");
        MovieRental arg = new MovieRental(new Movie("Avengers Endgame",30),15);
        Customer instance = new Customer("Victor Aguilera Lascano");
        instance.addMovieRental(arg);
        assertEquals(arg, instance.getMovieRentals().get(instance.getMovieRentals().size()-1));
    }

    /**
     * Test of addVideoGameRental method, of class Customer.
     */
    
    @Test
    public void testAddVideoGameRental() {
        System.out.println("addVideoGameRental");
        VideoGameRental arg = new VideoGameRental("GTA San Andreas",15,true);
        Customer instance = new Customer("Edwin");
        instance.addVideoGameRental(arg);
        assertEquals(arg, instance.getVideoRental().get(instance.getVideoRental().size()-1));
    }


    /**
     * Test of statement method, of class Customer.
     */
    @Test
    public void testStatement() {
        System.out.println("statement");
        Customer instance = null;
        String expResult = "";
        String result = instance.statement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        MovieRental movieRental1 = new MovieRental(theManWhoKnewTooMuch, 3);
        johnDoe.addMovieRental(movieRental1);
        String statement = regular(johnDoe, theManWhoKnewTooMuch, 2, 1.50);
        System.out.print(johnDoe.statement());
        
        assertEquals(statement, johnDoe.statement());
    }

    @Test
    public void testStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        MovieRental movieRental1 = new MovieRental(mulan, 4);
        johnDoeJr.addMovieRental(movieRental1);
        String statement = children(johnDoeJr, mulan, 1.50, 1.25);
        assertEquals(statement, johnDoeJr.statement());
        
    }

    @Test
    public void testStatementNewReleaseOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");
        MovieRental movieRental1 = new MovieRental(slumdogMillionaire, 2);
        janeDoe.addMovieRental(movieRental1);
        String statement = release(janeDoe, slumdogMillionaire, 3, 0);
        assertEquals(statement, janeDoe);
    }
    
    
    private String regular(Customer customer, Movie movie, double num, double num2) {
    	double thisAmount = num;
    	thisAmount += num2;
        return "Rental Record for " + customer._name + "\n"
        		 + "\t" + movie._title + "\t"
		+ "Amount owed is " + thisAmount + "\n"        		
		+ "You earned " + 1 + " frequent renter points";
	}
    
    private String children(Customer customer, Movie movie, double num, double num2) {
    	double thisAmount = num;
    	thisAmount += num2;
        return "Rental Record for " + customer._name + "\n"
		 		+ "\t" + movie._title + "\t"
		 		+ "Amount owed is " + thisAmount + "\n"        		
		 		+ "You earned " + 1 + " frequent renter points";
	}
    
    private String release(Customer customer, Movie movie, double num, double num2) {
    	double thisAmount = num;
    	thisAmount += num2;
        return "Rental Record for " + customer._name + "\n"
		 		+ "\t" + movie._title + "\t"
		 		+ "Amount owed is " + thisAmount + "\n"        		
		 		+ "You earned " + 2 + " frequent renter points";
	}

    
}
