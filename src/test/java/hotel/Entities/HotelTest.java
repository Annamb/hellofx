/*
Hópur 8H
Anna Margrét Benediktsdóttir amb33@hi.is
Númi Steinn Baldursson nsb3@hi.is
*/
package hotel.Entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HotelTest {
    private Hotel hotel1, hotel2;

    @Before
    public void setUp() {
        hotel1 = new Hotel("Reykjavik", "Nice Hotel",
                "555-1122",
                "nice@hotel.com", "Nice street 10");
        hotel2 = new Hotel("New York", "The Good Stay",
                "111-2233",
                "mail@good.com", "Broadway 101", 3.3,
                9000, 3, true, true, false);
    }

    @After
    public void tearDown() {
        hotel1 = null;
        hotel2 = null;
    }

    @Test
    public void getCity() {
        assertEquals("Reykjavik", hotel1.getCity());
        assertEquals("New York", hotel2.getCity());
    }

    @Test
    public void getEmailAddress() {
        assertEquals("nice@hotel.com", hotel1.getEmailadress());
        assertEquals("mail@good.com", hotel2.getEmailadress());
    }

    @Test
    public void getPrice() {
        assertEquals(0, hotel1.getPrice());
        assertEquals(9000, hotel2.getPrice());
    }

    @Test
    public void setPrice() {
        hotel1.setPrice(100);
        hotel2.setPrice(99);
        assertEquals(100, hotel1.getPrice());
        assertEquals(99, hotel2.getPrice());
    }


    @Test
    public void getStars() {
        assertEquals(0, hotel1.getStars());
        assertEquals(3, hotel2.getStars());
    }


    @Test
    public void isRestaurant() {
        assertEquals(false, hotel1.isRestaurant());
        assertEquals(true, hotel2.isRestaurant());
    }

}