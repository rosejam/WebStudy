package com.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vue.vo.Dept;
import com.vue.vo.DeptCount;
import com.vue.vo.DeptEmp;
import com.vue.vo.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	SqlSession session;
	
	@Override
	public List<Emp> findAllEmps() throws Exception {//모든 직원 정보
		return session.selectList("employee.findAllEmps");
	}

	@Override
	public Emp findEmpById(String id) throws Exception {//id기준으로 직원 한사람 정보 리턴
		return session.selectOne("employee.findEmpById", id);
	}

	@Override
	public int getEmpsTotal() throws Exception {//모든 직원수 리턴(카운트)
		return session.selectOne("employee.getEmpsTotal");
	}

	@Override
	public List<Emp> findLikeEmps(String name) throws Exception {//이름으로 like 검색
		return session.selectList("employee.findLikeEmps", name);
	}

	@Override
	public List<Dept> findAllDepts() throws Exception {//모든 부서 정보 리턴
		return session.selectList("employee.findAllDepts");
	}

	@Override
	public List<Emp> findAllTitles() throws Exception {//emp테이블에서 title만 검색해 리턴(중복제거!)
		return session.selectList("employee.findAllTitles");
	}

	@Override
	public int addEmp(Emp emp) throws Exception {//새 직원 추가
		return session.insert("employee.addEmp", emp);
	}

	@Override
	public int updateEmp(Emp emp) throws Exception {//직원정보 수정
		return session.update("employee.updateEmp", emp);
	}

	@Override
	public int deleteEmp(String id) throws Exception {//id기준 직원정보 삭제
		return session.delete("employee.deleteEmp", id);
	}

	
	@Override
	public List<Emp> findEmpByMgrId(int managerId) {
		return session.selectList("employee.findEmpByMgrId", managerId);
	}

	@Override
	public List<DeptEmp> findAllDeptEmps() {
		return session.selectList("employee.findAllDeptEmps");
	}

	@Override
	public List<DeptCount> findAllDepCounts() {
		return session.selectList("employee.findAllDepCounts");
	}

	@Override
	public List<Emp> findDeptByname(String name) {
		return session.selectList("employee.findDeptByname", name);
	}

	@Override
	public List<Emp> findDeptBydeptid(int dept_id) {
		return session.selectList("employee.findDeptBydeptid", dept_id);
	}

}
