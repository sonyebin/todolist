package forStudy;
import java.util.ArrayList;
import java.util.Scanner;

public class Users extends Todolist {
    private String name;
    Scanner s = new Scanner(System.in);
    ArrayList<Users> userlist = new ArrayList<>();
    ArrayList<Todolist> todolists = new ArrayList<>();
    Todolist exerciselist;
    Todolist studylist;
    Todolist otherlist;
    Todolist alllist;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
        exerciselist = new Todolist();
        studylist = new Todolist();
        otherlist = new Todolist();
        alllist = new Todolist();
        todolists.add(exerciselist);
        todolists.add(studylist);
        todolists.add(otherlist);
        todolists.add(alllist);
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
                return exerciselist;
            case "study":
                return studylist;
            case "other":
                return otherlist;
            case "all":
                return alllist;
            default:
                return null;
        }
    }

    public void viewTodoToUser() {
        System.out.print("사용자의 이름을 입력하세요: ");
        String targetname = s.nextLine();
        for (Users target : userlist) {
            if (target.getName().equals(targetname)) {
                System.out.println("확인할 카테고리 번호를 고르세요(1.운동, 2.학업, 3.그외");
                int category = s.nextInt();
                s.nextLine();
                if (category == 1) {
                    target.getList("exercise").view();
                } else if (category == 2) {
                    target.getList("study").view();
                } else if (category == 3) {
                    target.getList("other").view();
                }
            }
            else {
                System.out.println("사용자를 찾을 수 없습니다.");
            }
        }
    }
    public void addTodoToUser() {
        System.out.print("사용자의 이름을 입력하세요: ");
        String targetname = s.nextLine();
        for (Users target : userlist) {
            if (target.getName().equals(targetname)) {
                System.out.println("추가할 할일 카테고리 번호를 고르세요(1.운동, 2.학업, 3.그외");
                int category = s.nextInt();
                if (category == 1) {
                    target.getList("exercise").addSchedule();
                } else if (category == 2) {
                    target.getList("study").addSchedule();
                } else if (category == 3) {
                    target.getList("other").addSchedule();
                }
            }
            else {
                System.out.println("사용자를 찾을 수 없습니다.");
            }
        }
    }
}