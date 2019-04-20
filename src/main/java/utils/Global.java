package utils;

import entities.Director;
import entities.Operator;
import entities.Supervisor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Global {
    public static long CALLS = 0;
    public static final char QUIT = 'q';
    public static final char CALL = 'c';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final ThreadPoolExecutor EXECUTOR = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    public static final List<String> EMPLOYEE_TYPES = new ArrayList<String>()
    {
        {
            add(Operator.class.getSimpleName());
            add(Supervisor.class.getSimpleName());
            add(Director.class.getSimpleName());
        }
    };
}
