import java.util.ArrayList;
import java.util.Scanner;
//1
//2
//报名入学接口
interface ISignUp{
    // 打印输出结果
    public void print();
    // 检查是否有 stuType对应的班级名额
    // 如果没有剩余名额，请返回 false ，否则学生将报名进入该班级并返回 true
    public boolean addStudent (int stuType);
    // 解析命令行输入的参数（格式），如文档描述
    public static IParams parse() throws Exception{
		final Scanner reader = new Scanner(System.in);
        System.out.print("大班名额：");
        SchoolSystem.big = reader.nextInt();
        System.out.print("中班名额：");
        SchoolSystem.middle = reader.nextInt();
        System.out.print("小班名额：");
        SchoolSystem.small = reader.nextInt();
        IParams ip = new IParams() {
            public int getBig() {
                return SchoolSystem.big;
            }

            public int getMedium() {
                return SchoolSystem.middle;
            }

            public int getSmall() {
                return SchoolSystem.small;
            }

            public ArrayList<Integer> getPlanSignUp() {
                ArrayList<Integer> input = new ArrayList();
                System.out.print("进入班级：");
                Integer a = reader.nextInt();
                input.add(a);
                System.out.print("进入班级：");
                Integer b = reader.nextInt();
                input.add(b);
                System.out.print("进入班级：");
                Integer c = reader.nextInt();
                input.add(c);
                System.out.print("进入班级：");
                Integer d = reader.nextInt();
                input.add(d);
                return input;
            }
        };
        return ip;

    }
}
interface IParams {
    // 获取大班名额
    public int getBig();
    // 获取中班名额
    public int getMedium();
    // 获取小班名额
    public int getSmall();
    // 获取入学序列，例如 [1 2 2 3] 表示 依次报名入学一名大班学生，中班学生，中班学生，小班学生
    public ArrayList<Integer> getPlanSignUp ();
}

public class SchoolSystem implements ISignUp {
	 public static int big = 0;
    public static int middle = 0;
    public static int small = 0;
    public String operation;
    public int tempcou = 0;
    public static boolean[] result;

    public SchoolSystem() {
        this.operation = null;
    }
	public SchoolSystem(int b, int m, int s) {
        big = b;
        middle = m;
        small = s;
        result = new boolean[4];
    }

    public SchoolSystem(int b, int m, int s) {
        big = b;
        middle = m;
        small = s;
        result = new boolean[4];
    }


    public static void main(String[] args) throws Exception {
        IParams params = ISignUp.parse();//SchoolSystem.parse();
        SchoolSystem sc = new SchoolSystem(params.getBig(), params.getMedium(), params.getSmall());
        ArrayList<Integer> plan = params.getPlanSignUp();
        for (int i = 0; i < plan.size(); i++) {
            sc.addStudent(plan.get(i));
        }
        sc.print();
    }
	public void print() {
        System.out.print("[");
        System.out.print("null,");

        for(int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + ",");
        }

        System.out.print("]");
    }
	    public boolean addStudent(int stuType) {
        if (stuType == 1 && big > 0) {
            --big;
            return true;
        } else if (stuType == 2 && middle > 0) {
            --middle;
            return true;
        } else if (stuType == 3 && small > 0) {
            --small;
            return true;
        } else {
            return false;
        }
    }
	
}

}