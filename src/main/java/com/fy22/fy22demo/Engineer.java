package com.fy22.fy22demo;

import javax.persistence.*;

@Entity
@Table(name = "engineers")
public class Engineer {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engineer_id")
    private Integer engineer_id;

    @Column(name = "name")
    private String name;
    
    public Engineer() {
        super();
    }

    public Engineer(Integer id, String s) {
        engineer_id = id;
        name = s;
    }

    public Integer getEnId() {
        return engineer_id;
    }

    public void setEnId(Integer engineer_id) {
        this.engineer_id = engineer_id;
    }
 

    public String getName() {
        return name;
    }

    public void setName(String enName) {
        this.name = enName;
    }

    @Override
	public String toString() {
	    return "Engineer [engineer_id=" + engineer_id + ", name=" + name + "]";
	}
}
