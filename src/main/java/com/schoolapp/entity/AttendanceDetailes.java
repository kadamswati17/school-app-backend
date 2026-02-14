package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AttendanceDetailes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendanceId;
	private int sId;
	private int teacherId;
	private int subjectId;
	private int classId;
	private int divId;
	private String time;
	private int year;
	private String month;

	private int d1;
	private int d2;
	private int d3;
	private int d4;
	private int d5;
	private int d6;
	private int d7;
	private int d8;
	private int d9;
	private int d10;
	private int d11;
	private int d12;
	private int d13;
	private int d14;
	private int d15;
	private int d16;
	private int d17;
	private int d18;
	private int d19;
	private int d20;
	private int d21;
	private int d22;
	private int d23;
	private int d24;
	private int d25;
	private int d26;
	private int d27;
	private int d28;
	private int d29;
	private int d30;
	private int d31;

	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;

	public AttendanceDetailes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendanceDetailes(int attendanceId, int sId, int teacherId, int subjectId, int classId, int divId,
			String time, int year, String month, int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9,
			int d10, int d11, int d12, int d13, int d14, int d15, int d16, int d17, int d18, int d19, int d20, int d21,
			int d22, int d23, int d24, int d25, int d26, int d27, int d28, int d29, int d30, int d31, int userId,
			int orgId, int branchId, Date createdDate, int updatedBy, Date updatedDate, int isActive) {
		super();
		this.attendanceId = attendanceId;
		this.sId = sId;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.classId = classId;
		this.divId = divId;
		this.time = time;
		this.year = year;
		this.month = month;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
		this.d4 = d4;
		this.d5 = d5;
		this.d6 = d6;
		this.d7 = d7;
		this.d8 = d8;
		this.d9 = d9;
		this.d10 = d10;
		this.d11 = d11;
		this.d12 = d12;
		this.d13 = d13;
		this.d14 = d14;
		this.d15 = d15;
		this.d16 = d16;
		this.d17 = d17;
		this.d18 = d18;
		this.d19 = d19;
		this.d20 = d20;
		this.d21 = d21;
		this.d22 = d22;
		this.d23 = d23;
		this.d24 = d24;
		this.d25 = d25;
		this.d26 = d26;
		this.d27 = d27;
		this.d28 = d28;
		this.d29 = d29;
		this.d30 = d30;
		this.d31 = d31;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getDivId() {
		return divId;
	}

	public void setDivId(int divId) {
		this.divId = divId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getD1() {
		return d1;
	}

	public void setD1(int d1) {
		this.d1 = d1;
	}

	public int getD2() {
		return d2;
	}

	public void setD2(int d2) {
		this.d2 = d2;
	}

	public int getD3() {
		return d3;
	}

	public void setD3(int d3) {
		this.d3 = d3;
	}

	public int getD4() {
		return d4;
	}

	public void setD4(int d4) {
		this.d4 = d4;
	}

	public int getD5() {
		return d5;
	}

	public void setD5(int d5) {
		this.d5 = d5;
	}

	public int getD6() {
		return d6;
	}

	public void setD6(int d6) {
		this.d6 = d6;
	}

	public int getD7() {
		return d7;
	}

	public void setD7(int d7) {
		this.d7 = d7;
	}

	public int getD8() {
		return d8;
	}

	public void setD8(int d8) {
		this.d8 = d8;
	}

	public int getD9() {
		return d9;
	}

	public void setD9(int d9) {
		this.d9 = d9;
	}

	public int getD10() {
		return d10;
	}

	public void setD10(int d10) {
		this.d10 = d10;
	}

	public int getD11() {
		return d11;
	}

	public void setD11(int d11) {
		this.d11 = d11;
	}

	public int getD12() {
		return d12;
	}

	public void setD12(int d12) {
		this.d12 = d12;
	}

	public int getD13() {
		return d13;
	}

	public void setD13(int d13) {
		this.d13 = d13;
	}

	public int getD14() {
		return d14;
	}

	public void setD14(int d14) {
		this.d14 = d14;
	}

	public int getD15() {
		return d15;
	}

	public void setD15(int d15) {
		this.d15 = d15;
	}

	public int getD16() {
		return d16;
	}

	public void setD16(int d16) {
		this.d16 = d16;
	}

	public int getD17() {
		return d17;
	}

	public void setD17(int d17) {
		this.d17 = d17;
	}

	public int getD18() {
		return d18;
	}

	public void setD18(int d18) {
		this.d18 = d18;
	}

	public int getD19() {
		return d19;
	}

	public void setD19(int d19) {
		this.d19 = d19;
	}

	public int getD20() {
		return d20;
	}

	public void setD20(int d20) {
		this.d20 = d20;
	}

	public int getD21() {
		return d21;
	}

	public void setD21(int d21) {
		this.d21 = d21;
	}

	public int getD22() {
		return d22;
	}

	public void setD22(int d22) {
		this.d22 = d22;
	}

	public int getD23() {
		return d23;
	}

	public void setD23(int d23) {
		this.d23 = d23;
	}

	public int getD24() {
		return d24;
	}

	public void setD24(int d24) {
		this.d24 = d24;
	}

	public int getD25() {
		return d25;
	}

	public void setD25(int d25) {
		this.d25 = d25;
	}

	public int getD26() {
		return d26;
	}

	public void setD26(int d26) {
		this.d26 = d26;
	}

	public int getD27() {
		return d27;
	}

	public void setD27(int d27) {
		this.d27 = d27;
	}

	public int getD28() {
		return d28;
	}

	public void setD28(int d28) {
		this.d28 = d28;
	}

	public int getD29() {
		return d29;
	}

	public void setD29(int d29) {
		this.d29 = d29;
	}

	public int getD30() {
		return d30;
	}

	public void setD30(int d30) {
		this.d30 = d30;
	}

	public int getD31() {
		return d31;
	}

	public void setD31(int d31) {
		this.d31 = d31;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "AttendanceDetailes [attendanceId=" + attendanceId + ", sId=" + sId + ", teacherId=" + teacherId
				+ ", subjectId=" + subjectId + ", classId=" + classId + ", divId=" + divId + ", time=" + time
				+ ", year=" + year + ", month=" + month + ", d1=" + d1 + ", d2=" + d2 + ", d3=" + d3 + ", d4=" + d4
				+ ", d5=" + d5 + ", d6=" + d6 + ", d7=" + d7 + ", d8=" + d8 + ", d9=" + d9 + ", d10=" + d10 + ", d11="
				+ d11 + ", d12=" + d12 + ", d13=" + d13 + ", d14=" + d14 + ", d15=" + d15 + ", d16=" + d16 + ", d17="
				+ d17 + ", d18=" + d18 + ", d19=" + d19 + ", d20=" + d20 + ", d21=" + d21 + ", d22=" + d22 + ", d23="
				+ d23 + ", d24=" + d24 + ", d25=" + d25 + ", d26=" + d26 + ", d27=" + d27 + ", d28=" + d28 + ", d29="
				+ d29 + ", d30=" + d30 + ", d31=" + d31 + ", userId=" + userId + ", orgId=" + orgId + ", branchId="
				+ branchId + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + ", isActive=" + isActive + "]";
	}

}
