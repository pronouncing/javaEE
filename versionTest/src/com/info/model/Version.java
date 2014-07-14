package com.info.model;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_version")
public class Version {
	/**
	 * OID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	private int id;
	/**
	 * APKӦ������
	 */
	@Column(name = "v_apkName")
	private String apkName;
	/**
	 * APKURL���ص�ַ
	 */
	@Column(name = "v_apkUrl")
	private String apkUrl;
	/**
	 * verBug �°汾����������ʾ
	 */
	@Column(name = "v_verBug")
	private String verBug;
	/**
	 * �汾
	 */
	@Column(name = "v_verCode")
	private int verCode;
	/**
	 * �汾��
	 */
	@Column(name = "v_verName")
	private String verName;
	/**
	 * ʱ���¼
	 */
	@Column(name = "v_dataTime")
	private String dataTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApkName() {
		return apkName;
	}
	public void setApkName(String apkName) {
		this.apkName = apkName;
	}
	public String getApkUrl() {
		return apkUrl;
	}
	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}
	public String getVerBug() {
		return verBug;
	}
	public void setVerBug(String verBug) {
		this.verBug = verBug;
	}
	public int getVerCode() {
		return verCode;
	}
	public void setVerCode(int verCode) {
		this.verCode = verCode;
	}
	public String getVerName() {
		return verName;
	}
	public void setVerName(String verName) {
		this.verName = verName;
	}
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	@Override
	public String toString() {
		return "Version [apkName=" + apkName + ", apkUrl=" + apkUrl
				+ ", dataTime=" + dataTime + ", id=" + id + ", verBug="
				+ verBug + ", verCode=" + verCode + ", verName=" + verName
				+ "]";
	}
	



}
