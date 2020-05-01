package com.outfit7.AdMediation.ad_validator;

import java.util.List;

import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.model.AdNetworkModel;

public class SmartyAdsValidator implements AdNetworkValidator {

	private static SmartyAdsValidator instance = null;
	
	private SmartyAdsValidator() {
		
	}
	
    public static SmartyAdsValidator getInstance() { 
        if (instance == null) {
        	instance = new SmartyAdsValidator(); 
        }
        	
        return instance; 
    }

	@Override
	public boolean validate(List<AdNetworkModel> adNetworkList, AdNetworkModel adNetwork, ClientDataModel clientData) {
		
		return true;
	}
}
