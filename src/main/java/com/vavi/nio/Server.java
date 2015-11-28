package com.vavi.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) throws IOException {
	ServerSocketChannel channel = ServerSocketChannel.open();
	channel.configureBlocking(false);

	Selector selector = Selector.open();
	channel.register(selector, SelectionKey.OP_ACCEPT);

	InetSocketAddress address = new InetSocketAddress(8081);
	channel.bind(address);

	while (true) {
	    Iterator<SelectionKey> iterators = selector.keys().iterator();
	    while (iterators.hasNext()) {
		SelectionKey key = iterators.next();
		iterators.remove();
		if (key.isAcceptable()) {
		    ServerSocketChannel ssc = (ServerSocketChannel) key
			    .channel();
		    SocketChannel clientSocketChannel = ssc.accept();
		    clientSocketChannel.configureBlocking(false);

		    SelectionKey writableKey = clientSocketChannel.register(
			    selector, SelectionKey.OP_WRITE);
		}

	    }

	}
    }
}
