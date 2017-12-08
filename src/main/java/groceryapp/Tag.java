package groceryapp;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tag implements Comparable<Tag> {

	@Id
	@GeneratedValue
	private Long id;
	private String tag;

	@OneToMany(mappedBy = "tag")
	private Set<Ingredient> ingredients;

	@OneToMany(mappedBy = "tag")
	private Set<StoreItem> storeItems;

	protected Tag() {

	}

	public Tag(Long id, String tag) {
		this.id = id;
		this.tag = tag;
	}

	public Tag(String tag) {
		this.tag = tag;
	}

	public Tag(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public Set<StoreItem> getStoreItems() {
		return storeItems;
	}

	@Override
	public int compareTo(Tag other) {
		return tag.compareTo(other.tag);
	}

}
