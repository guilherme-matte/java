package control.invest.IC.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StringExtract {
    private String extractValue(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            System.out.println(matcher.group());

        }
        return null;
    }

    public String extractCpf(String Text) {
        return extractValue(Text, "\\s*(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})\\s+(.+)");
    }

    public String extractCnpj(String Text) {
        return extractValue(Text, "\\s*(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})\\s+(.+)");
    }

    public String StringToArray(String text) {
        return List < String > words = Arrays.asList(text.split("\\s+"));

    }
}

public void SplitLines(String text) {
    String[] lines = text.split("\\s{2,}");
    for (String line : lines) {
        System.out.println(line.trim());
    }

}



