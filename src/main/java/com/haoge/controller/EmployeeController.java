package com.haoge.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haoge.dao.DepartmentDao;
import com.haoge.dao.EmployeeDao;
import com.haoge.entities.Department;
import com.haoge.entities.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	/**
	 * 查詢所有的員工
	 * @param model
	 * @return
	 */
	@GetMapping(value="/emps")
	public String getList(Model model) {
		Collection<Employee> all = employeeDao.getAll();
		model.addAttribute("emps", all);
		return "emp/list";
	}
	/**
	 * 跳转到添加员工页面
	 * @param model
	 * @return
	 */
	@GetMapping(value="/emp")
	public String toAdd(Model model) {
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("dep", departments);
		return "emp/add";
	}
	/**
	 * 添加员工
	 * @param model
	 * @param employee
	 * @return
	 */
	@PostMapping(value="/emp")
	public String addEmp(Model model,Employee employee) {
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/**
	 * 跳转到修改员工页面
	 * @param model1
	 * @param employee
	 * @return
	 */
	@GetMapping(value="/emp/{id}")
	public String toUpd(Model model,@PathVariable("id") Integer id) {
		Employee employee = employeeDao.get(id);
		System.out.println(employee);
		model.addAttribute("emp", employee);
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("dep", departments);
		
		return "emp/add";
	}
	
	/**
	 * 修改员工操作
	 * @param model1
	 * @param employee
	 * @return
	 */
	@PutMapping(value="/emp")
	public String updEmp(Model model,Employee employee) {
		employeeDao.save(employee);
		//重定向到员工列表页面
		return "redirect:/emps";
	}
	
	/**
	 * 删除员工
	 * @param model1
	 * @param employee
	 * @return
	 */
	@DeleteMapping(value="/emp/{id}")
	public String deleteEmp(Model model,@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
}
