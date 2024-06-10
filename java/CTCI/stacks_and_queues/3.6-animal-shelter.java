//O(1) Time & O(n) Space - where n is the number of push operations to the lists dogs and cats
class AnimalQueue { //there are more methods to implement here.
    List<Dog> dogs = new LinkedList<>();
    List<Cat> cats = new LinkedList<>();
    private int order = 0; //could be a timestamp
    
    //O(1) Time
    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;

        if(a instanceof Dog) dogs.addLast((Dog) a);
        else if(a instanceof Cat) cats.addLast((Cat) a);
    }

    //O(1) Time
    public Animal dequeueAny() {
        if(dogs.size() == 0) {
            return dequeueCats();
        } else if(cats.size() == 0) {
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    //O(1) Time
    public Dog dequeueDogs() {
        return dogs.poll();
    }
    
    //O(1) Time
    public Cat dequeueCats() {
        return cats.poll();
    }
}