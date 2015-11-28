package com.vavi.test;

import com.google.common.eventbus.EventBus;

// Class is typically registered by the container.
class EventBusChangeRecorder {

	// // Subscribe annotation，并且只有一个 ChangeEvent 方法参数
	// @Subscribe
	// public void recordCustomerChange(ChangeEvent e) {
	// recordChange(e.getChange());
	// }
	//
	// private void recordChange(Object change) {
	// // TODO Auto-generated method stub
	//
	// }

	public static void main(String[] args) {
		final EventBus eventBus = new EventBus();
		Object object = new ChangeListener();
		eventBus.register(object);

		eventBus.post(1);
		eventBus.post(1L);
	}
}
