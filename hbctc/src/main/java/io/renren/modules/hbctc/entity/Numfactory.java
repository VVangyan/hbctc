package io.renren.modules.hbctc.entity;

import java.io.Serializable;

public class Numfactory implements Serializable {
	private Integer id;

	private Integer bh1;//year

	private Integer bh2;//num

	public Numfactory() {
	}

	public Numfactory(Integer bh1, Integer bh2) {
		super();
		this.bh1 = bh1;
		this.bh2 = bh2;
	}

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", bh1=").append(bh1);
		sb.append(", bh2=").append(bh2);
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
		Numfactory other = (Numfactory) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getBh1() == null ? other.getBh1() == null : this.getBh1().equals(other.getBh1()))
				&& (this.getBh2() == null ? other.getBh2() == null : this.getBh2().equals(other.getBh2()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getBh1() == null) ? 0 : getBh1().hashCode());
		result = prime * result + ((getBh2() == null) ? 0 : getBh2().hashCode());
		return result;
	}
}