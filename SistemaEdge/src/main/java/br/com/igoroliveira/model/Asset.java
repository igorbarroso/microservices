package br.com.igoroliveira.model;

import java.math.BigDecimal;
import java.util.Map;

public class Asset {

    // A vehicle, a piece of land, investments, etc.
    private String type;

    /*
     * Depends on the type of asset. For example,
     * a homestead could have an address, an area,
     * a perimeter and whether it is used for farming.
     */
    private Map<String,String> attributes;

    private BigDecimal estimatedValue;

    private Person owner;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public BigDecimal getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(BigDecimal estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
