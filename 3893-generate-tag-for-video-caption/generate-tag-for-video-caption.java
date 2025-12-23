class Solution {
    public String generateTag(String caption) {
         String[] st=caption.trim().split("\\s+");
        if(st.length==0||st[0].isEmpty()) return "#";
        StringBuilder sb=new StringBuilder("#");
        sb.append(st[0].toLowerCase());
        for(int i=1;i<st.length;i++){
            sb.append(Character.toUpperCase(st[i].charAt(0)));
            sb.append(st[i].substring(1).toLowerCase());
        }
        // System.out.println(sb.length());
        return sb.length() > 100 ? sb.substring(0, 100) : sb.toString();
    }
}