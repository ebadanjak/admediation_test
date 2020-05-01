package com.outfit7.AdMediation.ad_validator;

import java.util.List;

import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.model.AdNetworkModel;

public class AdBladeValidator implements AdNetworkValidator {
	
	private static AdBladeValidator instance = null;
	
	private AdBladeValidator() {
		
	}
	
    public static AdBladeValidator getInstance() { 
        if (instance == null) {
        	instance = new AdBladeValidator(); 
        }
        	
        return instance; 
    }

	@Override
	public boolean validate(List<AdNetworkModel> adNetworkList, AdNetworkModel adNetwork, ClientDataModel clientData) {
		
		return true;
	}
}
