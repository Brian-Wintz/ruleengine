package com.bkw.rulesengine.tests;
import java.util.*;

import com.bkw.rulesengine.CompareObjects;

import java.text.*;

public class RulesTest {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar(2007,Calendar.OCTOBER,4);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = "123456";
		
		Integer i = new Integer(123456789);
		Double d = new Double(45678.9);
		Float f = new Float(2342354.83);
		Boolean b = new Boolean(true);
		Long l = new Long(12345);
		
		//System.out.println("compare:"+f.compareTo(d));
		
		//   String -> GregorianCalendar:  force date to string using "yyyy-mm-dd" format for date
		//   String -> Integer:  force int to string using toString
		//   String -> Double:  force double to string using toString
		//   String -> Long:  force double to string using toString
		//   String -> Float:  force float to string using toString
		//   String -> Boolean:  force boolean to string using "true"/"false"
		//   Integer -> GregorianCalendar:  force both to string using "yyyy-mm-dd' format for date
		//   Integer -> Double:  force int to double
		//   Integer -> Long:  force int to long
		//   Integer -> Float:  force int to float
		//   Integer -> Boolean:  force both to int using 1/0 for boolean
		//   Long -> Double:  force long to double
		//   Long -> Float:  force long to float
		//   Long -> Boolean:  force both to long using 1/0 for boolean
		//   Double -> Float:  force float to double
		//   Double -> Boolean:  force both to int using 1/0 for boolean
		//   Float -> Boolean:  force both to int using 1/0 for boolean
		System.out.println("compare "+str+" to "+sdf.format(gc.getTime())+":"+CompareObjects.compare(str,gc)+":"+CompareObjects.compare(gc,str));
		System.out.println("compare "+str+" to "+i+":"+CompareObjects.compare(str,i)+":"+CompareObjects.compare(i,str));
		System.out.println("compare "+str+" to "+d+":"+CompareObjects.compare(str,d)+":"+CompareObjects.compare(d,str));
		System.out.println("compare "+str+" to "+l+":"+CompareObjects.compare(str,l)+":"+CompareObjects.compare(l,str));
		System.out.println("compare "+str+" to "+f+":"+CompareObjects.compare(str,f)+":"+CompareObjects.compare(f,str));
		System.out.println("compare "+str+" to "+b+":"+CompareObjects.compare(str,b)+":"+CompareObjects.compare(b,str));
		
		System.out.println("compare "+i+" to "+sdf.format(gc.getTime())+":"+CompareObjects.compare(i,gc)+":"+CompareObjects.compare(gc,i));
		System.out.println("compare "+i+" to "+d+":"+CompareObjects.compare(i,d)+":"+CompareObjects.compare(d,i));
		System.out.println("compare "+i+" to "+l+":"+CompareObjects.compare(i,l)+":"+CompareObjects.compare(l,i));
		System.out.println("compare "+i+" to "+f+":"+CompareObjects.compare(i,f)+":"+CompareObjects.compare(f,i));
		System.out.println("compare "+i+" to "+b+":"+CompareObjects.compare(i,b)+":"+CompareObjects.compare(b,i));

		System.out.println("compare "+l+" to "+sdf.format(gc.getTime())+":"+CompareObjects.compare(l,gc)+":"+CompareObjects.compare(gc,l));
		System.out.println("compare "+l+" to "+d+":"+CompareObjects.compare(l,d)+":"+CompareObjects.compare(d,l));
		System.out.println("compare "+l+" to "+f+":"+CompareObjects.compare(l,f)+":"+CompareObjects.compare(f,l));
		System.out.println("compare "+l+" to "+b+":"+CompareObjects.compare(l,b)+":"+CompareObjects.compare(b,l));

		System.out.println("compare "+d+" to "+sdf.format(gc.getTime())+":"+CompareObjects.compare(d,gc)+":"+CompareObjects.compare(gc,d));
		System.out.println("compare "+d+" to "+f+":"+CompareObjects.compare(d,f)+":"+CompareObjects.compare(f,d));
		System.out.println("compare "+d+" to "+b+":"+CompareObjects.compare(d,b)+":"+CompareObjects.compare(b,d));

		System.out.println("compare "+f+" to "+sdf.format(gc.getTime())+":"+CompareObjects.compare(f,gc)+":"+CompareObjects.compare(gc,f));
		System.out.println("compare "+f+" to "+b+":"+CompareObjects.compare(f,b)+":"+CompareObjects.compare(b,f));

		System.out.println("compare "+sdf.format(gc.getTime())+" to "+b+":"+CompareObjects.compare(gc,b)+":"+CompareObjects.compare(b,gc));
		
	}

}
