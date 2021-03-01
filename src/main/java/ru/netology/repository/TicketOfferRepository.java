package ru.netology.repository;

import ru.netology.domain.TicketOffer;

public class TicketOfferRepository {

    private TicketOffer[] items = new TicketOffer[0];

    public void save(TicketOffer item) {
        int length = items.length + 1;
        TicketOffer[] tmp = new TicketOffer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketOffer[] findAll(String out, String in) {
        //System.out.println("Ищем билеты из " + out + " в " + in);

        int i = 0;
        TicketOffer[] result = new TicketOffer[items.length];
        for (TicketOffer item : items) {
            if (item.getAirportOut() == out) {
                if (item.getAirportIn() == in) {
                    //System.out.println("Нашли билет " + item.getId());
                    i = i + 1;
                    result[i - 1] = item;
                }
            }
        }
        return deleteNull(result);
    }

    public TicketOffer[] deleteNull(TicketOffer[] result1) {
        TicketOffer[] tmp = new TicketOffer[result1.length];
        int counter = 0;
        for (TicketOffer item : result1) {
            if (item != null) {
                tmp[counter++] = item;
            }
        }
        TicketOffer[] result = new TicketOffer[counter];
        System.arraycopy(tmp, 0, result, 0, counter);
        return result;
    }


    public TicketOffer findById(int id) {
        for (TicketOffer item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public void removeById(int id) {

        int length = items.length - 1;
        TicketOffer[] tmp = new TicketOffer[length];
        int index = 0;
        for (TicketOffer item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }


}

