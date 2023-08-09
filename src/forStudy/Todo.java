package forStudy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Todo {
    Scanner s = new Scanner(System.in);
    String todo;
    int day;
    public static int len = 0;
    LocalDate limitdate;

    public Todo() {
    }

    public Todo(String todo, LocalDate limitdate) {
        this.todo = todo;
        this.limitdate = limitdate;
    }


    public void addSchedule(ArrayList<Todo> lists) {
        s.nextLine();
        System.out.print("할 일을 입력하시오: ");
        todo = s.nextLine();
        System.out.print("마감일을 입력하시오: ");
        day = s.nextInt();
        this.limitdate = LocalDate.of(2023, 8, day);
        lists.add(new Todo(todo,limitdate));
    }

    public void changeSchedule(ArrayList<Todo> lists) {
        s.nextLine();
        System.out.print("수정할 일을 입력하시오: ");
        String work = s.nextLine();
        for(Todo newdata : lists){
            if (work.equals(newdata.todo)) {
                System.out.print("할 일을 다시 입력하세요: ");
                newdata.todo = s.nextLine();
                System.out.print("마감일을 다시 입력하세요: ");
                int newday = s.nextInt();
                newdata.limitdate = LocalDate.of(2023,8,newday);
            }
        }
    }

    public void finishSchedule(ArrayList<Todo> lists) {
        s.nextLine();
        LocalDate today = LocalDate.now();
        System.out.print("완료한 일을 입력하시오: ");
        String fin = s.nextLine();
        for (Todo finwork : lists) {
            int comparisonResult = today.compareTo(finwork.limitdate);
            if (fin.equals(finwork.todo)) {
                if (comparisonResult > 0) {
                    System.out.println("날짜가 이미 지났습니다.");
                    finwork.todo = fin + "-기한지남";
                } else {
                    finwork.todo = fin + "-완료됨";
                }
            }
        }
        s.nextLine();
    }


    @Override
    public String toString(){
        return todo+" / 마감일: "+limitdate;
    }
}
