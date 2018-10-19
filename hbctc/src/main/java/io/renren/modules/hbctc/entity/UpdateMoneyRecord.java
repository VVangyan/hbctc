package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.Date;

public class UpdateMoneyRecord implements Serializable {
    private Integer id;

    private Double oldMoney;

    private Double newMoney;

    private Integer fundfromId;

    private Integer projectId;

    private Long userId;

    private String username;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
    
    

    public UpdateMoneyRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public UpdateMoneyRecord(Double oldMoney, Double newMoney, Integer fundfromId, Integer projectId, Long userId,
			String username) {
		super();
		this.oldMoney = oldMoney;
		this.newMoney = newMoney;
		this.fundfromId = fundfromId;
		this.projectId = projectId;
		this.userId = userId;
		this.username = username;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(Double oldMoney) {
        this.oldMoney = oldMoney;
    }

    public Double getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", oldMoney=").append(oldMoney);
        sb.append(", newMoney=").append(newMoney);
        sb.append(", fundfromId=").append(fundfromId);
        sb.append(", projectId=").append(projectId);
        sb.append(", userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", updateTime=").append(updateTime);
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
        UpdateMoneyRecord other = (UpdateMoneyRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOldMoney() == null ? other.getOldMoney() == null : this.getOldMoney().equals(other.getOldMoney()))
            && (this.getNewMoney() == null ? other.getNewMoney() == null : this.getNewMoney().equals(other.getNewMoney()))
            && (this.getFundfromId() == null ? other.getFundfromId() == null : this.getFundfromId().equals(other.getFundfromId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOldMoney() == null) ? 0 : getOldMoney().hashCode());
        result = prime * result + ((getNewMoney() == null) ? 0 : getNewMoney().hashCode());
        result = prime * result + ((getFundfromId() == null) ? 0 : getFundfromId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}