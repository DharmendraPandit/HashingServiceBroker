package simple.servicebroker.cf.haash.haash;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import simple.servicebroker.cf.haash.utility.CustomHashMap;


@Component
public class HashingServiceImpl implements HashingService {

	private Map<String, CustomHashMap<Object, Object>> hashMaps = new HashMap<>();

	@Override
    public void create(String id) {
        hashMaps.put(id, new CustomHashMap<Object, Object>());
    }

	@Override
    public void delete(String id) {
        hashMaps.remove(id);
    }

	@Override
    public void put(String id, Object key, Object value) {
        CustomHashMap<Object, Object> mapInstance = hashMaps.get(id);
        mapInstance.put(key, value);
    }

	@Override
    public Object get(String id, Object key) {
        CustomHashMap<Object, Object> mapInstance = hashMaps.get(id);
        return mapInstance.get(key);
    }

	@Override
    public void delete(String id, Object key) {
        CustomHashMap<Object, Object> mapInstance = hashMaps.get(id);
        mapInstance.remove(key);
    }	
}
