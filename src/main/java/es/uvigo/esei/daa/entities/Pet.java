package es.uvigo.esei.daa.entities;

import static java.util.Objects.requireNonNull;

/**
 * An entity that represents a pet.
 * 
 * @author Fernando Rodriguez Alvarez
 */
public class Pet {
	private int id;
	private int person_id;
	private String name;
	private String species;
	
	// Constructor needed for the JSON conversion
	Pet() {}
	
	/**
	 * Constructs a new instance of {@link pet}.
	 *
	 * @param id identifier of the pet.
	 * @param id identifier of the pets owner.
	 * @param name name of the pet.
	 * @param species species of the pet.
	 */
	public Pet(int id, int person_id, String name, String species) {
		this.id = id;
		this.setPersonId(person_id);
		this.setName(name);
		this.setSpecies(species);
	}
	
	/**
	 * Returns the identifier of the pet.
	 * 
	 * @return the identifier of the pet.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Returns the identifier of the person.
	 * 
	 * @return the identifier of the person.
	 */
	public int getPersonId() {
		return person_id;
	}
	
	/**
	 * Set the name of this person.
	 * 
	 * @param name the new name of the person.
	 * @throws NullPointerException if the {@code name} is {@code null}.
	 */
	public void setPersonId(int person_id) {
		this.person_id = requireNonNull(person_id, "Owner id can't be null");
	}

	/**
	 * Returns the name of the owner.
	 * 
	 * @return the name of the owner.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of this person.
	 * 
	 * @param name the new name of the person.
	 * @throws NullPointerException if the {@code name} is {@code null}.
	 */
	public void setName(String name) {
		this.name = requireNonNull(name, "Name can't be null");
	}

	/**
	 * Returns the species.
	 * 
	 * @return the species.
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * Set the species.
	 * 
	 * @param species the species of the pet.
	 * @throws NullPointerException if the {@code species} is {@code null}.
	 */
	public void setSpecies(String species) {
		this.species = requireNonNull(species, "Species can't be null");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pet))
			return false;
		Pet other = (Pet) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
