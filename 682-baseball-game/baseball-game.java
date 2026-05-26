class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("C")) {
                if (!st.isEmpty()) st.pop();
            } else if (op.equals("D")) {
                st.push(st.peek() * 2);
            } else if (op.equals("+")) {
                int last = st.pop();
                int newScore = last + st.peek();
                st.push(last);
                st.push(newScore);
            } else {
                st.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int i = 0; i < st.size(); i++) {
            sum += st.get(i);
        }
        return sum;
    }
}