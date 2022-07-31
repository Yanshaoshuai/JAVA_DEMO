package com.javademo.common.pojo;

import org.apache.commons.lang3.StringUtils;

public class Transform {
    private String alg;
    private String mod;
    private String padding;
    private String delimiter;

    public Transform(String alg, String mod, String padding, String delimiter) {
        this.alg = alg;
        this.mod = mod;
        this.padding = padding;
        this.delimiter = delimiter;
    }

    public Transform(String transformation, String delimiter) {
        String[] strings = transformation.split(delimiter);
        this.alg = strings[0];
        this.mod = strings[1];
        this.padding = strings[2];
        this.delimiter = delimiter;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getPadding() {
        return padding;
    }

    public void setPadding(String padding) {
        this.padding = padding;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getTransformation() {
        return StringUtils.joinWith(delimiter, alg, mod, padding);
    }
}
