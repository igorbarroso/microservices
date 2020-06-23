package br.com.igoroliveira.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idAsset;


    // A vehicle, a piece of land, investments, etc.
    private String type;

    /*
     * Depends on the type of asset. For example,
     * a homestead could have an address, an area,
     * a perimeter and wheter it is used for farming.
     */
    @ElementCollection
    @MapKeyColumn(name="key")
    @Column(name="value")
    @CollectionTable(name="asset_attributes")
    private Map<String,String> attributes;

    private BigDecimal estimatedValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", referencedColumnName = "idPerson")
    private Person owner;

    public int getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(int idAsset) {
        this.idAsset = idAsset;
    }

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
