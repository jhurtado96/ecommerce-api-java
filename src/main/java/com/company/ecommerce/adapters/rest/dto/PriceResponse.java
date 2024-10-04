package com.company.ecommerce.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PriceResponse {
    private Integer productId;
    private Long brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private String currency;
    private Integer priority;
    
    public PriceResponse(Long brandId, Integer priceList, LocalDateTime startDate, LocalDateTime endDate, int productId, 
            Integer priority, BigDecimal price, String currency) {
	   this.brandId = brandId;
	   this.priceList = priceList;
	   this.startDate = startDate;
	   this.endDate = endDate;
	   this.productId = productId;
	   this.priority = priority;
	   this.price = price;
	   this.currency = currency;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
	
	public Integer getPriority() {
	   return priority;
	}
	
	public void setPriority(Integer priority) {
	   this.priority = priority;
	}

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
