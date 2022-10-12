package com.jbk.Spring_MVC_ERP.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.Spring_MVC_ERP.dao.EmployeeDao;
import com.jbk.Spring_MVC_ERP.entity.Employee;

@Service
public class EmployeeService_impl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee login(Employee employee) {
		Employee emp = dao.login(employee);
		return emp;
	}

	@Override
	public Employee save(Employee employee) {
		// To generate id
		String eid = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		employee.setEid(eid);

		Employee emp = dao.save(employee);
		return emp;
	}

	@Override
	public List<Employee> listofEmployee() {
		List<Employee> list = dao.listofEmployee();
		return list;
	}

	@Override
	public Employee profile(String eid) {
		Employee employee = dao.profile(eid);
		return employee;
	}

	@Override
	public boolean deleteEmployee(String eid) {
//		Employee employee = dao.deleteEmployee(eid)
//		return employee;

		boolean b = dao.deleteEmployee(eid);
		return b;

	}

	@Override
	public boolean updateEmployee(Employee employee) {
		boolean b = dao.updateEmployee(employee);
		return b;
	}

	@Override
	public String uploadSheet(CommonsMultipartFile file, HttpSession httpSession) {
		String msg = null;
		String path = httpSession.getServletContext().getRealPath("/WEB-INF/uploaded");
		System.out.println("path :-" + path);
		String fileName = file.getOriginalFilename();
		System.out.println(path + File.separator + fileName);

		// write operation
		byte[] data = file.getBytes();
		try {
			FileOutputStream fos = new FileOutputStream(new File(path + File.separator + fileName));
			fos.write(data);

			// call readExcel method
			List<Employee> list = readExcel(path + File.separator + fileName);
			msg = dao.saveList(list);
			//System.out.println(list);
			/*
			 * for(Employee emp : list){ System.out.println(emp); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	// read excel
	public List<Employee> readExcel(String filePath) {
		Employee employee = null;
		List<Employee> list = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream(filePath);

			// Workbook
			Workbook workbook = new XSSFWorkbook(fis);
			// get sheet
			Sheet sheet = workbook.getSheetAt(0);
			// rows
			Iterator<Row> rows = sheet.iterator();
			while (rows.hasNext()) {
				employee = new Employee();

				String eid = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
				employee.setEid(eid);

				Row row = rows.next();

				Iterator<Cell> cells = row.iterator();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					int col = cell.getColumnIndex();
					CellType cellType = cell.getCellType();

					if (cellType == cellType.NUMERIC) {
						cell.setCellType(cellType.STRING);
					}

					switch (col) {
					case 0:
						employee.setUsername(cell.getStringCellValue());
						break;
					case 1:
						employee.setPassword(cell.getStringCellValue());
						break;
					case 2:
						employee.setDepartment(cell.getStringCellValue());
						break;
					case 3:
						employee.setSalary(cell.getStringCellValue());
						break;
					case 4:
						employee.setType(cell.getStringCellValue());
						break;
					case 5:
						employee.setQuestion(cell.getStringCellValue());
						break;
					case 6:
						employee.setAnswer(cell.getStringCellValue());
						break;

					default:
						break;
					}
				}
				list.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
