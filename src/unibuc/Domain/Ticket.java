package unibuc.Domain;
import java.util.*;

public class Ticket {
    public double ticketPriceInitial;
    public double ticketPriceFinal;
    public String eventName;
    public String locationName;
    public String date;
    public int ticketDiscount;
    public boolean ticketVip;
    public double priceVip;


    public Ticket(double ticketPriceInitial, String eventName, String locationName, String date, int ticketDiscount, boolean ticketVip, double priceVip) {
        this.ticketPriceInitial = ticketPriceInitial;
        this.eventName = eventName;
        this.locationName = locationName;
        this.date = date;
        this.ticketDiscount = ticketDiscount;
        this.ticketVip=ticketVip;
        this.priceVip=priceVip;
    }

    public double getTicketPriceInitial() {
        return ticketPriceInitial;
    }

    public void setTicketPriceInitial(double ticketPrice) {
        this.ticketPriceInitial = ticketPrice;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTicketDiscount() {
        return ticketDiscount;
    }

    public void setTicketDiscount(int ticketDiscount) {
        this.ticketDiscount = ticketDiscount;
    }

    public boolean isTicketVip() {
        return ticketVip;
    }

    public void setTicketVip(boolean ticketVip) {
        this.ticketVip = ticketVip;
    }

    public double getTicketPriceFinal() {
        return ticketPriceFinal;
    }

    public void setTicketPriceFinal(double ticketPriceFinal) {
        this.ticketPriceFinal = ticketPriceFinal;
    }

    public double getPriceVip() {
        return priceVip;
    }

    public void setPriceVip(double priceVip) {
        this.priceVip = priceVip;
    }

    public void finalPrice()
    {
        double price;
        if(ticketVip)
            price=(100-ticketDiscount)*ticketPriceInitial+priceVip;
        else price=(100-ticketDiscount)*ticketPriceInitial;
        this.setTicketPriceFinal(price);
    }

}
