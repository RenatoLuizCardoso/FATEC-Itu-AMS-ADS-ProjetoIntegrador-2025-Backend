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

import br.fatec.easycoast.dtos.ItemResponse;
import br.fatec.easycoast.dtos.Addon.AddonFiltered;
import br.fatec.easycoast.dtos.AddonCategory.AddonCategoryFiltered;
import br.fatec.easycoast.dtos.Products.ProductFiltered;
import br.fatec.easycoast.entities.resources.AddonType;
import br.fatec.easycoast.mappers.AddonMapper;

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

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @OneToMany
    @JoinColumn(name = "ADDON_ID")
    private List<Addon> addons;

    public AddonCategory() {
    }

    public AddonCategory(AddonCategoryFiltered addonCategoryFiltered) {
        this.id = addonCategoryFiltered.id();
        this.name = addonCategoryFiltered.name();
        this.type = addonCategoryFiltered.type();
        this.addons = addonCategoryFiltered.addons();
    }

    public AddonCategory(Integer id, String name, AddonType type, List<Addon> addons) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.addons = addons;
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

    public AddonType getType() {
        return type;
    }

    public void setType(AddonType type) {
        this.type = type;
    }

    public ProductFiltered getProduct() {

        return new ProductFiltered(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getDiscount(), product.getAvailability(), product.getCategory(), product.getImageurl());
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Addon> getAddons() {
        return addons;
    }

    public List<AddonFiltered> getAddonFiltered() {
        List<AddonFiltered> addonFiltered = addons.stream()
                .map(a -> a.getAddonFiltered())
                .toList();
        return addonFiltered;

    }

    public void setAddons(List<Addon> addons) {
        this.addons = addons;
    }

}
