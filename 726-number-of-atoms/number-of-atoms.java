class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> st=new Stack<>(); // Each map stores atom -> count at that level
        st.push(new HashMap<>());
        int i=0, n=formula.length();
        while(i<n){
            char ch=formula.charAt(i);
            if(ch=='('){
                st.push(new HashMap<>());
                i++;
            }
            else if(ch==')'){   // Pop top map, multiply counts, and merge into previous map
                i++;
                int multiplier=0;
                while(i<n && Character.isDigit(formula.charAt(i))){
                    multiplier=multiplier*10 + (formula.charAt(i)-'0');
                    i++;
                }
                if(multiplier==0) multiplier=1;

                 // Pop the current level map
                Map<String, Integer> top=st.pop();
                Map<String, Integer> curr=st.peek();

                for(String atom:top.keySet()){   // Merge multiplied counts into parent map
                    curr.put(atom, curr.getOrDefault(atom, 0)+top.get(atom)*multiplier);
                }

            }
            else{
                StringBuilder atom=new StringBuilder();
                atom.append(ch); // uppercase letter
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i))){
                    atom.append(formula.charAt(i));
                    i++;
                }

                int cnt=0;
                while(i<n && Character.isDigit(formula.charAt(i))){
                    cnt=cnt*10 +(formula.charAt(i)-'0');
                    i++;
                }
                if(cnt==0) cnt=1;

                Map<String, Integer> curr=st.peek();   // Add atom count to current scope
                curr.put(atom.toString(), curr.getOrDefault(atom.toString(), 0)+cnt);
            }
        }
        Map<String, Integer> result=st.pop();
        TreeMap<String, Integer> sorted=new TreeMap<>(result);  // Sort atoms lexicographically
        StringBuilder ans=new StringBuilder();
        for(String atom: sorted.keySet()){
            ans.append(atom);
            if(sorted.get(atom)>1)  ans.append(sorted.get(atom));
        }
        return ans.toString();
    }
}