package encryptdecrypt;

public class UnicodeCipher extends Cipher {

    @Override
    public String encrypt(String text, int bias) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); ++i) {
            result[i] = (char) (text.charAt(i) + bias);
        }
        return String.valueOf(result);
    }

    @Override
    public String decrypt(String text, int bias) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); ++i) {
            result[i] = (char) (text.charAt(i) - bias);
        }
        return String.valueOf(result);
    }
}
