public class WordScrambler {

    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {
        if (wordArr.length % 2 != 0) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        for (String word : wordArr) {
            if (word.contains(" ")) {
                throw new IllegalArgumentException("Word Array must contain single words only! " + word + " contains more than one word!");
            }
        }
        scrambledWords = mixedWords(wordArr);
    }

    private String recombine(String word1, String word2) {
        int mid1 = word1.length() / 2;
        int mid2 = word2.length() / 2;

        String firstHalf = word1.substring(0, mid1);
        String secondHalf = word2.substring(mid2);

        return firstHalf + secondHalf;
    }

    private String[] mixedWords(String[] words) {
        String[] result = new String[words.length];

        for (int i = 0; i < words.length; i += 2) {
            result[i] = recombine(words[i], words[i + 1]);
            result[i + 1] = recombine(words[i + 1], words[i]);
        }

        return result;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}
