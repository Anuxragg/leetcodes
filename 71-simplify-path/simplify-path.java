class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String [] parts = path.split("/");
        for(String part : parts ){
            if(part.equals("") || part.equals(".")){
                continue;
            }
            if(part.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
            st.push(part);
            }
        }
        StringBuilder answer = new StringBuilder();
        for(String dr : st){
            answer.append("/").append(dr);
        }
        return answer.length()==0 ? "/" : answer.toString();
    }
}