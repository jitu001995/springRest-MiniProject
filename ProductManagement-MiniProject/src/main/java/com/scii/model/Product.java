package com.scii.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="prd_tab")
public class Product {
	
	@GeneratedValue
	@Id
	@Column(name="p_id")
	private Integer prodId;
	@Column(name="p_code")
	private String prodCode;
	@Column(name="p_cost")
	private Double prodCost;
	@Column(name="p_vendor")
	private String prodVendor;
	@Column(name="p_gst")
	private Double prodgst;
	@Column(name="p_disc")
	private Double prodDisc;

}
