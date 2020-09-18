package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

public class ParameterReader {

    private static final String ENCRYPTION = "enc";
    private static final String MODE_PARAMETER = "-mode";
    private static final String KEY_PARAMETER = "-key";
    private static final String DATA_PARAMETER = "-data";
    private static final String IN_PARAMETER = "-in";
    private static final String OUT_PARAMETER = "-out";
    private static final String ALGORITHM_PARAMETER = "-alg";
    private static final String SHIFT_ALGORITHM = "shift";

    public Parameter readParameters(String[] args) {
        Map<String, String> parameters = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            parameters.put(args[i], args[i + 1]);
        }

        String modeParam = parameters.getOrDefault(MODE_PARAMETER, ENCRYPTION);
        int key = Integer.parseInt(parameters.getOrDefault(KEY_PARAMETER, "0"));
        String data = parameters.getOrDefault(DATA_PARAMETER, "");
        String fileOutputName = parameters.getOrDefault(OUT_PARAMETER, "");
        String fileInputName = parameters.getOrDefault(IN_PARAMETER, "");
        String algorithmParam = parameters.getOrDefault(ALGORITHM_PARAMETER, SHIFT_ALGORITHM);
        Algorithm algorithm = algorithmParam.equals(SHIFT_ALGORITHM) ? Algorithm.SHIFT : Algorithm.UNICODE;
        Mode mode = modeParam.equals(ENCRYPTION) ? Mode.ENCRYPTION : Mode.DECRYPTION;

        return new Parameter(mode, key, data, fileInputName, fileOutputName, algorithm);
    }
}
