package com.boot.jersey.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_users")
public class User {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
 
 @Column(name = "first_name", nullable = false)
 private String firstName;
 
 @Column(name = "last_name", nullable = false)
 private String lastName;

 @Column(name = "email_address", nullable = false)
 private String emailId;

 public long getId() {
  return id;
 }

 public void setId(long id) {
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

 public String getEmailId() {
  return emailId;
 }

 public void setEmailId(String emailId) {
  this.emailId = emailId;
 }
}
