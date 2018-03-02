package io.renren.modules.hbctc.entity;

import java.io.Serializable;

public class FileUploadPath implements Serializable {
    private Integer id;

    private String path;

    private String filename;

    private String suffix;

    private Integer preid;

    private static final long serialVersionUID = 1L;

	public FileUploadPath() {
		super();
	}

	public FileUploadPath(String path, String filename, String suffix, Integer preid) {
		super();
		this.path = path;
		this.filename = filename;
		this.suffix = suffix;
		this.preid = preid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
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
        sb.append(", path=").append(path);
        sb.append(", filename=").append(filename);
        sb.append(", suffix=").append(suffix);
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
        FileUploadPath other = (FileUploadPath) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getFilename() == null ? other.getFilename() == null : this.getFilename().equals(other.getFilename()))
            && (this.getSuffix() == null ? other.getSuffix() == null : this.getSuffix().equals(other.getSuffix()))
            && (this.getPreid() == null ? other.getPreid() == null : this.getPreid().equals(other.getPreid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
        result = prime * result + ((getSuffix() == null) ? 0 : getSuffix().hashCode());
        result = prime * result + ((getPreid() == null) ? 0 : getPreid().hashCode());
        return result;
    }
}