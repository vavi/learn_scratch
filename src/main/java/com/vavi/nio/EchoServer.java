package com.vavi.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class EchoServer {
	public static int DEFAULT_PORT = 7777;

	public static void main(String[] args) throws IOException {
		System.out.println("Listening for connection on port " + DEFAULT_PORT);

		Selector selector = Selector.open();
		initServer(selector);

		while (true) {
			selector.select();

			for (Iterator<SelectionKey> itor = selector.selectedKeys()
					.iterator(); itor.hasNext();) {
				SelectionKey key = itor.next();
				itor.remove();
				try {
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key
								.channel();
						SocketChannel client = server.accept();
						System.out
								.println("Accepted connection from " + client);
						client.configureBlocking(false);
						SelectionKey clientKey = client.register(selector,
								SelectionKey.OP_WRITE | SelectionKey.OP_READ);
						ByteBuffer buffer = ByteBuffer.allocate(100);
						clientKey.attach(buffer);
					}
					if (key.isReadable()) {
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer buffer = (ByteBuffer) key.attachment();
						client.read(buffer);
					}
					if (key.isWritable()) {
						// System.out.println("is writable...");
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer buffer = (ByteBuffer) key.attachment();
						buffer.flip();
						client.write(buffer);
						buffer.compact();
					}
				} catch (IOException e) {
					key.cancel();
					try {
						key.channel().close();
					} catch (IOException ioe) {
					}
				}
			}
		}
	}

	private static void initServer(Selector selector) throws IOException,
			ClosedChannelException {
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket ss = serverChannel.socket();
		ss.bind(new InetSocketAddress(DEFAULT_PORT));
		serverChannel.configureBlocking(false);
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
}
