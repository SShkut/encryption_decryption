package encryptdecrypt;

public class CipherFactory {

    public Cipher getCipher(Parameter parameter) {
        if (parameter.getAlgorithm().equals(Algorithm.SHIFT)) {
            return new ShiftCipher();
        }
        if (parameter.getAlgorithm().equals(Algorithm.UNICODE)) {
            return new UnicodeCipher();
        }
        return new ShiftCipher();
    }
}
