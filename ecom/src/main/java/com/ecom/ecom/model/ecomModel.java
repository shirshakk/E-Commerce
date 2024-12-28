package com.ecom.ecom.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ecomModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String productBrand;
    private String productDescription;
    private int productPrice;
    private int productQuantity;
    @Column(name = "product_category")
    private String productCategory;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate ;
    @JsonProperty("isAvailable")
    private boolean available;
    private String imageName;
    private String imageDescription;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private byte[] image;
    public void setId(int id) {
        this.id = id;
    }
}