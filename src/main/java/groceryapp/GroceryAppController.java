package groceryapp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroceryAppController {

	@Resource
	TagRepository tagRepo;

	@Resource
	RecipeRepository recipeRepo;

	@Resource
	IngredientRepository ingredientRepo;

	@Resource
	StoreItemRepository storeItemRepo;

	@Resource
	LineItemRepository lineItemRepo;

	@RequestMapping("/recipes")
	public String getAllRecipes(Model model) {
		model.addAttribute("recipes", recipeRepo.findAll());
		return "recipes";
	}

	@RequestMapping("/recipe")
	public String getOneRecipe(@RequestParam Long id, Model model) {
		model.addAttribute("recipe", recipeRepo.findOne(id));
		return "recipe";
	}

	@RequestMapping("/ingredients")
	public String getAllIngredients(Model model) {
		model.addAttribute("ingredients", ingredientRepo.findAll());
		return "ingredients";
	}

	@RequestMapping("/tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	// test
	@RequestMapping("/hello-world")
	public String stopGettingADamn404(Model model) {
		return "hello-world";
	}

	// sample code for controller to save a selected ingredient to repository
	// Long testObjectId = testIngredientWithTag.getId();
	// selectedIngredientsRepo.save(ingredientRepo.findOne(testObjectId));

}
