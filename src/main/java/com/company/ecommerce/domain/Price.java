package com.company.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "price_list", nullable = false)
    private Integer priceList;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "curr", nullable = false, length = 3)
    private String currency;

    public Price() {
    }
    
    public Price(Long brandId, Integer priceList, LocalDateTime startDate, LocalDateTime endDate, int productId, 
            Integer priority, BigDecimal price,  String currency) {
	   this.brandId = brandId;
	   this.priceList = priceList;
	   this.startDate = startDate;
	   this.endDate = endDate;
	   this.productId = productId;
	   this.priority = priority;
	   this.price = price;
	   this.currency = currency;
    }

	public long getBrandId() {
	   return brandId;
	}
	
	public void setBrandId(long brandId) {
	   this.brandId = brandId;
	}
	
	public Integer getPriceList() {
	   return priceList;
	}
	
	public void setPriceList(Integer priceList) {
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
	
	public int getProductId() {
	   return productId;
	}
	
	public void setProductId(int productId) {
	   this.productId = productId;
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
