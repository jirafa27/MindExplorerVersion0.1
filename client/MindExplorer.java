/*
 *Класс пользователя.
 */
package client;

import client.client_exceptions.IllegalValueException;
import client.client_exceptions.NotEnoughScoresException;
import client.parameters.Filter;
import client.parameters.Sex;
import client.parameters.YearOfBirth;

import java.math.BigDecimal;
import java.util.ArrayList;
/**
*Класс пользователя
 * Singleton
*/
public class MindExplorer {
    /**Поле экземпляра класса*/
    private MindExplorer mindExplorer;

    /**Поле количества пользователей в системе*/
    private static BigDecimal numberOfExplorers = BigDecimal.ZERO;

    /**Поле идентификатора пользователя*/
    private BigDecimal id;

    /**Фильтры, определяющие, какие вопросы показывать пользователю*/
    private ArrayList<Filter> userFilters = new ArrayList<Filter>();

    /**Флаг, показывающий отвечает ли пользователь на вопросы в данный момент*/
    private boolean responseMode = false;

    /**Количество очков пользователя*/
    private long scores;

    /**Конструктор пользователя*/
    private MindExplorer() {
        id = numberOfExplorers.add(BigDecimal.ONE);
        scores = ClientConstants.INITIAL_SCORES_OF_MIND_EXPLORER;
        setYear();
        setSex();
    }
    /**Метод вывода сообщения с запросом года рождения, его считывания и добавления как один из фильтров пользователя*/
    private void setYear() {
        UserInterface.printString("Please, enter your year of your birth.");
        userFilters.add(new YearOfBirth((Integer) UserInterface.enterSomething(Integer.class)));

    }
    /**Метод вывода сообщения с запросом пола пользователя, его считывания и добавления как один из фильтров пользователя*/
    private void setSex() {
        UserInterface.printString("Please, choose your sex.");
        userFilters.add(new Sex((Boolean) UserInterface.enterSomething(Boolean.class)));
    }
    /*Метод создания объекта класса, если он еще не создан и
    * возвращения объекта класса, если он уже создан
    * @return экземпляр класса
    */
     MindExplorer getMindExplorer() {
        if (mindExplorer == null)
            return (mindExplorer = new MindExplorer());
        return mindExplorer;
    }

    public BigDecimal getId() {
        return id;
    }

    /**
     * Метод создания вопроса пользователя
     * Запрашивает и сохраняет текст вопроса, количество получателей, приоритет, и фильтры
     * Создает новый экземпляр класса Question
     * Изменяет переменную scores на время нахождения вопроса в очереди
     * Вычитание очков за ответы будет производиться при полученнии и одобрении ответа
     * @return экземпляр класса Question
     * */
    private Question createQuestion() {
        String text = getTextOfQuestion();
        int recipientNumber = getRecipientNumberOfQuestion();
        int timeInMinutes = getTimeOfQuestion();
        Filter[] filters;
        ArrayList<Filter> listFilters = new ArrayList<>();
        //Считывание фильтров
        filters = (Filter[]) listFilters.toArray();
        listFilters = null;
        Question question = new Question(text, recipientNumber, timeInMinutes, filters);
        return new Question(text, recipientNumber, timeInMinutes, filters);
    }


    /**Запрашивает и возвращает текст вопроса
     * @return текст вопроса*/
    private String getTextOfQuestion()
    {
        UserInterface.printString("Please, enter your question");
        return (String) UserInterface.enterSomething(String.class);
    }
    /**Запрашивает и возвращает количество желаемых ответов
     * В случае нехватки баллов вывордит сообщение с текущим и требуемым
     * количеством баллов, предлагая ввести снова, до тех пор, пока не
     * будет введено подходящее количесвто
     * @return количество желаемых ответов
     * */
    private int getRecipientNumberOfQuestion()
    {
        UserInterface.printString("Please, enter number of random recipients");
        int recipientNumber = (Integer) UserInterface.enterSomething(Integer.class);
            try {
                if (scores - recipientNumber < 1)
                throw new NotEnoughScoresException();
                if (recipientNumber <= 0)
                    throw new IllegalValueException();
            } catch (NotEnoughScoresException e) {
                UserInterface.printString("You have got not enough scores. Your scores: " + scores + ". Required: " + recipientNumber+1 + "." + "Try again. You should have");
                UserInterface.printString("at least one score left to have an opportunity set question in the queue on minimum time equals one minute.");
                getRecipientNumberOfQuestion();
            } catch (IllegalValueException e) {
                UserInterface.printString("Number of recipients should be more zero. Try again.");
                getRecipientNumberOfQuestion();
            }
        return recipientNumber;
    }
    /**Запрашивает и возвращает количество желаемых ответов
     * В случае нехватки баллов вывордит сообщение с текущим и требуемым
     * количеством баллов, предлагая ввести снова, до тех пор, пока не
     * будет введено подходящее количесвто
     * @return количество желаемых ответов
     * */
    private int getTimeOfQuestion()
    {
        UserInterface.printString("Please, enter desirable time in minutes your question will be in the queue. This might be any integer number, beginning from one. One minute");
        UserInterface.printString("equals one your score.");
        int timeInMinutes = (Integer) UserInterface.enterSomething(Integer.class);
            try {
                if (scores - timeInMinutes > 0)
                    throw new NotEnoughScoresException();
                if (timeInMinutes<=0)
                    throw new IllegalValueException();
            } catch (NotEnoughScoresException e) {
                UserInterface.printString("You have got not enough scores. Your scores: " + scores + ". Required: " + timeInMinutes + "." + "Try again.");
                getTimeOfQuestion();
            } catch (IllegalValueException e) {
                UserInterface.printString("Time in minutes should be more zero. Try again.");
                getTimeOfQuestion();
            }
        return timeInMinutes;
    }

    /*Добавляет новый фильтр к пользователю**/
    private  void addFilter (Filter filter)
    {
        userFilters.add(filter);
    }




    /*Переводит пользователя в режим ответа на вопросы**/
    private void startAnswering()
    {
        responseMode = true;
    }
    /*Переводит пользователя в обычный режим**/
    private  void finishAnswering()
    {
        responseMode = false;
    }
}
