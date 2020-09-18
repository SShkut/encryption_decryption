package encryptdecrypt;

public class Parameter {

    private final Mode mode;
    private final int key;
    private final String data;
    private final String in;
    private final String out;
    private final Algorithm algorithm;

    public Parameter(Mode mode, int key, String data, String in, String out, Algorithm algorithm) {
        this.mode = mode;
        this.key = key;
        this.data = data;
        this.in = in;
        this.out = out;
        this.algorithm = algorithm;
    }

    public Mode getMode() {
        return mode;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }
}
