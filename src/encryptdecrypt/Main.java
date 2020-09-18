package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        ParameterReader paramReader = new ParameterReader();
        Parameter parameter = paramReader.readParameters(args);
        CipherFactory cipherFactory = new CipherFactory();
        Cipher cipher = cipherFactory.getCipher(parameter);
        cipher.process(parameter);
    }
}