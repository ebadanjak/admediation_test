package com.outfit7.AdMediation.model;

public class AdNetworkModel {
	
	private String handler;
	private String country;
	private String adType;
	private String iabCategory;
	private String platform;
	private String deviceBrand;
	private Integer scoreVal;
	
	
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
	public Integer getScoreVal() {
		return scoreVal;
	}
	public void setScoreVal(Integer scoreVal) {
		this.scoreVal = scoreVal;
	}
}
