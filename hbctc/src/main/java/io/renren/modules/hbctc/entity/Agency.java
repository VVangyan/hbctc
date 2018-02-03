package io.renren.modules.hbctc.entity;

import java.io.Serializable;

public class Agency implements Serializable {
	private Integer id;

	private String agentno;

	private String agency;

	public Agency() {
	}

	public Agency(String agentno, String agency) {
		super();
		this.agentno = agentno;
		this.agency = agency;
	}

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgentno() {
		return agentno;
	}

	public void setAgentno(String agentno) {
		this.agentno = agentno == null ? null : agentno.trim();
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency == null ? null : agency.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", agentno=").append(agentno);
		sb.append(", agency=").append(agency);
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
		Agency other = (Agency) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getAgentno() == null ? other.getAgentno() == null
						: this.getAgentno().equals(other.getAgentno()))
				&& (this.getAgency() == null ? other.getAgency() == null : this.getAgency().equals(other.getAgency()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getAgentno() == null) ? 0 : getAgentno().hashCode());
		result = prime * result + ((getAgency() == null) ? 0 : getAgency().hashCode());
		return result;
	}
}