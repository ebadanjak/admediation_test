package com.outfit7.AdMediation.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.outfit7.AdMediation.ad_validator.AdNetworkValidator;
import com.outfit7.AdMediation.ad_validator.AdNetworkValidatorFactory;
import com.outfit7.AdMediation.api_model.AdNetworkListModel;
import com.outfit7.AdMediation.api_model.AdNetworkListWrapper;
import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.db_model.AdNetwork;
import com.outfit7.AdMediation.model.AdNetworkModel;
import com.outfit7.AdMediation.repository.AdNetworkRepository;

@Service
public class AdNetworkService {
	
	@Autowired
	AdNetworkRepository adNetworkRepository;
	
	@Value("${app.db.retrieve-rows-limit}")
	private int rowLimit;
	
	
	public AdNetworkListWrapper getAdNetworkLists(ClientDataModel clientData) {
		
		List<AdNetworkModel> bannerAdNetworks = new ArrayList<>();
		List<AdNetworkModel> videoAdNetworks = new ArrayList<>();
		List<AdNetworkModel> interstitialAdNetworks = new ArrayList<>();
		
		List<AdNetwork> adnetworks = adNetworkRepository.getOrderedListByType("BANNER", clientData.getCountryCode(), clientData.getPlatform(), clientData.getDeviceBrand(), rowLimit);
		for(AdNetwork ad : adnetworks) {
			AdNetworkModel adNetworkModel = bindAdNetworkModel(ad);
			bannerAdNetworks.add(adNetworkModel);
		}
		
		adnetworks = adNetworkRepository.getOrderedListByType("INTERSTITIAL", clientData.getCountryCode(), clientData.getPlatform(), clientData.getDeviceBrand(), rowLimit);
		for(AdNetwork ad : adnetworks) {
			AdNetworkModel adNetworkModel = bindAdNetworkModel(ad);
			interstitialAdNetworks.add(adNetworkModel);
		}
		
		adnetworks = adNetworkRepository.getOrderedListByType("VIDEO", clientData.getCountryCode(), clientData.getPlatform(), clientData.getDeviceBrand(), rowLimit);
		for(AdNetwork ad : adnetworks) {
			AdNetworkModel adNetworkModel = bindAdNetworkModel(ad);
			videoAdNetworks.add(adNetworkModel);
		}
		
		validateAdNetworkLists(clientData, bannerAdNetworks, videoAdNetworks, interstitialAdNetworks);
		
		AdNetworkListWrapper response = new AdNetworkListWrapper();
		response.setBannerAdNetworkList(bannerAdNetworks);
		response.setVideoAdNetworkList(videoAdNetworks);
		response.setInterstitialAdNetworkList(interstitialAdNetworks);
		
		return response;
	}
	
	public void storeAdNetworkList(AdNetworkListModel adNetworkList) {
		
		List<AdNetwork> adNetworks = new ArrayList<>();
		Date currentDate = new Date();
		for(AdNetworkModel adNetworkModel : adNetworkList.getAdNetworkList()) {
			AdNetwork adNetwork = bindAdNetwork(adNetworkModel, currentDate);
			adNetworks.add(adNetwork);
		}
		
		adNetworkRepository.saveAll(adNetworks);
	}
	
	private void validateAdNetworkLists(ClientDataModel clientData, List<AdNetworkModel> bannerAdNetworks, List<AdNetworkModel> videoAdNetworks, List<AdNetworkModel> interstitialAdNetworks) {
		
		bannerAdNetworks.removeIf( ad -> {
			AdNetworkValidator validator = AdNetworkValidatorFactory.getAdNetworkValidator(ad.getHandler());
			if(validator == null) {
				return true;
			}
			return !validator.validate(bannerAdNetworks, ad, clientData);
		});
		
		videoAdNetworks.removeIf( ad -> {
			AdNetworkValidator validator = AdNetworkValidatorFactory.getAdNetworkValidator(ad.getHandler());
			if(validator == null) {
				return true;
			}
			return !validator.validate(videoAdNetworks, ad, clientData);
		});
		
		interstitialAdNetworks.removeIf( ad -> {
			AdNetworkValidator validator = AdNetworkValidatorFactory.getAdNetworkValidator(ad.getHandler());
			if(validator == null) {
				return true;
			}
			return !validator.validate(interstitialAdNetworks, ad, clientData);
		});
	}
	
	private AdNetworkModel bindAdNetworkModel(AdNetwork adNetwork) {
		
		AdNetworkModel adNetworkModel = new AdNetworkModel();
		adNetworkModel.setCountry(adNetwork.getCountry());
		adNetworkModel.setHandler(adNetwork.getHandler());
		adNetworkModel.setAdType(adNetwork.getAdType());
		adNetworkModel.setIabCategory(adNetwork.getIabCategory());
		adNetworkModel.setPlatform(adNetwork.getPlatform());
		adNetworkModel.setDeviceBrand(adNetwork.getDeviceBrand());
		adNetworkModel.setScoreVal(adNetwork.getScoreVal());
		
		return adNetworkModel;
	}
	
	private AdNetwork bindAdNetwork(AdNetworkModel adNetworkModel, Date recordDate) {
		
		AdNetwork adNetwork = new AdNetwork();
		adNetwork.setCountry(adNetworkModel.getCountry());
		adNetwork.setHandler(adNetworkModel.getHandler());
		adNetwork.setAdType(adNetworkModel.getAdType());
		adNetwork.setIabCategory(adNetworkModel.getIabCategory());
		adNetwork.setPlatform(adNetworkModel.getPlatform());
		adNetwork.setDeviceBrand(adNetworkModel.getDeviceBrand());
		adNetwork.setScoreVal(adNetworkModel.getScoreVal());
		adNetwork.setRecordDate(new Timestamp(recordDate.getTime()));
		
		return adNetwork;
	}

}
