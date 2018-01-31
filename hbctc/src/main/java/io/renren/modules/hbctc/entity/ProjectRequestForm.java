package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.List;

public class ProjectRequestForm implements Serializable {
	private Integer id;

	private String dept;

	private String deptpeo;

	private String deptpeoinfo;

	private String projectname;

	private String projectcontact;

	private String projectpeoinfo;

	private String buyway;

	private String moneyway;

	private Double premoney;

	private Double questmoney;
	
	List<BuyItemInfo> buyItemInfos;// 采购项目需求

	private Double totalmoney;

	private String others;

	public ProjectRequestForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectRequestForm(String dept, String deptpeo, String deptpeoinfo, String projectname,
			String projectcontact, String projectpeoinfo, String buyway, String moneyway, Double premoney,
			Double questmoney, List<BuyItemInfo> buyItemInfos, Double totalmoney, String others) {
		super();
		this.dept = dept;
		this.deptpeo = deptpeo;
		this.deptpeoinfo = deptpeoinfo;
		this.projectname = projectname;
		this.projectcontact = projectcontact;
		this.projectpeoinfo = projectpeoinfo;
		this.buyway = buyway;
		this.moneyway = moneyway;
		this.premoney = premoney;
		this.questmoney = questmoney;
		this.buyItemInfos = buyItemInfos;
		this.totalmoney = totalmoney;
		this.others = others;
	}

	
	
	public ProjectRequestForm(String dept, String deptpeo, String deptpeoinfo, String projectname,
			String projectcontact, String projectpeoinfo, String buyway, String moneyway, Double premoney,
			Double questmoney, Double totalmoney, String others) {
		super();
		this.dept = dept;
		this.deptpeo = deptpeo;
		this.deptpeoinfo = deptpeoinfo;
		this.projectname = projectname;
		this.projectcontact = projectcontact;
		this.projectpeoinfo = projectpeoinfo;
		this.buyway = buyway;
		this.moneyway = moneyway;
		this.premoney = premoney;
		this.questmoney = questmoney;
		this.totalmoney = totalmoney;
		this.others = others;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDeptpeo() {
		return deptpeo;
	}

	public void setDeptpeo(String deptpeo) {
		this.deptpeo = deptpeo;
	}

	public String getDeptpeoinfo() {
		return deptpeoinfo;
	}

	public void setDeptpeoinfo(String deptpeoinfo) {
		this.deptpeoinfo = deptpeoinfo;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectcontact() {
		return projectcontact;
	}

	public void setProjectcontact(String projectcontact) {
		this.projectcontact = projectcontact;
	}

	public String getProjectpeoinfo() {
		return projectpeoinfo;
	}

	public void setProjectpeoinfo(String projectpeoinfo) {
		this.projectpeoinfo = projectpeoinfo;
	}

	public String getBuyway() {
		return buyway;
	}

	public void setBuyway(String buyway) {
		this.buyway = buyway;
	}

	public String getMoneyway() {
		return moneyway;
	}

	public void setMoneyway(String moneyway) {
		this.moneyway = moneyway;
	}

	public Double getPremoney() {
		return premoney;
	}

	public void setPremoney(Double premoney) {
		this.premoney = premoney;
	}

	public Double getQuestmoney() {
		return questmoney;
	}

	public void setQuestmoney(Double questmoney) {
		this.questmoney = questmoney;
	}

	public List<BuyItemInfo> getBuyItemInfos() {
		return buyItemInfos;
	}

	public void setBuyItemInfos(List<BuyItemInfo> buyItemInfos) {
		this.buyItemInfos = buyItemInfos;
	}

	public Double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@Override
	public String toString() {
		return "ProjectRequestForm [id=" + id + ", dept=" + dept + ", deptpeo=" + deptpeo + ", deptpeoinfo="
				+ deptpeoinfo + ", projectname=" + projectname + ", projectcontact=" + projectcontact
				+ ", projectpeoinfo=" + projectpeoinfo + ", buyway=" + buyway + ", moneyway=" + moneyway + ", premoney="
				+ premoney + ", questmoney=" + questmoney + ", buyItemInfos=" + buyItemInfos + ", totalmoney="
				+ totalmoney + ", others=" + others + "]";
	}
}