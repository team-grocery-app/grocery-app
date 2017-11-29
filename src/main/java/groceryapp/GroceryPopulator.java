package groceryapp;

import javax.annotation.Resource;

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
	
	

	@Override
	public void run(String... args) throws Exception {
		
		
		
	
		
		StoreItem storeItem1 = new StoreItem("Fettuccine",1.99);
		storeItemRepo.save(storeItem1);
//		StoreItem storeItem2 = new StoreItem("Broccoli",.99);
//		storeItemRepo.save(storeItem2);
//		StoreItem storeItem3 = new StoreItem("Garlic Powder",2.50);
//		storeItemRepo.save(storeItem3);
//		StoreItem storeItem4  = new StoreItem("Pasta",1.99);
//		storeItemRepo.save(storeItem4);
//		StoreItem storeItem5  = new StoreItem("Butter",1.99);
//		storeItemRepo.save(storeItem5);
//		StoreItem storeItem6  = new StoreItem("Garlic",1.99);
//		storeItemRepo.save(storeItem6);
//		StoreItem storeItem7  = new StoreItem("Black Pepper",1.99);
//		storeItemRepo.save(storeItem7);
//		StoreItem storeItem8  = new StoreItem("All Purpsoe Flour",1.99);
//		storeItemRepo.save(storeItem8);
//		StoreItem storeItem9  = new StoreItem("Heavy Cream",1.99);
//		storeItemRepo.save(storeItem9);
//		StoreItem storeItem10  = new StoreItem("Onion",1.99);
//		storeItemRepo.save(storeItem10);
//		StoreItem storeItem11  = new StoreItem("Salt",1.99);
//		storeItemRepo.save(storeItem11);
//		StoreItem storeItem12  = new StoreItem("Parmesan Cheese",1.99);
//		storeItemRepo.save(storeItem12);
//		StoreItem storeItem13  = new StoreItem("Milk",1.99);
//		storeItemRepo.save(storeItem13);
//		StoreItem storeItem14  = new StoreItem("Chicken Broth",1.99);
//		storeItemRepo.save(storeItem14);
//		StoreItem storeItem15  = new StoreItem("",1.99);
//		storeItemRepo.save(storeItem15);
//		StoreItem storeItem16  = new StoreItem("",1.99);
//		storeItemRepo.save(storeItem16);
//		
//		
//		
//		
		LineItem lineItem1 = new LineItem(1,storeItem1);
		lineItemRepo.save(lineItem1);
//		LineItem lineItem2 = new LineItem(1, storeItem2);
//		lineItemRepo.save(lineItem2);
//		LineItem lineItem3 = new LineItem(1, storeItem3);
//		lineItemRepo.save(lineItem3);
//		LineItem lineItem4 = new LineItem(1, storeItem4);
//		lineItemRepo.save(lineItem4);
//		LineItem lineItem5 = new LineItem(1, storeItem5);
//		lineItemRepo.save(lineItem5);
//		LineItem lineItem6 = new LineItem(1, storeItem6);
//		lineItemRepo.save(lineItem6);
//		LineItem lineItem7 = new LineItem();
//		lineItemRepo.save(lineItem7);
//		LineItem lineItem8 = new LineItem();
//		lineItemRepo.save(lineItem8);
//		LineItem lineItem9 = new LineItem();
//		lineItemRepo.save(lineItem9);
//		LineItem lineItem10 = new LineItem();
//		lineItemRepo.save(lineItem10);
		
		
		
		
		
		
		Ingredient fettuccine = new Ingredient("Fettucine","");
		ingredientRepo.save(fettuccine);
		Ingredient broccoli = new Ingredient("Fresh chopped broccoli","1 to 2 cups");
		ingredientRepo.save(broccoli);
		Ingredient butter = new Ingredient("Butter","1/2 cup(1 stick)");
		ingredientRepo.save(butter);
		Ingredient butter2 = new Ingredient("Butter","1/3 cup");
		ingredientRepo.save(butter2);
		Ingredient garlic = new Ingredient("Garlic","1/2 tsp(1 clove)");
		ingredientRepo.save(garlic);
		Ingredient heavyCream = new Ingredient("Heavy Cream","2 cups");
		ingredientRepo.save(heavyCream);
		Ingredient garlicPowder = new Ingredient("Garlic Powder","1/8 tsp");
		ingredientRepo.save(garlicPowder);
		Ingredient blackPepper = new Ingredient("Black Pepper","1/8 tsp");
		ingredientRepo.save(blackPepper);
		Ingredient blackPepper2 = new Ingredient("Black Pepper","1/4 tsp");
		ingredientRepo.save(blackPepper2);
		Ingredient parmesanCheese = new Ingredient("Parmesan Cheese","1/4 cup freshly grated");
		ingredientRepo.save(parmesanCheese);
		Ingredient chickenBreasts = new Ingredient("Chicken Breasts","2 to 3 cooked/diced");
		ingredientRepo.save(chickenBreasts);
		Ingredient flour = new Ingredient("All Purpose flour","1/3 cup");
		ingredientRepo.save(flour);
		Ingredient milk = new Ingredient("Milk","2/3 cup");
		ingredientRepo.save(milk);
		Ingredient chickenBroth = new Ingredient("Chicken Broth","1 3/4 cups");
		ingredientRepo.save(chickenBroth);
		Ingredient onion = new Ingredient("Chopped onion","1/3 cup");
		ingredientRepo.save(onion);
		Ingredient salt = new Ingredient("Salt","1/2 tsp");
		ingredientRepo.save(salt);
		Ingredient frozenVeggies = new Ingredient("Frozen peas and carrots","1 box(10 oz)");
		ingredientRepo.save(frozenVeggies);
		Ingredient pieCrust = new Ingredient("Refrigerated Pie Crust","1 package(15 oz) softened as directed on box");
		ingredientRepo.save(pieCrust);
		
		Recipe recipe1 = new Recipe("Chicken Broccoli Alfredo","/images/chicken-broccoli-alfredo.jpg","1\r\n" + 
				"Cook fettuccine according to package directions adding broccoli last 3 minutes, drain. Set aside.\r\n" + 
				"2\r\n" + 
				"Meanwhile, melt butter in medium saucepan over medium heat. Add minced garlic with the butter. Add cream, garlic powder, and pepper.\r\n" + 
				"3\r\n" + 
				"Simmer, uncovered, for 10 to 12 minutes or until thick, stirring frequently. Trust me, it will thicken. When sauce has reached desired consistency, stir in Parmesan cheese.\r\n" + 
				"4\r\n" + 
				"Add cooked chicken to Alfredo sauce and heat through. Serve over hot, cooked fettuccine and broccoli.",fettuccine,broccoli, butter, garlic, heavyCream, garlicPowder, blackPepper, parmesanCheese, chickenBreasts);
		recipeRepo.save(recipe1);
		Recipe recipe2 = new Recipe("Classic Chicken Pot Pie","classic-chicken-pot-pie.jpg","1\r\n" + 
				"In 2-quart saucepan, melt butter over medium heat. Stir in flour, onion, salt and pepper. Cook, stirring constantly, until mixture is bubbly; remove from heat. Stir in broth and milk. Heat to boiling, stirring constantly. Boil and stir 1 minute. Stir in chicken and peas and carrots; remove from heat.\r\n" + 
				"2\r\n" + 
				"Heat oven to 425°F. Roll 1 pie crust into 13-inch square. Ease into ungreased 9-inch (2-quart) glass baking dish. Pour chicken mixture into crust-lined dish.\r\n" + 
				"3\r\n" + 
				"Roll remaining pie crust into 11-inch square. Cut out designs with 1-inch cookie cutter. Place square over chicken mixture. Arrange cutouts on top crust. Turn edges of pie crust under; flute edge.\r\n" + 
				"4\r\n" + 
				"Bake about 35 minutes or until golden brown.",butter2, blackPepper2, flour,milk, chickenBroth, onion, salt, frozenVeggies, pieCrust);
		recipeRepo.save(recipe2);
		
//		Recipe recipe1 = new Recipe ("Simple Recipe","","",fettuccine);
//		recipeRepo.save(recipe1);
		


				
	}

}
