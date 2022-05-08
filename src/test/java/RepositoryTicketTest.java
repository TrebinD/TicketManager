import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTicketTest {
    RepositoryTicket repo = new RepositoryTicket();
    ManagerTicket manager = new ManagerTicket(repo);
    Ticket ticketMoscow = new Ticket(1, 1000, "LED", "ZKD", 77);
    Ticket ticketSpb = new Ticket(2, 20, "LED ", "ZKD", 66);
    Ticket ticketBishkek = new Ticket(3, 300, "LED", "FRU", 75);


    @Test
    public void addProduct() {

        manager.add(ticketMoscow);
        manager.add(ticketSpb);
        manager.add(ticketBishkek);

        Ticket[] actual = {ticketMoscow, ticketSpb, ticketBishkek};
        Ticket[] expected = manager.find();

        assertArrayEquals(actual, expected);

    }

    @Test
    public void removeProduct() {

        manager.add(ticketMoscow);
        manager.add(ticketSpb);
        manager.add(ticketBishkek);

        manager.remove(2);

        Ticket[] actual = {ticketMoscow, ticketBishkek};
        Ticket[] expected = manager.find();

        assertArrayEquals(actual, expected);

    }

    @Test
    public void removeProductNullMassiv() {

        assertThrows(NotFoundException.class, () -> {
            manager.remove(3);
        });

    }

    @Test
    public void removeProductNotIdTicket() {
        manager.add(ticketMoscow);
        manager.add(ticketSpb);
        manager.add(ticketBishkek);

        manager.remove(9);
        Ticket[] actual = {ticketMoscow, ticketSpb, ticketBishkek};
        Ticket[] expected = manager.find();

        assertArrayEquals(actual, expected);

    }

    @Test
    public void findAllProductNotSort() {

        manager.add(ticketMoscow);
        manager.add(ticketSpb);
        manager.add(ticketBishkek);

        Ticket[] actual = {ticketMoscow, ticketSpb, ticketBishkek};
        Ticket[] expected = manager.find();


        assertArrayEquals(actual, expected);

    }


    @Test
    public void findAllProductSortByCoast() {

        manager.add(ticketMoscow);
        manager.add(ticketSpb);
        manager.add(ticketBishkek);

        Ticket[] actual = {ticketSpb, ticketBishkek, ticketMoscow};
        Ticket[] expected = manager.find();

        Arrays.sort(expected);

        assertArrayEquals(actual, expected);

    }


    @Test
    public void searchByAirportOneResult() {
        manager.add(ticketSpb);
        manager.add(ticketBishkek);
        manager.add(ticketMoscow);

        Ticket[] actual = {ticketBishkek};
        Ticket[] expected = manager.searchBy("LED", "FRU");

        Arrays.sort(expected);

        assertArrayEquals(actual, expected);


    }

    @Test
    public void searchByAirportTwoResultSort() {

        manager.add(ticketBishkek);
        manager.add(ticketMoscow);
        manager.add(ticketSpb);

        Ticket[] actual = {ticketSpb, ticketMoscow};
        Ticket[] expected = manager.searchBy("LED", "ZKD");

        Arrays.sort(expected);

        assertArrayEquals(actual, expected);

    }

    @Test
    public void searchByAirportTwoResultNotSort() {

        manager.add(ticketBishkek);
        manager.add(ticketMoscow);
        manager.add(ticketSpb);

        Ticket[] actual = {ticketMoscow, ticketSpb};
        Ticket[] expected = manager.searchBy("LED", "ZKD");

        assertArrayEquals(actual, expected);

    }

    @Test
    public void searchByAirportNullResult() {
        manager.add(ticketSpb);
        manager.add(ticketBishkek);
        manager.add(ticketMoscow);

        Ticket[] actual = {};
        Ticket[] expected = manager.searchBy("AS", "ZKD");

        Arrays.sort(expected);

        assertArrayEquals(actual, expected);

    }
}