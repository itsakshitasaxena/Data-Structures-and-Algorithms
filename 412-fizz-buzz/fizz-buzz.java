class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans=new ArrayList<>();
        int c3=1, c5=1;
        for(int i=1;i<=n;i++){
            String str="";
            if(c3==3){
                str+="Fizz";
                c3=0;
            }
            if(c5==5){
                str+="Buzz";
                c5=0;
            }
            if(str=="")   str+=i;
            ans.add(str);
            c3++;
            c5++;
        }
        return ans;
    }
}