package groceryapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String image;

	@Lob
	private String instructions;

	@OneToMany
	private Set<Ingredient> listOfIngredients;

	protected Recipe() {

	}

	public Recipe(Long id, String name, String image, String instructions, Ingredient... listOfIngredients) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.instructions = instructions;
		this.listOfIngredients = new HashSet<>(Arrays.asList(listOfIngredients));
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
