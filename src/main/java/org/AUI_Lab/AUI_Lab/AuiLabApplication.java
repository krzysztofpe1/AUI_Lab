package org.AUI_Lab.AUI_Lab;

import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AuiLabApplication {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		SpringApplication.run(AuiLabApplication.class, args);
	}
}
