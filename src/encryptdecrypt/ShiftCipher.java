package encryptdecrypt;

public class ShiftCipher extends Cipher {

    @Override
    String encrypt(String text, int bias) {
        int textLength = text.length();
        char[] result = new char[textLength];
        for (int i = 0; i < textLength; ++i) {
            char letter = text.charAt(i);
            if (Character.isAlphabetic(letter)) {
                if (Character.isUpperCase(letter)) {
                    result[i] = (char) ('A' + ((letter - 'A' + bias) % 26));
                } else {
                    result[i] = (char) ('a' + ((letter - 'a' + bias) % 26));
                }
            } else {
                result[i] = letter;
            }
        }
        return String.valueOf(result);
    }

    @Override
    String decrypt(String text, int bias) {
        return encrypt(text, (26 - bias % 26));
    }
}
