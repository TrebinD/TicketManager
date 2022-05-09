import org.junit.jupiter.api.Test;

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

        Ticket[] expected = {ticketSpb, ticketBishkek, ticketMoscow};
        Ticket[] actual = manager.find();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void removeProduct() {

        manager.add(ticketMoscow);
        manager.add(ticketSpb);
        manager.add(ticketBishkek);

        manager.remove(2);

        Ticket[] expected = {ticketBishkek, ticketMoscow};
        Ticket[] actual = manager.find();

        assertArrayEquals(expected, actual);

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
        Ticket[] expected = {ticketSpb, ticketBishkek, ticketMoscow};
        Ticket[] actual = manager.find();

        assertArrayEquals(expected, actual);

    }


    @Test
    public void findAllProductSortByCoast() {

        manager.add(ticketMoscow);
        manager.add(ticketSpb);
        manager.add(ticketBishkek);

        Ticket[] expected = {ticketSpb, ticketBishkek, ticketMoscow};
        Ticket[] actual = manager.find();

        assertArrayEquals(expected, actual);

    }


    @Test
    public void searchByAirportOneResult() {
        manager.add(ticketSpb);
        manager.add(ticketBishkek);
        manager.add(ticketMoscow);

        Ticket[] expected = {ticketBishkek};
        Ticket[] actual = manager.findBySort("LED", "FRU");

        assertArrayEquals(expected, actual);


    }

    @Test
    public void searchByAirportTwoResultSort() {

        manager.add(ticketBishkek);
        manager.add(ticketMoscow);
        manager.add(ticketSpb);

        Ticket[] expected = {ticketSpb, ticketMoscow};
        Ticket[] actual = manager.findBySort("LED", "ZKD");


        assertArrayEquals(expected, actual);

    }


    @Test
    public void searchByAirportNullResult() {
        manager.add(ticketSpb);
        manager.add(ticketBishkek);
        manager.add(ticketMoscow);

        Ticket[] expected = {};
        Ticket[] actual = manager.findBySort("AS", "ZKD");

        assertArrayEquals(expected, actual);

    }
}