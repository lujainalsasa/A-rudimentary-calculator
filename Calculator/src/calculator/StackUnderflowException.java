/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author user
 */
public class StackUnderflowException extends RuntimeException
{
    public StackUnderflowException()
    {
        super();
    }
    public StackUnderflowException(String msg)
    {
        super(msg);
    }
}
