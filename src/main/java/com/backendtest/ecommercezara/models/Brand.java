package com.backendtest.ecommercezara.models;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "brand_id")
    private int brand_id;

    @Column(name = "brand_name")
    private String brand_name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "brand_product",
        joinColumns = @JoinColumn(name="brand_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn( name = "product_id", referencedColumnName = "id"))
    private List<Price> prices;

}
