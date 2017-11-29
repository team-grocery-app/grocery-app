package groceryapp;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class GroceryAppController {

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


	
}
