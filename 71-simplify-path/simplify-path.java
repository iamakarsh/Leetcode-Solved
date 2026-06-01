class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            String dir = stack.get(i);
            ans.append("/").append(dir);
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}