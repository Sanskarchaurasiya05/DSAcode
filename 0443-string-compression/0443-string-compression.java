class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int i=0;
        int count;
        int index=0;
        while(i<n){
          char curr_char=chars[i];
            count=0;
            while(i<n && chars[i]==curr_char){
                i++;
                count++;
            }
            
            chars[index]=curr_char;
            index++;
            if(count>1){
//                 first we convert a count into string
          String countStr = Integer.toString(count);
//                 now we create a character aaray to store a each each char present in string
         char[] charArray = countStr.toCharArray();
// now we store the result
                 for (char c : charArray) {
            chars[index++]=c;
        }
           
            }
            
            
        }
        return index;
    }
}