package com.cornellsatech.o_week.util;

/**
 * Alternative to functional programming in Java 7. A wrapper for a function that some type T.
 */
public interface Callback<T>
{
	void execute(T t);
}