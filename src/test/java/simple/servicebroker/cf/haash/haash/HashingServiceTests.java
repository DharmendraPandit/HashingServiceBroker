package simple.servicebroker.cf.haash.haash;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import simple.servicebroker.cf.haash.haash.HashingService;
import simple.servicebroker.cf.haash.haash.HashingServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HashingServiceTests {

	HashingService service = new HashingServiceImpl();

	@Test
	public void create01() {
		service.create("1001");
	}

	@Test
	public void create02() {
		service.create(null);
	}

	@Test
	public void delete01() {
		service.delete("1001");
	}

	@Test
	public void delete02() {
		service.delete(null);
	}

	@Test
	public void put() {
		service.create("1001");
		service.put("1001", "Dharmendra", "Pandit");
	}

	@Test
	public void get() {
		service.create("1001");
		service.put("1001", "Dharmendra", "Pandit");
		String value = service.get("1001", "Dharmendra").toString();
		assertThat(value).isEqualTo("Pandit");
	}
}
