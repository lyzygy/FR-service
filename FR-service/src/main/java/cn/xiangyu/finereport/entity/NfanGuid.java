package cn.xiangyu.finereport.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author liuzg
 *
 */
@Entity
@Table(name = "nfanguid")
public class NfanGuid {

	@Id
	@GeneratedValue(generator="idGenerator")
	@GenericGenerator(name="idGenerator", strategy = "uuid")
	@Column(name = "primaryid", unique = true, nullable = false)
	private String primaryid;

	@Column(name = "guid", length = 100)
	private String guid;

	@Column(name = "fieldtype", length = 30)
	private String fieldType;

	@Column(name = "fieldname", length = 30)
	private String fieldName;

	@Column(name = "fielddesc", length = 100)
	private String fieldDesc;

	@Column(name = "created_by", length = 50)
	private String createdBy;

	@Temporal(TemporalType.TIME)
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "token_expireation_time")
	private Date tokenExpirationTime;

	public String getPrimaryid() {
		return primaryid;
	}

	public void setPrimaryid(String primaryid) {
		this.primaryid = primaryid;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDesc() {
		return fieldDesc;
	}

	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getTokenExpirationTime() {
		return tokenExpirationTime;
	}

	public void setTokenExpirationTime(Date tokenExpirationTime) {
		this.tokenExpirationTime = tokenExpirationTime;
	}
	
}
