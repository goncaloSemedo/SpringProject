package com.springproject.auth.messages.requests;

public class DeviceData {
	
	private String os;
	private String model;
	private Long deviceId;
	private String product;
	private String version;
	private boolean violated;
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public boolean isViolated() {
		return violated;
	}
	public void setViolated(boolean violated) {
		this.violated = violated;
	}
}
