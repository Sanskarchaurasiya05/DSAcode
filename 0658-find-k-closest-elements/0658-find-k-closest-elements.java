class Solution {
   class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

  
}

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       List<Integer>ans=new ArrayList<>();
        //  PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(Collections.reverseOrder());

           PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Collections.reverseOrder(
            Comparator.comparingInt(Pair::getKey)
        ));
        
        for(int i=0;i<arr.length;i++){
            int distance = Math.abs(x - arr[i]);
            if (pq.size() < k) {
                pq.add(new Pair<>(distance, arr[i]));
            } else if (distance < pq.peek().getKey()) {
                pq.poll();
                pq.add(new Pair<>(distance, arr[i]));
            }
        }
           while(!pq.isEmpty()){
               ans.add(pq.poll().getValue());
           } 

            Collections.sort(ans);

        return ans;       
    }
}