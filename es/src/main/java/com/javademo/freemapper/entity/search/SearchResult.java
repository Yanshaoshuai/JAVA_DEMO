package com.javademo.freemapper.entity.search;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "took",
    "timed_out",
    "_shards",
    "hits"
})
@Generated("jsonschema2pojo")
public class SearchResult<T> {

    @JsonProperty("took")
    private Integer took;
    @JsonProperty("timed_out")
    private Boolean timedOut;
    @JsonProperty("_shards")
    private Shards shards;
    @JsonProperty("hits")
    private Hits<T> hits;

    @JsonProperty("took")
    public Integer getTook() {
        return took;
    }

    @JsonProperty("took")
    public void setTook(Integer took) {
        this.took = took;
    }

    @JsonProperty("timed_out")
    public Boolean getTimedOut() {
        return timedOut;
    }

    @JsonProperty("timed_out")
    public void setTimedOut(Boolean timedOut) {
        this.timedOut = timedOut;
    }

    @JsonProperty("_shards")
    public Shards getShards() {
        return shards;
    }

    @JsonProperty("_shards")
    public void setShards(Shards shards) {
        this.shards = shards;
    }

    @JsonProperty("hits")
    public Hits<T> getHits() {
        return hits;
    }

    @JsonProperty("hits")
    public void setHits(Hits<T> hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SearchResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("took");
        sb.append('=');
        sb.append(((this.took == null)?"<null>":this.took));
        sb.append(',');
        sb.append("timedOut");
        sb.append('=');
        sb.append(((this.timedOut == null)?"<null>":this.timedOut));
        sb.append(',');
        sb.append("shards");
        sb.append('=');
        sb.append(((this.shards == null)?"<null>":this.shards));
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
        result = ((result* 31)+((this.took == null)? 0 :this.took.hashCode()));
        result = ((result* 31)+((this.shards == null)? 0 :this.shards.hashCode()));
        result = ((result* 31)+((this.timedOut == null)? 0 :this.timedOut.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchResult) == false) {
            return false;
        }
        SearchResult rhs = ((SearchResult) other);
        return (((((this.hits == rhs.hits)||((this.hits!= null)&&this.hits.equals(rhs.hits)))&&((this.took == rhs.took)||((this.took!= null)&&this.took.equals(rhs.took))))&&((this.shards == rhs.shards)||((this.shards!= null)&&this.shards.equals(rhs.shards))))&&((this.timedOut == rhs.timedOut)||((this.timedOut!= null)&&this.timedOut.equals(rhs.timedOut))));
    }

}
