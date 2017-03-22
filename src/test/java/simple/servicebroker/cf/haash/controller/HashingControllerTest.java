package simple.servicebroker.cf.haash.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import simple.servicebroker.cf.haash.haash.HashingService;

@RunWith(MockitoJUnitRunner.class)
public class HashingControllerTest {

	@InjectMocks
	HashingController hashingController;

	@Mock
	HashingService hashService;

	@Test
	public void putTest() {
		ResponseEntity<String> responseEntityMocked = hashingController.put("firstinstance", "firstKey", "firstValue");
		verify(hashService, atLeastOnce()).put("firstinstance", "firstKey", "firstValue");
		assertEquals(HttpStatus.OK, responseEntityMocked.getStatusCode().OK);
	}

	@Test
	public void getTest() {
		hashingController.put("getTestInstance", "getTestKey", "getTestValue");
		ResponseEntity<Object> responseEntityMocked = hashingController.get("getTestInstance", "getTestKey");
		verify(hashService, atLeastOnce()).put("getTestInstance", "getTestKey", "getTestValue");
		verify(hashService, atLeastOnce()).get("getTestInstance", "getTestKey");
		assertEquals(HttpStatus.OK, responseEntityMocked.getStatusCode().OK);
	}

	@Test
	public void deleteTest() {
		hashingController.put("deleteTestInstance", "deleteTestKey", "deleteTestValue");
		when(hashService.get("deleteTestInstance", "deleteTestKey")).thenReturn(new Object());
		ResponseEntity<String> responseEntityMocked = hashingController.delete("deleteTestInstance", "deleteTestKey");
		verify(hashService, atLeastOnce()).put("deleteTestInstance", "deleteTestKey", "deleteTestValue");
		verify(hashService, atLeastOnce()).delete("deleteTestInstance", "deleteTestKey");
		verify(hashService, atLeastOnce()).get("deleteTestInstance", "deleteTestKey");
		assertEquals(HttpStatus.OK, responseEntityMocked.getStatusCode().OK);
	}
}
