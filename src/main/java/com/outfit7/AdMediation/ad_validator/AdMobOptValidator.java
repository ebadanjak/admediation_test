package com.outfit7.AdMediation.ad_validator;

import java.util.List;

import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.model.AdNetworkModel;

public class AdMobOptValidator implements AdNetworkValidator {
	
	private static AdMobOptValidator instance = null;
	
	private AdMobOptValidator() {
		
	}
	
    public static AdMobOptValidator getInstance() { 
        if (instance == null) {
        	instance = new AdMobOptValidator(); 
        }
        	
        return instance; 
    }

	@Override
	public boolean validate(List<AdNetworkModel> adNetworkList, AdNetworkModel adNetwork, ClientDataModel clientData) {
		
		boolean retval = true;
		AdNetworkModel adMob = adNetworkList.stream()
				  .filter(ad -> ad.getHandler().equalsIgnoreCase("ADMOB"))
				  .findAny()
				  .orElse(null);
		if(adMob != null) {
			retval = false;
		}
		
		return retval;
	}

}
