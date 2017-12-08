package groceryapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

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

	public List<Ingredient> getIngredients() {

		String currentTagName;
		TreeMap<String, ArrayList<Ingredient>> selIngredientMap = new TreeMap<String, ArrayList<Ingredient>>();
		for (Ingredient currentIngredient : ingredients) {
			currentTagName = currentIngredient.getTag().getTag();
			if (selIngredientMap.containsKey(currentTagName)) {
				selIngredientMap.get(currentTagName).add(currentIngredient);
			} else {
				ArrayList<Ingredient> newIngredientsArray = new ArrayList<Ingredient>();
				newIngredientsArray.add(currentIngredient);
				selIngredientMap.put(currentTagName, newIngredientsArray);
			}
		}
		List<Ingredient> iList = new ArrayList<Ingredient>();

		for (ArrayList<Ingredient> i : selIngredientMap.values()) {

			iList.addAll(i);
		}

		return iList;

		// The original code just did this:
		// return ingredients;

		// Brian's code did this but it removed duplicate entries for a
		// tag:
		// SortedSet<Ingredient> sorted = new TreeMap<>(new ByTagComparator());
		// sorted.addAll(ingredients);
		// return Collections.unmodifiableSet(sorted); // makes this read-only
	}

} // to close class
