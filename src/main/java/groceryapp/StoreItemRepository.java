package groceryapp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StoreItemRepository extends CrudRepository<StoreItem, Long> {

	List<StoreItem> findByTag(Tag tag);

}
