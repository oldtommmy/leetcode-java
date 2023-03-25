package secondExercise.hash;

public class T383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] dic = new int[26];
        char[] m_ch = magazine.toCharArray();
        char[] r_ch = ransomNote.toCharArray();

        for (char c : m_ch) {
            dic[c - 'a']++;
        }
        for (char c : r_ch) {
            if (dic[c - 'a'] == 0) {
                return false;
            }
            dic[c - 'a']--;
        }
        return true;
    }
}
