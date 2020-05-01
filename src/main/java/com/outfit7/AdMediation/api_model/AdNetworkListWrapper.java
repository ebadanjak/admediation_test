package com.outfit7.AdMediation.api_model;

import java.util.List;

import com.outfit7.AdMediation.model.AdNetworkModel;

public class AdNetworkListWrapper {
	
	private List<AdNetworkModel> bannerAdNetworkList;
	private List<AdNetworkModel> interstitialAdNetworkList;
	private List<AdNetworkModel> videoAdNetworkList;
	
	
	public List<AdNetworkModel> getBannerAdNetworkList() {
		return bannerAdNetworkList;
	}
	public void setBannerAdNetworkList(List<AdNetworkModel> bannerAdNetworkList) {
		this.bannerAdNetworkList = bannerAdNetworkList;
	}
	public List<AdNetworkModel> getInterstitialAdNetworkList() {
		return interstitialAdNetworkList;
	}
	public void setInterstitialAdNetworkList(List<AdNetworkModel> interstitialAdNetworkList) {
		this.interstitialAdNetworkList = interstitialAdNetworkList;
	}
	public List<AdNetworkModel> getVideoAdNetworkList() {
		return videoAdNetworkList;
	}
	public void setVideoAdNetworkList(List<AdNetworkModel> videoAdNetworkList) {
		this.videoAdNetworkList = videoAdNetworkList;
	}
}
