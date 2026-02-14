package com.schoolapp.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.schoolapp.entity.Admission;
import com.schoolapp.service.AdmissionService;

@RestController
@RequestMapping("/admission")
@CrossOrigin(origins = "*")
public class AdmissionController {
	@Autowired
	AdmissionService admissionService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file)
			throws ClassNotFoundException, SQLException {

		return admissionService.uploadImage(file);
	}

	@PostMapping("/save")
	public String saveAdmission(@RequestBody Admission admission )
			throws ClassNotFoundException, SQLException {
		admissionService.saveAdmission(admission);
		return "Record save successfully";
	}

	@PostMapping("/getAll")
	public String getAllAdmission(@RequestBody Admission admission) throws ClassNotFoundException, SQLException {

		return admissionService.getAllAdmission(admission);
	}

	@PostMapping("/getAllStudentClassWise")
	public String getAllStudentClassWise(@RequestBody Admission admission) throws ClassNotFoundException, SQLException {
		return admissionService.getAllStudentClassWise(admission);
	}

	@PostMapping("/getPdfBonafied")
	public String getPdfBonafied(@RequestBody Admission admission) throws ClassNotFoundException, SQLException {
		return admissionService.getPdfBonafied(admission);
	}

	@GetMapping("/get")
	public Admission findAdmissionById(@PathVariable int admissionID) {
		return admissionService.findAdmissionById(admissionID);
	}

	@PutMapping("/update")
	public String updateAdmission(@RequestBody Admission admission) throws ClassNotFoundException, SQLException {

		return admissionService.updateAdmission(admission);

	}

	@DeleteMapping("/delete")
	public String deleteAdmissionById(@RequestBody Admission admission) {
		admissionService.deleteAdmissionById(admission.getAdmissionId());
		return "deleted............";
	}

}
