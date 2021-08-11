package com.javastart.rest.controller.dto;

public class RestResponse {

        private Long productId;
        private String name;
        private String description;
        private Integer implementationCost;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getImplementationCost() {
            return implementationCost;
        }

        public void setImplementationCost(Integer implementationCost) {
            this.implementationCost = implementationCost;
        }
    }

