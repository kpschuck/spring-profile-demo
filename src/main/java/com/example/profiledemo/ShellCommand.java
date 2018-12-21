package com.example.profiledemo;

class ShellCommand {

    void execute(String command) {

        StringBuilder output = new StringBuilder();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream());
            StreamGobbler outputGobbler = new StreamGobbler(p.getInputStream());
            errorGobbler.start();
            outputGobbler.start();
            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
