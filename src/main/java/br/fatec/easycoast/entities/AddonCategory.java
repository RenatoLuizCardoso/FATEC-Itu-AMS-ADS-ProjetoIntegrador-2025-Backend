package br.fatec.easycoast.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import br.fatec.easycoast.entities.resources.AddonType;

@Entity
@Table(name = "TBL_ADDONCATEGORY")
public class AddonCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AddonType type;

    // @ManyToOne
    // @JoinColumn(name = "PRODUCT_ID")
    // private Product product;

    @OneToMany
    @JoinColumn(name = "ADDON_ID")

    private List<Addon> addons;

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

    public AddonType getType() {
        return type;
    }

    public void setType(AddonType type) {
        this.type = type;
    }

    // public Product getProduct() {
    // return product;
    // }

    // public void setProduct(Product product) {
    // this.product = product;
    // }

    public List<Addon> getAddons() {
        return addons;
    }

    public void setAddons(List<Addon> addons) {
        this.addons = addons;
    }

}
