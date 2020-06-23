package br.com.igoroliveira.model;

public class Address {

    private int idAddress;

    private String zip;

    private String number;

    private String neighbourhood;

    private String street;

    private String city;

    private String state;

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    
    public String getZip() {
        return zip;
    }

    public void setZip( String zip) {
        this.zip = zip;
    }

    
    public String getNumber() {
        return number;
    }

    public void setNumber( String number) {
        this.number = number;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
