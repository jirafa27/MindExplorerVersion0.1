package server;

import client.MindExplorer;
import client.parameters.Filter;

import java.math.BigDecimal;
import java.util.Date;
/*Сущность, которая является посредником между двумя пользователями
* Хранит идентификаторы обоих
* Находится на сервере
* Способна заявлять о своем существовании только тем пользователям,
* фильтры которых содержат в себе фильтры экземпляра этого класса.
* Способна уменьшать значение поля numberOfRecipients, и
* полностью удаляться из очереди MessageQueue объектов класса SmartMessage
* Способна отправлять объекты создателю вопроса:
* 1) Объект Answer с ответом на вопрос создателя.
* 2) Объект Answer с уведомления о том, что на вопрос был удален, потому что его время истекло, возвратом баллов равных количству неполученных ответов создателю вопроса и предложением задать вопрос снова.
* 3) Объект Answer c уведомлением о том, что отвечающий пожаловался на вопрос, и что вопрос удален полностью, и снятием одного балла с создателя вопроса. При этом этот объект SmartMessage удалаяется
* из очереди MessageQueue.
* Способна отправлять объекты ответившему на вопрос
* 1) Объект Score с уведомлением о том, что создатель вопроса принял ответ и с зачислением одного балла ответившему. При этом значание поля numberOfRecipients уменьшается на единицу,
* объект SmartMessage удаляется из очереди MessageQueue если numberOfRecipients равно нулю.
* 2) Объект Score c уведомлением о том, что создатель вопроса не принял ответ и баллы при этом не зачисляются ответившему.
* 3) Объект Score с уведомлением о том, что создатель пожаловался на ответ и с снятем одного балла с ответившего. При этом значение numberOfRecipients не изменяется.
*
**/
public class SmartMessage {
    private  String text;
    public Filter[] filters;
    private Date creationTime;
    private int timeInMinutes;
    private long numberOfRecipients;
    private static final MessageQueue messageQueue;
    private MindExplorer sender;
    private MindExplorer recipient;
    static
    {
        messageQueue = MessageQueue.getMessageQueue();
    }
    public SmartMessage(String text, Filter[] filters, int timeInMinutes, MindExplorer sender) {
        this.text = text;
        this.filters = filters;
        this.sender = sender;
        this.timeInMinutes = timeInMinutes;
        creationTime = new Date();

    }

    public void setRecipient(MindExplorer recipient) {
        this.recipient = recipient;
    }

    /**Удалаяет объект SmartMessage из очереди.
     * Вызывается, когда длина очереди больше {@value server.ServerConstants#MAX_LENGTH_OF_MESSAGE_QUEUE}*/
     private void removeThis() throws Throwable {
         if (new Date().getTime()-creationTime.getTime()>timeInMinutes*60*1000)
         {
             messageQueue.remove(this);
             sendMessage("Time of your question is up. There was no users to answer it. You can try ask it again.", sender);
         }

     }
     private void sendMessage(String text, MindExplorer mindExplorer)
     {

     }


}
