package forStudy;
import java.time.LocalDate;
import java.util.ArrayList;

public class Users {
    private String name;
    private ArrayList<Todo> userlist = new ArrayList<>();
    public Users(String name) {
        this.name = name;
        this.userlist = new ArrayList<>();
    }
    public void addUser(Todo name) {
        userlist.add(name);
    }
    public void changeName(String name) {
        this.name = name;
    }
    public void addTodo(String todo, LocalDate limitdate) {
        userlist.add(new Todo(todo, limitdate));
    }
}
