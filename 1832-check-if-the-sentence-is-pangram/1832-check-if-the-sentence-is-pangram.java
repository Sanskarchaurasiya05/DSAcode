class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] alpha=new int[26];
        int count=0;
        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
        if (ch >= 'a' && ch <= 'z') { // Ensure character is a lowercase letter
            int index = ch - 'a'; // Calculate the index for the character
            if (alpha[index] == 0) {
                alpha[index] = 1; // Mark this letter as seen
                count++;
            }
        }
        }
        
        if(count==26)
            return true;
        return false;
    }
}