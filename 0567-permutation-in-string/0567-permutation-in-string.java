class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int k = s1.length();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char curr = s1.charAt(i);
            map1.put(curr, map1.getOrDefault(curr, 0) + 1);
        }

        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s2.length(); windowEnd++) {

            char curr = s2.charAt(windowEnd);
            map2.put(curr, map2.getOrDefault(curr, 0) + 1);

            // when window size exceeds k
            if (windowEnd - windowStart + 1 > k) {
                char temp = s2.charAt(windowStart);
                map2.put(temp, map2.get(temp) - 1);

                if (map2.get(temp) == 0) {
                    map2.remove(temp);
                }
                windowStart++;
            }

            // compare maps when window size == k
            if (windowEnd - windowStart + 1 == k) {
                if (map1.equals(map2)) return true;
            }
        }

        return false;
    }
}
