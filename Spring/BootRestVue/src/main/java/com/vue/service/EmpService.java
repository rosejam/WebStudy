package com.vue.service;

import java.util.List;

import com.vue.vo.Dept;
import com.vue.vo.DeptCount;
import com.vue.vo.DeptEmp;
import com.vue.vo.Emp;

public interface EmpService {
	
	public List<Emp> findAllEmps() throws Exception;//모든 직원 정보
	public Emp findEmpById(String id) throws Exception;//id기준으로 직원 한사람 정보 리턴
	public int getEmpsTotal() throws Exception;//모든 직원수 리턴
	public List<Emp> findLikeEmps(String name) throws Exception;//이름으로 like 검색
	
	public List<Dept> findAllDepts() throws Exception;//모든 부서 정보 리턴
	public List<Emp> findAllTitles() throws Exception;//emp테이블에서 title만 검색해 리턴(중복제거)
	
	public boolean addEmp(Emp emp) throws Exception;//새 직원 추가
	public boolean updateEmp(Emp emp) throws Exception;//직원정보 수정
	public boolean deleteEmp(String id) throws Exception;//id기준 직원정보 삭제
	
	/*추가*/
	public List<Emp> findEmpByMgrId(int managerId);//managerId에 해당하는 manager를 가지는 직원의 목록을 반환
	public List<DeptEmp> findAllDeptEmps();//직원정보(id, name, mailid)와 함께 부서정보(dept_id, name)를 DeptEmp 목록 형태로 반환
	public List<DeptCount> findAllDepCounts();//부서코드, 이름과 함께 직원수를 DeptCount의 목록 형태로 반환
	public List<Emp> findDeptByname(String name);//부서명에 해당하는 직원들의 목록을 반환
	public List<Emp> findDeptBydeptid(int dept_id);//deptId에 속한 직원들의 목록을 반환
	
}
