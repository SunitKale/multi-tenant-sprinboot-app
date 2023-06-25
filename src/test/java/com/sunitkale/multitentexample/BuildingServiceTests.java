package com.sunitkale.multitentexample;

import com.sunitkale.multitentexample.config.TenantIdentifierResolver;
import com.sunitkale.multitentexample.entity.Building;
import com.sunitkale.multitentexample.service.BuildingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuildingServiceTests {

	@Autowired
	private BuildingService buildingService;

	@Autowired
	TenantIdentifierResolver tenantIdentifierResolver;

	@Test
	void saveBuildingTest() {
		tenantIdentifierResolver.setCurrentTenant("asia");
		Building building = new Building();
		building.setAddress("Akurdi");
		building.setCity("Pune");
		building.setState("MH");
		building.setZipcode("401 411");
		building.setCountry("India");
		buildingService.createBuilding(building);
	}

}
