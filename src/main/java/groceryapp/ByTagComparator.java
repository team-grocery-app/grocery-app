package groceryapp;

import java.util.Comparator;

public class ByTagComparator implements Comparator<Ingredient> {
	@Override
	public int compare(Ingredient ingredient1, Ingredient ingredient2) {
		return ingredient1.getTag().compareTo(ingredient2.getTag());
	}
}
