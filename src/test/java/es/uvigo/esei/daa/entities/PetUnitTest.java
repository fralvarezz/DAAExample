package es.uvigo.esei.daa.entities;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class PetUnitTest {
	@Test
	public void testPetIntIntStringString() {
		final int id = 1;
		final int person_id = 1;
		final String name = "Pipo";
		final String species = "Perro";
		
		final Pet Pet = new Pet(id, person_id, name, species);
		
		assertThat(Pet.getId(), is(equalTo(id)));
		assertThat(Pet.getPersonId(), is(equalTo(person_id)));
		assertThat(Pet.getName(), is(equalTo(name)));
		assertThat(Pet.getSpecies(), is(equalTo(species)));
	}

	@Test(expected = NullPointerException.class)
	public void testPetIntIntStringStringNullName() {
		new Pet(1, 1, null, "Perro");
	}
	
	@Test(expected = NullPointerException.class)
	public void testPetIntIntStringStringNullSpecies() {
		new Pet(1, 1, "Pipo", null);
	}
	
	@Test
	public void testSetPersonId() {
		final int id = 1;
		final String name = "Pipo";
		final String species = "Perro";
		
		final Pet Pet = new Pet(id, 1, name, species);
		Pet.setPersonId(2);
		
		assertThat(Pet.getId(), is(equalTo(id)));
		assertThat(Pet.getPersonId(), is(equalTo(2)));
		assertThat(Pet.getName(), is(equalTo(name)));
		assertThat(Pet.getSpecies(), is(equalTo(species)));
	}


	@Test
	public void testSetName() {
		final int id = 1;
		final int person_id = 1;
		final String species = "Perro";
		
		final Pet Pet = new Pet(id, person_id, "Pipo", species);
		Pet.setName("Pepe");
		
		assertThat(Pet.getId(), is(equalTo(id)));
		assertThat(Pet.getPersonId(), is(equalTo(person_id)));
		assertThat(Pet.getName(), is(equalTo("Pepe")));
		assertThat(Pet.getSpecies(), is(equalTo(species)));
	}

	@Test(expected = NullPointerException.class)
	public void testSetNullName() {
		final Pet Pet = new Pet(1, 1, "Pipo", "Perro");
		
		Pet.setName(null);
	}

	@Test
	public void testSetSpecies() {
		final int id = 1;
		final int person_id = 1;
		final String name = "John";
		
		final Pet Pet = new Pet(id, person_id, name, "Perro");
		Pet.setSpecies("Gato");
		
		assertThat(Pet.getId(), is(equalTo(id)));
		assertThat(Pet.getPersonId(), is(equalTo(person_id)));
		assertThat(Pet.getName(), is(equalTo(name)));
		assertThat(Pet.getSpecies(), is(equalTo("Gato")));
	}

	@Test(expected = NullPointerException.class)
	public void testSetNullSpecies() {
		final Pet Pet = new Pet(1, 1, "John", "Gato");
		
		Pet.setSpecies(null);
	}

	@Test
	public void testEqualsObject() {
		final Pet PetA = new Pet(1, 1, "Name A", "Species A");
		final Pet PetB = new Pet(1, 1, "Name B", "Species B");
		
		assertTrue(PetA.equals(PetB));
	}

	@Test
	public void testEqualsHashcode() {
		EqualsVerifier.forClass(Pet.class)
			.withIgnoredFields("person_id","name", "species")
			.suppress(Warning.STRICT_INHERITANCE)
			.suppress(Warning.NONFINAL_FIELDS)
		.verify();
	}
}
