package groceryapp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SelectedIngredientsList {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany
	private Set<Ingredient> ingredients;

	public SelectedIngredientsList() {

	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	public void removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
	}

	public Long getId() {
		return id;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

} // to close class
