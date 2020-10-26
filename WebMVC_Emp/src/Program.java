import java.util.List;

import DAO.EmpDao;
import DTO.Emp;

public class Program {

	public static void main(String[] args) {
		
		EmpDao dao = new EmpDao();
		
		System.out.println("[전체조회]*******");
		List<Emp> emplist= dao.getEmpAllList(); //요청
		//화면구성
		if(emplist != null) {
			EmpPrint(emplist);
		}
	}
	public static void EmpPrint(List<Emp> list) {
		for(Emp data : list) {
			System.out.println(data.toString());
		}
	}
}
