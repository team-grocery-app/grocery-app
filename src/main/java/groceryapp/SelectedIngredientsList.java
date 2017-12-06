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

	public void removeIngredient(Ingredient i) {
		ingredients.remove(i);
	}

	public Ingredient getIngredient(Long id) {
		for (Ingredient i : ingredients) {
			if (i.getId() == id) {
				return i;
			}
		}
		return null;
	}

	public Long getId() {
		return id;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

} // to close class
