package com.javademo.freemapper.entity.byid;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "_index",
    "_id",
    "_version",
    "_seq_no",
    "_primary_term",
    "found",
    "_source"
})
@Generated("jsonschema2pojo")
public class SearchByIdResult<T> {

    @JsonProperty("_index")
    private String index;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_version")
    private Integer version;
    @JsonProperty("_seq_no")
    private Integer seqNo;
    @JsonProperty("_primary_term")
    private Integer primaryTerm;
    @JsonProperty("found")
    private Boolean found;
    @JsonProperty("_source")
    private T source;

    @JsonProperty("_index")
    public String getIndex() {
        return index;
    }

    @JsonProperty("_index")
    public void setIndex(String index) {
        this.index = index;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("_version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("_version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("_seq_no")
    public Integer getSeqNo() {
        return seqNo;
    }

    @JsonProperty("_seq_no")
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    @JsonProperty("_primary_term")
    public Integer getPrimaryTerm() {
        return primaryTerm;
    }

    @JsonProperty("_primary_term")
    public void setPrimaryTerm(Integer primaryTerm) {
        this.primaryTerm = primaryTerm;
    }

    @JsonProperty("found")
    public Boolean getFound() {
        return found;
    }

    @JsonProperty("found")
    public void setFound(Boolean found) {
        this.found = found;
    }

    @JsonProperty("_source")
    public T getSource() {
        return source;
    }

    @JsonProperty("_source")
    public void setSource(T source) {
        this.source = source;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SearchByIdResult.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("index");
        sb.append('=');
        sb.append(((this.index == null)?"<null>":this.index));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("seqNo");
        sb.append('=');
        sb.append(((this.seqNo == null)?"<null>":this.seqNo));
        sb.append(',');
        sb.append("primaryTerm");
        sb.append('=');
        sb.append(((this.primaryTerm == null)?"<null>":this.primaryTerm));
        sb.append(',');
        sb.append("found");
        sb.append('=');
        sb.append(((this.found == null)?"<null>":this.found));
        sb.append(',');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null)?"<null>":this.source));
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
        result = ((result* 31)+((this.found == null)? 0 :this.found.hashCode()));
        result = ((result* 31)+((this.seqNo == null)? 0 :this.seqNo.hashCode()));
        result = ((result* 31)+((this.primaryTerm == null)? 0 :this.primaryTerm.hashCode()));
        result = ((result* 31)+((this.index == null)? 0 :this.index.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchByIdResult) == false) {
            return false;
        }
        SearchByIdResult rhs = ((SearchByIdResult) other);
        return ((((((((this.found == rhs.found)||((this.found!= null)&&this.found.equals(rhs.found)))&&((this.seqNo == rhs.seqNo)||((this.seqNo!= null)&&this.seqNo.equals(rhs.seqNo))))&&((this.primaryTerm == rhs.primaryTerm)||((this.primaryTerm!= null)&&this.primaryTerm.equals(rhs.primaryTerm))))&&((this.index == rhs.index)||((this.index!= null)&&this.index.equals(rhs.index))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))));
    }

}
