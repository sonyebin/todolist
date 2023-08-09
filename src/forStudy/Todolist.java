package forStudy;
import java.util.ArrayList;

public class Todolist extends Todo {
    private int i;
    private int j;
    private int temp;
    private int least;
    public static ArrayList<Todo> todos = new ArrayList<>();
    ArrayList<Todo> exerciselist = new ArrayList<>();
    ArrayList<Todo> studylist = new ArrayList<>();
    ArrayList<Todo> otherlist = new ArrayList<>();
    public Todolist(){
    }
    public ArrayList<Todo> sortArray(ArrayList<Todo> lists) {
        ArrayList<Todo> copies = new ArrayList<>();
        for(Todo data : lists){
            copies.add(new Todo(data.todo,data.limitdate));
        }
        for (int i = 0; i < copies.size() - 1; i++) {
            int least = i;
            for (int j = i + 1; j < copies.size(); j++) {
                if (copies.get(j).limitdate.isBefore(copies.get(least).limitdate)) {
                    least = j;
                }
            }
            Todo temp = copies.get(i);
            copies.set(i, copies.get(least));
            copies.set(least, temp);
        }
        return copies;
    }


    public void view(ArrayList<Todo> lists){
        ArrayList<Todo> copylist = sortArray(lists);
        if (copylist.isEmpty()) {
            System.out.println("할 일이 없습니다.");
        }
        else{
            for(Todo list : copylist){
                System.out.println(list);
            }
        }
    }
}
