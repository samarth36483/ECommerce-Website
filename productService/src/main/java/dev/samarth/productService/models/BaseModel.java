package dev.samarth.productService.models;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseModel {
	@Id
	@GeneratedValue
	private Long id;
	private Date createdAt;
	private Date lastUpdatedAt;
	private boolean Deleted;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	public boolean isDeleted() {
		return Deleted;
	}
	public void setDeleted(boolean deleted) {
		Deleted = deleted;
	}

}
