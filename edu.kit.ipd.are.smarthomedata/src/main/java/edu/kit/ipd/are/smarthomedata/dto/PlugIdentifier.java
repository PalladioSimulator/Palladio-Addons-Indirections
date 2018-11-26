package edu.kit.ipd.are.smarthomedata.dto;

import java.util.Objects;

/**
 * Used because only the combination of plugId, householdId and houseId is
 * unique.
 * 
 * @author Dominik Werle
 *
 */
public class PlugIdentifier {
	public final Long plugId;
	public final Long householdId;
	public final Long houseId;

	public PlugIdentifier(Long plugId, Long householdId, Long houseId) {
		this.plugId = plugId;
		this.householdId = householdId;
		this.houseId = houseId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(houseId, householdId, plugId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlugIdentifier other = (PlugIdentifier) obj;
		return Objects.equals(houseId, other.houseId) && Objects.equals(householdId, other.householdId)
				&& Objects.equals(plugId, other.plugId);
	}

	@Override
	public String toString() {
		return "[" + houseId + "." + householdId + "." + plugId + "]";
	}
}
