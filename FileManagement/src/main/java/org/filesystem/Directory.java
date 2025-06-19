package org.filesystem;

import java.util.List;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String directoryName, List<FileSystem> fileSystemList) {
        this.directoryName = directoryName;
        this.fileSystemList = fileSystemList;
    }

    @Override
    public void ls() {
        System.out.println("Directory is: " + directoryName);
        for (FileSystem fileSystem : fileSystemList) {
            fileSystem.ls();
        }
    }
}
