package com.javademo.freemapper.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "max_score",
    "hits"
})
@Generated("jsonschema2pojo")
public class Hits<T> {

    @JsonProperty("total")
    private Total total;
    @JsonProperty("max_score")
    private Double maxScore;
    @JsonProperty("hits")
    private List<Hit<T>> hits = new ArrayList<Hit<T>>();

    @JsonProperty("total")
    public Total getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Total total) {
        this.total = total;
    }

    @JsonProperty("max_score")
    public Double getMaxScore() {
        return maxScore;
    }

    @JsonProperty("max_score")
    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    @JsonProperty("hits")
    public List<Hit<T>> getHits() {
        return hits;
    }

    @JsonProperty("hits")
    public void setHits(List<Hit<T>> hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Hits.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null)?"<null>":this.total));
        sb.append(',');
        sb.append("maxScore");
        sb.append('=');
        sb.append(((this.maxScore == null)?"<null>":this.maxScore));
        sb.append(',');
        sb.append("hits");
        sb.append('=');
        sb.append(((this.hits == null)?"<null>":this.hits));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.hits == null)? 0 :this.hits.hashCode()));
        result = ((result* 31)+((this.total == null)? 0 :this.total.hashCode()));
        result = ((result* 31)+((this.maxScore == null)? 0 :this.maxScore.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hits) == false) {
            return false;
        }
        Hits rhs = ((Hits) other);
        return ((((this.hits == rhs.hits)||((this.hits!= null)&&this.hits.equals(rhs.hits)))&&((this.total == rhs.total)||((this.total!= null)&&this.total.equals(rhs.total))))&&((this.maxScore == rhs.maxScore)||((this.maxScore!= null)&&this.maxScore.equals(rhs.maxScore))));
    }

}
