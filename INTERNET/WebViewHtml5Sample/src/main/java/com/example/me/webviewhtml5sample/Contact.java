package com.example.me.webviewhtml5sample;

public class Contact {
 private Integer id;
 private String name;
 private String phone;
 
 public Contact(Integer id,String name,String phone){
	 this.id=id;
	 this.name=name;
	 this.phone=phone;
 }
 public Integer getId(){
	 return id;
 }
 public void setId(Integer id){
	 this.id=id;
 }
 
 public String getName(){
	 return name;
 }
 public void setName(String name){
	 this.name=name;
 }
 
 public String getPhone(){
	 return phone;
 }
 public void setPhone(String phone){
	 this.phone=phone;
 }
}
