package br.fatec.easycoast.entities;

import br.fatec.easycoast.dtos.ItemResponse;
import br.fatec.easycoast.dtos.Addon.AddonFiltered;
import br.fatec.easycoast.dtos.Addon.AddonResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_ADDON")
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    private Float price;

    @Column(nullable = false)
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    public Addon() {
    }

    public Addon(AddonFiltered addonFiltered) {
        this.id = addonFiltered.id();
        this.name = addonFiltered.name();
        this.price = addonFiltered.price();
        this.availability = addonFiltered.availability();
        this.item = new Item(addonFiltered.item());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    // Aqui o item vai enviar a cópia de si mesmo filtrado com a classe
    // ItemResponse.
    public AddonFiltered getAddonFiltered() {
        return new AddonFiltered(id, name, price, availability, item.getItemResponse());
    }

}
