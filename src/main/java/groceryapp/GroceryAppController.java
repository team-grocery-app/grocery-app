package groceryapp;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		// reserved in case some functionality is required
		return "redirect:/store-items";
	}

	@GetMapping("/store-items")
	public String showStoreItemsTemplate(Model model) {
		List<Ingredient> selectedIngredients = selectedIngredientsListRepo.findOne(1L).getIngredients();
		Set<Tag> selectedTags = new TreeSet<Tag>();
		for (Ingredient i : selectedIngredients) {
			selectedTags.add(i.getTag());
		}
		model.addAttribute("selectedIngredients", selectedIngredients);
		model.addAttribute("selectedTags", selectedTags);
		model.addAttribute("productSelections", new ProductSelections());
		model.addAttribute("storeItems", storeItemRepo.findAll());
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

	@PostMapping("/process-store-item-selections")
	public String buildLineItems(@ModelAttribute ProductSelections productSelections) {
		System.out.println("List: " + productSelections.getIds());
		System.out.println("List: " + productSelections.getQtys());

		lineItemRepo.deleteAll();
		StoreItem selectedStoreItem;
		LineItem groceryListLineItem;
		String id, qty;

		for (int i = 1; i < productSelections.getIds().size(); i++) {
			id = productSelections.getIds().get(i);
			qty = productSelections.getQtys().get(i);
			if (id == null || id.isEmpty()) {
			} else {
				Long longId = Long.valueOf(id);
				selectedStoreItem = storeItemRepo.findOne(longId);
				System.out.println("i is " + i);
				System.out.println("id is " + id);
				if (qty == null || qty.isEmpty()) {
					qty = "1";
				}
				System.out.println("qty is " + qty);

				Integer intQty = Integer.valueOf(qty);
				groceryListLineItem = new LineItem(intQty, selectedStoreItem);
				lineItemRepo.save(groceryListLineItem);

			}
		}
		return "redirect:/grocery-list";
	}

	@RequestMapping("/grocery-list")
	public String getAllSelectedStoreItems(Model model) {
		Double listTotal = 0D;
		for (LineItem lineItem : lineItemRepo.findAll()) {
			listTotal += lineItem.getTotalPrice();
		}
		String formattedTotal = new DecimalFormat("#.00").format(listTotal);
		model.addAttribute("totalGroceryPrice", formattedTotal);
		model.addAttribute("groceryListLineItems", lineItemRepo.findAll());
		return "grocery-list";
	}

	// This is a utility mapping in case we want to remove all of the
	// selected ingredients. They are in the database once the user
	// starts a session, until they basically start the controller over again.
	@RequestMapping("/reset")
	public String removeSelectedIngredients() {
		SelectedIngredientsList selIngList = selectedIngredientsListRepo.findOne(1L);
		selIngList.removeAllIngredients();
		lineItemRepo.deleteAll();
		return "redirect:/recipes";
	}

	// this is a utility mapping used during development to show all
	// of the tags in the system
	@RequestMapping("/tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	// this is a utility mapping used during development to show all
	// of the store items for a particular tag in the system
	@RequestMapping("/tagStoreItems")
	public String getStoreItemsForTag(@RequestParam Long id, Model model) {
		Tag searchTag = tagRepo.findOne(id);
		model.addAttribute("storeItems", storeItemRepo.findByTag(searchTag));
		return "tag-with-assoc-store-items";
	}

	// important ref for form stuff
	// https://stackoverflow.com/questions/44415339/bind-list-or-array-to-form-in-thymleaf

	// The mappings below are for testing purposes
	// The test-select-store-items url shows all store items in the system
	// IF IF IF you uncomment the mwzig line in the populator to put every
	// Store item we have into selected items
	// You can then go directly to this page to select store items
	// When you click submit, it will then do a POST to /testshowselectedstoreitems
	// That logic creates line items then re-routes to the grocery-list page to
	// show the grocery items selected and total cost.

	@GetMapping("/test-select-store-items")
	public String testSelectStoreItems(Model model) {
		model.addAttribute("storeItems", storeItemRepo.findAll());
		model.addAttribute("productSelections", new ProductSelections());
		return "test-select-store-items";
	}

	@PostMapping("/test-show-selected-store-items")
	public String testShowSelectedStoreItems(@ModelAttribute ProductSelections productSelections) {
		System.out.println("List: " + productSelections.getIds());
		System.out.println("List: " + productSelections.getQtys());

		StoreItem selectedStoreItem;
		LineItem groceryListLineItem;
		String id, qty;

		for (int i = 0; i < productSelections.getIds().size(); i++) {
			id = productSelections.getIds().get(i);
			qty = productSelections.getQtys().get(i);
			if (id != null) {
				Long longId = Long.valueOf(id);
				selectedStoreItem = storeItemRepo.findOne(longId);
				Integer intQty = Integer.valueOf(qty);
				groceryListLineItem = new LineItem(intQty, selectedStoreItem);
				lineItemRepo.save(groceryListLineItem);
			}
		}
		return "redirect:/grocery-list";
	}

} // to close Controller class
