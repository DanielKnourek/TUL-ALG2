package cz.knourekdaniel.TUL.cmd.commands;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author janvit
 */
public class Dir extends Command {

    @Override
    public String execute(File actualDir) {
        File[] files;
        if(params.length == 1){
            files = actualDir.listFiles();
            return dirToString(files);
        }
        if (Arrays.asList(params).contains("-r")){
            StringBuilder dirRecursive = new StringBuilder();
            files = actualDir.listFiles();
            for (File file : files) {
                if (file.isDirectory()){
//                    dirRecursive.append("./");
                    dirRecursive.append(dirToString(new File[]{file})).insert(dirRecursive.length()-2,"/");
                    dirRecursive.append(execute(file));
                }
                else{
                    dirRecursive.append("└ ");
                    dirRecursive.append(dirToString(new File[]{file}));
                }
            }
            return dirRecursive.toString();
        }
        return null;
    }

    @Override
    public String getHelp() {
        String help = "DIR\n"
                + String.format("%-7s %s\n", "Dir", "<-r> list recursive directories ");
        return help;
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if(file.isDirectory()){
                sb.append(String.format("%s%n", file.getName()));
            } else {
                sb.append(String.format("%-20s%6d ", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }
    
}
