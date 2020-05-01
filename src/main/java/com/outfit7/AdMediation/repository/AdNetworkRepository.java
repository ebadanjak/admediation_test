package com.outfit7.AdMediation.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.outfit7.AdMediation.db_model.AdNetwork;

public interface AdNetworkRepository extends JpaRepository<AdNetwork, Long>{
	
	@Cacheable(value = "OrderedListByTypeQueryCache")
	@Query(nativeQuery=true, value = "select * from {h-schema}ad_networks where record_date between now() - interval '24 HOURS' and now() " +
		   "and ad_type = :adType " +
		   "order by score_val desc, country=:countryCode desc, platform=:platform desc, device_brand=:deviceBrand desc limit :recordLimit")
	List<AdNetwork> getOrderedListByType(@Param("adType") String adType, @Param("countryCode") String countryCode, @Param("platform") String platform, @Param("deviceBrand") String deviceBrand, 
			@Param("recordLimit") Integer recordLimit);

}
