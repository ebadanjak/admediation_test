package com.outfit7.AdMediation.db_model;

import java.sql.Timestamp;

import javax.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="ad_networks")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AdNetwork {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adnetwork_generator")
    @SequenceGenerator(
            name = "adnetwork_generator",
            sequenceName = "eb_java_test.adnetwork_seq",
            allocationSize=1, initialValue=1
    )
	private Long id;
	
	@Column(name="ad_network_handler")
	private String handler;
	
	private String country;
	
	@Column(name="ad_type")
	private String adType;
	
	@Column(name="iab_category")
	private String iabCategory;
	
	private String platform;
	
	@Column(name="device_brand")
	private String deviceBrand;
	
	@Column(name="record_date")
	private Timestamp recordDate;
	
	@Column(name="score_val")
	private Integer scoreVal;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public String getIabCategory() {
		return iabCategory;
	}

	public void setIabCategory(String iabCategory) {
		this.iabCategory = iabCategory;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getDeviceBrand() {
		return deviceBrand;
	}

	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}

	public Timestamp getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
	}

	public Integer getScoreVal() {
		return scoreVal;
	}

	public void setScoreVal(Integer scoreVal) {
		this.scoreVal = scoreVal;
	}
}
