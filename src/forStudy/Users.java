package forStudy;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
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
        String name = s.next();
        userlist.add(new Users(name));
    }

    public String getName() {
        return name;
    }


    public void viewTodoToUser() {
        System.out.print("사용자의 이름을 입력하세요: ");
        String targetname = s.next();
        for (Users target : userlist) {
            if (target.getName().equals(targetname)) {
                System.out.print("확인할 카테고리 번호를 고르세요(1.운동, 2.학업, 3.그외): ");
                int category = s.nextInt();
                if (category == 1) {
                    target.exercises.view(Todolist.exerciselist);
                } else if (category == 2) {
                    target.studies.view(Todolist.studylist);
                } else if (category == 3) {
                    target.others.view(Todolist.otherlist);
                }
            }
        }
    }
    public void finishUserTodo() {
        System.out.print("사용자의 이름을 입력하세요: ");
        String targetname = s.next();
        for (Users target : userlist) {
            if (target.getName().equals(targetname)) {
                System.out.print("완료할 할일 카테고리 번호를 고르세요(1.운동, 2.학업, 3.그외): ");
                int category = s.nextInt();
                if (category == 1) {
                    target.exercises.finishSchedule(Todolist.exerciselist);
                } else if (category == 2) {
                    target.studies.finishSchedule(Todolist.studylist);
                } else if (category == 3) {
                    target.others.finishSchedule(Todolist.otherlist);
                }
            }
        }
    }
    public void changeUserTodo() {
        System.out.print("사용자의 이름을 입력하세요: ");
        String targetname = s.next();
        for (Users target : userlist) {
            if (target.getName().equals(targetname)) {
                System.out.print("추가할 할일 카테고리 번호를 고르세요(1.운동, 2.학업, 3.그외): ");
                int category = s.nextInt();
                if (category == 1) {
                    target.exercises.changeSchedule(Todolist.exerciselist);
                } else if (category == 2) {
                    target.studies.changeSchedule(Todolist.studylist);
                } else if (category == 3) {
                    target.others.changeSchedule(Todolist.otherlist);
                }
            }
        }
    }
    public void addTodoToUser() {
        System.out.print("사용자의 이름을 입력하세요: ");
        String targetname = s.next();
        for (Users target : userlist) {
            if (target.getName().equals(targetname)) {
                System.out.print("추가할 할일 카테고리 번호를 고르세요(1.운동, 2.학업, 3.그외): ");
                int category = s.nextInt();
                if (category == 1) {
                    target.exercises.addSchedule(Todolist.exerciselist);
                } else if (category == 2) {
                    target.studies.addSchedule(Todolist.studylist);
                } else if (category == 3) {
                    target.others.addSchedule(Todolist.otherlist);
                }
            }
        }
    }
}