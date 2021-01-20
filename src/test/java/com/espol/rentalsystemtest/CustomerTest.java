/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.rentalsystemtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoGameRentalTest{
	Ps3Game littleBigPlanet;
    Xbox360Game fable2;
    WiiGame superSmashBrosBrawl;
	
	@BeforeEach
    public void setUp() {
    	littleBigPlanet = new Ps3Game("Little Big Planet");
    	fable2 = new Xbox360Game("Fable 2");
    	superSmashBrosBrawl = new WiiGame("Super Smash Bros. Brawl");   
    }
    
    @Test
    public void testStatementPs3GameOnly() {
        // Ps3 games cost $4.00 for the first 4 days, and $1.250/day thereafter
        // a rental earns 2 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 1, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "Amount owed is 4.0\n" +
                "You earned 2 frequent renter points",
           johnDoe.statement());
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 3, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t4.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 4 frequent renter points",
           johnDoe.statement());
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 5, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t5.25\n" +
                "Amount owed is 13.25\n" +
                "You earned 6 frequent renter points",
           johnDoe.statement());
    }
}
