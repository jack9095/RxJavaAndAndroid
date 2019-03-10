package com.kuanquan.testdemo;

public class EventCenter<T> {
	private String eventType;
	private T data;
	
	public EventCenter(String eventType, T data) {
		super();
		this.eventType = eventType;
		this.data = data;
	}
	
	public EventCenter() {
		super();
	}



	public EventCenter(String eventType) {
		super();
		this.eventType = eventType;
	}
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "EventCenter [eventType=" + eventType + ", data=" + data + "]";
	}
	
	
	
}
