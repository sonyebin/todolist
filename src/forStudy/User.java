package forStudy;

import java.util.ArrayList;

public class User {
    private String name;
    private String phone_num;
    private int number;
    private String address;
    ArrayList<User> friends = new ArrayList<>();

    public User(String name, String phone_num) {
        this.name = name;
        this.phone_num = phone_num;
    }

    public User(String name, String phone_num, int number, String address) {
        this.name = name;
        this.phone_num = phone_num;
        this.number = number;
        this.address = address;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changePhoneNumber(String phone_num) {
        this.phone_num = phone_num;
    }

    public void changeNumber(int number) {
        this.number = number;
    }

    public void changeAddress(String address) {
        this.address = address;
    }

    public void addFriend(User name) { //User 객체 이용
        friends.add(name);
    }

    public void removeFriend(User name) { //User 객체 이용
        friends.remove(name);
    }

    @Override
    public String toString() {
        return "이름: "+name+" / 전화번호: "+phone_num+" / 학번: "+number+" / 주소: "+address;
    }

    public void printList() {
        for(User data : friends){
            System.out.println(data);
        }
    }
}
