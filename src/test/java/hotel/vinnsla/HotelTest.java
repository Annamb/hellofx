package hotel.vinnsla;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    private Hotel hotel1, hotel2;

    @BeforeEach
    public void setUp() {
        hotel1 = new Hotel("Reykjavik", "Nice Hotel",
                "555-1122",
                "nice@hotel.com", "Nice street 10");
        hotel2 = new Hotel("New York", "The Good Stay",
                "111-2233",
                "mail@good.com", "Broadway 101");
    }

    @AfterEach
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
    public void getEmailadress() {
        assertEquals("nice@hotel.com", hotel1.getEmailadress());
        assertEquals("mail@good.com", hotel2.getEmailadress());
    }

    @Test
    public void getPrice() {
        assertEquals(0, hotel1.getPrice());
        assertEquals(0, hotel2.getPrice());
    }

    @Test
    public void getStars() {
        assertEquals(0, hotel1.getStars());
        assertEquals(0, hotel2.getStars());
    }


    @Test
    public void isRestaurant() {
        assertEquals(false, hotel1.isRestaurant());
        assertEquals(false, hotel2.isRestaurant());
    }
}