package groceryapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class StoreItem {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double price;
	@Lob
	private String description;
	private String uriItemId;
	private String size;
	private String brand;
	private String upc;
	private String imgUrlSm;
	private String imgUrlMed;
	private String imgUrlLg;

	@OneToOne
	private LineItem lineItem;

	@ManyToOne
	private Tag tag;

	protected StoreItem() {

	}

	public StoreItem(String name, double price, Tag tag) {
		this.name = name;
		this.price = price;
		this.tag = tag;
	}

	// no tag constructor to be superseded
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

	public String getDescription() {
		return description;
	}

	public String getUriItemId() {
		return uriItemId;
	}

	public String getSize() {
		return size;
	}

	public String getBrand() {
		return brand;
	}

	public String getUpc() {
		return upc;
	}

	public String getImgUrlSm() {
		return imgUrlSm;
	}

	public String getImgUrlMed() {
		return imgUrlMed;
	}

	public String getImgUrlLg() {
		return imgUrlLg;
	}

	public LineItem getLineItem() {
		return lineItem;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUriItemId(String uriItemId) {
		this.uriItemId = uriItemId;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public void setImgUrlSm(String imgUrlSm) {
		this.imgUrlSm = imgUrlSm;
	}

	public void setImgUrlMed(String imgUrlMed) {
		this.imgUrlMed = imgUrlMed;
	}

	public void setImgUrlLg(String imgUrlLg) {
		this.imgUrlLg = imgUrlLg;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
