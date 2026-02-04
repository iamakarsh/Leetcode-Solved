class Solution {
    public boolean isVowel(char curr){
        return curr=='a'|| curr=='e'|| curr=='i'|| curr=='o'|| curr=='u';
    }
    public int maxVowels(String s, int k) {
        int windowStart=0;
        int windowEnd=0;

        int currVowelCount=0;
        int maxVowelCount=Integer.MIN_VALUE;

        while(windowEnd<s.length()) {
            char curr = s.charAt(windowEnd);
            if(isVowel(curr)) currVowelCount++;

            if(windowEnd>=k-1) {
                maxVowelCount=Math.max(currVowelCount,maxVowelCount);

                char exclude = s.charAt(windowStart);

                if(isVowel(exclude)) currVowelCount--;
                windowStart++;
            }
            windowEnd++;
        }
        return maxVowelCount;
    }
}