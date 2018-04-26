package org.job.schedule.util;

public abstract class SuperTask implements Task {
	public String name;// 任务名称-唯一标识
	
	
	public SuperTask(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void init() {
		
	}
	@Override
	public void end() {
		
	}
	
	@Override
	public String getName() {
		return name;
	}
}
