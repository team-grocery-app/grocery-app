package groceryapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String imageUrl;

	@Lob
	private String instructions;

	@OneToMany
	private Set<Ingredient> listOfIngredients;

	protected Recipe() {
	}

	public Recipe(String name, String imageUrl, String instructions, Ingredient... listOfIngredients) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.instructions = instructions;
		this.listOfIngredients = new HashSet<>(Arrays.asList(listOfIngredients));
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getInstructions() {
		return instructions;
	}

	public Set<Ingredient> getListOfIngredients() {
		return listOfIngredients;
	}

}
