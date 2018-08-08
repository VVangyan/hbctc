package io.renren.modules.hbctc.entity;

import java.io.Serializable;

public class UsedMoneyRecord implements Serializable {
    private Integer id;

    private Double usedMoney;

    private Integer fundfromId;

    private Integer projectId;

    private static final long serialVersionUID = 1L;
    
    public UsedMoneyRecord() {
		super();
	}
    
	public UsedMoneyRecord(Double usedMoney, Integer fundfromId, Integer projectId) {
		super();
		this.usedMoney = usedMoney;
		this.fundfromId = fundfromId;
		this.projectId = projectId;
	}
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUsedMoney() {
        return usedMoney;
    }

    public void setUsedMoney(Double usedMoney) {
        this.usedMoney = usedMoney;
    }

    public Integer getFundfromId() {
        return fundfromId;
    }

    public void setFundfromId(Integer fundfromId) {
        this.fundfromId = fundfromId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usedMoney=").append(usedMoney);
        sb.append(", fundfromId=").append(fundfromId);
        sb.append(", projectId=").append(projectId);
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
        UsedMoneyRecord other = (UsedMoneyRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsedMoney() == null ? other.getUsedMoney() == null : this.getUsedMoney().equals(other.getUsedMoney()))
            && (this.getFundfromId() == null ? other.getFundfromId() == null : this.getFundfromId().equals(other.getFundfromId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsedMoney() == null) ? 0 : getUsedMoney().hashCode());
        result = prime * result + ((getFundfromId() == null) ? 0 : getFundfromId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        return result;
    }
}