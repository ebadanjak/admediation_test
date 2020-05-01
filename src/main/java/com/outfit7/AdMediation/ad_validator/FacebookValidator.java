package com.outfit7.AdMediation.ad_validator;

import java.util.List;

import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.model.AdNetworkModel;

public class FacebookValidator implements AdNetworkValidator {
	
	private static FacebookValidator instance = null;
	
	private FacebookValidator() {
		
	}
	
    public static FacebookValidator getInstance() { 
        if (instance == null) {
        	instance = new FacebookValidator(); 
        }
        	
        return instance; 
    }

	@Override
	public boolean validate(List<AdNetworkModel> adNetworkList, AdNetworkModel adNetwork, ClientDataModel clientData) {
		
		boolean retval = true;
		if(clientData.getAppType().equalsIgnoreCase("CN")) {
			retval = false;
		}
		return retval;
	}
}
