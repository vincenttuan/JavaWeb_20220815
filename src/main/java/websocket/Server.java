package websocket;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class Server {
	// 用來存放每一個 Client 端的 Session 連線物件
	private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();
	
	@OnOpen // 建立連線
	public void onOpen(Session session) {
		// 記錄連線資訊
		System.out.println("有新的連線進來 session id: " + session.getId());
		// 將 session 物件存放到 sessions 集合中
		sessions.add(session);
		// 顯示目前連線數量
		System.out.println("目前連線數量: " + sessions.size());
		// 群播: 報告大家有新的人連線進來了
		String message = "有新成員加入!";
		// 進行群播
		sessions.stream()
				.filter(s -> s.isOpen())
				.forEach(s -> s.getAsyncRemote().sendText(message + " " + new Date()));
	}
	
	@OnMessage // 接收資訊
	public void onMessage(String message, Session session) {
		System.out.println("接收訊息: " + message);
		// 進行群播
		sessions.stream()
				.filter(s -> s.isOpen())
				.forEach(s -> s.getAsyncRemote().sendText(message + " " + new Date()));
	}

	@OnClose // 關閉連線
	public void onClose(Session session) {
		// 記錄連線資訊
		System.out.println("有連線離開 session id: " + session.getId());
		// 將 session 物件從 sessions 集合中移除
		sessions.remove(session);
		// 顯示目前連線數量
		System.out.println("目前連線數量: " + sessions.size());
		// 群播: 報告大家有人離開了
		String message = "有成員離開, session id: " + session.getId();
		// 進行群播
		sessions.stream()
				.filter(s -> s.isOpen())
				.forEach(s -> s.getAsyncRemote().sendText(message + " " + new Date()));
	}
	
}
