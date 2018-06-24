package com.vanhack.api.skip.hackatonskipthedishesmain.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class NearbySearchResponse  implements Serializable {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private String[] html_attributions;

    @Lob
    private String next_page_token;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Result> results;

    public NearbySearchResponse() {
    }

    public NearbySearchResponse(String[] html_attributions, String nextPageToken, List<Result> results) {
        this.html_attributions = html_attributions;
        this.next_page_token = nextPageToken;
        this.results = results;
    }

    public String[] getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(String[] html_attributions) {
        this.html_attributions = html_attributions;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getNext_page_token() {
        return next_page_token;
    }

    public void setNext_page_token(String next_page_token) {
        this.next_page_token = next_page_token;
    }
}
