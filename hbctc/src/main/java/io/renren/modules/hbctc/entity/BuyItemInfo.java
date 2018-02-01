package io.renren.modules.hbctc.entity;

import java.io.Serializable;

public class BuyItemInfo implements Serializable {
    private Integer id;

    private Integer byintemid;//采购项目 id

    private String buyitemname;//采购项目  品目名称

    private Integer buyitemqty;//采购项目  数量

    private String buyitemunit;//采购项目  计量单位

    private Double buyitemsum;//采购项目  预算金额

    private String buyitemtype;//采购项目  采购类别   0货物/1服务/2工程

    private String isimport;//采购项目  是否进口  0 否，1 是

    private String isenergy;//采购项目  节能  0 否，1 是

    private String isenvironment;//采购项目 是否环保   0 否，1 是

    private Integer preid;// 主表id

    private static final long serialVersionUID = 1L;
    
    

    public BuyItemInfo() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getByintemid() {
        return byintemid;
    }

    public void setByintemid(Integer byintemid) {
        this.byintemid = byintemid;
    }

    public String getBuyitemname() {
        return buyitemname;
    }

    public void setBuyitemname(String buyitemname) {
        this.buyitemname = buyitemname == null ? null : buyitemname.trim();
    }

    public Integer getBuyitemqty() {
        return buyitemqty;
    }

    public void setBuyitemqty(Integer buyitemqty) {
        this.buyitemqty = buyitemqty;
    }

    public String getBuyitemunit() {
        return buyitemunit;
    }

    public void setBuyitemunit(String buyitemunit) {
        this.buyitemunit = buyitemunit == null ? null : buyitemunit.trim();
    }

    public Double getBuyitemsum() {
        return buyitemsum;
    }

    public void setBuyitemsum(Double buyitemsum) {
        this.buyitemsum = buyitemsum;
    }

    public String getBuyitemtype() {
        return buyitemtype;
    }

    public void setBuyitemtype(String buyitemtype) {
        this.buyitemtype = buyitemtype == null ? null : buyitemtype.trim();
    }

    public String getIsimport() {
        return isimport;
    }

    public void setIsimport(String isimport) {
        this.isimport = isimport == null ? null : isimport.trim();
    }

    public String getIsenergy() {
        return isenergy;
    }

    public void setIsenergy(String isenergy) {
        this.isenergy = isenergy == null ? null : isenergy.trim();
    }

    public String getIsenvironment() {
        return isenvironment;
    }

    public void setIsenvironment(String isenvironment) {
        this.isenvironment = isenvironment == null ? null : isenvironment.trim();
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
        sb.append(", byintemid=").append(byintemid);
        sb.append(", buyitemname=").append(buyitemname);
        sb.append(", buyitemqty=").append(buyitemqty);
        sb.append(", buyitemunit=").append(buyitemunit);
        sb.append(", buyitemsum=").append(buyitemsum);
        sb.append(", buyitemtype=").append(buyitemtype);
        sb.append(", isimport=").append(isimport);
        sb.append(", isenergy=").append(isenergy);
        sb.append(", isenvironment=").append(isenvironment);
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
        BuyItemInfo other = (BuyItemInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getByintemid() == null ? other.getByintemid() == null : this.getByintemid().equals(other.getByintemid()))
            && (this.getBuyitemname() == null ? other.getBuyitemname() == null : this.getBuyitemname().equals(other.getBuyitemname()))
            && (this.getBuyitemqty() == null ? other.getBuyitemqty() == null : this.getBuyitemqty().equals(other.getBuyitemqty()))
            && (this.getBuyitemunit() == null ? other.getBuyitemunit() == null : this.getBuyitemunit().equals(other.getBuyitemunit()))
            && (this.getBuyitemsum() == null ? other.getBuyitemsum() == null : this.getBuyitemsum().equals(other.getBuyitemsum()))
            && (this.getBuyitemtype() == null ? other.getBuyitemtype() == null : this.getBuyitemtype().equals(other.getBuyitemtype()))
            && (this.getIsimport() == null ? other.getIsimport() == null : this.getIsimport().equals(other.getIsimport()))
            && (this.getIsenergy() == null ? other.getIsenergy() == null : this.getIsenergy().equals(other.getIsenergy()))
            && (this.getIsenvironment() == null ? other.getIsenvironment() == null : this.getIsenvironment().equals(other.getIsenvironment()))
            && (this.getPreid() == null ? other.getPreid() == null : this.getPreid().equals(other.getPreid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getByintemid() == null) ? 0 : getByintemid().hashCode());
        result = prime * result + ((getBuyitemname() == null) ? 0 : getBuyitemname().hashCode());
        result = prime * result + ((getBuyitemqty() == null) ? 0 : getBuyitemqty().hashCode());
        result = prime * result + ((getBuyitemunit() == null) ? 0 : getBuyitemunit().hashCode());
        result = prime * result + ((getBuyitemsum() == null) ? 0 : getBuyitemsum().hashCode());
        result = prime * result + ((getBuyitemtype() == null) ? 0 : getBuyitemtype().hashCode());
        result = prime * result + ((getIsimport() == null) ? 0 : getIsimport().hashCode());
        result = prime * result + ((getIsenergy() == null) ? 0 : getIsenergy().hashCode());
        result = prime * result + ((getIsenvironment() == null) ? 0 : getIsenvironment().hashCode());
        result = prime * result + ((getPreid() == null) ? 0 : getPreid().hashCode());
        return result;
    }

	public BuyItemInfo(Integer byintemid, String buyitemname, Integer buyitemqty, String buyitemunit, Double buyitemsum,
			String buyitemtype, String isimport, String isenergy, String isenvironment, Integer preid) {
		super();
		this.byintemid = byintemid;
		this.buyitemname = buyitemname;
		this.buyitemqty = buyitemqty;
		this.buyitemunit = buyitemunit;
		this.buyitemsum = buyitemsum;
		this.buyitemtype = buyitemtype;
		this.isimport = isimport;
		this.isenergy = isenergy;
		this.isenvironment = isenvironment;
		this.preid = preid;
	}
}