class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int ans=0;
        Stack<Character>st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    ans++;
                }
            }
        }
        return ans+st.size();
    }
}