class Solution {
    public char findTheDifference(String s, String t) {
        int SumS=0, SumT=0;
        for(char c:s.toCharArray()) SumS+=c;
        for(char c:t.toCharArray()) SumT+=c;
        return (char)(SumT-SumS);
    }
}