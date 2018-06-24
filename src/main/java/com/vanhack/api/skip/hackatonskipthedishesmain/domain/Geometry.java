package com.vanhack.api.skip.hackatonskipthedishesmain.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Geometry implements Serializable {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
