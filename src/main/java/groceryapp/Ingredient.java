package groceryapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String quantity;

	@ManyToOne
	private Recipe recipes;

	protected Ingredient() {

	}

	public Ingredient(Long id, String name, String quantity, Recipe recipes) {
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

	public Recipe getRecipes() {
		return recipes;
	}

}
