package com.outfit7.AdMediation.ad_validator;

import java.util.List;

import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.model.AdNetworkModel;

public class AdPushupValidator implements AdNetworkValidator {
	
	private static AdPushupValidator instance = null;
	
	private AdPushupValidator() {
		
	}
	
    public static AdPushupValidator getInstance() { 
        if (instance == null) {
        	instance = new AdPushupValidator(); 
        }
        	
        return instance; 
    }

	@Override
	public boolean validate(List<AdNetworkModel> adNetworkList, AdNetworkModel adNetwork, ClientDataModel clientData) {
		
		return true;
	}
}
