package com.rubanProject.AssignmentProject.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MessageModel {
	@Id
	int id;
	String fromuser;
	String touser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromuser == null) ? 0 : fromuser.hashCode());
		result = prime * result + id;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((touser == null) ? 0 : touser.hashCode());
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
		MessageModel other = (MessageModel) obj;
		if (fromuser == null) {
			if (other.fromuser != null)
				return false;
		} else if (!fromuser.equals(other.fromuser))
			return false;
		if (id != other.id)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (touser == null) {
			if (other.touser != null)
				return false;
		} else if (!touser.equals(other.touser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MessageModel [id=" + id + ", fromuser=" + fromuser + ", touser=" + touser + ", message=" + message
				+ "]";
	}
	public MessageModel(int id, String fromuser, String touser, String message) {
		super();
		this.id = id;
		this.fromuser = fromuser;
		this.touser = touser;
		this.message = message;
	}
	public MessageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	String message;
	

}
