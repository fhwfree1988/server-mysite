package com.project.site.base.ratelimit;

public enum TimeUnit {
	MINUTES(1),
	HOURS(2),
	DAY(3);

	int code = 3;
	TimeUnit(int code) {
		this.code = code;
	}

	public int getCode(){
		return this.code;
	}
	public static TimeUnit getType(int code){
		switch (code){
			case 1:
				return MINUTES;
			case 2:
				return HOURS;
			case 3:
				return DAY;
			default:
				return DAY;
		}
	}
}
