package io.renren.modules.hbctc.entity;

import java.io.Serializable;

import org.apache.poi.hssf.util.HSSFColor;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;

@ExcelSheet(name = "资金来源", headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class FundFrom implements Serializable {
	

	@ExcelField(name = "部门名称")
	private String detpname;

	@ExcelField(name = "部门编号")
	private String deptno;

	@ExcelField(name = "资金来源")
	private String moneyway;

	@ExcelField(name = "采购类别")
	private String buyitemtype;

	@ExcelField(name = "金额")
	private Double money;

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetpname() {
		return detpname;
	}

	public void setDetpname(String detpname) {
		this.detpname = detpname == null ? null : detpname.trim();
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno == null ? null : deptno.trim();
	}

	public String getMoneyway() {
		return moneyway;
	}

	public void setMoneyway(String moneyway) {
		this.moneyway = moneyway == null ? null : moneyway.trim();
	}

	public String getBuyitemtype() {
		return buyitemtype;
	}

	public void setBuyitemtype(String buyitemtype) {
		this.buyitemtype = buyitemtype == null ? null : buyitemtype.trim();
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public FundFrom() {
		super();
	}

	public FundFrom(String detpname, String deptno, String moneyway, String buyitemtype, Double money) {
		super();
		this.detpname = detpname;
		this.deptno = deptno;
		this.moneyway = moneyway;
		this.buyitemtype = buyitemtype;
		this.money = money;
	}
	
	public FundFrom(Double money, Integer id) {
		super();
		this.money = money;
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", detpname=").append(detpname);
		sb.append(", deptno=").append(deptno);
		sb.append(", moneyway=").append(moneyway);
		sb.append(", buyitemtype=").append(buyitemtype);
		sb.append(", money=").append(money);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyitemtype == null) ? 0 : buyitemtype.hashCode());
		result = prime * result + ((deptno == null) ? 0 : deptno.hashCode());
		result = prime * result + ((detpname == null) ? 0 : detpname.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((moneyway == null) ? 0 : moneyway.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FundFrom other = (FundFrom) obj;
		if (buyitemtype == null) {
			if (other.buyitemtype != null)
				return false;
		} else if (!buyitemtype.equals(other.buyitemtype))
			return false;
		if (deptno == null) {
			if (other.deptno != null)
				return false;
		} else if (!deptno.equals(other.deptno))
			return false;
		if (detpname == null) {
			if (other.detpname != null)
				return false;
		} else if (!detpname.equals(other.detpname))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (moneyway == null) {
			if (other.moneyway != null)
				return false;
		} else if (!moneyway.equals(other.moneyway))
			return false;
		return true;
	}
}