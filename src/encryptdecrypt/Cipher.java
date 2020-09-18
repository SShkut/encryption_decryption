package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Cipher {

    abstract String encrypt(String text, int bias);

    abstract String decrypt(String text, int bias);

    public void process(Parameter parameter) {
        String textForProcess = getText(parameter.getData(), parameter.getIn());
        String resultText = processText(parameter.getMode(), parameter.getKey(), textForProcess);
        outputResultText(parameter.getOut(), resultText);
    }

    private String getText(String data, String fileInputName) {
        String textForProcess = "";
        try {
            if (data.isEmpty()) {
                textForProcess = Files.readString(Paths.get(fileInputName));
            } else if (fileInputName.isEmpty()) {
                textForProcess = data;
            }
        } catch (IOException e) {
            System.out.println(String.format("Error occurred during reading from the file: %s", fileInputName));
        }
        return textForProcess;
    }

    private void outputResultText(String fileOutputName, String resultText) {
        if (fileOutputName.isEmpty()) {
            System.out.println(resultText);
        } else {
            try {
                Files.write(Paths.get(fileOutputName), resultText.getBytes());
            } catch (IOException e) {
                System.out.println(String.format("Error occurred during writing to the file: %s", fileOutputName));
            }
        }
    }

    private String processText(Mode mode, int key, String textForProcess) {
        String resultText = "";
        if (mode.equals(Mode.ENCRYPTION)) {
            resultText = encrypt(textForProcess, key);
        } else if (mode.equals(Mode.DECRYPTION)) {
            resultText = decrypt(textForProcess, key);
        }
        return resultText;
    }
}
