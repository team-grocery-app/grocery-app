package groceryapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class StoreItem {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double price;

	@OneToOne
	private LineItem lineItem;

	@ManyToOne
	private Tag tag;

	protected StoreItem() {

	}

	public StoreItem(String name, double price) {
		this.name = name;
		this.price = price;

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public Tag getTag() {
		return tag;
	}

}
