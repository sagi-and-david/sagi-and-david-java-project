
public enum Categories {
	kids, electricity, office, clothes;

	// Utility method to check if a string is in the enum
	public static boolean contains(String test) {
		//runs on all values of that the enum contains
		for (Categories value : Categories.values()) {
			if (value.name().equals(test)) {
				// if value is in the enum then return true
				return true;
			}
		}
		return false;
	}
}
