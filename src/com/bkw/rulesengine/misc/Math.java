package com.bkw.rulesengine.misc;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Math {
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");

	public static Object add(Object obj1,Object obj2) {
		// Handle situations where either, or both objects are null
		if(obj1 == null || obj2 == null) return null;

		// Handle condition where objects are of same class
		return addObjects(obj1,obj2);
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

	private static Object addObjects(Object obj1,Object obj2) {
		boolean reversed = false;
		//   String -> GregorianCalendar:  force date to string using "yyyy-mm-dd" format for date
		//   String -> Integer:  force int to string using toString
		//   String -> Double:  force double to string using toString
		//   String -> Long:  force double to string using toString
		//   String -> Float:  force float to string using toString
		//   String -> Boolean:  force boolean to string using "true"/"false"
		if(obj1 instanceof String || obj2 instanceof String) {
			Object o1, o2;
			String s1, s2;
			if(obj1 instanceof String) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			s1 = (String)o1;
			if(o2 instanceof GregorianCalendar)
				s2 = sdf1.format(((GregorianCalendar)o2).getTime());
			else
				s2 = o2.toString();
			return (reversed?s2+s1:s1+s2);
		}
		//   Integer -> GregorianCalendar:  force both to integer using "yyyymmdd' format for date
		//   Integer -> Double:  force int to double
		//   Integer -> Long:  force int to long
		//   Integer -> Float:  force int to float
		//   Integer -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Integer || obj2 instanceof Integer) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Integer) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				result = new Integer(((Integer)o1).intValue()+Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Double)
				result = new Double(((Integer)o1).doubleValue()+((Double)o2).doubleValue());
			if(o2 instanceof Long)
				result = new Long(((Integer)o1).longValue()+((Long)o2).longValue());
			if(o2 instanceof Float)
				result = new Float(((Integer)o1).floatValue()+((Float)o2).floatValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//	 Long -> GregorianCalendar:  force both to long using "yyyymmdd' format for date
		//   Long -> Double:  force long to double
		//   Long -> Float:  force long to float
		//   Long -> Boolean:  force both to long using 1/0 for boolean
		if(obj1 instanceof Long || obj2 instanceof Long) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Long) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				result = new Long(((Long)o1).intValue()+Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Double)
				result = new Double(((Long)o1).doubleValue()+((Double)o2).doubleValue());
			if(o2 instanceof Float)
				result = new Float(((Long)o1).floatValue()+((Float)o2).floatValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//   Double -> GregorianCalendar:   force both to double using "yyyymmdd' format for date
		//   Double -> Float:  force float to double
		//   Double -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Double || obj2 instanceof Double) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Double) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				result = new Double(((Double)o1).doubleValue()+Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Float)
				result = new Double(((Double)o1).doubleValue()+((Float)o2).doubleValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//   Float -> GregorianCalendar:   force both to float using "yyyymmdd' format for date
		//   Float -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Float || obj2 instanceof Float) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Float) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				result = new Float(((Float)o1).floatValue()+Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
	
		return null;
	}
	
	@SuppressWarnings("unused")
	private static Object subObjects(Object obj1,Object obj2) {
		boolean reversed = false;
		//   String -> GregorianCalendar:  force date to string using "yyyy-mm-dd" format for date
		//   String -> Integer:  force int to string using toString
		//   String -> Double:  force double to string using toString
		//   String -> Long:  force double to string using toString
		//   String -> Float:  force float to string using toString
		//   String -> Boolean:  force boolean to string using "true"/"false"
		if(obj1 instanceof String || obj2 instanceof String) {
			return null;
		}
		//   Integer -> GregorianCalendar:  force both to integer using "yyyymmdd' format for date
		//   Integer -> Double:  force int to double
		//   Integer -> Long:  force int to long
		//   Integer -> Float:  force int to float
		//   Integer -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Integer || obj2 instanceof Integer) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Integer) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				if(!reversed)
					result = new Integer(((Integer)o1).intValue()-Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
				else
					result = new Integer(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime()))-((Integer)o1).intValue());
			if(o2 instanceof Double)
				if(!reversed)
					result = new Double(((Integer)o1).doubleValue()-((Double)o2).doubleValue());
				else
					result = new Double(((Double)o2).doubleValue()-((Integer)o1).doubleValue());
			if(o2 instanceof Long)
				if(!reversed)
					result = new Long(((Integer)o1).longValue()-((Long)o2).longValue());
				else
					result = new Long(((Long)o2).longValue()-((Integer)o1).longValue());
			if(o2 instanceof Float)
				if(!reversed)
					result = new Float(((Integer)o1).floatValue()-((Float)o2).floatValue());
				else
					result = new Float(((Float)o2).floatValue()-((Integer)o1).floatValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//	 Long -> GregorianCalendar:  force both to long using "yyyymmdd' format for date
		//   Long -> Double:  force long to double
		//   Long -> Float:  force long to float
		//   Long -> Boolean:  force both to long using 1/0 for boolean
		if(obj1 instanceof Long || obj2 instanceof Long) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Long) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				if(!reversed)
					result = new Long(((Long)o1).longValue()-Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
				else
					result = new Long(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime()))-((Long)o1).longValue());
			if(o2 instanceof Double)
				if(!reversed)
					result = new Double(((Long)o1).doubleValue()-((Double)o2).doubleValue());
				else
					result = new Double(((Double)o2).doubleValue()-((Long)o1).doubleValue());
			if(o2 instanceof Float)
				if(!reversed)
					result = new Float(((Long)o1).floatValue()-((Float)o2).floatValue());
				else
					result = new Float(((Float)o2).floatValue()-((Long)o1).floatValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//   Double -> GregorianCalendar:   force both to double using "yyyymmdd' format for date
		//   Double -> Float:  force float to double
		//   Double -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Double || obj2 instanceof Double) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Double) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				if(!reversed)
					result = new Double(((Double)o1).doubleValue()-Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
				else
					result = new Double(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime()))-((Double)o1).doubleValue());
			if(o2 instanceof Float)
				if(!reversed)
					result = new Double(((Double)o1).doubleValue()-((Float)o2).doubleValue());
				else
					result = new Float(((Float)o2).doubleValue()-((Double)o1).doubleValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//   Float -> GregorianCalendar:   force both to float using "yyyymmdd' format for date
		//   Float -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Float || obj2 instanceof Float) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Float) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				if(!reversed)
					result = new Float(((Float)o1).floatValue()-Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
				else
					result = new Float(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime()))-((Float)o1).floatValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
	
		return null;
	}

	@SuppressWarnings("unused")
	private static Object multObjects(Object obj1,Object obj2) {
		if(obj1 instanceof String || obj2 instanceof String) {
			return null;
		}
		//   Integer -> GregorianCalendar:  force both to integer using "yyyymmdd' format for date
		//   Integer -> Double:  force int to double
		//   Integer -> Long:  force int to long
		//   Integer -> Float:  force int to float
		//   Integer -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Integer || obj2 instanceof Integer) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Integer) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				result = new Long(((Integer)o1).intValue()*Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Double)
				result = new Double(((Integer)o1).doubleValue()*((Double)o2).doubleValue());
			if(o2 instanceof Long)
				result = new Long(((Integer)o1).longValue()*((Long)o2).longValue());
			if(o2 instanceof Float)
				result = new Double(((Integer)o1).doubleValue()*((Float)o2).doubleValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//	 Long -> GregorianCalendar:  force both to long using "yyyymmdd' format for date
		//   Long -> Double:  force long to double
		//   Long -> Float:  force long to float
		//   Long -> Boolean:  force both to long using 1/0 for boolean
		if(obj1 instanceof Long || obj2 instanceof Long) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Long) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				result = new Long(((Long)o1).longValue()*Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Double)
				result = new Double(((Long)o1).doubleValue()*((Double)o2).doubleValue());
			if(o2 instanceof Float)
				result = new Double(((Long)o1).doubleValue()*((Float)o2).doubleValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//   Double -> GregorianCalendar:   force both to double using "yyyymmdd' format for date
		//   Double -> Float:  force float to double
		//   Double -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Double || obj2 instanceof Double) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Double) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				result = new Double(((Double)o1).doubleValue()*Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Float)
				result = new Double(((Double)o1).doubleValue()*((Float)o2).doubleValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//   Float -> GregorianCalendar:   force both to float using "yyyymmdd' format for date
		//   Float -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Float || obj2 instanceof Float) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Float) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
			}
			if(o2 instanceof GregorianCalendar)
				result = new Double(((Float)o1).doubleValue()+Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
	
		return null;
	}
	
	@SuppressWarnings("unused")
	private static Object divObjects(Object obj1,Object obj2) {
		boolean reversed = false;
		//   String -> GregorianCalendar:  force date to string using "yyyy-mm-dd" format for date
		//   String -> Integer:  force int to string using toString
		//   String -> Double:  force double to string using toString
		//   String -> Long:  force double to string using toString
		//   String -> Float:  force float to string using toString
		//   String -> Boolean:  force boolean to string using "true"/"false"
		if(obj1 instanceof String || obj2 instanceof String) {
			return null;
		}
		//   Integer -> GregorianCalendar:  force both to integer using "yyyymmdd' format for date
		//   Integer -> Double:  force int to double
		//   Integer -> Long:  force int to long
		//   Integer -> Float:  force int to float
		//   Integer -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Integer || obj2 instanceof Integer) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Integer) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				if(!reversed)
					result = new Double(((Integer)o1).floatValue()/Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
				else
					result = new Double(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime()))/((Integer)o1).floatValue());
			if(o2 instanceof Double)
				if(!reversed)
					result = new Double(((Integer)o1).doubleValue()/((Double)o2).doubleValue());
				else
					result = new Double(((Double)o2).doubleValue()/((Integer)o1).doubleValue());
			if(o2 instanceof Long)
				if(!reversed)
					result = new Double(((Integer)o1).doubleValue()/((Long)o2).longValue());
				else
					result = new Double(((Long)o2).floatValue()/((Integer)o1).longValue());
			if(o2 instanceof Float)
				if(!reversed)
					result = new Float(((Integer)o1).floatValue()/((Float)o2).floatValue());
				else
					result = new Float(((Float)o2).floatValue()/((Integer)o1).floatValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//	 Long -> GregorianCalendar:  force both to long using "yyyymmdd' format for date
		//   Long -> Double:  force long to double
		//   Long -> Float:  force long to float
		//   Long -> Boolean:  force both to long using 1/0 for boolean
		if(obj1 instanceof Long || obj2 instanceof Long) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Long) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				if(!reversed)
					result = new Double(((Long)o1).doubleValue()/Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
				else
					result = new Double(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime()))/((Long)o1).doubleValue());
			if(o2 instanceof Double)
				if(!reversed)
					result = new Double(((Long)o1).doubleValue()/((Double)o2).doubleValue());
				else
					result = new Double(((Double)o2).doubleValue()/((Long)o1).doubleValue());
			if(o2 instanceof Float)
				if(!reversed)
					result = new Double(((Long)o1).doubleValue()/((Float)o2).doubleValue());
				else
					result = new Float(((Float)o2).doubleValue()/((Long)o1).doubleValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//   Double -> GregorianCalendar:   force both to double using "yyyymmdd' format for date
		//   Double -> Float:  force float to double
		//   Double -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Double || obj2 instanceof Double) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Double) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				if(!reversed)
					result = new Double(((Double)o1).doubleValue()/Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
				else
					result = new Double(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime()))/((Double)o1).doubleValue());
			if(o2 instanceof Float)
				if(!reversed)
					result = new Double(((Double)o1).doubleValue()/((Float)o2).doubleValue());
				else
					result = new Float(((Float)o2).doubleValue()/((Double)o1).doubleValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
		//   Float -> GregorianCalendar:   force both to float using "yyyymmdd' format for date
		//   Float -> Boolean:  force both to int using 1/0 for boolean
		if(obj1 instanceof Float || obj2 instanceof Float) {
			Object o1, o2;
			Number result = null;
			if(obj1 instanceof Float) {
				o1 = obj1;
				o2 = obj2;
			} else {
				o1 = obj2;
				o2 = obj1;
				reversed = true;
			}
			if(o2 instanceof GregorianCalendar)
				if(!reversed)
					result = new Double(((Float)o1).doubleValue()/Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime())));
				else
					result = new Double(Integer.parseInt(sdf2.format(((GregorianCalendar)o2).getTime()))/((Float)o1).doubleValue());
			if(o2 instanceof Boolean)
				result = null;
			return result;
		}
	
		return null;
	}
}