package com.outfit7.AdMediation.ad_validator;

import java.util.List;

import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.model.AdNetworkModel;

public class TaboolaValidator implements AdNetworkValidator {
	
	private static TaboolaValidator instance = null;
	
	private TaboolaValidator() {
		
	}
	
    public static TaboolaValidator getInstance() { 
        if (instance == null) {
        	instance = new TaboolaValidator(); 
        }
        	
        return instance; 
    }

	@Override
	public boolean validate(List<AdNetworkModel> adNetworkList, AdNetworkModel adNetwork, ClientDataModel clientData) {
		
		return true;
	}
}
