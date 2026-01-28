class Solution {
    public static boolean[] isprime;
    static{
        isprime=sieve(500001); //sieve runs once when class is loaded (staticblock)
    }
    public static boolean[] sieve(int n){
        boolean[] prime=new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0]=prime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }
        return prime;
    }
    public int primeSubarray(int[] nums, int k) {
        // TreeMap to store frequency of prime VALUES in current window
        // Helps to get min and max prime in O(log n)
        TreeMap<Integer, Integer> map=new TreeMap<>();
        Deque<Integer> prime_idx=new ArrayDeque<>(); //store indices of prime n0. in curr window
        int left=0, right=0, cnt=0;
        while(right<nums.length){
            if(isprime[nums[right]]){
                map.put(nums[right], map.getOrDefault(nums[right],0)+1);  //grow
                prime_idx.add(right);
            }
            while(map.size()>0 && map.lastKey()-map.firstKey()>k){ //shrink
                if(isprime[nums[left]]){
                    prime_idx.poll();
                    map.put(nums[left], map.getOrDefault(nums[left],0)-1);
                    if(map.get(nums[left])==0)   map.remove(nums[left]);
                }
                left++;
            }
              // Count valid subarrays ending at (right - 1)
            if(prime_idx.size()>=2){
                int lastprime_idx=prime_idx.pollLast();
                int seclastprime_idx=prime_idx.peekLast();
                cnt+=(seclastprime_idx-left+1); // All starts from [left-secondLastPrimeIdx] will form balanced subarrays (left is the earlist idx possible to form valid subarrays)
                prime_idx.add(lastprime_idx); //restore
            }
            right++;
        }
        return cnt;
    }
}