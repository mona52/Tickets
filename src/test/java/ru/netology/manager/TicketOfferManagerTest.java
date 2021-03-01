package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfferManagerTest {
    private TicketOfferRepository repository = new TicketOfferRepository();
    private TicketOfferManager manager = new TicketOfferManager(repository);

    private TicketOffer ticketOffer1 = new TicketOffer(1, 1400, "AAA", "BBB", 300);
    private TicketOffer ticketOffer2 = new TicketOffer(2, 1100, "BBB", "AAA", 300);
    private TicketOffer ticketOffer3 = new TicketOffer(3, 1300, "AAA", "CCC", 400);
    private TicketOffer ticketOffer4 = new TicketOffer(4, 1800, "AAA", "BBB", 320);
    private TicketOffer ticketOffer5 = new TicketOffer(5, 1000, "AAA", "BBB", 350);
    private TicketOffer ticketOffer6 = new TicketOffer(6, 1500, "BBB", "CCC", 300);
    private TicketOffer ticketOffer7 = new TicketOffer(7, 1500, "BBB", "AAA", 300);
    private TicketOffer ticketOffer8 = new TicketOffer(8, 1100, "BBB", "AAA", 300);

    @BeforeEach
    public void setUp() {
        manager.add(ticketOffer1);
        manager.add(ticketOffer2);
        manager.add(ticketOffer3);
        manager.add(ticketOffer4);
        manager.add(ticketOffer5);
        manager.add(ticketOffer6);
        manager.add(ticketOffer7);
        manager.add(ticketOffer8);
    }


    @Test
    void shouldGetAllExistManyDifferentPrices() {
        TicketOffer[] actual = manager.getAll("AAA", "BBB");
        TicketOffer[] expected = new TicketOffer[]{ticketOffer5, ticketOffer1, ticketOffer4};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllExistManyNotDifferentPrices() {
        TicketOffer[] actual = manager.getAll("BBB", "AAA");
        TicketOffer[] expected = new TicketOffer[]{ticketOffer2, ticketOffer8, ticketOffer7};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllExistOne() {
        TicketOffer[] actual = manager.getAll("BBB", "CCC");
        TicketOffer[] expected = new TicketOffer[]{ticketOffer6};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllNoExist() {
        assertThrows(NotFoundException.class, () -> manager.getAll("CCC", "BBB"));
    }

}