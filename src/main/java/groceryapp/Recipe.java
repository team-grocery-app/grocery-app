package groceryapp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String image;

	@Lob
	private String instructions;

	@ManyToMany
	private Set<Ingredient> listOfIngredients;

	protected Recipe() {

	}

	public Recipe(Long id, String name, String image, String instructions, Set<Ingredient> listOfIngredients) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.instructions = instructions;
		this.listOfIngredients = listOfIngredients;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public String getInstructions() {
		return instructions;
	}

	public Set<Ingredient> getListOfIngredients() {
		return listOfIngredients;
	}

}
