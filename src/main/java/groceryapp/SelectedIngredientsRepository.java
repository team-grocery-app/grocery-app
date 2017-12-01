package groceryapp;

import org.springframework.data.repository.CrudRepository;

public interface SelectedIngredientsRepository extends CrudRepository<Ingredient, Long> {

}
