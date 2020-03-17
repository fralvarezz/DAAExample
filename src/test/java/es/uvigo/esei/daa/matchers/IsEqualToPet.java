package es.uvigo.esei.daa.matchers;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import es.uvigo.esei.daa.entities.Pet;

public class IsEqualToPet extends IsEqualToEntity<Pet> {
	public IsEqualToPet(Pet entity) {
		super(entity);
	}

	@Override
	protected boolean matchesSafely(Pet actual) {
		this.clearDescribeTo();
		
		if (actual == null) {
			this.addTemplatedDescription("actual", expected.toString());
			return false;
		} else {
			return checkAttribute("id", Pet::getId, actual)
				&& checkAttribute("person_id", Pet::getPersonId, actual)
				&& checkAttribute("name", Pet::getName, actual)
				&& checkAttribute("species", Pet::getSpecies, actual);
		}
	}

	/**
	 * Factory method that creates a new {@link IsEqualToEntity} matcher with
	 * the provided {@link Pet} as the expected value.
	 * 
	 * @param Pet the expected Pet.
	 * @return a new {@link IsEqualToEntity} matcher with the provided
	 * {@link Pet} as the expected value.
	 */
	@Factory
	public static IsEqualToPet equalsToPet(Pet pet) {
		return new IsEqualToPet(pet);
	}
	
	/**
	 * Factory method that returns a new {@link Matcher} that includes several
	 * {@link IsEqualToPet} matchers, each one using an {@link Pet} of the
	 * provided ones as the expected value.
	 * 
	 * @param Pets the Pets to be used as the expected values.
	 * @return a new {@link Matcher} that includes several
	 * {@link IsEqualToPet} matchers, each one using an {@link Pet} of the
	 * provided ones as the expected value.
	 * @see IsEqualToEntity#containsEntityInAnyOrder(java.util.function.Function, Object...)
	 */
	@Factory
	public static Matcher<Iterable<? extends Pet>> containsPetsInAnyOrder(Pet ... Pets) {
		return containsEntityInAnyOrder(IsEqualToPet::equalsToPet, Pets);
	}

}
