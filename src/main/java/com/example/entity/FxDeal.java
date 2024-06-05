package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class FxDeal {

	@Id
	
	@NotNull
    private String dealId;
	
	@NotNull
	@Size(min = 3, max = 3)
    private String fromCurrency;
	
	@NotNull
	@Size(min = 3, max = 3)
    private String toCurrency;
	
	@NotNull
    private LocalDateTime dealTimestamp;
	
	@NotNull
	@Positive
    private double dealAmount;
	
	@PrePersist
    protected void onCreate() {
        if (this.dealTimestamp == null) {
            this.dealTimestamp = LocalDateTime.now();
        }
    }
	
}
