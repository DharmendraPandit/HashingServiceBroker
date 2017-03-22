package simple.servicebroker.cf.haash.repository;

import simple.servicebroker.cf.haash.model.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, String> {
}
