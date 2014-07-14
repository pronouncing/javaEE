package com.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "t_mesginfo")
public class mesginfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "message")
  private String message;

  @Column(name = "messageinfo")
  private String messageinfo;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessageinfo() {
    return messageinfo;
  }

  public void setMessageinfo(String messageinfo) {
    this.messageinfo = messageinfo;
  }

}
