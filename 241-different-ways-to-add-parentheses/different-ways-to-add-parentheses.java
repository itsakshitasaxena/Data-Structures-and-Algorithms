class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans=new ArrayList<>();
        if(expression.length()==0)  return ans;
        if(expression.length()==1){
            ans.add(Integer.parseInt(expression));
            return ans;
        }
        if(expression.length()==2 && Character.isDigit(expression.charAt(0))){
             ans.add(Integer.parseInt(expression));
                return ans;
        }

        for(int i=0;i<expression.length();i++){
            char curr=expression.charAt(i);
            if(Character.isDigit(curr)) continue;

            List<Integer> left=diffWaysToCompute(expression.substring(0,i));
            List<Integer> right=diffWaysToCompute(expression.substring(i+1));

            for(int leftval:left){
                for(int rightval:right){
                    int computed_res=0;
                    switch(curr){
                        case '+':
                                computed_res=leftval+rightval; break;
                        case '-':
                                computed_res=leftval-rightval; break;
                        case '*':
                                computed_res=leftval*rightval; break;
                    }
                    ans.add(computed_res);
                }
            }
        }
        return ans;
    }
}