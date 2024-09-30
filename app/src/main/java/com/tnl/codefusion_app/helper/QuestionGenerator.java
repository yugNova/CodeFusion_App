package com.tnl.codefusion_app.helper;

import com.tnl.codefusion_app.data.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class QuestionGenerator {


    public static List<Question> getQuestion(){
        List<Question> list=new ArrayList<>();
        // Creating and adding questions to the list
        list.add(createQuestion(1, "What is Java?",
                "A type of coffee",
                "A high-level programming language",
                "A tropical island in Indonesia",
                "A brand of smartphones",
                "A high-level programming language"));

        list.add(createQuestion(2, "What is an object in Java?",
                "A variable that stores a single value",
                "A function that performs a specific task",
                "An instance of a class",
                "A reserved keyword in Java",
                "An instance of a class"));

        list.add(createQuestion(3, "What is the extension of Java code files?",
                ".js",
                ".txt",
                ".class",
                ".java",
                ".java"));

        list.add(createQuestion(4, "Which one of the following is not a Java feature?",
                "Object-oriented",
                "Use of pointers",
                "Portable",
                "Dynamic and Extensible",
                "Use of pointers"));

        list.add(createQuestion(5, "Which component is used to compile, debug, and execute Java programs?",
                "JRE",
                "JIT",
                "JDK",
                "JVM",
                "JDK"));

        list.add(createQuestion(6, "What does JVM stand for?",
                "Java Variable Machine",
                "Java Virtual Machine",
                "Java Verified Machine",
                "Java Visual Machine",
                "Java Virtual Machine"));

        list.add(createQuestion(7, "Which of the following is a valid declaration of a char?",
                "char ch = 'a';",
                "char ch = \"a\";",
                "char ch = a;",
                "char ch = 'ab';",
                "char ch = 'a';"));

        list.add(createQuestion(8, "What is the default value of a String variable?",
                "null",
                "''",
                "0",
                "undefined",
                "null"));

        list.add(createQuestion(9, "Which keyword is used to create a subclass in Java?",
                "extends",
                "implements",
                "inherits",
                "super",
                "extends"));

        list.add(createQuestion(10, "Which of the following is used for exception handling in Java?",
                "try-catch",
                "if-else",
                "switch-case",
                "for-each",
                "try-catch"));
        Collections.shuffle(list);
        return list;
    }


    private static Question createQuestion(int id, String questionText,
                                           String option1, String option2,
                                           String option3, String option4,
                                           String answer) {
        Question question = new Question();
        question.setId(id);
        question.setQuestion(questionText);
        question.setOption1(option1);
        question.setOption2(option2);
        question.setOption3(option3);
        question.setOption4(option4);
        question.setAnswer(answer);
        return question;
    }
}



