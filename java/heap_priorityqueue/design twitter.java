class Twitter {
    private Map<Integer, User> users;
    private static int timeStamp = 0;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }
        public void unfollow(int id) {
            followed.remove(id);
        }
        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    public Twitter() {
        users = new HashMap<Integer, User>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)) {
            User user = new User(userId);
            users.put(userId, user);
        }
        users.get(userId).post(tweetId);
    }
    
    //O(n log k) - where k is the number of users followed by the given user
    //and n is the total number of tweets in the heap.
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();

        if(!users.containsKey(userId)) return result;

        Set<Integer> usersFollowed = users.get(userId).followed;
        PriorityQueue<Tweet> heap = new PriorityQueue<>(usersFollowed.size(), (a,b) -> (b.time-a.time));

        for(int followed : usersFollowed) {
            Tweet tweet = users.get(followed).tweetHead;
            if(tweet != null) {
                heap.add(tweet);
            }
        }

        while(!heap.isEmpty() && result.size() < 10) {
            Tweet tweet = heap.poll();
            result.add(tweet.id);
            if(tweet.next != null) {
                heap.add(tweet.next);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) {
            User user = new User(followerId);
            users.put(followerId, user);
        }
        if(!users.containsKey(followeeId)) {
            User user = new User(followeeId);
            users.put(followeeId, user);
        }
        users.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId) || followerId == followeeId) return;
        users.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */