import java.util.ArrayList;
import java.util.Scanner;
//1
//2
//������ѧ�ӿ�
interface ISignUp{
    // ��ӡ������
    public void print();
    // ����Ƿ��� stuType��Ӧ�İ༶����
    // ���û��ʣ������뷵�� false ������ѧ������������ð༶������ true
    public boolean addStudent (int stuType);
    // ��������������Ĳ�������ʽ�������ĵ�����
    public static IParams parse() throws Exception{
		final Scanner reader = new Scanner(System.in);
        System.out.print("������");
        SchoolSystem.big = reader.nextInt();
        System.out.print("�а����");
        SchoolSystem.middle = reader.nextInt();
        System.out.print("С�����");
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
                System.out.print("����༶��");
                Integer a = reader.nextInt();
                input.add(a);
                System.out.print("����༶��");
                Integer b = reader.nextInt();
                input.add(b);
                System.out.print("����༶��");
                Integer c = reader.nextInt();
                input.add(c);
                System.out.print("����༶��");
                Integer d = reader.nextInt();
                input.add(d);
                return input;
            }
        };
        return ip;

    }
}
interface IParams {
    // ��ȡ�������
    public int getBig();
    // ��ȡ�а�����
    public int getMedium();
    // ��ȡС������
    public int getSmall();
    // ��ȡ��ѧ���У����� [1 2 2 3] ��ʾ ���α�����ѧһ�����ѧ�����а�ѧ�����а�ѧ����С��ѧ��
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