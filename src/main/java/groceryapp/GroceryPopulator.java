package groceryapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GroceryPopulator implements CommandLineRunner {
	@Resource
	private RecipeRepository recipeRepo;

	@Resource
	private IngredientRepository ingredientRepo;

	@Resource
	private StoreItemRepository storeItemRepo;

	@Resource
	private LineItemRepository lineItemRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private SelectedIngredientsListRepository selectedIngredientsListRepo;

	@Override
	public void run(String... args) throws Exception {

		SelectedIngredientsList selectedIngredientsList = new SelectedIngredientsList();
		selectedIngredientsListRepo.save(selectedIngredientsList);

		Tag tag1fettuccine = new Tag(1L, "fettuccine");
		tagRepo.save(tag1fettuccine);

		Tag tag2broccoli = new Tag(2L, "broccoli");
		tagRepo.save(tag2broccoli);

		Tag tag3butter = new Tag(3L, "butter");
		tagRepo.save(tag3butter);

		Tag tag4mincedGarlic = new Tag(4L, "minced garlic");
		tagRepo.save(tag4mincedGarlic);

		Tag tag5garlicPowder = new Tag(5L, "garlic powder");
		tagRepo.save(tag5garlicPowder);

		Tag tag6pepper = new Tag(6L, "pepper");
		tagRepo.save(tag6pepper);

		Tag tag7salt = new Tag(7L, "salt");
		tagRepo.save(tag7salt);

		Tag tag8heavyCream = new Tag(8L, "heavy cream");
		tagRepo.save(tag8heavyCream);

		Tag tag9parmesanCheese = new Tag(9L, "parmesan cheese");
		tagRepo.save(tag9parmesanCheese);

		Tag tag10chicken = new Tag(10L, "chicken");
		tagRepo.save(tag10chicken);

		Tag tag11flour = new Tag(11L, "flour");
		tagRepo.save(tag11flour);

		Tag tag12onions = new Tag(12L, "onions");
		tagRepo.save(tag12onions);

		Tag tag13chickenBroth = new Tag(13L, "chicken broth");
		tagRepo.save(tag13chickenBroth);

		Tag tag14milk = new Tag(14L, "milk");
		tagRepo.save(tag14milk);

		Tag tag15frozenPeasAndCarrots = new Tag(15L, "frozen peas & carrots");
		tagRepo.save(tag15frozenPeasAndCarrots);

		Tag tag16refrigeratedPieCrust = new Tag(16L, "refrigerated pie crust");
		tagRepo.save(tag16refrigeratedPieCrust);

		Tag tag17eggNoodles = new Tag(17L, "egg noodles");
		tagRepo.save(tag17eggNoodles);
		Tag tag18tuna = new Tag(18L, "tuna");
		tagRepo.save(tag18tuna);
		Tag tag19mushroomSoup = new Tag(19L, "cream of mushroom soup");
		tagRepo.save(tag19mushroomSoup);
		Tag tag20cheddarCheese = new Tag(20L, "shredded cheddar cheese");
		tagRepo.save(tag20cheddarCheese);
		Tag tag21frozenGreenPeas = new Tag(21L, "frozen green peas");
		tagRepo.save(tag21frozenGreenPeas);
		Tag tag22chips = new Tag(22L, "potato chips");
		tagRepo.save(tag22chips);
		Tag tag23mushrooms = new Tag(23L, "sliced mushrooms");
		tagRepo.save(tag23mushrooms);

		Tag tag24pastaSauce = new Tag(24L, "pasta Sauce");
		tagRepo.save(tag24pastaSauce);
		Tag tag25zucchini = new Tag(25L, "zucchini");
		tagRepo.save(tag25zucchini);
		Tag tag26 = new Tag(26L, "cottage Cheese");
		tagRepo.save(tag26);
		Tag tag27 = new Tag(27L, "frozen Spinach");
		tagRepo.save(tag27);
		Tag tag28 = new Tag(28L, "oregano");
		tagRepo.save(tag28);
		Tag tag29 = new Tag(29L, "lasagna Noodles");
		tagRepo.save(tag29);

		Tag tag30mozzarellaCheese = new Tag(30L, "mozzarella Cheese");
		tagRepo.save(tag30mozzarellaCheese);
		Tag tag31 = new Tag(31L, "chipotle pepper powder");
		tagRepo.save(tag31);
		Tag tag32 = new Tag(32L, "salmon fillet");
		tagRepo.save(tag32);
		Tag tag33 = new Tag(33L, "pecans");
		tagRepo.save(tag33);
		Tag tag34 = new Tag(34L, "onion powder");
		tagRepo.save(tag34);
		Tag tag35 = new Tag(35L, "maple syrup");
		tagRepo.save(tag35);
		Tag tag36 = new Tag(36L, "smoked paprika");
		tagRepo.save(tag36);
		Tag tag37 = new Tag(37L, "apple cider vinegar");
		tagRepo.save(tag37);

		// populateStoreItemsAndLineItems();
		populateStoreItemsFromJSONInput();

		Recipe recipe1 = new Recipe("Chicken Broccoli Alfredo", "/images/chicken-broccoli-alfredo.jpg", "1. "
				+ "Cook fettuccine according to package directions adding broccoli last 3 minutes, drain. Set aside.<br/>"
				+ "2. "
				+ "Meanwhile, melt butter in medium saucepan over medium heat. Add minced garlic with the butter. Add cream, garlic powder, and pepper.<br/>"
				+ "3. "
				+ "Simmer, uncovered, for 10 to 12 minutes or until thick, stirring frequently. Trust me, it will thicken. When sauce has reached desired consistency, stir in Parmesan cheese.<br/>"
				+ "4. "
				+ "Add cooked chicken to Alfredo sauce and heat through. Serve over hot, cooked fettuccine and broccoli.\n\n");
		recipeRepo.save(recipe1);

		Recipe recipe2 = new Recipe("Classic Chicken Pot Pie", "/images/classic-chicken-pot-pie.jpg", "1. "
				+ "In 2-quart saucepan, melt butter over medium heat. Stir in flour, onion, salt and pepper. Cook, stirring constantly, until mixture is bubbly; remove from heat. Stir in broth and milk. Heat to boiling, stirring constantly. Boil and stir 1 minute. Stir in chicken and peas and carrots; remove from heat.<br/>"
				+ "2. "
				+ "Heat oven to 425Â°F. Roll 1 pie crust into 13-inch square. Ease into ungreased 9-inch (2-quart) glass baking dish. Pour chicken mixture into crust-lined dish.<br/>"
				+ "3. "
				+ "Roll remaining pie crust into 11-inch square. Cut out designs with 1-inch cookie cutter. Place square over chicken mixture. Arrange cutouts on top crust. Turn edges of pie crust under; flute edge.<br/>"
				+ "4. " + "Bake about 35 minutes or until golden brown.\n\n");
		recipeRepo.save(recipe2);

		Recipe recipe3 = new Recipe("Best Tuna Casserole", "/images/tuna-casserole.jpg", "1. "
				+ "Bring a large pot of lightly salted water to a boil. Cook pasta in boiling water for 8 to 10 minutes, or until al dente; drain.<br/>"
				+ "2. " + "Preheat oven to 425°F (220° C).<br/>" + "3. "
				+ "In a large bowl, thoroughly mix noodles, onion, 1 cup cheese, peas, tuna, soup and mushrooms. Transfer to a 9x13 inch baking dish, and top with potato chip crumbs and remaining 1 cup cheese. Parmesan cheese.<br/>"
				+ "4. " + "Bake for 15 to 20 minutes in the preheated oven, or until cheese is bubbly.");
		recipeRepo.save(recipe3);

		Recipe recipe4 = new Recipe("Vegetarian Lasagna", "images/veggie-lasagna.jpg",
				"1. Spray 12x10-inch sheet of foil with nonstick cooking spray. In medium bowl, combine pasta sauce and zucchini; mix well. In another medium bowl, combine cottage cheese, spinach, Parmesan cheese and oregano; Mix well.<br/>"
						+ "2. Spread 1/4 cup sauce mixture in ungreased 8-inch square (2-quart) glass baking dish. Top with 2 lasagna noodles. Spread about 1/2 cup sauce mixture over noodles. Drop 1/2 cup of spinach mixture by small spoonfuls over sauce mixture; spread carefully. Sprinkle with 1/4 of mushrooms and 1/2 cup of the mozzarella cheese.<br/>"
						+ "3. Repeat layers 3 more times, beginning with noodles. Cover with foil, sprayed side down; refrigerate at least 8 hours or overnight.<br/>"
						+ "4. Heat oven to 400°F. Bake covered for 45 minutes.<br/>"
						+ "5. Uncover baking dish; bake an additional 10 minutes or until lasagna is bubbly around edges. Let stand 10 minutes before serving.");
		recipeRepo.save(recipe4);

		Recipe recipe5 = new Recipe("Paleo Pecan Maple Syrup Salmon", "/images/salmon.jpg", "1. "
				+ "Place salmon fillets on a baking sheet and season with salt and black pepper.<br/>" + "2. "
				+ "Combine pecans, maple syrup, vinegar, paprika, chipotle powder, and onion powder in a food processor; pulse until texture is crumbly. Spoon pecan mixture on top of each salmon fillet, coating the entire top surface. Refrigerate coated salmon, uncovered, for 2 to 3 hours.<br/>"
				+ "3. " + "Preheat oven to 425°F (220°C).<br/>" + "4. "
				+ "Bake salmon in the preheated oven until fish flakes easily with a fork, 12 to 14 minutes.");
		recipeRepo.save(recipe5);

		Ingredient fettuccine = new Ingredient("Fettucine", "16 oz", tag1fettuccine, recipe1);
		ingredientRepo.save(fettuccine);
		Ingredient broccoli = new Ingredient("Fresh chopped broccoli", "1 to 2 cups", tag2broccoli, recipe1);
		ingredientRepo.save(broccoli);
		Ingredient butter = new Ingredient("Butter", "1/2 cup (1 stick)", tag3butter, recipe1);
		ingredientRepo.save(butter);
		Ingredient garlic = new Ingredient("Garlic", "1/2 tsp (1 clove)", tag4mincedGarlic, recipe1);
		ingredientRepo.save(garlic);
		Ingredient heavyCream = new Ingredient("Heavy Cream", "2 cups", tag8heavyCream, recipe1);
		ingredientRepo.save(heavyCream);
		Ingredient garlicPowder = new Ingredient("Garlic Powder", "1/8 tsp", tag5garlicPowder, recipe1);
		ingredientRepo.save(garlicPowder);
		Ingredient blackPepper = new Ingredient("Black Pepper", "1/8 tsp", tag6pepper, recipe1);
		ingredientRepo.save(blackPepper);
		Ingredient parmesanCheese = new Ingredient("Parmesan Cheese", "1/4 cup freshly grated", tag9parmesanCheese,
				recipe1);
		ingredientRepo.save(parmesanCheese);
		Ingredient chickenBreasts = new Ingredient("Chicken Breasts", "2 to 3 cooked/diced", tag10chicken, recipe1);
		ingredientRepo.save(chickenBreasts);

		Ingredient butter2 = new Ingredient("Butter", "1/3 cup", tag3butter, recipe2);
		ingredientRepo.save(butter2);
		Ingredient blackPepper2 = new Ingredient("Black Pepper", "1/4 tsp", tag6pepper, recipe2);
		ingredientRepo.save(blackPepper2);

		Ingredient chicken = new Ingredient("Chicken", "2 1/2 to 3 cups cut-up cooked chicken or turkey", tag10chicken,
				recipe2);
		ingredientRepo.save(chicken);
		Ingredient flour = new Ingredient("All Purpose flour", "1/3 cup", tag11flour, recipe2);
		ingredientRepo.save(flour);
		Ingredient milk = new Ingredient("Milk", "2/3 cup", tag14milk, recipe2);
		ingredientRepo.save(milk);
		Ingredient chickenBroth = new Ingredient("Chicken Broth", "1 3/4 cups", tag13chickenBroth, recipe2);
		ingredientRepo.save(chickenBroth);
		Ingredient onion = new Ingredient("Chopped onion", "1/3 cup", tag12onions, recipe2);
		ingredientRepo.save(onion);
		Ingredient salt = new Ingredient("Salt", "1/2 tsp", tag7salt, recipe2);
		ingredientRepo.save(salt);
		Ingredient frozenVeggies = new Ingredient("Frozen peas and carrots", "1 box (10 oz)", tag15frozenPeasAndCarrots,
				recipe2);
		ingredientRepo.save(frozenVeggies);
		Ingredient pieCrust = new Ingredient("Refrigerated Pie Crust", "1 package (15 oz) softened as directed on box",
				tag16refrigeratedPieCrust, recipe2);
		ingredientRepo.save(pieCrust);

		Ingredient pastaSauce = new Ingredient("Pasta Sauce", "2 cups", tag24pastaSauce, recipe3);
		ingredientRepo.save(pastaSauce);
		Ingredient zucchini = new Ingredient("Zucchini - shredded", "1 cup", tag25zucchini, recipe3);
		ingredientRepo.save(zucchini);
		Ingredient cottageCheese = new Ingredient("Low-Fat Cottage Cheese", "1 1/2 cup", tag26, recipe3);
		ingredientRepo.save(cottageCheese);
		Ingredient frozenSpinach = new Ingredient("Frozen Spinach", "9 oz.", tag27, recipe3);
		ingredientRepo.save(frozenSpinach);
		Ingredient parmessanCheese = new Ingredient("Parmessan Cheese - grated", "1/3 cup", tag9parmesanCheese,
				recipe3);
		ingredientRepo.save(parmessanCheese);
		Ingredient oregano = new Ingredient("Oregano - chopped", "2 tbsp", tag28, recipe3);
		ingredientRepo.save(oregano);
		Ingredient lasagnaNoodles = new Ingredient("Lasagna Noodles - oven ready", "8 (7x3 inches)", tag29, recipe3);
		ingredientRepo.save(lasagnaNoodles);
		Ingredient mushrooms = new Ingredient("Mushrooms", "1 (4oz.) can", tag23mushrooms, recipe3);
		ingredientRepo.save(mushrooms);
		Ingredient mozzarellaCheese = new Ingredient("Mozzarella Cheese - shredded", "8oz. (2 Cups)",
				tag30mozzarellaCheese, recipe3);
		ingredientRepo.save(mozzarellaCheese);

		Ingredient eggNoodles = new Ingredient("Egg noodles", "1 (12 ounce) package", tag17eggNoodles, recipe4);
		ingredientRepo.save(eggNoodles);
		Ingredient tuna = new Ingredient("Tuna", "2 (5 ounce) cans tuna, drained", tag18tuna, recipe4);
		ingredientRepo.save(tuna);
		Ingredient onion2 = new Ingredient("Chopped onion", "1/4 cup", tag12onions, recipe4);
		ingredientRepo.save(onion2);
		Ingredient mushroomSoup = new Ingredient("Condensed cream of mushroom soup", "2 (10.75 ounce) cans",
				tag19mushroomSoup, recipe4);
		ingredientRepo.save(mushroomSoup);
		Ingredient cheddarCheese = new Ingredient("Shredded cheddar cheese", "2 cups", tag20cheddarCheese, recipe4);
		ingredientRepo.save(cheddarCheese);
		Ingredient mushrooms2 = new Ingredient("Sliced mushrooms", "1/2 (4.5 ounce) can", tag23mushrooms, recipe4);
		ingredientRepo.save(mushrooms2);
		Ingredient greenPeas = new Ingredient("Frozen green peas", "1 cup", tag21frozenGreenPeas, recipe4);
		ingredientRepo.save(greenPeas);
		Ingredient potatoChips = new Ingredient("Crushed potato chips", "1 cup", tag22chips, recipe4);
		ingredientRepo.save(potatoChips);

		Ingredient chipotlePowder = new Ingredient("Chipotle pepper powder", "1/2 tsp", tag31, recipe5);
		ingredientRepo.save(chipotlePowder);
		Ingredient salmon = new Ingredient("Salmon fillets", "4 (4 ounce)", tag32, recipe5);
		ingredientRepo.save(salmon);
		Ingredient pecans = new Ingredient("Pecans", "1/2 cup", tag33, recipe5);
		ingredientRepo.save(pecans);
		Ingredient onionPowder = new Ingredient("Onion powder", "1/2 tsp", tag34, recipe5);
		ingredientRepo.save(onionPowder);
		Ingredient mapleSyrup = new Ingredient("Pure maple syrup", "3 tbsp", tag35, recipe5);
		ingredientRepo.save(mapleSyrup);
		Ingredient paprika = new Ingredient("Smoked paprika", "1 tsp", tag36, recipe5);
		ingredientRepo.save(paprika);
		Ingredient acv = new Ingredient("Apple cider vinegar", "1 tbsp", tag37, recipe5);
		ingredientRepo.save(acv);
		Ingredient salt2 = new Ingredient("Salt", "to taste", tag7salt, recipe5);
		ingredientRepo.save(salt2);
		Ingredient blackPepper3 = new Ingredient("Pepper", "to taste", tag6pepper, recipe5);
		ingredientRepo.save(blackPepper3);

	}

	// This is an old method we used before populating data from walmart
	// We don't use it anymore, but it is here in case we need to populate things
	// directly sometime in
	// the future.
	/*
	 * public void populateStoreItemsAndLineItems() {
	 * 
	 * StoreItem storeItem1 = new StoreItem("Fettuccine", 1.99);
	 * storeItemRepo.save(storeItem1); StoreItem storeItem2 = new
	 * StoreItem("Fresh chopped broccoli", .99); storeItemRepo.save(storeItem2);
	 * StoreItem storeItem3 = new StoreItem("Garlic Powder", 2.50);
	 * storeItemRepo.save(storeItem3); StoreItem storeItem4 = new
	 * StoreItem("Butter", 1.99); storeItemRepo.save(storeItem4); StoreItem
	 * storeItem5 = new StoreItem("Butter", 1.99); storeItemRepo.save(storeItem5);
	 * StoreItem storeItem6 = new StoreItem("Garlic", 1.99);
	 * storeItemRepo.save(storeItem6); StoreItem storeItem7 = new
	 * StoreItem("Black Pepper", 1.99); storeItemRepo.save(storeItem7); StoreItem
	 * storeItem8 = new StoreItem("All Purpsoe Flour", 1.99);
	 * storeItemRepo.save(storeItem8); StoreItem storeItem9 = new
	 * StoreItem("Heavy Cream", 1.99); storeItemRepo.save(storeItem9); StoreItem
	 * storeItem10 = new StoreItem("Chopped onion", 2.00);
	 * storeItemRepo.save(storeItem10); StoreItem storeItem11 = new
	 * StoreItem("Salt", 1.99); storeItemRepo.save(storeItem11); StoreItem
	 * storeItem12 = new StoreItem("Parmesan Cheese", 1.99);
	 * storeItemRepo.save(storeItem12); StoreItem storeItem13 = new
	 * StoreItem("Milk", 1.99); storeItemRepo.save(storeItem13); StoreItem
	 * storeItem14 = new StoreItem("Chicken Broth", 1.99);
	 * storeItemRepo.save(storeItem14); StoreItem storeItem15 = new
	 * StoreItem("Black Pepper", 1.99); storeItemRepo.save(storeItem15); StoreItem
	 * storeItem16 = new StoreItem("Chicken breasts", 1.99);
	 * storeItemRepo.save(storeItem16); StoreItem storeItem17 = new
	 * StoreItem("Refrigerated pie crust", 2.50); storeItemRepo.save(storeItem17);
	 * StoreItem storeItem18 = new StoreItem("Frozen peas and carrots", 1.00);
	 * storeItemRepo.save(storeItem18); StoreItem storeItem19 = new
	 * StoreItem("Chicken", 6.99); storeItemRepo.save(storeItem19);
	 * 
	 * LineItem lineItem1 = new LineItem(1, storeItem1);
	 * lineItemRepo.save(lineItem1); LineItem lineItem2 = new LineItem(1,
	 * storeItem2); lineItemRepo.save(lineItem2); LineItem lineItem3 = new
	 * LineItem(1, storeItem3); lineItemRepo.save(lineItem3); LineItem lineItem4 =
	 * new LineItem(1, storeItem4); lineItemRepo.save(lineItem4); LineItem lineItem5
	 * = new LineItem(1, storeItem5); lineItemRepo.save(lineItem5); LineItem
	 * lineItem6 = new LineItem(1, storeItem6); lineItemRepo.save(lineItem6);
	 * LineItem lineItem7 = new LineItem(1, storeItem7);
	 * lineItemRepo.save(lineItem7); LineItem lineItem8 = new LineItem(1,
	 * storeItem8); lineItemRepo.save(lineItem8); LineItem lineItem9 = new
	 * LineItem(1, storeItem9); lineItemRepo.save(lineItem9); LineItem lineItem10 =
	 * new LineItem(1, storeItem10); lineItemRepo.save(lineItem10); LineItem
	 * lineItem11 = new LineItem(1, storeItem11); lineItemRepo.save(lineItem11);
	 * LineItem lineItem12 = new LineItem(1, storeItem12);
	 * lineItemRepo.save(lineItem12); LineItem lineItem13 = new LineItem(1,
	 * storeItem13); lineItemRepo.save(lineItem13); LineItem lineItem14 = new
	 * LineItem(1, storeItem14); lineItemRepo.save(lineItem14); LineItem lineItem15
	 * = new LineItem(1, storeItem15); lineItemRepo.save(lineItem15); LineItem
	 * lineItem16 = new LineItem(1, storeItem16); lineItemRepo.save(lineItem16);
	 * LineItem lineItem17 = new LineItem(1, storeItem17);
	 * lineItemRepo.save(lineItem17); LineItem lineItem18 = new LineItem(1,
	 * storeItem18); lineItemRepo.save(lineItem18); LineItem lineItem19 = new
	 * LineItem(1, storeItem19); lineItemRepo.save(lineItem19);
	 * 
	 * }
	 */
	public void populateStoreItemsFromJSONInput() {

		JSONParser parser = new JSONParser();

		String basePath = new File("").getAbsolutePath();
		// basePath += "\\src\\main\\resources\\walmart-input-json-for-db-init";
		basePath += File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator
				+ "walmart-input-json-for-db-init";
		System.out.println(basePath);

		File folder = new File(basePath);
		File[] listOfFiles = folder.listFiles();
		// /database-test/src/main/resources/walmart-input/wmpriceitem10309187.txt
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());

				try {
					StoreItem genericItem = new StoreItem();

					// Object obj = parser.parse(new
					// FileReader("C:/Users/WeCanCodeIT/wcci/default-workspace/database-test/src/main/resources/104514668.txt"));
					String fileName = basePath + "/" + listOfFiles[i].getName();
					Object obj = parser.parse(new FileReader(fileName));
					JSONObject jsonObject = (JSONObject) obj;
					System.out.println(jsonObject);

					Long uriItemId = ((Number) jsonObject.get("itemId")).longValue();
					String item = uriItemId.toString();
					System.out.println(uriItemId);
					genericItem.setUriItemId(item);

					String tagId = (String) jsonObject.get("groceryAppTagId");
					System.out.println(tagId);
					Long jsonTagId = new Long(tagId);
					Tag jsonTag = tagRepo.findOne(jsonTagId);
					genericItem.setTag(jsonTag);

					String name = (String) jsonObject.get("name");
					System.out.println(name);
					genericItem.setName(name);

					String shortDesc = (String) jsonObject.get("shortDescription");
					System.out.println(shortDesc);
					// sometimes walmart leaves in html chars, so strip them out
					// &lt;p&gt; will be at beginning
					// &lt;/p&gt; will be at the end
					// Also, it turns out some descriptions are not there, so
					// in that case, set it to an empty string in the db

					if (jsonObject.containsKey("shortDescription")) {
						// found a weird case where the desc was equal to this
						if (shortDesc.contentEquals("&nbsp;")) {
							shortDesc = "";
						} else {
							if (shortDesc.charAt(0) == '&') {
								String newDesc = shortDesc.substring(9, (shortDesc.length() - 10));
								shortDesc = newDesc;
							}
						}
					}

					genericItem.setDescription(shortDesc);

					// String longDesc = (String) jsonObject.get("longDescription");
					// System.out.println(longDesc);

					String size = (String) jsonObject.get("size");
					System.out.println(size);
					genericItem.setSize(size);

					String brand = (String) jsonObject.get("brandName");
					System.out.println(brand);
					genericItem.setBrand(brand);

					String upc = (String) jsonObject.get("upc");
					System.out.println(upc);
					genericItem.setUpc(upc);

					String imgUrlSmall = (String) jsonObject.get("thumbnailImage");
					System.out.println(imgUrlSmall);
					genericItem.setImgUrlSm(imgUrlSmall);

					String imgUrlMed = (String) jsonObject.get("mediumImage");
					System.out.println(imgUrlMed);
					genericItem.setImgUrlMed(imgUrlMed);

					String imgUrlLg = (String) jsonObject.get("largeImage");
					System.out.println(imgUrlLg);
					genericItem.setImgUrlLg(imgUrlLg);

					// genericItem.setId(3L);

					try {
						if (jsonObject.containsKey("salePrice")) {
							double salePrice = ((Number) jsonObject.get("salePrice")).doubleValue();
							System.out.println(salePrice);
							genericItem.setPrice(salePrice);
						} else if (jsonObject.containsKey("msrp")) {
							double salePrice = ((Number) jsonObject.get("msrp")).doubleValue();
							System.out.println(salePrice);
							genericItem.setPrice(salePrice);
						} else if (jsonObject.containsKey("groceryAppPrice")) {
							double salePrice = ((Number) jsonObject.get("groceryAppPrice")).doubleValue();
							System.out.println(salePrice);
							genericItem.setPrice(salePrice);

						}
					} catch (Exception ex) {
						throw new IllegalStateException("Failed to execute ApplicationRunner", ex);
					}

					storeItemRepo.save(genericItem);

					// mwzig test logic populate some store items
					// here so that I can test page 5
					// LineItem lineItem = new LineItem(2, genericItem);
					// lineItemRepo.save(lineItem);

					// Saved this logic because it shows how to iterate through
					// json array of data (in case we want to loop thru an
					// array of images present)
					// JSONArray msg = (JSONArray) jsonObject.get("messages");
					// Iterator<String> iterator = msg.iterator();
					// while (iterator.hasNext()) {
					// System.out.println(iterator.next());
					// }

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}

			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}

		}

	} // run, throws exception

}
