package simple.servicebroker.cf.haash.repository;

import simple.servicebroker.cf.haash.model.ServiceBinding;
import org.springframework.data.repository.CrudRepository;

public interface ServiceBindingRepository extends CrudRepository<ServiceBinding,String> {
}
