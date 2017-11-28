package groceryapp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String storeItem;
	private String quantity;
	private double price;

	@OneToMany(mappedBy = "storeItemList")
	private Set<StoreItem> storeItems;

	@ManyToOne
	ShoppingList shoppingLists;

	protected LineItem() {

	}

	public LineItem(Long id, String storeItem, String quantity, double price, ShoppingList shoppingLists,
			Set<StoreItem> storeItems) {
		this.id = id;
		this.storeItem = storeItem;
		this.quantity = quantity;
		this.price = price;
		this.shoppingLists = shoppingLists;
		this.storeItems = storeItems;
	}

	public Long getId() {
		return id;
	}

	public String getStoreItem() {
		return storeItem;
	}

	public String getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public Set<StoreItem> getStoreItems() {
		return storeItems;
	}

}
