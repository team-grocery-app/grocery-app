package groceryapp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "lineItemsList")
	private Set<LineItem> lineItems;

	public ShoppingList() {
	}

	public Long getId() {
		return id;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

}
