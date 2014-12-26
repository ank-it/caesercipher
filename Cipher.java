public class Cipher
{
	public static String encrypt(String message, int shift)
	{
		char[] messageArray = message.toCharArray();

		for(int i = 0; i < messageArray.length; i++)
		{
			messageArray[i] = shift(messageArray[i], shift);
		}
		return new String(messageArray);
	}

	public static String decrypt(String encryptedMessage, int shift)
	{
		return encrypt(encryptedMessage, 26 - shift);
	}

	private static char shift(char letter, int shift)
	{
		shift = shift % 26 + 26;
		if('a' <= letter && letter <= 'z')
		{
			letter = (char)('a' + (letter - 'a' + shift) % 26);
		}
		else if('A' <= letter && letter <= 'Z')
		{
			letter = (char)('A' + (letter - 'A' + shift) % 26);
		}

		return letter;
	}
}