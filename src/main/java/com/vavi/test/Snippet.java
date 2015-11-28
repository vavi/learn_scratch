package com.vavi.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import org.junit.Test;

public class Snippet {
    @Test
    public void referenceQueue1() throws InterruptedException {
	Object strongRef = new Object();
	ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
	WeakReference<Object> weakRef = new WeakReference<Object>(
		strongRef, queue);

	assertFalse(weakRef.isEnqueued());
	Reference<? extends Object> polled = queue.poll();
	assertNull(polled);

	strongRef = null;
	System.gc();

	assertTrue(weakRef.isEnqueued());
	Reference<? extends Object> removed = queue.remove();
	assertNotNull(removed);
    }

    @Test
    public void referenceQueue() throws InterruptedException {
	Object strongRef = new Object();
	ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
	WeakReference<Object> weakRef = new WeakReference<Object>(
		strongRef, queue);

	assertFalse(weakRef.isEnqueued());
	Reference<? extends Object> polled = queue.poll();
	assertNull(polled);

	strongRef = null;
	System.gc();

	assertTrue(weakRef.isEnqueued());
	Reference<? extends Object> removed = queue.remove();
	assertNotNull(removed);
    }
}
