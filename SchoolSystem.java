import java.util.ArrayList;
//1
//������ѧ�ӿ�
interface ISignUp{
    // ��ӡ������
    public void print();
    // ����Ƿ��� stuType��Ӧ�İ༶����
    // ���û��ʣ������뷵�� false ������ѧ������������ð༶������ true
    public boolean addStudent (int stuType);
    // ��������������Ĳ�������ʽ�������ĵ�����
    public static IParams parse() throws Exception{

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


    public static void main(String[] args) throws Exception {
        IParams params = ISignUp.parse();//SchoolSystem.parse();
        SchoolSystem sc = new SchoolSystem(params.getBig(), params.getMedium(), params.getSmall());
        ArrayList<Integer> plan = params.getPlanSignUp();
        for (int i = 0; i < plan.size(); i++) {
            sc.addStudent(plan.get(i));
        }
        sc.print();
    }

}