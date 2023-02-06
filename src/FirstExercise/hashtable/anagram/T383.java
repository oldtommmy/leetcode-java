package FirstExercise.hashtable.anagram;


/**
 * 383. 赎金信
 */
@SuppressWarnings({"all"})
public class T383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        char[] ransom = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        int[] num = new int[26];

        for (int i = 0; i < ransom.length; i++) {
            num[maga[i] - 'a']++;
            num[ransom[i] - 'a']--;
        }

        for (int i = ransom.length; i < maga.length; i++) {
            num[maga[i]- 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (num[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
