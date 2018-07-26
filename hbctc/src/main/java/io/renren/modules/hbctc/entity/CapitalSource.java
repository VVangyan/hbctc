package io.renren.modules.hbctc.entity;

import java.io.Serializable;

public class CapitalSource implements Serializable {
    private Integer id;

    /**
     * 资金来源编号
     */
    private Integer csid;
    /**
     * 资金来源
     */
    private String moneyway;
    /**
     * 预算金额
     */
    private Double premoney;
    /**
     * 申请项目资金
     */
    private Double questmoney;

    private Integer preid;

    private static final long serialVersionUID = 1L;
    
    public CapitalSource() {
		super();
	}
    
	public CapitalSource(Integer csid, String moneyway, Double premoney, Double questmoney) {
		super();
		this.csid = csid;
		this.moneyway = moneyway;
		this.premoney = premoney;
		this.questmoney = questmoney;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getMoneyway() {
        return moneyway;
    }

    public void setMoneyway(String moneyway) {
        this.moneyway = moneyway == null ? null : moneyway.trim();
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

    public Integer getPreid() {
        return preid;
    }

    public void setPreid(Integer preid) {
        this.preid = preid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", csid=").append(csid);
        sb.append(", moneyway=").append(moneyway);
        sb.append(", premoney=").append(premoney);
        sb.append(", questmoney=").append(questmoney);
        sb.append(", preid=").append(preid);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CapitalSource other = (CapitalSource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCsid() == null ? other.getCsid() == null : this.getCsid().equals(other.getCsid()))
            && (this.getMoneyway() == null ? other.getMoneyway() == null : this.getMoneyway().equals(other.getMoneyway()))
            && (this.getPremoney() == null ? other.getPremoney() == null : this.getPremoney().equals(other.getPremoney()))
            && (this.getQuestmoney() == null ? other.getQuestmoney() == null : this.getQuestmoney().equals(other.getQuestmoney()))
            && (this.getPreid() == null ? other.getPreid() == null : this.getPreid().equals(other.getPreid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCsid() == null) ? 0 : getCsid().hashCode());
        result = prime * result + ((getMoneyway() == null) ? 0 : getMoneyway().hashCode());
        result = prime * result + ((getPremoney() == null) ? 0 : getPremoney().hashCode());
        result = prime * result + ((getQuestmoney() == null) ? 0 : getQuestmoney().hashCode());
        result = prime * result + ((getPreid() == null) ? 0 : getPreid().hashCode());
        return result;
    }
}