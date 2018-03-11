package io.renren.modules.hbctc.entity;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer id;

    private String detpname;

    private String deptno;

    private Integer preid;

    private Integer ismiddledept;

    private static final long serialVersionUID = 1L;
    
    public Department() {
		super();
	}
    
	public Department(String detpname, String deptno, Integer preid, Integer ismiddledept) {
		super();
		this.detpname = detpname;
		this.deptno = deptno;
		this.preid = preid;
		this.ismiddledept = ismiddledept;
	}

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

    public Integer getPreid() {
        return preid;
    }

    public void setPreid(Integer preid) {
        this.preid = preid;
    }

    public Integer getIsmiddledept() {
        return ismiddledept;
    }

    public void setIsmiddledept(Integer ismiddledept) {
        this.ismiddledept = ismiddledept;
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
        sb.append(", preid=").append(preid);
        sb.append(", ismiddledept=").append(ismiddledept);
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
        Department other = (Department) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDetpname() == null ? other.getDetpname() == null : this.getDetpname().equals(other.getDetpname()))
            && (this.getDeptno() == null ? other.getDeptno() == null : this.getDeptno().equals(other.getDeptno()))
            && (this.getPreid() == null ? other.getPreid() == null : this.getPreid().equals(other.getPreid()))
            && (this.getIsmiddledept() == null ? other.getIsmiddledept() == null : this.getIsmiddledept().equals(other.getIsmiddledept()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDetpname() == null) ? 0 : getDetpname().hashCode());
        result = prime * result + ((getDeptno() == null) ? 0 : getDeptno().hashCode());
        result = prime * result + ((getPreid() == null) ? 0 : getPreid().hashCode());
        result = prime * result + ((getIsmiddledept() == null) ? 0 : getIsmiddledept().hashCode());
        return result;
    }
}