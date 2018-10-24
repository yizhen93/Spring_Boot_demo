package com.dipont.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity{

    private long id;
    private String userName;
    private int state;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "state")
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    
    public UserEntity() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", state=" + state + "]";
	}
    
    
}
