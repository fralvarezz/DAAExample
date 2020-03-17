package es.uvigo.esei.daa.dataset;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.function.Predicate;

import es.uvigo.esei.daa.entities.Pet;

public final class PetsDataset {
	private PetsDataset() {}
	
	public static Pet[] pets() {
		return new Pet[] {
			new Pet(1, 1, "Lili", "Perro"),
			new Pet(2, 1, "Popi", "Perro"),
			new Pet(3, 1, "Miski", "Perro"),
			new Pet(4, 1, "Triski", "Perro"),
			new Pet(5, 1, "Manolete", "Perro"),
			new Pet(6, 1, "Gatete", "Gato"),
			new Pet(7, 1, "Misifu", "Gato"),
			new Pet(8, 1, "Leonidas", "Gato"),
			new Pet(9, 1, "Chungo", "Gato"),
			new Pet(10, 1, "Juan", "Gato")
		};
	}
	
	public static Pet[] PetsWithout(int ... ids) {
		Arrays.sort(ids);
		
		final Predicate<Pet> hasValidId = Pet ->
			binarySearch(ids, Pet.getId()) < 0;
		
		return stream(pets())
			.filter(hasValidId)
		.toArray(Pet[]::new);
	}
	
	public static Pet Pet(int id) {
		return stream(pets())
			.filter(Pet -> Pet.getId() == id)
			.findAny()
		.orElseThrow(IllegalArgumentException::new);
	}
	
	public static int existentId() {
		return 5;
	}
	
	public static int nonExistentId() {
		return 1234;
	}

	public static Pet existentPet() {
		return Pet(existentId());
	}
	
	public static Pet nonExistentPet() {
		return new Pet(nonExistentId(), 1, "None", "Serpiente");
	}
	
	public static String newPersonId() {
		return "10";
	}
	
	public static String newName() {
		return "Pepito";
	}
	
	public static String newSpecies() {
		return "Perro";
	}
	
	public static Pet newPet() {
		return new Pet(pets().length + 1, Integer.parseInt(newPersonId()), newName(), newSpecies());
	}
}
