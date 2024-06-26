package fr.training.samples.spring.shop.domain.common.entity;

import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;


/**
 * @author Badr NASS
 *
 */
@MappedSuperclass
public abstract class AbstractBaseEntity {

	/**
	 * Entity Id
	 */
	@NotNull
	@Id
	protected String id = UUID.randomUUID().toString();

	/**
	 * Entity Version
	 */
	@NotNull
	@Version
	protected Integer version = 0;

	/**
	 * @return
	 */
	public String getId() {

		return id;
	}

	/**
	 * @param id
	 */
	public void setId(final String id) {

		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractBaseEntity [id=");
		builder.append(id);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractBaseEntity other = (AbstractBaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}