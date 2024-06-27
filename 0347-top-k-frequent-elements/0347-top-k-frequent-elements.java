class Solution {
    public class Pair<K, V> {
    private K key;
    private V value;

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

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        Map<Integer,Integer>mp=new HashMap<>();

            for(int i=0 ; i<nums.length;i++)
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            Comparator.comparing(Pair::getValue));

              for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
                      int key=entry.getKey();
                      int value=entry.getValue();
                      pq.add(new Pair<>(key,value));
                      if(pq.size()>k)
                      pq.poll();
              }
                     int i=0;
              for (Pair<Integer, Integer> pair : pq) {
            Integer key = pair.getKey();
           res[i++]=key;
        }
               return res;
    }
}