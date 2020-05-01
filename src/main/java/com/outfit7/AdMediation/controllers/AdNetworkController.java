package com.outfit7.AdMediation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outfit7.AdMediation.api_model.AdNetworkListModel;
import com.outfit7.AdMediation.api_model.AdNetworkListWrapper;
import com.outfit7.AdMediation.api_model.ClientDataModel;
import com.outfit7.AdMediation.api_model.RestResponse;
import com.outfit7.AdMediation.service.AdNetworkService;

@CrossOrigin
@RestController
@RequestMapping("ad-networks")
public class AdNetworkController {
	
	@Autowired
	AdNetworkService adNetworkService;
	
	@GetMapping
	private ResponseEntity<AdNetworkListWrapper> getAdNetworkList(@RequestBody ClientDataModel clientData) {
		
		AdNetworkListWrapper adNetworkListModel = adNetworkService.getAdNetworkLists(clientData);
		
		return ResponseEntity.ok(adNetworkListModel);
	}
	
	@PostMapping
	private ResponseEntity<RestResponse> storeAdNetworkList(@RequestBody AdNetworkListModel adNetworkList) {
		
		adNetworkService.storeAdNetworkList(adNetworkList);
		
		RestResponse response = new RestResponse();
		response.setMessage("SUCCESS");
		
		return ResponseEntity.ok(response);
	}

}
