package ru.netology.domain;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int price;
    private String airportOut;
    private String airportIn;
    private long time;

    @Override
    public int compareTo(TicketOffer o) {
        return price - o.price;
    }
}
