package simple.servicebroker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import simple.servicebroker.cf.haash.utility.CustomHashMap;

@RunWith(MockitoJUnitRunner.class)
public class CustomHashMapTest {

	@InjectMocks
	CustomHashMap<Integer, String> customHashMap;

	private int defaultKey = 0;
	private String defaultValue = "Default";

	@Before
	public void setUp() throws Exception {
		customHashMap.put(defaultKey, defaultValue);
	}
	
	@Test
	public void testPut() {
		int newKey = 1;		
		String data = "MyFistValue";		
		customHashMap.put(newKey, data);
		assertThat("MyFistValue").isEqualTo(customHashMap.get(1));
	}
	
	@Test
	public void get() {
		customHashMap.put(1001, "Dharmendra");
		String value = customHashMap.get(1001).toString();
		assertThat(value).isEqualTo("Dharmendra");
	}
	
	@Test
	public void testGet() {
		assertThat("Default").isEqualTo(customHashMap.get(0));
	}
	
	@Test
	public void delete01() {
		customHashMap.put(1001, "Dharmendra");
		boolean isRemoved = customHashMap.remove(1001);
		assertThat(true).isEqualTo(isRemoved);
	}

}
