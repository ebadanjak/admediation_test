package com.outfit7.AdMediation.ad_validator;

public class AdNetworkValidatorFactory {
	
	public static AdNetworkValidator getAdNetworkValidator(String adNetworkHandler) {
		
		AdNetworkValidator validator = null;
		if(adNetworkHandler.equalsIgnoreCase("FACEBOOK")) {
			validator =  FacebookValidator.getInstance();
		}
		else if(adNetworkHandler.equalsIgnoreCase("ADMOB")) {
			validator =  AdMobValidator.getInstance();
		}
		else if(adNetworkHandler.equalsIgnoreCase("ADMOB_OPT")) {
			validator =  AdMobOptValidator.getInstance();
		}
		else if(adNetworkHandler.equalsIgnoreCase("ADPUSHUP")) {
			validator =  AdPushupValidator.getInstance();
		}
		else if(adNetworkHandler.equalsIgnoreCase("SMARTYADS")) {
			validator =  SmartyAdsValidator.getInstance();
		}
		else if(adNetworkHandler.equalsIgnoreCase("ADBLADE")) {
			validator =  AdBladeValidator.getInstance();
		}
		else if(adNetworkHandler.equalsIgnoreCase("TABOOLA")) {
			validator =  TaboolaValidator.getInstance();
		}
		
		return validator;
	}

}
