package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerMain {
    private static MessageQueue messageQueue;
    public static void main(String[] args)
    {
        messageQueue = MessageQueue.getMessageQueue();
        try (ServerSocket serverSocket = new ServerSocket(3345))
        {
            Socket clientSocket = serverSocket.accept();

        }
            catch (IOException e) {
            //Обработотка ошибки
        }

    }
}
