//O(n) Time & O(1) Space
boolean checkOneAway(String a, String b) {
    if(a.length() == b.length()) {
        return replace(a, b);
    } else if(a.length() + 1 == b.length()) {
        return insert(a, b);
    } else if(a.length() - 1 == b.length()) {
        return insert(b, a);
    }
    return false;
}

boolean replace(String s1, String s2) {
    boolean foundDifference = false;
    for(int i = 0; i < s1.length(); i++) {
        if(s1.charAt(i) != s2.charAt(i)) {
            if(foundDifference) return false;
            foundDifference = true;
        }
    }
    return true;
}

boolean insert(String s1, String s2) {
    int index1 = 0;
    int index2 = 0;
    
    while(index2 < s2.length() && index1 < s1.length()) {
        if(s1.charAt(index1) != s2.charAt(index2)) {
            //it means that there's more than one char to insert, 
            //because we'd already updated the index2; 
            if(index1 != index2) { 
                return false;
            }
            index2++;
        } else { //characters are equal -> move the two pointers
            index1++;
            index2++;
        }
    }
    return true;
}