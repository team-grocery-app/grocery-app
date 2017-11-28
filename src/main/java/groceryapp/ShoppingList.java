package groceryapp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ShoppingList {

	@Id
	@GeneratedValue
	private Long id;

	private LineItem lineItems;

	protected ShoppingList() {

	}

	public ShoppingList(Long id, LineItem lineItems) {
		super();
		this.id = id;
		this.lineItems = lineItems;
	}

	public Long getId() {
		return id;
	}

	public LineItem getLineItems() {
		return lineItems;
	}

}
