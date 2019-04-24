package unibuc.Domain;

public class Location {
    protected String locName;
    protected String address;
    protected int noSeatsAvailable;
    protected int noSeatsVIP;
    protected String eventsType; //movie, theatre, concert, all

    public Location(String locName, String address, int seatsAvailable, int seatsVIP,String eventsType)
    {
        this.locName = locName;
        this.address = address;
        this.noSeatsAvailable = seatsAvailable;
        this.noSeatsVIP=seatsVIP;
        this.eventsType=eventsType;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoSeatsAvailable() {
        return noSeatsAvailable;
    }

    public void setNoSeatsAvailable(int seatsAvailable) {
        this.noSeatsAvailable = seatsAvailable;
    }

    public String getEventsType() {
        return eventsType;
    }

    public void setEventsType(String eventsType) {
        this.eventsType = eventsType;
    }

    public int getNoSeatsVIP() {
        return noSeatsVIP;
    }

    public void setNoSeatsVIP(int noSeatsVIP) {
        this.noSeatsVIP = noSeatsVIP;
    }
}
