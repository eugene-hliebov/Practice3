package ua.nure.hliebov.practice3;

public class Part6 {
    public static void main(String[] args) {
        System.out.println("Part6");
        System.out.println("============================");
        String input = "This is a test\nAnd this is also a test\nAnd these are also tests\ntest\nЦе тест\nЦе також тест\nІ це також тести";
        String output = convert(input);
        System.out.println(output);
        System.out.println("============================");
        System.out.println();
    }
    public static String convert(String input) {
        String[] words = input.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                String current = words[i];


                for (int j = i + 1; j < words.length; j++) {
                    if (words[j] != null && words[j].equals(current)) {
                        if (!words[i].startsWith("_")) {
                            words[i] = "_" + words[i];
                        }
                        words[j] = "_" + words[j];
                    }
                }

                if (words[i].startsWith("__")) {
                    words[i] = words[i].replace("__", "_");
                }
            }
        }

        String[] lines = input.split("\n");
        StringBuilder changedInput = new StringBuilder();

        for (String line : lines) {
            String[] lineWords = line.split("\\s+");
            StringBuilder modifiedLine = new StringBuilder();

            for (String word : lineWords) {
                boolean isDuplicate = false;

                for (String duplicate : words) {
                    if (duplicate.equals(word)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    modifiedLine.append("_").append(word).append(" ");
                } else {
                    modifiedLine.append(word).append(" ");
                }
            }

            modifiedLine.deleteCharAt(modifiedLine.length() - 1);  // Видаляємо останній пробіл
            changedInput.append(modifiedLine).append("\n");
        }
        changedInput.deleteCharAt(changedInput.length() - 1);  // Видаляємо останній символ нового рядка

        return changedInput.toString();
    }

    private static int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while (index != -1) {
            index = text.indexOf(word, index);
            if (index != -1) {
                boolean isPartialMatch = false;
                if (index > 0 && Character.isLetter(text.charAt(index - 1))) {
                    isPartialMatch = true;
                }
                if (index + word.length() < text.length() && Character.isLetter(text.charAt(index + word.length()))) {
                    isPartialMatch = true;
                }
                if (!isPartialMatch) {
                    count++;
                }
                index += word.length();
            }
        }
        return count;
    }
}


