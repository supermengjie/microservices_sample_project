package com.infosys.kafka_consumer_service.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactionDetails")
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ServerName;
	private String traceId;
	private String spanId;
	private String request;
	private String response;
	private Timestamp produceTime;
	private Timestamp consumeTime;
	
	public String getServerName() {
		return ServerName;
	}
	public void setServerName(String serverName) {
		ServerName = serverName;
	}
	public String getTraceId() {
		return traceId;
	}
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	public String getSpanId() {
		return spanId;
	}
	public void setSpanId(String spanId) {
		this.spanId = spanId;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "TransactionDetails [ServerName=" + ServerName + ", traceId=" + traceId + ", spanId=" + spanId
				+ ", request=" + request + ", response=" + response + "]";
	}
	public Timestamp getConsumeTime() {
		return consumeTime;
	}
	public void setConsumeTime(Timestamp consumeTime) {
		this.consumeTime = consumeTime;
	}
	public Timestamp getProduceTime() {
		return produceTime;
	}
	public void setProduceTime(Timestamp produceTime) {
		this.produceTime = produceTime;
	}

}
