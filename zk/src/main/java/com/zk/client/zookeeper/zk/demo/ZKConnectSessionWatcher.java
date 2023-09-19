package com.zk.client.zookeeper.zk.demo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Title: ZKConnectDemo.java
 * @Description: zookeeper 恢复之前的会话连接demo演示
 */
public class ZKConnectSessionWatcher implements Watcher {
	
	final static Logger log = LoggerFactory.getLogger(ZKConnectSessionWatcher.class);

	public static final String zkServerPath = "172.16.0.3:2181";
	public static final Integer timeout = 5000;
	
	public static void main(String[] args) throws Exception {
		
		ZooKeeper zk = new ZooKeeper(zkServerPath, timeout, new ZKConnectSessionWatcher());
		Thread.sleep(1000);
		long sessionId = zk.getSessionId();
		String ssid = "0x" + Long.toHexString(sessionId);
		System.out.println(ssid);
		byte[] sessionPassword = zk.getSessionPasswd();
		log.warn("连接状态：{}", zk.getState());

		Thread.sleep(2000);
		
		// 开始会话重连
		log.warn("开始会话重连...");
		
		ZooKeeper zkSession = new ZooKeeper(zkServerPath, 
											timeout, 
											new ZKConnectSessionWatcher(), 
											sessionId, 
											sessionPassword);
		log.warn("重新连接状态zkSession：{}", zkSession.getState());
		Thread.sleep(1000);
		log.warn("重新连接状态zkSession：{}", zkSession.getState());
	}
	
	@Override
	public void process(WatchedEvent event) {
		log.warn("接受到watch通知：{}", event);
	}
}

