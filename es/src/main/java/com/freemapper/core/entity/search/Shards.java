package com.freemapper.core.entity.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "successful",
    "skipped",
    "failed"
})
@Generated("jsonschema2pojo")
public class Shards {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("successful")
    private Integer successful;
    @JsonProperty("skipped")
    private Integer skipped;
    @JsonProperty("failed")
    private Integer failed;

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("successful")
    public Integer getSuccessful() {
        return successful;
    }

    @JsonProperty("successful")
    public void setSuccessful(Integer successful) {
        this.successful = successful;
    }

    @JsonProperty("skipped")
    public Integer getSkipped() {
        return skipped;
    }

    @JsonProperty("skipped")
    public void setSkipped(Integer skipped) {
        this.skipped = skipped;
    }

    @JsonProperty("failed")
    public Integer getFailed() {
        return failed;
    }

    @JsonProperty("failed")
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Shards.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null)?"<null>":this.total));
        sb.append(',');
        sb.append("successful");
        sb.append('=');
        sb.append(((this.successful == null)?"<null>":this.successful));
        sb.append(',');
        sb.append("skipped");
        sb.append('=');
        sb.append(((this.skipped == null)?"<null>":this.skipped));
        sb.append(',');
        sb.append("failed");
        sb.append('=');
        sb.append(((this.failed == null)?"<null>":this.failed));
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
        result = ((result* 31)+((this.total == null)? 0 :this.total.hashCode()));
        result = ((result* 31)+((this.failed == null)? 0 :this.failed.hashCode()));
        result = ((result* 31)+((this.successful == null)? 0 :this.successful.hashCode()));
        result = ((result* 31)+((this.skipped == null)? 0 :this.skipped.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Shards) == false) {
            return false;
        }
        Shards rhs = ((Shards) other);
        return (((((this.total == rhs.total)||((this.total!= null)&&this.total.equals(rhs.total)))&&((this.failed == rhs.failed)||((this.failed!= null)&&this.failed.equals(rhs.failed))))&&((this.successful == rhs.successful)||((this.successful!= null)&&this.successful.equals(rhs.successful))))&&((this.skipped == rhs.skipped)||((this.skipped!= null)&&this.skipped.equals(rhs.skipped))));
    }

}
