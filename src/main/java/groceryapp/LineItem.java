package groceryapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LineItem {

	@Id
	@GeneratedValue
	private Long id;
	private int quantity;
	private double totalPrice;

	@OneToOne
	private StoreItem storeItem;

	protected LineItem() {
	}

	public LineItem(int quantity, StoreItem storeItem) {
		this.storeItem = storeItem;
		this.quantity = quantity;
		this.totalPrice = quantity * storeItem.getPrice();
	}

	public Long getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public StoreItem getStoreItem() {
		return storeItem;
	}

}
