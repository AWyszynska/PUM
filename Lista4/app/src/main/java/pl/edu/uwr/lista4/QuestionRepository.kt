package pl.edu.uwr.lista4



fun generateQuestions(): List<Question> {
    return listOf(
        Question(
            text = "Jaką własność ciała określa stosunek masy do objętości?",
            answers = listOf("Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Który pierwiastek chemiczny ma symbol H?",
            answers = listOf("Hel", "Wodór", "Węgiel", "Azot"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Prędkość to?",
            answers = listOf("Iloczyn drogi przez czas", "Funkcja zmiany położenia w czasie", "Druga pochodna położenia po czasie", "Pochodna funkcji położenia po czasie"),
            correctAnswerIndex = 3
        ),
        Question(
            text = "Prędkość i położenie to wielkości?",
            answers = listOf("Skalarne", "Styczne","Wektorowe", "Normalne"),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Prędkość kątowa i przyspieszenie kątowe opisują?",
            answers = listOf("Kinematykę ruchu postępowego", "Kinematykę ruchu obrotowego", "Kinematykę ruchu postępowo-obrotowego", "Statykę"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Druga zasada dynamiki Newtona głosi, że?",
            answers = listOf("Siła działająca na ciało równa jest iloczynowi masy i prędkości", "Szybkość zmiany pędu ciała jest równa sile działającej na ciało", "Szybkość zmiany pędu ciała jest równa energii kinetycznej ciała", "Siła działająca na ciało jest równa ilorazowi masy i prędkości"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Siła bezwładności jest siłą?",
            answers = listOf("Zachowawczą", "Pozorną", "Realną", "Mogącą wywołać przemieszczenie ciała"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Do sił zachowawczych nie należą?",
            answers = listOf("Jądrowe, grawitacyjne i elektrostatyczne", "Tarcia, aerodynamiczne i hydrodynamiczne", " Jądrowe, grawitacyjne, aerodynamiczne", "Tarcia, grawitacji, i elektrostatyczne"),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Układ zamknięty to układ, w którym?",
            answers = listOf("Występują siły zewnętrzne", "Nie występują siły wewnętrzne", "Nie występują siły zewnętrzne", "Wszystkie działające siły równoważą się"),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Energia jest to?",
            answers = listOf("Miara zdolności ciała do wykonania pracy", "Wielkość zależna od wyboru układu odniesienia", "Element zasady dynamiki dla punktu materialnego", "Iloczyn masy i kwadratu prędkości"),
            correctAnswerIndex = 0
        ),

    )
}
