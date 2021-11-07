//$Id$
package com.example.todo.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name="TODO")
public class ToDo{
	
	@Id 
	@GeneratedValue private int id;
	private String title;
	private String description;
	
}
