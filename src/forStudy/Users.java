package forStudy;
import java.util.ArrayList;
import java.util.Scanner;

public class Users extends Todolist {
    private String name;
    Scanner s = new Scanner(System.in);
    ArrayList<Users> userlist = new ArrayList<>();
    ArrayList<Todolist> todolists = new ArrayList<>();
    Todolist exercises;
    Todolist studies;
    Todolist others;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
        exercises = new Todolist();
        studies = new Todolist();
        others = new Todolist();
        todolists.add(exercises);
        todolists.add(studies);
        todolists.add(others);
    }

    public void addUser() {
        System.out.print("추가할 사용자의 이름을 입력하세요: ");
        String name = s.nextLine();
        userlist.add(new Users(name));
    }

    public String getName() {
        return name;
    }

    public Todolist getList(String listType) {
        switch (listType) {
            case "exercise":
                return exercises;
            case "study":
                return studies;
            case "other":
                return others;
            default:
                return null;
        }
    }

    public void viewTodoToUser() {
        System.out.print("사용자의 이름을 입력하세요: ");
        String targetname = s.nextLine();
        for (Users target : userlist) {
            if (target.getName().equals(targetname)) {
                System.out.println("확인할 카테고리 번호를 고르세요(1.운동, 2.학업, 3.그외)");
                int category = s.nextInt();
                s.nextLine();
                if (category == 1) {
                    target.getList("exercise").view(exerciselist);
                } else if (category == 2) {
                    target.getList("study").view(studylist);
                } else if (category == 3) {
                    target.getList("other").view(otherlist);
                }
            }
        }
    }
    public void addTodoToUser() {
        System.out.print("사용자의 이름을 입력하세요: ");
        String targetname = s.nextLine();
        for (Users target : userlist) {
            if (target.getName().equals(targetname)) {
                System.out.println("추가할 할일 카테고리 번호를 고르세요(1.운동, 2.학업, 3.그외)");
                int category = s.nextInt();
                s.nextLine();
                if (category == 1) {
                    target.getList("exercise").addSchedule(exerciselist);
                } else if (category == 2) {
                    target.getList("study").addSchedule(studylist);
                } else if (category == 3) {
                    target.getList("other").addSchedule(otherlist);
                }
            }
        }
    }
}