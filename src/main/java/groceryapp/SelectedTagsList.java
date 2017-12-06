package groceryapp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SelectedTagsList {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany
	private Set<Tag> tags;

	public SelectedTagsList() {

	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public void removeIngredient(Tag tag) {
		tags.remove(tag);
	}

	public Long getId() {
		return id;
	}

	public Set<Tag> getTags() {
		return tags;
	}

}
