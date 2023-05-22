package com.bkw.rulesengine;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class CompareObjects {
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");

	public static int compare(Object obj1,Object obj2) {
		// Handle situations where either, or both objects are null
		if(obj1 == null && obj2 != null) return -1;
		if(obj1 != null && obj2 == null) return 1;
		if(obj1 == null && obj2 == null) return 0;

		// Handle condition where objects are of same class
		if(obj1.getClass() == obj2.getClass()) return ((Comparable<Object>)obj1).compareTo(((Comparable<Object>)obj2));
		
		return compareObjectsOfDifferentClasses(obj1,obj2);
		
	}

	// Handle situation where objects are of different classes:
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
	private static int compareObjectsOfDifferentClasses(Object obj1,Object obj2) {
		boolean reversed = false;
		//   String -> GregorianCalendar:  force date to string using "yyyy-mm-dd" format for date
		//   String -> Integer:  force int to string using toString
		//   String -> Double:  force double to string using toString
		//   String -> Long:  force double to string using toString
		//   String -> Float:  force float to string using toString
		//   String -> Boolean:  force boolean to string using "true"/"false"
		if(obj1 instanceof String || obj2 instanceof String) {
			Object o1, o2;
			if(obj1 instanceof String) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				o2 = sdf1.format(((GregorianCalendar)o2).getTime());
			else
				o2 = o2.toString();
			return ((Comparable<Object>)o1).compareTo((Comparable<Object>)o2);
		}
		//   Integer -> GregorianCalendar:  force both to integer using "yyyymmdd' format for date
		//   Integer -> Double:  force int to double
		//   Integer -> Long:  force int to long
		//   Integer -> Float:  force int to float
		//   Integer -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Integer || obj2 instanceof Integer) {
			Object o1, o2;
			if(obj1 instanceof Integer) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				o2 = new Integer(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Double)
				o1 = new Double(((Integer)o1).doubleValue());
			if(o2 instanceof Long)
				o1 = new Long(((Integer)o1).longValue());
			if(o2 instanceof Float)
				o1 = new Float(((Integer)o1).floatValue());
			if(o2 instanceof Boolean)
				o2 = new Integer((((Boolean)o2).booleanValue()?1:0));
			return (reversed?((Comparable<Object>)o2).compareTo((Comparable<Object>)o1):((Comparable<Object>)o1).compareTo((Comparable<Object>)o2));
		}
		//   Long -> GregorianCalendar:  force both to long using "yyyymmdd' format for date
		//   Long -> Double:  force long to double
		//   Long -> Float:  force long to float
		//   Long -> Boolean:  force both to long using 1/0 for boolean
		if(obj1 instanceof Long || obj2 instanceof Long) {
			Object o1, o2;
			if(obj1 instanceof Long) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				o2 = new Long(Long.parseLong(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Double)
				o1 = new Double(((Long)o1).doubleValue());
			if(o2 instanceof Float)
				o1 = new Float(((Long)o1).floatValue());
			if(o2 instanceof Boolean)
				o2 = new Long((((Boolean)o2).booleanValue()?1:0));
			return (reversed?((Comparable<Object>)o2).compareTo((Comparable<Object>)o1):((Comparable<Object>)o1).compareTo((Comparable<Object>)o2));
		}
		//   Double -> GregorianCalendar:  force both to double using "yyyymmdd' format for date
		//   Double -> Float:  force float to double
		//   Double -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Double || obj2 instanceof Double) {
			Object o1, o2;
			if(obj1 instanceof Double) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				o2 = new Double(Double.parseDouble(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Float)
				o2 = new Double(((Float)o2).doubleValue());
			if(o2 instanceof Boolean)
				o2 = new Double((((Boolean)o2).booleanValue()?1:0));
			return (reversed?((Comparable<Object>)o2).compareTo((Comparable<Object>)o1):((Comparable<Object>)o1).compareTo((Comparable<Object>)o2));
		}
		//   Float -> GregorianCalendar:  force both to float using "yyyymmdd' format for date
		//   Float -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Float || obj2 instanceof Float) {
			Object o1, o2;
			if(obj1 instanceof Float) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				o2 = new Float(Float.parseFloat(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Boolean)
				o2 = new Float((((Boolean)o2).booleanValue()?1:0));
			return (reversed?((Comparable<Object>)o2).compareTo((Comparable<Object>)o1):((Comparable<Object>)o1).compareTo((Comparable<Object>)o2));
		}
	
		//   GregorianCalendar -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof GregorianCalendar || obj2 instanceof GregorianCalendar) {
			Object o1, o2;
			if(obj1 instanceof GregorianCalendar) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof Boolean) {
				o1 = new Integer(Integer.parseInt(sdf2.format(((GregorianCalendar)o1).getTime())));
				o2 = new Integer((((Boolean)o2).booleanValue()?1:0));
			}
			return (reversed?((Comparable<Object>)o2).compareTo((Comparable<Object>)o1):((Comparable<Object>)o1).compareTo((Comparable<Object>)o2));
		}

		return 0;
	}
	
	public static boolean equals(Object obj1,Object obj2) {
		return compare(obj1,obj2) == 0;
	}
	
	public static boolean notEquals(Object obj1,Object obj2) {
		return compare(obj1,obj2) != 0;
	}

	public static boolean lessThan(Object obj1,Object obj2) {
		return compare(obj1,obj2) < 0;
	}
	
	public static boolean greaterThan(Object obj1,Object obj2) {
		return compare(obj1,obj2) > 0;
	}
	
	public static boolean lessThanOrEqual(Object obj1,Object obj2) {
		return compare(obj1,obj2) <= 0;
	}
	
	public static boolean greaterThanOrEqual(Object obj1,Object obj2) {
		return compare(obj1,obj2) >= 0;
	}
	
	public static boolean and(boolean b1,boolean b2) {
		return b1 && b2;
	}
	
	public static boolean or(boolean b1,boolean b2) {
		return b1 || b2;
	}
	
	public static boolean not(boolean b) {
		return !b;
	}
	

}
