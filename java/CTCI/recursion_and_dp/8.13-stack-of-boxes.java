//O(2^n) Time & Space - where n is the number of boxes in the list. 
int createStack(List<Box> boxes) {
    Collections.sort(boxes, BoxComparator());
    int[] stackMap = new int[boxes.size()];
    return createStack(boxes, null, 0, stackMap);
}

int createStack(List<Box> boxes, Box bottom, int offset, int[] stackMap) {
    if(offset >= boxes.size()) return 0;

    Box newBottom = boxes.get(offset);
    int heightWithBottom = 0;
    if(bottom == null || newBottom.canBeAbove(bottom)) {
        if(stackMap[offset] == 0) {
            stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
            stackMap[offset] += newBottom.height;
        }
        heightWithBottom = stackMap[offset];
    }
    int heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap);
    
    return Math.max(heightWithBottom, heightWithoutBottom);
}

class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x, Box y) {
        return y.height - x.height;
    }
}