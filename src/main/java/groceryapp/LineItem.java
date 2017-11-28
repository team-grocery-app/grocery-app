package groceryapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String storeItem;
	private String quantity;
	private double price;

	protected LineItem() {

	}

	public LineItem(Long id, String storeItem, String quantity, double price) {
		super();
		this.id = id;
		this.storeItem = storeItem;
		this.quantity = quantity;
		this.price = price;
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

}
