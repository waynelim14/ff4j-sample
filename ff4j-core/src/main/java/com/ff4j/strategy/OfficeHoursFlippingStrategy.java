package com.ff4j.strategy;

import java.util.Calendar;
import java.util.Map;

import org.ff4j.core.FeatureStore;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.strategy.AbstractFlipStrategy;

public class OfficeHoursFlippingStrategy extends AbstractFlipStrategy {

	/** Start Hour. */
	private int start = 0;

	/** Hend Hour. */
	private int end = 0;

	@Override
	public void init(String featureName, Map<String, String> initValue) {
		super.init(featureName, initValue);
		start = new Integer(initValue.get("startHour"));
		end = new Integer(initValue.get("endHour"));
	}

	@Override
	public boolean evaluate(String featureName, FeatureStore store, FlippingExecutionContext executionContext) {
		int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		return (currentHour >= start && currentHour < end);
	}
	
}
