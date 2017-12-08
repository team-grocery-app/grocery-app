package groceryapp;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SelectedIngredientsList {

	@Id
	@GeneratedValue
	private Long id;

	// @OneToMany
	// private Set<Ingredient> ingredients;

	// @OneToMany
	private TreeMap<String, ArrayList<Ingredient>> ingredients;

	public SelectedIngredientsList() {
		this.ingredients = new TreeMap<String, ArrayList<Ingredient>>();
	}

	public void addIngredient(Ingredient ingredient) {
		// accepts ingredient as input parameter
		// checks to see if that ingredient's tag
		// is already a key on the map. if so, adds
		// ingredient to the arrayList at that key's value.
		// if that key is not present, create an
		// ArrayList<Ingredient>, then add the tag as
		// a new key, add the input Ingredient to the ArrayList,
		// and store the ArrayList at the value of the new key

		if (ingredients.containsKey(ingredient.getTag().getTag())) {
			ingredients.get(ingredient.getTag().getTag()).add(ingredient);
		} else {
			ArrayList<Ingredient> newIngredientsArray = new ArrayList<Ingredient>();
			newIngredientsArray.add(ingredient);
			ingredients.put(ingredient.getTag().getTag(), newIngredientsArray);
		}
	} // to close addIngredient method

	public void removeIngredient(Ingredient ingredient) {
		// use ingredient's tag to locate its entry in treemap,
		// call that key's ArrayList's to remove the input Ingredient
		// then check if that key's ArrayList is empty. If empty, remove Key/Entry
		String tagName = ingredient.getTag().getTag();
		ingredients.get(tagName).remove(ingredient);
		if (ingredients.get(tagName).isEmpty()) {
			ingredients.remove(ingredients.get(tagName));
		}

	}

	public Long getId() {
		return id;
	}

	// public Set<Ingredient> getIngredients() {
	// Set<Ingredient> sortedIngredients = null;
	// for (Entry<String, ArrayList<Ingredient>> i : ingredients.entrySet()) {
	// for (Ingredient j : i.getValue()) {
	// sortedIngredients.add(j);
	// }
	// }
	// return sortedIngredients;
	// }

} // to close class
