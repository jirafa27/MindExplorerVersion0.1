package server;


import java.util.concurrent.ConcurrentLinkedQueue;

/**Синхронизированная очередь из объектов SmartMessage
 * Singleton
 * */
public class MessageQueue extends ConcurrentLinkedQueue<SmartMessage> {
    private static MessageQueue messageQueue;
    private MessageQueue ()
    {
        messageQueue = (MessageQueue) new ConcurrentLinkedQueue<SmartMessage>();
    }
    static MessageQueue getMessageQueue()
    {
        if (messageQueue==null)
            return (messageQueue = new MessageQueue());
        return messageQueue;
    }


    int getLength() {
        return messageQueue.size();
    }
}
