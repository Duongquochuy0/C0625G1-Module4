package com.example.quan_ly_sach.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.*;

@Aspect
@Component
public class Logger {
    private static final String DIR_PATH = "./view_count";
    private static final String FILE_PATH = DIR_PATH + "/view_count.txt";

    private int readViewCount() {
        File file = new File(FILE_PATH);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            return line == null ? 0 : Integer.parseInt(line);
        } catch (Exception e) {
            System.out.println("lỗi đọc file");
            e.printStackTrace();
            return 0;
        }
    }
    private void writeViewCount(int count) {
        try {
            File dir = new File(DIR_PATH);
            if (!dir.exists()) {
                boolean createdDir = dir.mkdirs();
            }

            File file = new File(FILE_PATH);
            if (!file.exists()) {
                boolean createdFile = file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.valueOf(count));
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After("execution(* com.example.quan_ly_sach.controller.BookController.*(..))")
    public void loggerAddSuccess(JoinPoint joinPoint) {
        System.out.println("Gọi phương thức: " + joinPoint.getSignature().getName());

        int viewCount = readViewCount();
        viewCount++;
        writeViewCount(viewCount);

        System.out.println("Số lượng truy cập: " + viewCount);
        System.out.println("--------------------------------------------");
    }
}
