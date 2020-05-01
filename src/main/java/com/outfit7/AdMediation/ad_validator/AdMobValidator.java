package com.outfit7.AdMediation.ad_validator;

import java.util.List;

import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.model.AdNetworkModel;

public class AdMobValidator implements AdNetworkValidator {
	
	private static AdMobValidator instance = null;
	
	private AdMobValidator() {
		
	}
	
    public static AdMobValidator getInstance() { 
        if (instance == null) {
        	instance = new AdMobValidator(); 
        }
        	
        return instance; 
    }
    
	@Override
	public boolean validate(List<AdNetworkModel> adNetworkList, AdNetworkModel adNetwork, ClientDataModel clientData) {
		
		boolean retval = true;
		if(clientData.getPlatform().equalsIgnoreCase("ANDROID") && clientData.getOsVersion() - (clientData.getOsVersion() % 1) == 9) {
			
			retval = false;
		}
		return retval;
	}
}
