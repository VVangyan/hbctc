package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectRequestForm implements Serializable {
	private Integer id;

	private String dept;// 项目申报部门

	private String deptpeo;// 项目申报部门负责人

	private String deptpeoinfo;// 联系方式

	private String projectname;// 项目名称

	private String projectcontact;// 项目联系人

	private String projectpeoinfo;// 联系方式

	private String buyway;// 采购方式

	private String moneyway;// 资金来源

	private Double premoney;// 预算项目金额（元)

	private Double questmoney;// 申请项目金额（元）

	List<BuyItemInfo> buyItemInfos;// 采购项目需求

	private Double totalmoney;// 合计金额（元）

	private String others;// 其他说明

	private Date createdate;// 创建时间

	private Date updatedate;// 修改时间

	private Integer stepstatus;// 步骤 0:项目负责人审核中,
								// 1：项目负责人审核通过,2：业务经办人审核通过,3：业务负责人审核通过
								// 4：项目负责人审核失败,5：业务经办人审核失败,6： 业务负责人审核失败

	private Integer isten;// 是否是10万以上

	private Integer bh1;// 编号1
	private Integer bh2;// 编号2

	private String agentno;// 代理机构编号

	public ProjectRequestForm() {
		super();
	}

	public ProjectRequestForm(String dept, String deptpeo, String deptpeoinfo, String projectname,
			String projectcontact, String projectpeoinfo, String buyway, String moneyway, Double premoney,
			Double questmoney, Double totalmoney, String others, Date createdate, Date updatedate, Integer stepstatus,
			Integer isten, Integer bh1, Integer bh2, String agentno) {
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
		this.createdate = createdate;
		this.updatedate = updatedate;
		this.stepstatus = stepstatus;
		this.isten = isten;
		this.bh1 = bh1;
		this.bh2 = bh2;
		this.agentno = agentno;
	}

	public ProjectRequestForm(String dept, String deptpeo, String deptpeoinfo, String projectname,
			String projectcontact, String projectpeoinfo, String buyway, String moneyway, Double premoney,
			Double questmoney, Double totalmoney, String others, Date createdate, Date updatedate, Integer stepstatus,
			Integer isten, Integer bh1, Integer bh2) {
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
		this.createdate = createdate;
		this.updatedate = updatedate;
		this.stepstatus = stepstatus;
		this.isten = isten;
		this.bh1 = bh1;
		this.bh2 = bh2;
	}

	public ProjectRequestForm(String dept, String deptpeo, String deptpeoinfo, String projectname,
			String projectcontact, String projectpeoinfo, String buyway, String moneyway, Double premoney,
			Double questmoney, Double totalmoney, String others, Date createdate, Date updatedate, Integer stepstatus,
			Integer isten) {
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
		this.createdate = createdate;
		this.updatedate = updatedate;
		this.stepstatus = stepstatus;
		this.isten = isten;
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

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Integer getStepstatus() {
		return stepstatus;
	}

	public void setStepstatus(Integer stepstatus) {
		this.stepstatus = stepstatus;
	}

	public Integer getIsten() {
		return isten;
	}

	public void setIsten(Integer isten) {
		this.isten = isten;
	}

	public Integer getBh1() {
		return bh1;
	}

	public void setBh1(Integer bh1) {
		this.bh1 = bh1;
	}

	public Integer getBh2() {
		return bh2;
	}

	public void setBh2(Integer bh2) {
		this.bh2 = bh2;
	}

	public String getAgentno() {
		return agentno;
	}

	public void setAgentno(String agentno) {
		this.agentno = agentno;
	}

	@Override
	public String toString() {
		return "ProjectRequestForm [id=" + id + ", dept=" + dept + ", deptpeo=" + deptpeo + ", deptpeoinfo="
				+ deptpeoinfo + ", projectname=" + projectname + ", projectcontact=" + projectcontact
				+ ", projectpeoinfo=" + projectpeoinfo + ", buyway=" + buyway + ", moneyway=" + moneyway + ", premoney="
				+ premoney + ", questmoney=" + questmoney + ", buyItemInfos=" + buyItemInfos + ", totalmoney="
				+ totalmoney + ", others=" + others + ", createdate=" + createdate + ", updatedate=" + updatedate
				+ ", stepstatus=" + stepstatus + ", isten=" + isten + ", bh1=" + bh1 + ", bh2=" + bh2 + ", agentno="
				+ agentno + "]";
	}
}