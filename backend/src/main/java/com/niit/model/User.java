package com.niit.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table


public class User {
@Id
@GeneratedValue
int userId;


public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
String userName;
String customerName;
String mobileNo;
String password;
String email;
String Role;
String Enabled;
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public String getEnabled() {
	return Enabled;
}
public void setEnabled(String enabled) {
	Enabled = enabled;
}
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getCustomerName() {
return customerName;
}
public void setCustomerName(String customerName) {
this.customerName = customerName;
}
public String getMobileNo() {
return mobileNo;
}
public void setMobileNo(String mobileNo) {
this.mobileNo = mobileNo;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}


}
