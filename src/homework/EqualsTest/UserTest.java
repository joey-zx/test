package homework.EqualsTest;

public class UserTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUsername(null);
        user1.setPassword("1234");

        User user2 = new User();
        user2.setUsername(null);
        user2.setPassword("1234");

        System.out.println(user1.equals(user2));
    }
}
