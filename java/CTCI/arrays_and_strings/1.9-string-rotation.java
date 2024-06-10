//O(A + B) Time ~ O(n) Time & O(1) Space
boolean isRotation(String a, String b) {
    int aLen = a.length();
    int bLen = b.length();

    if(aLen == bLen && aLen > 0) {
        String aa = a + a;
        return isSubString(aa, b);
    }
    return false;
}

//xy = a -> xyxy (aa) -> x yx(b) y
//yx = b 