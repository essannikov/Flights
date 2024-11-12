package com.gridnine.testing.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class Messages {
    public static final String MSG_HELP_FILE = "src/main/resources/help.txt";
    public static final String MSG_ENTER = ">>>";

    private Messages(){}

    public static void printHelp(){
        try {
            StringBuilder builder = new StringBuilder();

            List<String> lines = Files.readAllLines(Paths.get(MSG_HELP_FILE));
            lines.forEach(line -> builder.append(line + "\n"));

            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
