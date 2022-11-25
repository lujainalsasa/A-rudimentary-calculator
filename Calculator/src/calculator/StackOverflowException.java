/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author user
 */
public class StackOverflowException extends RuntimeException
{
    public StackOverflowException()
    {
        super();
    }
    public StackOverflowException(String msg)
    {
        super(msg);
    }
}
