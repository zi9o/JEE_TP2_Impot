/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author zakaria
 */
public class NumberError extends NumberFormatException
{
    private final String message;
    public NumberError(String s) 
    {
        this.message=s;
    }
    @Override
    public String getMessage()
    {
        return this.message;
    }
}
