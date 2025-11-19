class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         //Topological Sort--> only used for Directed Acyclic Graph
        //here, we did by using BFS i.e. Kahn's Algorithm
        //Topological sort is not possible if there exists a cycle

        //build adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int[] courses:prerequisites)
            adj.get(courses[1]).add(courses[0]);

        //built indegree array
        int[] in=new int[numCourses];
        for(int[] course:prerequisites)
            in[course[0]]++;
        Queue<Integer> qu=new LinkedList<>();
        List<Integer> ord=new ArrayList<>();
        for(int i=0;i<numCourses;i++) if(in[i]==0)  qu.add(i);
        while(!qu.isEmpty()){
            int r=qu.poll();
            ord.add(r);
            for(int nbrs:adj.get(r)){
                in[nbrs]--;
                if(in[nbrs]==0)  qu.add(nbrs);
            }

        }
        int[] ans=new int[ord.size()];
        for(int i=0;i<ord.size();i++){
            ans[i]=ord.get(i);
        }
        return ord.size()==numCourses?ans:new int[0];
    }
}