package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.Date;

public class CheckMsg implements Serializable {
    private Integer id;

    private String msg;

    private Date checkdate;

    private Integer userid;

    private Integer preid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPreid() {
        return preid;
    }

    public void setPreid(Integer preid) {
        this.preid = preid;
    }

    
    public CheckMsg() {
	}
    
    public CheckMsg(String msg, Date checkdate, Integer userid, Integer preid) {
		super();
		this.msg = msg;
		this.checkdate = checkdate;
		this.userid = userid;
		this.preid = preid;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", msg=").append(msg);
        sb.append(", checkdate=").append(checkdate);
        sb.append(", userid=").append(userid);
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
        CheckMsg other = (CheckMsg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMsg() == null ? other.getMsg() == null : this.getMsg().equals(other.getMsg()))
            && (this.getCheckdate() == null ? other.getCheckdate() == null : this.getCheckdate().equals(other.getCheckdate()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPreid() == null ? other.getPreid() == null : this.getPreid().equals(other.getPreid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMsg() == null) ? 0 : getMsg().hashCode());
        result = prime * result + ((getCheckdate() == null) ? 0 : getCheckdate().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPreid() == null) ? 0 : getPreid().hashCode());
        return result;
    }
}