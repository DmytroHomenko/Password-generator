


public class Alphabet {

	// symbols that can be used in creating password
	public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String UPPERCASE_LETTERSUKR = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
	public static final String LOWERCASE_LETTERSUKR = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
	
	private final StringBuilder pool;

	// variable "Alphabet" which includes all symblos
	public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean uppercaseUkrIncluded,
					boolean lowercaseUkrIncluded, boolean numbersIncluded, boolean specialCharactersIncluded) {
		
		pool = new StringBuilder();
		
		if (uppercaseIncluded) pool.append(UPPERCASE_LETTERS);
		
		if (lowercaseIncluded) pool.append(LOWERCASE_LETTERS);

		if (uppercaseUkrIncluded) pool.append(UPPERCASE_LETTERSUKR);

		if (lowercaseUkrIncluded) pool.append(LOWERCASE_LETTERSUKR);
		
		if (numbersIncluded) pool.append(NUMBERS);
		
		if (specialCharactersIncluded) pool.append(SYMBOLS);
		
	}
	
	public String getAlphabet() {
		return pool.toString();
	}
}
