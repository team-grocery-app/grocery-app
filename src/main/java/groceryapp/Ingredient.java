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
	private Recipe recipe;

	@ManyToOne
	private Tag tag;

	protected Ingredient() {

	}

	public Ingredient(String name, String quantity, Tag tag, Recipe recipe) {
		this.name = name;
		this.quantity = quantity;
		this.tag = tag;
		this.recipe = recipe;
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

	public Recipe getRecipe() {
		return recipe;
	}

	public Tag getTag() {
		return tag;
	}

}
