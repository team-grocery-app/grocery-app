package groceryapp;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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

	@Resource
	SelectedIngredientsListRepository selectedIngredientsListRepo;

	ArrayList<String> newList;

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
		model.addAttribute("selectedIngredients", selectedIngredientsListRepo.findOne(1L).getIngredients());
		return "ingredients";
	}

	@RequestMapping("/tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/tagStoreItems")
	public String getStoreItemsForTag(@RequestParam Long id, Model model) {
		Tag searchTag = tagRepo.findOne(id);
		model.addAttribute("storeItems", storeItemRepo.findByTag(searchTag));
		return "tag-with-assoc-store-items";
	}

	@RequestMapping("/cook-this")
	public String cookThisButtonActionOnRecipeTemplate(@RequestParam Long id) {

		SelectedIngredientsList selectedIngredientsList = selectedIngredientsListRepo.findOne(1L);
		for (Ingredient i : recipeRepo.findOne(id).getListOfIngredients()) {
			selectedIngredientsList.addIngredient(i);
		}
		selectedIngredientsListRepo.save(selectedIngredientsList);
		return "redirect:/ingredients";

	}

	@RequestMapping("/shop")
	public String shop() {

		return "redirect:/store-items";
	}

	@RequestMapping("/store-items")
	public String showStoreItemsTemplate(Model model) {
		List<Ingredient> selectedIngredients = selectedIngredientsListRepo.findOne(1L).getIngredients();
		Set<Tag> selectedTags = new TreeSet<Tag>();
		for (Ingredient i : selectedIngredients) {
			selectedTags.add(i.getTag());
		}
		model.addAttribute("selectedIngredients", selectedIngredients);
		model.addAttribute("selectedTags", selectedTags);
		return "store-items";
	}

	@RequestMapping("/remove")
	public String removeTag(@RequestParam(value = "id") Long id) {

		SelectedIngredientsList selList = selectedIngredientsListRepo.findOne(1L);
		Ingredient i = selList.getIngredient(id);
		selList.removeIngredient(i);
		selectedIngredientsListRepo.save(selList);
		return "redirect:/ingredients";
	}

} // to close Controller class
