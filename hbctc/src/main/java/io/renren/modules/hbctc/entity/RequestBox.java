package io.renren.modules.hbctc.entity;

import java.io.Serializable;
import java.util.Date;

public class RequestBox implements Serializable {
    private Integer id;

    private Integer fromid;

    private Integer fromuserid;

    private String fromusername;

    private Integer fromroleid;

    private String fromdeptno;

    private String fromdeptname;

    private Date fromdate;

    private Integer touserid;

    private String tousername;

    private Integer toroleid;

    private String todeptno;

    private String todeptname;

    private Integer checkstatus;

    private static final long serialVersionUID = 1L;
    
    public RequestBox() {
		super();
	}

    public RequestBox(Integer fromid, Integer fromuserid, String fromusername, Integer fromroleid, String fromdeptno,
			String fromdeptname, Date fromdate, Integer touserid, String tousername, Integer toroleid, String todeptno,
			String todeptname, Integer checkstatus) {
		super();
		this.fromid = fromid;
		this.fromuserid = fromuserid;
		this.fromusername = fromusername;
		this.fromroleid = fromroleid;
		this.fromdeptno = fromdeptno;
		this.fromdeptname = fromdeptname;
		this.fromdate = fromdate;
		this.touserid = touserid;
		this.tousername = tousername;
		this.toroleid = toroleid;
		this.todeptno = todeptno;
		this.todeptname = todeptname;
		this.checkstatus = checkstatus;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public Integer getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(Integer fromuserid) {
        this.fromuserid = fromuserid;
    }

    public String getFromusername() {
        return fromusername;
    }

    public void setFromusername(String fromusername) {
        this.fromusername = fromusername == null ? null : fromusername.trim();
    }

    public Integer getFromroleid() {
        return fromroleid;
    }

    public void setFromroleid(Integer fromroleid) {
        this.fromroleid = fromroleid;
    }

    public String getFromdeptno() {
        return fromdeptno;
    }

    public void setFromdeptno(String fromdeptno) {
        this.fromdeptno = fromdeptno == null ? null : fromdeptno.trim();
    }

    public String getFromdeptname() {
        return fromdeptname;
    }

    public void setFromdeptname(String fromdeptname) {
        this.fromdeptname = fromdeptname == null ? null : fromdeptname.trim();
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername == null ? null : tousername.trim();
    }

    public Integer getToroleid() {
        return toroleid;
    }

    public void setToroleid(Integer toroleid) {
        this.toroleid = toroleid;
    }

    public String getTodeptno() {
        return todeptno;
    }

    public void setTodeptno(String todeptno) {
        this.todeptno = todeptno == null ? null : todeptno.trim();
    }

    public String getTodeptname() {
        return todeptname;
    }

    public void setTodeptname(String todeptname) {
        this.todeptname = todeptname == null ? null : todeptname.trim();
    }

    public Integer getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fromid=").append(fromid);
        sb.append(", fromuserid=").append(fromuserid);
        sb.append(", fromusername=").append(fromusername);
        sb.append(", fromroleid=").append(fromroleid);
        sb.append(", fromdeptno=").append(fromdeptno);
        sb.append(", fromdeptname=").append(fromdeptname);
        sb.append(", fromdate=").append(fromdate);
        sb.append(", touserid=").append(touserid);
        sb.append(", tousername=").append(tousername);
        sb.append(", toroleid=").append(toroleid);
        sb.append(", todeptno=").append(todeptno);
        sb.append(", todeptname=").append(todeptname);
        sb.append(", checkstatus=").append(checkstatus);
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
        RequestBox other = (RequestBox) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFromid() == null ? other.getFromid() == null : this.getFromid().equals(other.getFromid()))
            && (this.getFromuserid() == null ? other.getFromuserid() == null : this.getFromuserid().equals(other.getFromuserid()))
            && (this.getFromusername() == null ? other.getFromusername() == null : this.getFromusername().equals(other.getFromusername()))
            && (this.getFromroleid() == null ? other.getFromroleid() == null : this.getFromroleid().equals(other.getFromroleid()))
            && (this.getFromdeptno() == null ? other.getFromdeptno() == null : this.getFromdeptno().equals(other.getFromdeptno()))
            && (this.getFromdeptname() == null ? other.getFromdeptname() == null : this.getFromdeptname().equals(other.getFromdeptname()))
            && (this.getFromdate() == null ? other.getFromdate() == null : this.getFromdate().equals(other.getFromdate()))
            && (this.getTouserid() == null ? other.getTouserid() == null : this.getTouserid().equals(other.getTouserid()))
            && (this.getTousername() == null ? other.getTousername() == null : this.getTousername().equals(other.getTousername()))
            && (this.getToroleid() == null ? other.getToroleid() == null : this.getToroleid().equals(other.getToroleid()))
            && (this.getTodeptno() == null ? other.getTodeptno() == null : this.getTodeptno().equals(other.getTodeptno()))
            && (this.getTodeptname() == null ? other.getTodeptname() == null : this.getTodeptname().equals(other.getTodeptname()))
            && (this.getCheckstatus() == null ? other.getCheckstatus() == null : this.getCheckstatus().equals(other.getCheckstatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFromid() == null) ? 0 : getFromid().hashCode());
        result = prime * result + ((getFromuserid() == null) ? 0 : getFromuserid().hashCode());
        result = prime * result + ((getFromusername() == null) ? 0 : getFromusername().hashCode());
        result = prime * result + ((getFromroleid() == null) ? 0 : getFromroleid().hashCode());
        result = prime * result + ((getFromdeptno() == null) ? 0 : getFromdeptno().hashCode());
        result = prime * result + ((getFromdeptname() == null) ? 0 : getFromdeptname().hashCode());
        result = prime * result + ((getFromdate() == null) ? 0 : getFromdate().hashCode());
        result = prime * result + ((getTouserid() == null) ? 0 : getTouserid().hashCode());
        result = prime * result + ((getTousername() == null) ? 0 : getTousername().hashCode());
        result = prime * result + ((getToroleid() == null) ? 0 : getToroleid().hashCode());
        result = prime * result + ((getTodeptno() == null) ? 0 : getTodeptno().hashCode());
        result = prime * result + ((getTodeptname() == null) ? 0 : getTodeptname().hashCode());
        result = prime * result + ((getCheckstatus() == null) ? 0 : getCheckstatus().hashCode());
        return result;
    }
}