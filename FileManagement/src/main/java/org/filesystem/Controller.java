package org.filesystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    public static void main(String[] args) {
        Directory directory2 = new Directory("comedy movies", new ArrayList<>(Arrays.asList(new File("heraFeri"))));

        Directory directory = new Directory("movies", new ArrayList<>(Arrays.asList(new File("boarder"), directory2)));

        directory.ls();
    }
}
