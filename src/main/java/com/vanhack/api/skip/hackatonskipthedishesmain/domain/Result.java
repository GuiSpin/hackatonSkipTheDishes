package com.vanhack.api.skip.hackatonskipthedishesmain.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Result implements Serializable {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Geometry geometry;
    private String icon;
    private String name;
    private String place_id;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }
}
