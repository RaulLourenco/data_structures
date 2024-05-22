public class UserManager {
    private static UserManager instance;
    private Map<Integer, User> usersById;
    private Map<String, User> userByAccountName;
    private Map<Integer, User> onlineUsers;

    public static UserManager getInstance() {
        if(instance == null) instance = new UserManager();
        return instance;
    }

    public void addUser(User fromUser, String toAccountName) {....}
    public void approveAddRequests(AddRequest req) {...}
    public void rejectAddRequest(AddRequest req) {...}
    public void userSignedOn(String accountName) {...}
    public void userSignedOff(String accountname) {...}
}

public class User {
    private int id;
    private UserStatus status = null;

    private Map<Integer, PrivateChat> privateChats;
    private List<GroupChat> groupChats;
    private Map<Integer, AddRequest> receiveAddRequests;
    private Map<Integer, AddRequest> sentAddRequests;
    private Map<Integer, User> contacts;

    private String accountName;
    private String fullName;

    public User(int id, String accountName, String fullName) {...}

    public boolean sendMessageToUser(User to, String content) {...}
    public boolean sendMessageToGroupChat(int id, String cnt) {...}
    public void setStatus(UserStatus status) {...}
    public UserStatus getStatus() {...}
    public boolean addContact(User user) {...}
    public void receiveAddRequest(AddRequest req) {...}
    public void sentAddRequest(AddRequest req) {...}
    public void removeAddRequest(AddRequest req) {...}
    public void requestAddUser(String accountName) {...}
    public void addConversation(PrivateChat conversation) {...}
    public void addConversation(GroupChat conversation) {...}
    public int getId() {...}
    public String getAccountName() {...}
    public String getFullName() {...}
}

public abstract class Conversation {
    protected List<User> participants;
    protected int id;
    protected List<Message> messages;

    public List<Message> getMessages() {...}
    public boolean addMessage(Message m) {...}
    public int getId() {...}
}

public class GroupChat extends Conversation {
    public void removeParticipant(User user) {...}
    public void addParticipant(User user) {...}
}

public class PrivateChat extends Conversation {
    public PrivateChat(User user1, User user2) {...}
    public User getOtherParticipant(User primary) {...}
}

public class Message {
    private String content;
    private Date date;
    public Message(String content, Date date) {...}

    public String getContent() {...}
    public Date getDate() {...}
}

public class AddRequest {
    private User fromUser;
    private User toUser;
    private Date date;
    RequestStatus status;

    public AddRequest(User from, User to, Date date) {...}
    public RequestStatus getStatus() {...}
    public User getFromUser() {...}
    public User getToUser() {...}
    public Date getDate() {...}
}

public class UserStatus {
    private String message;
    private UserStatusType type;
    
    public UserStatus(UserStatusType type, String message) {...}

    public UserStatusType getStatusType() {...}
    public String getMessage() {...}
}

public enum UserStatusType {
    Offline, Away, Idle, Available, Busy;
}

public enum RequestStatus {
    Unread, Read, Accepted, Rejected;
}