import java.util.HashSet;
import java.util.Set;

public class Subsequence { 
	      
	    // set to store all the subsequences 
	    static HashSet<String> st = new HashSet<>(); 
	    static HashSet<String> stPermutations = new HashSet<>(); 
	  
	    static void reset() {
		    st = new HashSet<>(); 
		    stPermutations = new HashSet<>();	    	
	    }
	    
	    // It computes all the subsequence of an string
	    static void subsequence(String str) 
	    { 
//	    	st = new HashSet<>(); 
//	    	stPermutations = new HashSet<>(); 
	        // iterate over the entire string 
	        for (int i = 0; i < str.length(); i++) { 
	              
	            // iterate from the end of the string 
	            // to generate substrings 
	            for (int j = str.length(); j > i; j--) { 
	                String sub_str = str.substring(i, j); 
	              
	                if (!st.contains(sub_str)) 
	                    st.add(sub_str); 
	  
	                // drop kth character in the substring 
	                // and if its not in the set then recur 
	                for (int k = 1; k < sub_str.length() - 1; k++) { 
	                    StringBuffer sb = new StringBuffer(sub_str); 
	  
	                    // drop character from the string 
	                    sb.deleteCharAt(k); 
	                    if (!st.contains(sb)) 
	                        ; 
	                    subsequence(sb.toString()); 
	                } 
	            } 
	        } 
	    }

		public static HashSet<String> getSt() {
			return st;
		} 
	    
	   public static Set<String> permutationFinder(String str) {
	        Set<String> perm = new HashSet<String>();
	        //Handling error scenarios
	        if (str == null) {
	            return null;
	        } else if (str.length() == 0) {
	            perm.add("");
	            return perm;
	        }
	        char initial = str.charAt(0); // first character
	        String rem = str.substring(1); // Full string without first character
	        Set<String> words = permutationFinder(rem);
	        for (String strNew : words) {
	            for (int i = 0;i<=strNew.length();i++){
	                perm.add(charInsert(strNew, initial, i));
	            }
	        }
	        return perm;
	    }

	    public static String charInsert(String str, char c, int j) {
	        String begin = str.substring(0, j);
	        String end = str.substring(j);
	        return begin + c + end;
	    }


	    
}