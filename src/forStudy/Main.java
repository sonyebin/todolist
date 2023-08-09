package forStudy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Users user = new Users();

        int ans = 0;
        while(true){
            System.out.println("----투두리스트----");
            System.out.println("1. 사용자 추가");
            System.out.println("2. 투두리스트 확인");
            System.out.println("3. 할 일 추가");
            System.out.println("4. 할 일 완료");
            System.out.println("5. 할 일 수정");
            System.out.println("6. 종료");
            System.out.print("번호를 입력하시오: ");
            ans = s.nextInt();
            s.nextLine();
            if (ans==1) {
                user.addUser(); }
            else if (ans==2){
                user.viewTodoToUser();
            } else if (ans==3){
                user.addTodoToUser();
            }
            else if (ans==4){
                user.finishUserTodo();
            }
            else if (ans==5){
                user.changeUserTodo();
            }
            else if (ans==6) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else
                System.out.println("잘못된 입력입니다. 번호를 다시 확인해 주세요.");
        }
    }
}
