package groceryapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
