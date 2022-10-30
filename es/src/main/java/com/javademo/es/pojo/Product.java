package com.javademo.es.pojo;

import java.util.List;

public class Product {
    private String name;
    private Double revenue;
    List<SubProduct> subProduct;

    public static class SubProduct{
        private String name;
        private Double revenue;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getRevenue() {
            return revenue;
        }

        public void setRevenue(Double revenue) {
            this.revenue = revenue;
        }

        @Override
        public String toString() {
            return "SubProduct{" +
                    "name='" + name + '\'' +
                    ", revenue=" + revenue +
                    '}';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public List<SubProduct> getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(List<SubProduct> subProduct) {
        this.subProduct = subProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", revenue=" + revenue +
                ", subProduct=" + subProduct +
                '}';
    }
}
