# MindExplorerVersion0.1
Это пока заготовка местами прописанная детально, местами не написанная вообще. Странно, что не получилось ни одного интерфейса.
Видимо, я не до конца понимаю преимущества их использования.
Идея проекта.
<br>
Если код дорабатывать, то в итоге должно получиться клиент-серверное приложение для Андройд.
Суть заключена в названии: Исследователь разума. Написано оно будет в первую очередь для любопытных людей, которым интересно изучать себя
и других. Приложение дает возможность задать любой вопрос определенному количеству случайных, но выбранных по заданным критериям
пользователям, которые в данный момент отвечают на вопросы.
Для того, чтобы задать вопрос нужно обладать некоторым количеством баллов.
Также, получить баллы можно отвечая на вопросы и предоставляя дополнительную информацию о себе. При регистрации пользователь указывает
только язык, пол, год рождения. Вопросы организованы в виде общей для всех пользователей очереди. Но, пользователь имеет возможность
включать или выключать указанные им единицы данных о себе. Например, он может отключить фильтр по году рождения. Тогда ему будут
показываться вопросы для которых год рождения не указан, и вопросы его года рождения. Также с полом: его пола, и вопросы, где автору 
пол не важен. 
Когда пользователь задает вопрос он выбирает количество человек, которых хочет опросить и количество минут хранения вопроса в очереди.
Затем, этот вопрос добавляется в очередь. Другой пользователь отвечает на вопрос, и создателю вопроса приходит об этом уведомление.
Он может принять ответ, тогда с него спишется один балл за один ответ. Он может не принять ответ, тогда баллы не списываются, 
и количество требуемых ответов не изменяется. Он может пожаловаться на ответ, тогда с того, кто ответил спишется один балл, и
соответственно количество требуемых ответов на вопрос в очереди также не изменится. Вопрос исчезает из очереди, либо когда всё количество
требуемых ответов получено(в этом случае баллы за ответы будут полностью списаны, а за время только частично),
либо когда выйдет время вопроса(тогда баллы за время полностью списываются, а за ответы по количеству принятых ответов, и будет предложено 
задать вопрос снова).
У отвечающего есть возможность пропустить вопрос, в этом случае никаких уведомлений не посылается, вопрос остается неизменным в очереди.
Также, у отвечающего есть возможность пожаловаться на вопрос с указанием причины жалобы. Это уведомление с причиной жалобы 
посылается создателю вопроса, вопрос полностью удаляется, баллы за оставшееся время и неполученные ответы остаются при создателе,
но списывается один штрафной.
Немного о реализации.
Планируется, что все данные о пользователе и все вопросы на которые он получил и одобрил ответ будут
храниться на его устроистве.
На сервере будет только очередь из неотвеченных и еще актуальных по времени вопросов. Похоже, что для экономии памяти, в каждом элементе
очереди будет: идентификатор создателя вопроса, условия видимости вопроса для отвечающих, текст вопроса, время создания вопроса, сколько
раз создатель еще должен получить ответ. С ответом создатель вопроса получает идентификатор пользователя, чтобы иметь возможность одобрить 
ответ и начислить балл ответившему, а также отправить жалобу на ответ с причиной и списать балл с того, кто ответил, или просто не принять
ответ.
Немного о монетизации.
Пользователю, который использует приложение не в коммерческих целях по задумке ничего платить не придется.
Возможно, эта штука будет интересна компаниям, которые проводят маркетинговые исследования, а также психологам и социологам.

В конце скажу, что то, что написано у меня в коде может противоречить финальной задумке, но вроде все соответсвует.



