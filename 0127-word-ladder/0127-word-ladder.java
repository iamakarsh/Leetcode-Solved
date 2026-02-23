class Solution {
    
    class Pair {
        String word;
        int dist;
        Pair(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        while(!q.isEmpty()) {
            
            Pair curr = q.poll();
            String word = curr.word;
            int dist = curr.dist;
            
            if(word.equals(endWord)) return dist;
            
            char[] arr = word.toCharArray();
            
            for(int i = 0; i < arr.length; i++) {
                
                char original = arr[i];
                
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    
                    arr[i] = ch;
                    String newWord = new String(arr);
                    
                    if(set.contains(newWord)) {
                        q.add(new Pair(newWord, dist + 1));
                        set.remove(newWord);
                    }
                }
                
                arr[i] = original;
            }
        }
        
        return 0;
    }
}