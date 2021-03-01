package ru.netology.manager;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;

public class TicketOfferManager {
    private TicketOfferRepository repository;

    public TicketOfferManager(TicketOfferRepository repository) {
        this.repository = repository;
    }

    public TicketOfferManager() {
    }

    public void add(TicketOffer item) {
        repository.save(item);
    }

    public TicketOffer[] getAll(String airportOut, String airportIn) {
        TicketOffer[] result = repository.findAll(airportOut, airportIn);
        if (result.length == 0) {
            System.out.println("Path from " + airportOut + " to " + airportIn + " not found");
            throw new NotFoundException(airportOut, airportIn);
        }
        Arrays.sort(result);
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
        System.out.println("manager done"); // for demo only
    }


}
