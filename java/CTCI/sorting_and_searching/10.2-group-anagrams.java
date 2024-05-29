//O(n * k log(k)) Time & O(n) Space - where n is the number of strings in the array.
void sort(String[] array) {
    Map<String, List<String>> mapLists = new HashMap<>();

    for(String s : array) {
        String key = sortChars(s);
        if(!mapLists.containsKey(key)) {
            mapLists.put(key, new ArrayList<>());
        }
        mapLists.get(key).add(s);
    }

    int index = 0;
    for(String key : mapLists.keySet()) {
        List<String> list = mapLists.get(key);
        for(String t : list) {
            array[index] = t;
            index++;
        }
    }
}

//O(k log(k)) Time - where k is the length of the input string
String sortChars(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
}