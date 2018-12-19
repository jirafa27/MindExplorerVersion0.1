
package client;
import client.parameters.Filter;
/**
 *Класс вопроса, который пользователь может задать опреленному количеству случайных людей,
 * выбранных определенным образом.
 */
public class Question {
    String text;
    int recipientNumber;
    int time;
    Filter[] filters;
    /**
     *Конструктор вопроса
     * @param text - текст вопроса
     * @param recipientNumber - количество случайных получателе
     *@param time - время вопроса в минутах, по истечении которого объект SmartMessage будет полностью удаляться из очереди MessageQueue
     *@param filters - определяет каким пользователям показываь этот вопрос
     */
    public Question(String text, int recipientNumber, int time, Filter[] filters) {
        this.text = text;
        this.recipientNumber = recipientNumber;
        this.time = time;
        this.filters = filters;
    }
}
