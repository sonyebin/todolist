package forStudy;
import java.util.ArrayList;
import java.util.Scanner;
//투두리스트 프로그램

class Todo {
    Scanner s = new Scanner(System.in);
    public static ArrayList<Todo> todos = new ArrayList<>();
    String todo;
    int day;
    public static int len = 0;

    public Todo() {
    }

    public Todo(String todo, int day) {
        this.todo = todo;
        this.day = day;
    }

    public void addSchedule() {
        System.out.print("할 일을 입력하시오: ");
        todo = s.nextLine();
        System.out.print("마감일을 입력하시오: ");
        day = s.nextInt();
        s.nextLine();
        todos.add(new Todo(todo,day));
        len = 1;
    }

    public void changeSchedule() {
        System.out.print("수정할 일을 입력하시오: ");
        String work = s.nextLine();
        for(Todo newdata : todos){
            if (work.equals(newdata.todo)) {
                System.out.print("할 일을 다시 입력하세요: ");
                String reset = s.nextLine();
                newdata.todo = reset;
                System.out.print("마감일을 다시 입력하세요: ");
                int newday = s.nextInt();
                newdata.day = newday;
            }
        }
    }

    public void finishSchedule() {
        System.out.print("완료한 일을 입력하시오: ");
        String fin = s.nextLine();
        for (Todo finwork : todos){
            if(fin.equals(finwork.todo)){
                finwork.todo = fin+"-완료됨";
            }
        }
    }

    @Override
    public String toString(){
        return todo+" / 마감일: "+day;
    }
}

class Todolist {
    private int i;
    private int j;
    private int temp;
    private int least;
    public void addTodo(){
        Todo todo = new Todo();
        todo.addSchedule();
    }
    public void changeTodo(){
        Todo todo = new Todo();
        todo.changeSchedule();
    }
    public void finishTodo(){
        Todo todo = new Todo();
        todo.finishSchedule();
    }

    public Todolist(){
    }

    public ArrayList<Todo> sortArray() {
        ArrayList<Todo> copies = new ArrayList<>();
        for(Todo data : Todo.todos){
            copies.add(new Todo(data.todo,data.day));
        }
        for(i = 0; i < copies.size() - 1; i++){
            least = i;
            for(j = i+1; j<copies.size(); j++)
                if(copies.get(j).day < copies.get(least).day)
                    least = j;
            Todo temp = copies.get(i);
            copies.set(i, copies.get(least));
            copies.set(least, temp);
        }
        return copies;

    }

    public void view(){
        ArrayList<Todo> copylist = sortArray();
        if (Todo.len == 0) {
            System.out.println("할 일이 없습니다.");
        }
        else{
            for(Todo list : copylist){
                System.out.println(list);
            }
        }
    }
}

public class Project1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Todolist play = new Todolist();

        int ans = 0;
        while(true){
            System.out.println("----투두리스트----");
            System.out.println("1. 투두리스트 확인");
            System.out.println("2. 할 일 추가");
            System.out.println("3. 할 일 완료");
            System.out.println("4. 할 일 수정");
            System.out.println("5. 종료");
            System.out.print("번호를 입력하시오: ");
            ans = s.nextInt();
            if (ans==1)
                play.view();
            else if (ans==2){
                play.addTodo();
                s.nextLine();
            }
            else if (ans==3){
                play.finishTodo();
                s.nextLine();
            }
            else if (ans==4){
                play.changeTodo();
                s.nextLine();
            }
            else if (ans==5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else
                System.out.println("잘못된 입력입니다. 번호를 다시 확인해 주세요.");
        }
    }
}
