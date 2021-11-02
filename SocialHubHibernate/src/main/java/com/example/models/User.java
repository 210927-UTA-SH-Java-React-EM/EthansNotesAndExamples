package com.example.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Named Queries/Named Native Queries
@NamedQueries({
		@NamedQuery(name="getUserLikedPosts", query="select u.likePosts from User u where u.id =:id")
})

//We need to mark our POJO/Bean as a persistence object
@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	//We can also setup multiplicity, do that we use annotataions such as @ManyToMany, @ManyToOne, @OneToMany
	//JoinColumn, and others
	
	//One user has many posts
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	//Json ignore will ignore the user object inside of the posts when we try to return data to the user
	@JsonIgnore
	private List<Post> posts;
	
	//Many to Many example, just so you can see one
	@ManyToMany(mappedBy="likes")
	@JsonIgnore
	private Set<Post> likePosts = new HashSet<Post>();
	
	public User() {
		posts = new ArrayList<Post>();
	}
	
	//Used to send user info to the database because the db autogenerates the id
	public User(String firstName, String lastName, String email, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		posts = new ArrayList<Post>();
	}
	
	//Used to get info from the database and create a user from it
	public User(int id, String firstName, String lastName, String email, String username, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		posts = new ArrayList<Post>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Set<Post> getLikePosts() {
		return likePosts;
	}

	public void setLikePosts(Set<Post> likePosts) {
		this.likePosts = likePosts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", posts=" + posts + ", likedPosts=" + likePosts + "]";
	}
}
