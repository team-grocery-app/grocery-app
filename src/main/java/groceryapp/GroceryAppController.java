package groceryapp;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
		// give model treemap - works
		SelectedIngredientsList selectedIngredientsList = selectedIngredientsListRepo.findOne(1L);
		TreeMap<String, ArrayList<Ingredient>> treeMap = selectedIngredientsList.getTreeMap();
		model.addAttribute("selectedIngredientsTreeMap", treeMap);
		// give model a set of selected tags to narrow down our displayed store items
		Set<Tag> selectedTags = new HashSet<Tag>();
		for (Entry<String, ArrayList<Ingredient>> i : treeMap.entrySet()) {
			ArrayList<Ingredient> arrayListAtEntry = i.getValue();
			for (Ingredient j : arrayListAtEntry) {
				selectedTags.add(j.getTag());
			}
		}
		Set<StoreItem> matchingStoreItems = new HashSet<StoreItem>();
		for (Tag k : selectedTags) {
			for (StoreItem m : k.getStoreItems()) {
				matchingStoreItems.add(m);
			}
		}
		model.addAttribute("selectedTags", selectedTags);
		model.addAttribute("matchingStoreItems", matchingStoreItems);
		model.addAttribute("selectedIngredients", selectedIngredientsListRepo.findOne(1L).getIngredients());
		return "store-items";
	}

	@RequestMapping("/remove")
	public String removeTag(@RequestParam(value = "id") Long id) {

		SelectedIngredientsList selList = selectedIngredientsListRepo.findOne(1L);
		Ingredient i = selList.getIngredient(id);
		selList.removeIngredient(i);
		selectedIngredientsListRepo.save(selList);
		return "redirect:/ingredients";
		// removed id parameter. ingredients mapping does not accept ids - AB
	}
}
