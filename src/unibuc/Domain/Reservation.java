package unibuc.Domain;

import java.util.*;

public class Reservation {
    protected String clientName;
    protected Date resDate;
    protected int noRegTickets;
    protected int noVIPTickets;
    protected String resType;
    protected int[] seats;
    protected int resCode;
    public Ticket ticket;
    public Reservation(String clientName,Date date, int noRegTickets,int noVIPTickets, String resType,int resCode, Ticket ticket) {
        this.clientName=clientName;
        this.resDate = date;
        this.noRegTickets = noRegTickets;
        this.noVIPTickets=noVIPTickets;
        this.resType = resType;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date date) {
        this.resDate = date;
    }

    public int getNoRegTickets() {
        return noRegTickets;
    }

    public void setNoRegTickets(int noTickets) {
        this.noRegTickets = noTickets;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public int getNoVIPTickets() {
        return noVIPTickets;
    }

    public void setNoVIPTickets(int noVIPTickets) {
        this.noVIPTickets = noVIPTickets;
    }
}
