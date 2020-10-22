import java.util.ArrayList;
import java.util.Scanner;

import DAO.DepartmentDao;
import DTO.Department;

public class Program {

	public static void main(String[] args) {
		DepartmentDao departmentdata = new DepartmentDao();
		while(true)
		{
					String selection = menu();
					//System.out.println(selection);
					switch (selection)
					{
						case "1": //목록
							    ArrayList<Department> departments = departmentdata.GetDepartmentList();
							    DepartmentPrint(departments);
								break;
						case "2": //등록
								Department dept = new Department();
								InputDepartment(dept, false);
								int row = departmentdata.InsertDepartment(dept);
								System.out.println("INSERT ROW : " + row);
								System.out.println("INSERT DATA : " + dept.getDeptno() + " : " + dept.getDname());
							    break;
						case "3": //변경 (기존 부서명 변경)
							    System.out.print("변경할 부서명 :");
							    String deptname = scanner.nextLine();
							    ArrayList<Department> departments2 = departmentdata.GetDepartmentListByDname(deptname);
							    	if(DepartmentPrint(departments2,"부서변경검색") > 0)
							    	{
							    		System.out.println("[부서 변경 정보 입력]");
									    Department update = new Department();
									    InputDepartment(update, false);
									    int updaterow =departmentdata.UpdateDepartment(update);
									    System.out.println("변경된 ROW : " + updaterow);
							    	}
							    break;
						case "4" : //삭제
								 System.out.print("삭제할 부서명 :");
								 String deptname4 = scanner.nextLine();
								 ArrayList<Department> departments4 = departmentdata.GetDepartmentListByDname(deptname4);
									if(DepartmentPrint(departments4,"부서삭제검색") > 0)
							    	{
										System.out.print("삭제할 부서 코드:");
										String deptcode = scanner.nextLine();
										int deleterow = departmentdata.DeleteDepartment(Integer.parseInt(deptcode));
										System.out.println("삭제된 row : " + deleterow);
							    	}	
							    break;
						case "5" : //검색
							    System.out.print("검색할 부서명:"); 
							    String deptname5 = scanner.nextLine();
							    ArrayList<Department> departments5 = departmentdata.GetDepartmentListByDname(deptname5);
							    DepartmentPrint(departments5,"검색부서");
								break;
							    
						case "6" : //종료	
							System.out.println("프로그램 종료");
							return;
					}
	
		}

	}
	private static Scanner scanner = new Scanner(System.in);
	private static String menu(){
		System.out.println("**********************");
		System.out.println("*1.부서목록");
		System.out.println("*2.부서등록");
		System.out.println("*3.부서변경");
		System.out.println("*4.부서삭제");
		System.out.println("*5.부서검색");
		System.out.println("*6.프로그램종료");
		System.out.println("**********************");
		System.out.print("작업번호선택:");
		return scanner.nextLine();
	}
	private static void InputDepartment(Department department , boolean update){
		if(!update){ //update false 값을 가지면 IF
			System.out.print("부서코드:");
			department.setDeptno(Integer.parseInt(scanner.nextLine()));
		}
		System.out.print("부서이름:");
		department.setDname(scanner.nextLine());
	}
	private static void DepartmentPrint(ArrayList<Department> list){
		for(Department d : list){
			System.out.printf("[%d][%s]\n",d.getDeptno(), d.getDname());
		}
	}
	private static int  DepartmentPrint(ArrayList<Department> list , String Find){
		 int FineRowCount=0;
		 if(list.size() > 0)
		 {
			 for(int i =0 ; i < list.size() ; i++)
		    	{   
				 	FineRowCount++;
		    		System.out.println(list.get(i).toString());
		    	}
		 }
		 else
		 {
			 System.out.println(Find + "FAIL");
		 }
		 
		 return  FineRowCount;
	}
	
}
