package groceryapp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String quantity;

	@ManyToMany(mappedBy = "recipeIngredients")
	private Set<Recipe> recipes;

	protected Ingredient() {

	}

	public Ingredient(Long id, String name, String quantity, Set<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.recipes = recipes;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getQuantity() {
		return quantity;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

}
