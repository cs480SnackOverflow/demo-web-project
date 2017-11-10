package edu.csupomona.cs480.data.entity;


public class SetMetadata {

	/**
	 * A human-identifiable string related to this flash card set
	 */
	private String name;
	/**
	 * The user who owns this set
	 */
	private String userId;
	/**
	 * The unique id of this set
	 */
	private String setId;

	public SetMetadata() {
		name = "";
		userId = "";
		setId = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String user) {
		this.userId = user;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String id) {
		this.setId = id;
	}

	@Override
	public String toString() {
		return name + "\t" + userId + "\t" + setId;
	}

}
