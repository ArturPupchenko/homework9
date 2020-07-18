package ua.com.alevel.nix.homework9;

import java.util.Random;

public class Retry {

//    Retry должен пытаться выполнить Block
//    заданное количество раз,
//    покуда тот не выполнится корректно,
//    либо не истечет количество попыток
//    (в этом случае внутреннее исключение должно
//    быть выброшено наверх).
//
//    Между каждой попыткой Retry должен ждать (Thread.sleep).
//    Изначальное ожидание должно быть не менее 0.
//    Дальнейшее ожидание должно быть увеличено
//    в арифметической прогрессии с каждой попыткой
//    (например, 100 мс на первой попытке,
//     200 на второй и.т.д.) - т.е.,
//    изначальное ожидание * попытка.


    public static void run(int numberOfTry) throws Exception {
        System.out.println("Бросаем кубик " + numberOfTry + " раз и ожидем шестерку");

        for (int i = 0; i < numberOfTry; i++) {
            try {
                System.out.println("Попытка " + (i + 1));
                block.run();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (i == numberOfTry-1) throw new Exception("Количество попыток исчерпано!");
            Thread.sleep(100 + (i * 100));
            System.out.println("Ждем " + (100 + (i * 100)) + "мс");
        }
    }


    private static Block block = () -> {
        Random random = new Random();
        int points;
        points = random.nextInt(6) + 1;
        if (points == 6) System.out.println("Выпало " + 6 + "!");
        else {
            throw new Exception("Не повезло! Выпало " + points);
        }
    };
}
