package cz.knourekdaniel.TUL.cmd;

/**
 *
 * @author janvit
 */
public interface CmdInterface {

    /**
     * Returns whether the cmd is still running.
     * Cmd should be closed using the command defined in constant EXIT
     * @return false when the entered command matches constant EXIT, otherwise 
     * true
     */
    public boolean isRunning();

    /**
     * Returns actual directory. 
     * When cmd opens, it should be the user dir.
     * @return actual user directory
     */
    public String getActualDir();

    /**
     * Returns the text to be displayed after the entered command execution
     * @param line entered command
     */
    public String parseAndExecute(String line);
    
}
