package forStudy;

import java.util.Scanner;

public class Main {
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
